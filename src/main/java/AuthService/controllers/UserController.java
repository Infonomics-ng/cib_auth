package AuthService.controllers;

import AuthService.dtos.requests.PostUserRequest;
import AuthService.dtos.requests.UserLoginRequest;
import AuthService.dtos.responses.UserResponse;
import AuthService.exceptions.DuplicateException;
import AuthService.exceptions.InvalidRequestException;
import AuthService.exceptions.NotFoundException;
import AuthService.services.UserService;
import AuthService.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody PostUserRequest request) throws DuplicateException {
        userService.createUser(request);
        return ResponseEntity.ok(request);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) throws NotFoundException {
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody  PostUserRequest request) throws InvalidRequestException {
        var token = userService.registerUser(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequest request){
        var token = userService.loginUser(request);
        return ResponseEntity.ok(token);
    }
}