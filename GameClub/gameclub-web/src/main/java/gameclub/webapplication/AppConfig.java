package gameclub.webapplication;

import gameclub.persistence.*;
import gameclub.service.GameClubService;
import gameclub.service.GameClubUserDetailsService;
import gameclub.service.IGameClubService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories("gameclub.persistence")
@EntityScan("gameclub.domain")
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public IGameClubService gameClubService(IGameRepository gameRepository, IGroupRepository groupRepository,
                                            IJoinRequestRepository joinRequestRepository, IPlayerRepository playerRepository,
                                            IEventRepository eventRepository){
        return new GameClubService(gameRepository, groupRepository, joinRequestRepository, playerRepository, eventRepository);
    }

    @Bean
    public GameClubUserDetailsService gameClubUserDetailsService(IPlayerRepository playerRepository){
        return new GameClubUserDetailsService(playerRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                .and()
                .logout().logoutUrl("/logout")
                .deleteCookies();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
