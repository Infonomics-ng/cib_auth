package AuthService.repositories;

import AuthService.entites.Role;
import AuthService.entites.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
