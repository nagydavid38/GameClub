/*package gameclub.application;

//import gameclub.persistence.DataStore;
import gameclub.persistence.IGameRepository;
import gameclub.service.IGameClubService;
import gameclub.view.ConsoleView;
import gameclub.service.GameClubService;
import gameclub.view.IConsoleView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){

        IGameClubService gameClubService = ctx.getBean(GameClubService.class);
        ConsoleView view = ctx.getBean(ConsoleView.class);


        return args -> {
            view.printLogin();
            String username = view.getUsername();
            String password = view.getPassword();
            if(gameClubService.authentication(username, password)){
                view.printLoginSuccess(gameClubService.rolesOfPlayer(username));
            }else{
                view.printLoginFailure();
                System.exit(0);
            }

            view.printDoubleLine();

            view.printUserInformation(
                    gameClubService.rolesOfPlayer(username), gameClubService.playerName(username),
                    gameClubService.playerAdminGroup(username),gameClubService.groupJoinRequests(gameClubService.playerAdminGroup(username)),
                    gameClubService.gamesOfPlayer(username), gameClubService.groupsOfPlayer(username));

            view.printDoubleLine();

            int choice = view.printMenu(gameClubService.rolesOfPlayer(username));

            do {
                switch (choice){
                    case 1 :
                        view.printGameList(gameClubService.listAllGames());
                        choice = view.printMenu(gameClubService.rolesOfPlayer(username));
                        break;
                    case 2 :
                        String gameToAdd = view.printAddGame(gameClubService.gamesNotOwnedByPlayer(username));
                        gameClubService.addMyGame(gameToAdd, username);
                        choice = view.printMenu(gameClubService.rolesOfPlayer(username));
                        break;
                    case 3 :
                        String groupToJoin = view.printJoinGroup(gameClubService.notJoinedGroups(username));
                        gameClubService.createJoinRequest(username, groupToJoin);
                        choice = view.printMenu(gameClubService.rolesOfPlayer(username));
                        break;
                    case 4 :
                        String decision = view.printJoinRequestDecision(gameClubService.groupJoinRequests(gameClubService.playerAdminGroup(username)));
                        gameClubService.decideJoinRequest(view.getUsername(), gameClubService.playerAdminGroup(view.getUsername()), decision);
                        choice = view.printMenu(gameClubService.rolesOfPlayer(username));
                        break;
                    default:
                        view.printMenuWrongNumber();
                        choice = view.printMenu(gameClubService.rolesOfPlayer(username));
                }
            }while(choice != 5);

            System.exit(0);
            //DataStore.getInstance().writeObjectsToFile();
        };
    }
}
*/