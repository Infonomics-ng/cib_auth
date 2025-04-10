package AuthService.dtos.requests;

import AuthService.entites.RoleEnum;
import AuthService.entites.UserTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostUserRequest {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "firstName is required")
    private String firstName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "middleName is required")
    private String middleName;

    private String address;

    @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 characters")
    private String mobileNumber;

    @NotBlank(message = "email is required")
    private String email;

    @NotNull(message = "corpId is required")
    private Long corpId;

    private Long subsidiaryId;

    private UserTypeEnum userType;

    private String jobTitle;
    private String createdIpAddress;
    private String approvedIpAddress;
    private String password;

    private Set<RoleEnum> userRoles;
    private boolean enableToken;
    private boolean viewAccountBalance;
    private boolean signatory;
    private boolean globalAccess;
}