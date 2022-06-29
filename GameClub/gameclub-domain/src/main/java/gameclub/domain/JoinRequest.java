package gameclub.domain;

import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
public class JoinRequest {
    @EmbeddedId
    private JoinRequestId id;
    @ManyToOne
    private Group group;
    @ManyToOne
    private Player user;
    @Enumerated(EnumType.STRING)
    private JoinRequestState state;

    @Column(name = "id")
    public JoinRequestId getId() {
        return id;
    }
    @Column(name = "group_id")
    public Group getGroup() {
        return group;
    }
    @Column(name = "state")
    public JoinRequestState getState() {
        return state;
    }
    @Column(name = "user_id")
    public Player getUser() {
        return user;
    }

    public void setState(JoinRequestState state) {
        this.state = state;
    }


    public JoinRequest(JoinRequestId id, Group group, Player player, JoinRequestState state){
        this.id = id;
        this.group = group;
        this.user = player;
        this.state = state;
    }

    public JoinRequest() {
    }



    @Override
    public String toString() {
        return "JoinRequest{" +
                "id=" + id +
                ", groupId=" + group +
                ", userId=" + user +
                ", state=" + state +
                '}';
    }
}
