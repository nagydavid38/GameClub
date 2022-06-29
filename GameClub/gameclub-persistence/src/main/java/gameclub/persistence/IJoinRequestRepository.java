package gameclub.persistence;

import gameclub.domain.Group;
import gameclub.domain.JoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoinRequestRepository extends JpaRepository<JoinRequest, Long> {
    List<JoinRequest> findByGroupId(Long groupId);
    JoinRequest findByGroupIdAndUserId(Long groupId, Long userId);
}
