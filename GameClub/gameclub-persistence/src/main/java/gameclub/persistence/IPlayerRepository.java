package gameclub.persistence;

import gameclub.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Long> {
    Player findByLoginName(String username);
}
