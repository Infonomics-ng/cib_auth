package AuthService.dtos.mappers;

import AuthService.dtos.requests.PostUserRequest;
import AuthService.dtos.responses.UserResponse;
import AuthService.entites.User;
import AuthService.services.UserServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User postUserRequestToUser(PostUserRequest request);

    UserResponse userToUserResponse(User user);
}