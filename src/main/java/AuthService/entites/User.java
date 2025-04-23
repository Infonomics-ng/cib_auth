package AuthService.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "userRoles")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long userId;

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

    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;

    private String jobTitle;

    private String createdIpAddress;

    private String approvedIpAddress;

    private String password;

//    private List<RoleEnum> userRoleEnums;
    private boolean enableToken;

    private boolean viewAccountBalance;

    private boolean signatory;

    private String profilePicture;

    private boolean globalAccess = false;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Enumerated(value = EnumType.STRING)


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private Set<Role> userRoles = new HashSet<>();
}