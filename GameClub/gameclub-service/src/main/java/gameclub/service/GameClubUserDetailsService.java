package gameclub.service;
import gameclub.domain.GameUserPrincipal;
import gameclub.domain.Player;
import gameclub.persistence.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GameClubUserDetailsService implements UserDetailsService {

    private IPlayerRepository playerRepository;

    @Autowired
    public GameClubUserDetailsService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByLoginName(username);
        player.getRoles().toString();
        if(player == null){
            throw new UsernameNotFoundException(username);
        }
        return new GameUserPrincipal(player);
    }
}
