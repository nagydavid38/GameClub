package gameclub.service;

import gameclub.domain.*;

import java.util.List;
import java.util.Map;

public interface IGameClubService {
    boolean authentication(String username, String password);

    List<String> rolesOfPlayer(String username);

    Map<String, String> playerBaseAttributes(String username);

    List<Group> groupsOfPlayer(String username);

    String playerName(String username);

    Group playerAdminGroup(String username);

    List<JoinRequest> groupJoinRequests(Long groupId);

    List<Game> gamesOfPlayer(String username);

    List<Game> gamesNotOwnedByPlayer(String username);

    List<Game> listAllGames();

    void addGame(Game game);

    void addMyGame(String username, Long gameId);

    void createJoinRequest(String username, Long groupId);

    void decideJoinRequest(String username, Long groupId, String decision);

    List<Group> notJoinedGroups(String username);

    JoinRequestState groupRequestState(Long groupId, String userName);

    Group getGroup(Long groupId);

    List<Event> getGroupEvents(Long groupId);

    void addEventToGroup(Long groupId, Event event);

    void attendEvent(Long eventId, String userName);

    Player getPlayer(String userName);

}
