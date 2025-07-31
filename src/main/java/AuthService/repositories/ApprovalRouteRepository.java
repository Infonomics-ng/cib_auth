package AuthService.repositories;

import AuthService.entites.ApprovalRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRouteRepository extends JpaRepository<ApprovalRoute, Long> {
}
