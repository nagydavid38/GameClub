package gameclub.domain;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "EVENTS")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_date")
    private LocalDateTime date;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;
    @ManyToMany
    @Target(Player.class)
    @Column(name = "participants")
    private List<Player> participants;

    public Long getId() {
        return id;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public List<Player> getParticipants() {
        return participants;
    }

    public Event(Long id, LocalDateTime date, String place, String description, List<Player> participants) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.description = description;
        this.participants = participants;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", description='" + description + '\'' +
                ", participants=" + participants +
                '}';
    }
}
