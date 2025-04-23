package AuthService.dtos.responses;

import AuthService.entites.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class Profile {
    private List<String> userRoles;
    private String firstName;
    private String lastName;
}
