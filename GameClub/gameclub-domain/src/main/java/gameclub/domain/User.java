package gameclub.domain;


import java.util.List;

public class User {
    private Long id;
    private String loginName;
    private String name;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Game> games;

    public User(Long id, String loginName, String name, String password, String email, List<Role> roles, List<Game> games) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.games = games;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }

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
