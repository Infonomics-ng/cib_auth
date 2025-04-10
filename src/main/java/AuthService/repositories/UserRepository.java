package AuthService.repositories;

import AuthService.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = """
        SELECT u.* 
        FROM user u
        JOIN user_role ur ON u.userId = ur.userId
        JOIN role r ON ur.roleId = r.roleId
        WHERE u.username = :username
        """, nativeQuery = true)
    User findByUsernameWithRoles(@Param("username") String username);
}