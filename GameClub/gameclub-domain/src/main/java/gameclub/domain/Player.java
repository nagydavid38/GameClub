package gameclub.domain;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class Player {
    @Id
    private Long id;

    private String loginName;

    private String name;

    private String password;

    private String email;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @ManyToMany
    @Target(Game.class)
    private List<Game> games;

    public Player(Long id, String loginName, String name, String password, String email, List<Role> roles, List<Game> games) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.games = games;
    }

    public Player() {
    }

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "login_name")
    public String getLoginName() {
        return loginName;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "roles")
    public List<Role> getRoles() {
        return roles;
    }

    @Column(name = "games")
    public List<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", games=" + games +
                '}';
    }
}
