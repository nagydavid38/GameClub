package gameclub.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JoinRequestId implements Serializable {

    private Long jr_player_id;
    private Long jr_group_id;

    public JoinRequestId(){

    }

    public JoinRequestId(Long jr_player_id, Long jr_group_id) {
        this.jr_player_id = jr_player_id;
        this.jr_group_id = jr_group_id;
    }

    public Long getJr_player_id() {
        return jr_player_id;
    }

    public void setJr_player_id(Long jr_player_id) {
        this.jr_player_id = jr_player_id;
    }

    public Long getJr_group_id() {
        return jr_group_id;
    }

    public void setJr_group_id(Long jr_group_id) {
        this.jr_group_id = jr_group_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinRequestId that = (JoinRequestId) o;
        return Objects.equals(jr_player_id, that.jr_player_id) && Objects.equals(jr_group_id, that.jr_group_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jr_player_id, jr_group_id);
    }

}
