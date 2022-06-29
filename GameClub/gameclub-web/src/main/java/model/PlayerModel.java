package model;

public class PlayerModel {
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public PlayerModel() {
    }

    public PlayerModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
