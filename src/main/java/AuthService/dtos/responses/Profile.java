package AuthService.dtos.responses;

import AuthService.entites.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Profile {
    private List<String> userRoles;
    private String firstName;
    private String lastName;
}
