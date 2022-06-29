package gameclub.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SUPERUSER,
    @JsonProperty("GROUP_ADMIN")
    GROUPADMIN,
    PLAYER;

    @Override
    public String getAuthority() {
        return name();
    }
}
