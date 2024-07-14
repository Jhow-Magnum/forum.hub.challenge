package api.forum.hub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends JpaRepository<api.forum.hub.domain.Topics, Long> {
    Page<api.forum.hub.domain.Topics> findAllByStatus(short ativo, Pageable pageable);
}
