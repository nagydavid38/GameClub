/*package gameclub.persistence;


import gameclub.domain.Game;
import gameclub.domain.Group;
import gameclub.domain.JoinRequest;
import gameclub.domain.Player;
import gameclub.domain.dtos.GameDTO;
import gameclub.domain.dtos.GroupDTO;
import gameclub.domain.dtos.JoinRequestDTO;
import gameclub.domain.dtos.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public GameDTO toGameDTO(Game game){
        return new GameDTO(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getMinimumAge(),
                game.getPlayTime(),
                game.getNumberOfPlayers(),
                game.getCategories()
        );
    }

    public GroupDTO toGroupDTO(Group group){
        List<Long> memberIdList = new ArrayList<>();
        for(Player player : group.getMembers()){
            memberIdList.add(player.getId());
        }
        return new GroupDTO(
                group.getId(),
                group.getName(),
                memberIdList,
                group.getAdmin().getId()
        );
    }

    public JoinRequestDTO toJoinRequestDTO(JoinRequest joinRequest){
        return new JoinRequestDTO(
                joinRequest.getId(),
                joinRequest.getGroup().getId(),
                joinRequest.getUser().getId(),
                joinRequest.getState()
        );
    }

    public UserDTO toUserDTO(Player player){
        List<Long> gameIdList = new ArrayList<>();
        for(Game game : player.getGames()){
            gameIdList.add(game.getId());
        }
        return new UserDTO(
                player.getId(),
                player.getLoginName(),
                player.getName(),
                player.getPassword(),
                player.getEmail(),
                player.getRoles(),
                gameIdList
        );
    }

    public Game toGame(GameDTO gameDTO){
        Game game = new Game(
                gameDTO.getId(),
                gameDTO.getName(),
                gameDTO.getDescription(),
                gameDTO.getMinimumAge(),
                gameDTO.getPlayTime(),
                gameDTO.getNumberOfPlayers(),
                gameDTO.getCategories()
        );

        return game;
    }

    public Group toGroup(GroupDTO groupDTO, List<Player> playerList){

        List<Player> members = new ArrayList<>();

        for(Long id : groupDTO.getMembers()){
            members.add(playerList.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null));
        }

        return new Group(
                groupDTO.getId(),
                groupDTO.getName(),
                members,
                playerList.stream().filter(x -> x.getId().equals(groupDTO.getAdmin())).findAny().orElse(null)
        );
    }

    public JoinRequest toJoinRequest(JoinRequestDTO joinRequestDTO, List<Group> groupList, List<Player> playerList){


        return new JoinRequest(
                joinRequestDTO.getId(),
                groupList.stream().filter(x -> x.getId().equals(joinRequestDTO.getGroupId())).findAny().orElse(null),
                playerList.stream().filter(x -> x.getId().equals(joinRequestDTO.getUserId())).findAny().orElse(null),
                joinRequestDTO.getState()
        );
    }

    public Player toUser(UserDTO userDTO, List<Game> gameList){
        List<Game> actualGames =  new ArrayList<>();
        for(Long gameId : userDTO.getGames()){
            actualGames.add(gameList.stream().filter(x -> x.getId().equals(gameId)).findAny().orElse(null));
        }

        return new Player(
                userDTO.getId(),
                userDTO.getLoginName(),
                userDTO.getName(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getRoles(),
                actualGames
        );
    }
}
*/