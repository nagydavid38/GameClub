package gameclub.domain.dtos;

import gameclub.domain.JoinRequest;

import java.util.List;

public class GroupDTO {
    private Long id;
    private String name;
    private List<Long> members;
    private Long admin;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getMembers() {
        return members;
    }

    public Long getAdmin() {
        return admin;
    }

    public GroupDTO(Long id, String name, List<Long> members, Long admin) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.admin = admin;
    }

    public GroupDTO() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                ", admin=" + admin +
                '}';
    }
}
