package gameclub.domain.dtos;


import gameclub.domain.Role;

import java.util.List;

public class UserDTO {
    private Long id;
    private String loginName;
    private String name;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Long> games;

    public UserDTO(Long id, String loginName, String name, String password, String email, List<Role> roles, List<Long> games) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.games = games;
    }

    public UserDTO() {
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

    public List<Long> getGames() {
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
