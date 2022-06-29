package gameclub.persistence;

import gameclub.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventRepository extends JpaRepository<Event, Long> {
}
