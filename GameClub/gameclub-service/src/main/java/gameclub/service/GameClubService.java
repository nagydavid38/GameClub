package gameclub.service;
import gameclub.domain.*;
import gameclub.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class GameClubService implements IGameClubService{


    IGameRepository gameRepository;
    IGroupRepository groupRepository;
    IJoinRequestRepository joinRequestRepository;
    IPlayerRepository playerRepository;
    IEventRepository eventRepository;


    @Autowired
    public GameClubService(IGameRepository gameRepository, IGroupRepository groupRepository, IJoinRequestRepository joinRequestRepository, IPlayerRepository playerRepository, IEventRepository eventRepository){
        this.gameRepository = gameRepository;
        this.groupRepository = groupRepository;
        this.joinRequestRepository = joinRequestRepository;
        this.playerRepository = playerRepository;
        this.eventRepository = eventRepository;
    }


    @Override
    public boolean authentication(String username, String password) throws NullPointerException {

        boolean success = false;

        try{
            if(playerRepository.findByLoginName(username).getPassword().equals(password)){
                success = true;
            }
            else{
                success = false;
            }
        }catch (NullPointerException e){
            System.out.print("");
        }

        return success;
    }

    @Override
    @Transactional
    public List<String> rolesOfPlayer(String username) {
        List<String> roleList = new ArrayList<>();
        Player currentPlayer = playerRepository.findByLoginName(username);
        for(Role role : currentPlayer.getRoles()){
            roleList.add(role.name());
        }
        return roleList;
    }

    @Override
    @Transactional
    public Map<String, String> playerBaseAttributes(String username) {
        Player currentPlayer = playerRepository.findByLoginName(username);
        return new HashMap<>(){
            {
                put("id", String.valueOf(currentPlayer.getId()));
                put("login", currentPlayer.getLoginName());
                put("name", currentPlayer.getName());
                put("email", currentPlayer.getEmail());
            }
        };
    }

    @Override
    @Transactional
    public List<Group> groupsOfPlayer(String username) {
        Player player = playerRepository.findByLoginName(username);
        return groupRepository.findAll().stream().filter(x -> x.getMembers().contains(player)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String playerName(String username) {
        return playerRepository.findByLoginName(username).getName();
    }

    @Override
    @Transactional
    public Group playerAdminGroup(String username) {
        Player admin = playerRepository.findByLoginName(username);

        return groupRepository.findByAdmin(admin);
    }

    @Override
    @Transactional
    public List<JoinRequest> groupJoinRequests(Long groupId) {
        return joinRequestRepository.findByGroupId(groupId).stream().filter(y -> y.getState().equals(JoinRequestState.REQUESTED)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Game> gamesOfPlayer(String username) {
        return playerRepository.findByLoginName(username).getGames();
    }

    @Override
    @Transactional
    public List<Game> gamesNotOwnedByPlayer(String username) {
        List<Game> games = new ArrayList<>();

        for(Game game : gameRepository.findAll()){
            if(!playerRepository.findByLoginName(username).getGames().contains(game)){
                games.add(game);
            }
        }
        return games;
    }

    @Override
    @Transactional
    public List<Game> listAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public void addGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    @Transactional
    public void addMyGame(String username, Long gameId) {
        Player player = playerRepository.findByLoginName(username);

        player.getGames().add(gameRepository.getById(gameId));
    }

    @Override
    @Transactional
    public void createJoinRequest(String username, Long groupId) {

        Group group = groupRepository.getById(groupId);
        Player player = playerRepository.findByLoginName(username);
        JoinRequest joinRequest = new JoinRequest(new JoinRequestId(player.getId(), group.getId()), group, player, JoinRequestState.REQUESTED);
        joinRequest = joinRequestRepository.save(joinRequest);
    }

    @Override
    @Transactional
    public void decideJoinRequest(String username, Long groupId, String decision) {

        Player player = playerRepository.findByLoginName(username);
        Group group = groupRepository.getById(groupId);

        JoinRequest joinRequest = joinRequestRepository.findByGroupIdAndUserId(group.getId(), player.getId());

        if(decision.equals("ACCEPT")){
            joinRequest.setState(JoinRequestState.ACCEPTED);
            group.getMembers().add(player);
        }
        else{
            joinRequest.setState(JoinRequestState.REJECTED);
        }
    }

    @Override
    @Transactional
    public List<Group> notJoinedGroups(String username) {
        Player player = playerRepository.findByLoginName(username);
        List<Group> notJoinedGroups = new ArrayList<>();

        for(Group group : groupRepository.findAll()){
            JoinRequest joinRequest = joinRequestRepository.findAll().stream().filter(x -> x.getGroup().equals(group)).filter(y -> y.getUser().equals(player)).findFirst().orElse(null);
            if(!group.getMembers().contains(player) && !group.getAdmin().getLoginName().equals(username) && Objects.isNull(joinRequest)){
                notJoinedGroups.add(group);
            }
            else if(!group.getMembers().contains(player) && !group.getAdmin().getLoginName().equals(username) &&
                    (joinRequest.getState() == JoinRequestState.REQUESTED || joinRequest.getState() == JoinRequestState.REJECTED)){
                notJoinedGroups.add(group);
            }
        }
        return notJoinedGroups;
    }

    @Override
    @Transactional
    public JoinRequestState groupRequestState(Long groupId, String userName) {

        Player player = playerRepository.findByLoginName(userName);

        JoinRequestState state = joinRequestRepository.findByGroupIdAndUserId(groupId, player.getId()) != null ?
                joinRequestRepository.findByGroupIdAndUserId(groupId, player.getId()).getState() : JoinRequestState.NOT_REQUESTED ;
        return state;
    }

    @Override
    @Transactional
    public Group getGroup(Long groupId){
        return groupRepository.findById(groupId).get();
    }

    @Override
    @Transactional
    public List<Event> getGroupEvents(Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        return group.getEvents();
    }

    @Override
    @Transactional
    public void addEventToGroup(Long groupId, Event event) {
        eventRepository.save(event);
        groupRepository.getById(groupId).getEvents().add(event);
    }

    @Override
    @Transactional
    public void attendEvent(Long eventId, String userName) {
        Player player = playerRepository.findByLoginName(userName);
        eventRepository.getById(eventId).getParticipants().add(player);
    }

    @Override
    public Player getPlayer(String userName) {
        return playerRepository.findByLoginName(userName);
    }


}

