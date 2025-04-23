package AuthService.services;

import AuthService.dtos.requests.PostUserRequest;
import AuthService.dtos.requests.UserLoginRequest;
import AuthService.dtos.responses.AuthorizationResponse;
import AuthService.dtos.responses.UserResponse;
import AuthService.exceptions.DuplicateException;
import AuthService.exceptions.InvalidRequestException;
import AuthService.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    void createUser(PostUserRequest request) throws DuplicateException;
    UserResponse getUser(Long userId) throws NotFoundException;
    AuthorizationResponse registerUser(PostUserRequest request) throws InvalidRequestException;
    AuthorizationResponse loginUser(UserLoginRequest request) throws Exception;
}