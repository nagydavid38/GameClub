package gameclub.persistence;

import gameclub.domain.Group;
import gameclub.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IGroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
    Group findByAdmin(Player admin);
}
