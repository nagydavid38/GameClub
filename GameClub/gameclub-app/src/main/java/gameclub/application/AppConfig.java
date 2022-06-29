/*package gameclub.application;

import gameclub.persistence.*;
import gameclub.service.IGameClubService;
import gameclub.service.GameClubService;
import gameclub.view.IConsoleView;
import gameclub.view.ConsoleView;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("gameclub.persistence")
@EntityScan("gameclub.domain")
public class AppConfig {

  @Bean
   public DataStore dataStore(){
       return DataStore.getInstance();
   }

   @Bean
   public IGameRepository gameRepository(){
       return new GameRepository(dataStore());
   }

   @Bean
   public IGroupRepository groupRepository(){
       return new GroupRepository(dataStore());
   }

   @Bean
   public IPlayerRepository playerRepository(){
       return new PlayerRepository(dataStore());
   }

   @Bean
   public IJoinRequestRepository joinRequestRepository(){
       return  new JoinRequestRepository(dataStore());
   }


   @Bean
   public IGameClubService gameClubService(IGameRepository gameRepository, IGroupRepository groupRepository, IJoinRequestRepository joinRequestRepository, IPlayerRepository playerRepository){
       return new GameClubService(gameRepository, groupRepository, joinRequestRepository, playerRepository);
   }

   @Bean
   public IConsoleView consoleView(){
       return new ConsoleView();
   }

}
*/

