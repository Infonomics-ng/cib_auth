package AuthService.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UserLoginRequest {
    @NotBlank(message = "Username cannot be null")
    private String username;

    @NotBlank(message = "password cannot be null")
    @Length(min = 7, message = "Password length must be equal or greater than 7")
    private String password;


}