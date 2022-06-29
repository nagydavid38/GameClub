package model;

import gameclub.webapplication.validation.MinMaxConstraint;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@MinMaxConstraint
public class GameModel {
    private Long id;
    @NotBlank(message = "Name must be specified!")
    private String name;
    @NotBlank(message = "Description must be added!")
    private String description;
    @Min(value = 3, message = "Minimum age must be at least 3!")
    private int minimumAge;
    @Min(value = 1, message = "Some playtime must be added!")
    private int playTime_min;
    private int playTime_max;
    @Min(value = 1, message = "At least one player is required!")
    private int numOfPlayers_min;
    private int numOfPlayers_max;
    private List<String> categories;

    public GameModel(Long id, String name, String description, int minimumAge, int playTime_min, int playTime_max, int numOfPlayers_min, int numOfPlayers_max, List<String> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimumAge = minimumAge;
        this.playTime_min = playTime_min;
        this.playTime_max = playTime_max;
        this.numOfPlayers_min = numOfPlayers_min;
        this.numOfPlayers_max = numOfPlayers_max;
        this.categories = categories;
    }

    public GameModel(){

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

    public int getPlayTime_min() {
        return playTime_min;
    }

    public int getPlayTime_max() {
        return playTime_max;
    }

    public int getNumOfPlayers_min() {
        return numOfPlayers_min;
    }

    public int getNumOfPlayers_max() {
        return numOfPlayers_max;
    }

    public List<String> getCategories() {
        return categories;
    }

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

    public void setPlayTime_min(int playTime_min) {
        this.playTime_min = playTime_min;
    }

    public void setPlayTime_max(int playTime_max) {
        this.playTime_max = playTime_max;
    }

    public void setNumOfPlayers_min(int numOfPlayers_min) {
        this.numOfPlayers_min = numOfPlayers_min;
    }

    public void setNumOfPlayers_max(int numOfPlayers_max) {
        this.numOfPlayers_max = numOfPlayers_max;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "GameModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minimumAge=" + minimumAge +
                ", playTime_min=" + playTime_min +
                ", playTime_max=" + playTime_max +
                ", numOfPlayers_min=" + numOfPlayers_min +
                ", numOfPlayers_max=" + numOfPlayers_max +
                ", categories='" + categories + '\'' +
                '}';
    }
}
