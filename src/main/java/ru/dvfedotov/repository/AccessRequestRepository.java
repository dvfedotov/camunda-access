package ru.dvfedotov.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.dvfedotov.domain.AccessRequest;

public interface AccessRequestRepository extends JpaRepository<AccessRequest,Long> {
    Optional<AccessRequest> findOneByEntityId(Long entityId);
}
