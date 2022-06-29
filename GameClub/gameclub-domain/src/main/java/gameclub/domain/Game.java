package gameclub.domain;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(length = 500)
    private String description;
    @Column(name = "minimum_age")
    private int minimumAge;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "min", column = @Column(name = "playtime_min")),
            @AttributeOverride( name = "max", column = @Column(name = "playtime_max"))
    })
    private Limits playTime;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "min", column = @Column(name = "playernum_min")),
            @AttributeOverride( name = "max", column = @Column(name = "playernum_max")),
    })
    private Limits numberOfPlayers;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIES")
    private List<Category> categories;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public void setPlayTime(Limits playTime) {
        this.playTime = playTime;
    }

    public void setNumberOfPlayers(Limits numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public Limits getPlayTime() {
        return playTime;
    }

    public Limits getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Game(Long id, String name, String description, int minimumAge, Limits playTime, Limits numberOfPlayers, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimumAge = minimumAge;
        this.playTime = playTime;
        this.numberOfPlayers = numberOfPlayers;
        this.categories = categories;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minimumAge=" + minimumAge +
                ", playTime=" + playTime +
                ", numberOfPlayers=" + numberOfPlayers +
                ", categories=" + categories +
                '}';
    }
}
