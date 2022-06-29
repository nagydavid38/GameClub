package gameclub.domain.dtos;

import gameclub.domain.JoinRequestState;

public class JoinRequestDTO {
    private Long id;
    private Long groupId;
    private Long userId;
    private JoinRequestState state;

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public JoinRequestState getState() {
        return state;
    }

    public Long getUserId() {
        return userId;
    }

    public JoinRequestDTO(Long id, Long groupId, Long userId, JoinRequestState state) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
        this.state = state;
    }

    public JoinRequestDTO() {
    }

    @Override
    public String toString() {
        return "JoinRequest{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", state=" + state +
                '}';
    }
}
