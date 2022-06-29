/*package gameclub.persistence;

import gameclub.domain.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PlayerRepository implements IPlayerRepository{
    List<Player> playerList;
    DataStore dataStore;

    public PlayerRepository(DataStore dataStore){
        this.dataStore = dataStore;
        playerList = this.dataStore.getInstance().getPlayerList();
    }

    @Override
    public List<Player> GetAll() {
        return playerList;
    }

    @Override
    public void Create(Player entity) {
        playerList.add(entity);
    }

    @Override
    public Player GetOne(Long id) {
        Player playerToGet = new Player();

        try{
            playerToGet = playerList.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such user exists");
        }

        return playerToGet;
    }

    @Override
    public Player GetOne(String username) {
        Player playerToGet = new Player();

        try{
            playerToGet = playerList.stream().filter(x -> x.getLoginName().equals(username)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such user exists");
        }

        return playerToGet;
    }
}
*/