package api.forum.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<api.forum.hub.domain.User, Long> {
    UserDetails findByLogin(String login);
}
