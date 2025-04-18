package AuthService.services;

import AuthService.clients.CorporateClient;
import AuthService.dtos.mappers.UserMapper;
import AuthService.dtos.requests.PostUserRequest;
import AuthService.dtos.requests.UserLoginRequest;
import AuthService.dtos.responses.AuthorizationResponse;
import AuthService.dtos.responses.Profile;
import AuthService.dtos.responses.UserResponse;
import AuthService.entites.Role;
import AuthService.entites.RoleEnum;
import AuthService.entites.User;
import AuthService.exceptions.DuplicateException;
import AuthService.exceptions.InvalidRequestException;
import AuthService.exceptions.NotFoundException;
import AuthService.repositories.CorporateRepository;
import AuthService.repositories.RoleRepository;
import AuthService.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final AuthService authService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final CorporateRepository corporateRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final CorporateClient corporateClient;

    public void createUser(PostUserRequest request) throws DuplicateException {
        var corporate = corporateClient.getCorpByCorpId(request.getCorpId());
        System.out.println(corporate);
        User existingUser = userRepository.findByUsername(request.getUsername());
        if(existingUser != null){
            String errmsg = String.format("user with the email already exists");
            throw new DuplicateException(errmsg);
        }
        User newUser = userMapper.postUserRequestToUser(request);
        userRepository.save(newUser);
    }

    public UserResponse getUser(Long id) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("user with id %d not found", id)));
        UserResponse userResponse = userMapper.userToUserResponse(user);
        return userResponse;
    }

    public AuthorizationResponse registerUser(PostUserRequest user) throws InvalidRequestException {
//        System.out.println(corp);
//        var existingCorporate = corporateClient.getCorpByCorpId(user.getCorpId());
        var existingCorporate = corporateRepository.findByCorpId(user.getCorpId());
        if (existingCorporate == null) {
            throw new InvalidRequestException("Corporate must exist before a user can be created");
        }
        var newUser = User
                .builder()
                .username(user.getUsername())
                .corpId(existingCorporate.getCorpId())
                .address(user.getAddress())
                .email(user.getEmail())
                .subsidiaryId(user.getSubsidiaryId())
                .approvedIpAddress(user.getApprovedIpAddress())
                .createdIpAddress(user.getCreatedIpAddress())
                .jobTitle(user.getJobTitle())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .mobileNumber(user.getMobileNumber())
                .password(passwordEncoder.encode(user.getPassword()))
                .enableToken(user.isEnableToken())
                .viewAccountBalance(user.isViewAccountBalance())
                .signatory(user.isSignatory())
                .globalAccess(user.isGlobalAccess())
                .build();
        Set<Role> roles = new HashSet<>();
        for (RoleEnum roleName : user.getUserRoles()) {
            Role role = roleRepository.findByRoleName(roleName.toString());
            if (role != null) {
                Role newRole = Role.builder()
                        .roleCd("super_admin")
                        .roleName(roleName.toString())
                        .approvalStatus("APPROVED")
                        .approvedBy("ADMIN")
                        .build();
                roles.add(newRole);
                roleRepository.save(newRole);
            }
        }
        newUser.setUserRoles(roles);
        userRepository.save(newUser);
        String token = authService.generateToken(newUser);
        return AuthorizationResponse.builder().token(token).build();
    }

    @Override
    public AuthorizationResponse loginUser(UserLoginRequest user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        User userDtl = userRepository.findByUsernameWithRoles(user.getUsername());
        String token = authService.generateToken(userDtl);
        if(userDtl != null && userDtl.getUserRoles() != null){
          System.out.println(userDtl);
        }
            var userRoles = List.of("");
        Profile profile = Profile.builder()
                .userRoles(userRoles)
                .firstName(userDtl.getFirstName())
                .lastName(userDtl.getLastName())
                .build();
//        profile = Profile.builder().userRoles(roleNames).build()
        return AuthorizationResponse.builder()
                .token(token)
                .profile(profile)
                .build();
    }
}