package gameclub.domain;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    private Long id;

    private String name;
    @ManyToMany
    @Target(Player.class)
    private List<Player> members;

    @OneToOne
    @Target(Player.class)
    private Player admin;

    @OneToMany
    @Target(Event.class)
    private List<Event> events;

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "members")
    public List<Player> getMembers() {
        return members;
    }

    @Column(name = "admin")
    public Player getAdmin() {
        return admin;
    }


    @Column(name = "events")
    public List<Event> getEvents() {
        return events;
    }

    public Group(Long id, String name, List<Player> members, Player admin, List<Event> events) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.admin = admin;
        this.events = events;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                ", admin=" + admin +
                ", events=" + events +
                '}';
    }
}
