/*package gameclub.persistence;

import gameclub.domain.Game;
import gameclub.domain.Group;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class GameRepository implements IGameRepository {

    List<Game> gameList;
    DataStore dataStore;

    public GameRepository(DataStore dataStore){
        this.dataStore = dataStore;
        gameList = this.dataStore.getInstance().getGameList();
    }
    @Override
    public List<Game> GetAll() {
        return gameList;
    }

    @Override
    public void Create(Game entity) {
        gameList.add(entity);

    }

    @Override
    public Game GetOne(Long id) {
        Game gameToGet = new Game();
        try{
            gameToGet = gameList.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such game in the list");
        }

        return gameToGet;
    }

    @Override
    public Game GetOne(String gameName) {
        Game gameToGet = new Game();
        try{
            gameToGet = gameList.stream().filter(x -> x.getName().equals(gameName)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such game exists");
        }

        return gameToGet;
    }
}
*/