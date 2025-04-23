package AuthService.dtos.responses;

import AuthService.entites.UserTypeEnum;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    public Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private String middleName;

    private String address;

    private String mobileNumber;

    private String email;

    private Long corpId;

    private Long roleId;

    private Long subsidiaryId;

    private UserTypeEnum userType;

    private String jobTitle;

    private String createdIpAddress;

    private String approvedIpAddress;

    private String password;

    private boolean enableToken;

    private boolean viewAccountBalance;

    private boolean signatory;

    private String profilePicture;

    private boolean globalAccess = false;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}