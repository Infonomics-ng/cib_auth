package AuthService.repositories;

import AuthService.entites.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, Long> {
    Corporate findByCorporatecd(String corporatecd);
    Corporate findByCorpId(Long corpId);
}
