package AuthService.dtos.mappers;

import AuthService.dtos.requests.PostUserRequest;
import AuthService.dtos.responses.UserResponse;
import AuthService.entites.Role;
import AuthService.entites.RoleEnum;
import AuthService.entites.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-30T21:15:38+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User postUserRequestToUser(PostUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getUsername() );
        user.firstName( request.getFirstName() );
        user.lastName( request.getLastName() );
        user.middleName( request.getMiddleName() );
        user.address( request.getAddress() );
        user.mobileNumber( request.getMobileNumber() );
        user.email( request.getEmail() );
        user.corpId( request.getCorpId() );
        user.subsidiaryId( request.getSubsidiaryId() );
        user.userType( request.getUserType() );
        user.jobTitle( request.getJobTitle() );
        user.createdIpAddress( request.getCreatedIpAddress() );
        user.approvedIpAddress( request.getApprovedIpAddress() );
        user.password( request.getPassword() );
        user.enableToken( request.isEnableToken() );
        user.viewAccountBalance( request.isViewAccountBalance() );
        user.signatory( request.isSignatory() );
        user.globalAccess( request.isGlobalAccess() );
        user.userRoles( roleEnumSetToRoleSet( request.getUserRoles() ) );

        user.createdAt( java.time.LocalDateTime.now() );

        return user.build();
    }

    @Override
    public UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.userId( user.getUserId() );
        userResponse.username( user.getUsername() );
        userResponse.firstName( user.getFirstName() );
        userResponse.lastName( user.getLastName() );
        userResponse.middleName( user.getMiddleName() );
        userResponse.address( user.getAddress() );
        userResponse.mobileNumber( user.getMobileNumber() );
        userResponse.email( user.getEmail() );
        userResponse.corpId( user.getCorpId() );
        userResponse.subsidiaryId( user.getSubsidiaryId() );
        userResponse.userType( user.getUserType() );
        userResponse.jobTitle( user.getJobTitle() );
        userResponse.createdIpAddress( user.getCreatedIpAddress() );
        userResponse.approvedIpAddress( user.getApprovedIpAddress() );
        userResponse.password( user.getPassword() );
        userResponse.enableToken( user.isEnableToken() );
        userResponse.viewAccountBalance( user.isViewAccountBalance() );
        userResponse.signatory( user.isSignatory() );
        userResponse.profilePicture( user.getProfilePicture() );
        userResponse.globalAccess( user.isGlobalAccess() );
        userResponse.createdAt( user.getCreatedAt() );
        userResponse.updatedAt( user.getUpdatedAt() );

        return userResponse.build();
    }

    @Override
    public User userResponseToUser(UserResponse user) {
        if ( user == null ) {
            return null;
        }

        User.UserBuilder user1 = User.builder();

        user1.userId( user.getUserId() );
        user1.username( user.getUsername() );
        user1.firstName( user.getFirstName() );
        user1.lastName( user.getLastName() );
        user1.middleName( user.getMiddleName() );
        user1.address( user.getAddress() );
        user1.mobileNumber( user.getMobileNumber() );
        user1.email( user.getEmail() );
        user1.corpId( user.getCorpId() );
        user1.subsidiaryId( user.getSubsidiaryId() );
        user1.userType( user.getUserType() );
        user1.jobTitle( user.getJobTitle() );
        user1.createdIpAddress( user.getCreatedIpAddress() );
        user1.approvedIpAddress( user.getApprovedIpAddress() );
        user1.password( user.getPassword() );
        user1.enableToken( user.isEnableToken() );
        user1.viewAccountBalance( user.isViewAccountBalance() );
        user1.signatory( user.isSignatory() );
        user1.profilePicture( user.getProfilePicture() );
        user1.globalAccess( user.isGlobalAccess() );
        user1.createdAt( user.getCreatedAt() );
        user1.updatedAt( user.getUpdatedAt() );

        return user1.build();
    }

    protected Role roleEnumToRole(RoleEnum roleEnum) {
        if ( roleEnum == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        return role.build();
    }

    protected Set<Role> roleEnumSetToRoleSet(Set<RoleEnum> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new LinkedHashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleEnum roleEnum : set ) {
            set1.add( roleEnumToRole( roleEnum ) );
        }

        return set1;
    }
}
