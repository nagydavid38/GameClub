package gameclub.domain.dtos;

import gameclub.domain.Category;
import gameclub.domain.Limits;

import java.util.List;

public class GameDTO {
    private Long id;
    private String name;
    private String description;
    private int minimumAge;
    private Limits playTime;
    private Limits numberOfPlayers;
    private List<Category> categories;

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

    public GameDTO(Long id, String name, String description, int minimumAge, Limits playTime, Limits numberOfPlayers, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimumAge = minimumAge;
        this.playTime = playTime;
        this.numberOfPlayers = numberOfPlayers;
        this.categories = categories;
    }

    public GameDTO() {
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
