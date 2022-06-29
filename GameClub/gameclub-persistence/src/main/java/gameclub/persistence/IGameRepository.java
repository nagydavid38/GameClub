package gameclub.persistence;

import gameclub.domain.Game;
import gameclub.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
public interface IGameRepository extends JpaRepository<Game, Long> {
    Game findByName(String name);
}
