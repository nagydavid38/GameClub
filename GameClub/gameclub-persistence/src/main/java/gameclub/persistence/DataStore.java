/*package gameclub.persistence;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import gameclub.domain.*;
import gameclub.domain.dtos.GameDTO;
import gameclub.domain.dtos.GroupDTO;
import gameclub.domain.dtos.JoinRequestDTO;
import gameclub.domain.dtos.UserDTO;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {

    private List<Game> gameList;
    private List<Player> playerList;
    private List<Group> groupList;
    private List<JoinRequest> joinRequestList;



    private static DataStore instance;

    public static DataStore getInstance(){
        if(instance == null){
            instance = new DataStore();
        }
        return instance;
    }

    private DataStore(){
        gameList = new ArrayList<>();
        playerList = new ArrayList<>();
        groupList = new ArrayList<>();
        joinRequestList = new ArrayList<>();
        loadObjectsFromFile();
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<JoinRequest> getJoinRequestList() {
        return joinRequestList;
    }

    public void setJoinRequestList(List<JoinRequest> joinRequestList) {
        this.joinRequestList = joinRequestList;
    }

    private <T> List<T> loadGameFiles(String file, Class<T[]> objClass){

        ObjectMapper mapper = new ObjectMapper();
        List<T> jsonObjects = new ArrayList<>();

        try{
            jsonObjects = Arrays.asList(mapper.readValue(Paths.get("gameclub-persistence\\src\\main\\resources\\" + file).toFile(), objClass));


        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObjects;
    }

    private void loadObjectsFromFile(){
        Mapper mapper = new Mapper();
        List<GameDTO> gameListDTO = loadGameFiles("games.json", GameDTO[].class);
        List<UserDTO> userListDTO = loadGameFiles("users.json", UserDTO[].class);
        List<GroupDTO> groupListDTO = loadGameFiles("groups.json", GroupDTO[].class);
        List<JoinRequestDTO> joinRequestListDTO = loadGameFiles("joinRequests.json", JoinRequestDTO[].class);

        for(GameDTO gameDTO : gameListDTO){
            gameList.add(mapper.toGame(gameDTO));
        }
        for(UserDTO userDTO : userListDTO){
            playerList.add(mapper.toUser(userDTO, gameList));
        }
        for(GroupDTO groupDTO : groupListDTO){
            groupList.add(mapper.toGroup(groupDTO,playerList));
        }
        for(JoinRequestDTO joinRequestDTO : joinRequestListDTO){
            joinRequestList.add(mapper.toJoinRequest(joinRequestDTO, groupList, playerList));
        }

    }

    public void writeObjectsToFile(){
        List<GameDTO> gameDTOList = new ArrayList<>();
        List<UserDTO> userDTOList = new ArrayList<>();
        List<GroupDTO> groupDTOList = new ArrayList<>();
        List<JoinRequestDTO> joinRequestDTOList = new ArrayList<>();

        Mapper mapper = new Mapper();

        for(Game game : gameList){
            gameDTOList.add(mapper.toGameDTO(game));
        }
        for(Player player : playerList){
            userDTOList.add(mapper.toUserDTO(player));
        }
        for(Group group : groupList){
            groupDTOList.add(mapper.toGroupDTO(group));
        }
        for(JoinRequest joinRequest : joinRequestList){
            joinRequestDTOList.add(mapper.toJoinRequestDTO(joinRequest));
        }

        writeFiles("games.json", gameDTOList);
        writeFiles("users.json", userDTOList);
        writeFiles("groups.json", groupDTOList);
        writeFiles("joinRequests.json", joinRequestDTOList);
    }

    private <T> void writeFiles(String file, List<T> objList){
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(Paths.get("gameclub-persistence\\src\\main\\resources\\" + file).toFile(), objList);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
*/