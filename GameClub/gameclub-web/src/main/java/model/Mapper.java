package model;

import gameclub.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public Mapper() {
    }

    public PlayerModel toPlayerModel(Player player){
        return new PlayerModel(
                player.getId(),
                player.getName(),
                player.getEmail()
                );
    }

    public GameModel toGameModel(Game game){
        List<String> categories = new ArrayList<>();
        for (Category category : game.getCategories()){
            categories.add(category.toString());
        }
        return new GameModel(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getMinimumAge(),
                game.getPlayTime().getMin(),
                game.getPlayTime().getMax(),
                game.getNumberOfPlayers().getMin(),
                game.getNumberOfPlayers().getMax(),
                categories
        );
    }

    public Game toGame(GameModel gameModel){
        List<Category> categories = new ArrayList<>();
        for (String category : gameModel.getCategories()){
            categories.add(Category.valueOf(category.toUpperCase()));
        }
        return new Game(
                gameModel.getId(),
                gameModel.getName(),
                gameModel.getDescription(),
                gameModel.getMinimumAge(),
                new Limits(gameModel.getPlayTime_min(), gameModel.getPlayTime_max()),
                new Limits(gameModel.getNumOfPlayers_min(), gameModel.getNumOfPlayers_max()),
                categories
        );
    }

    public GroupModel toGroupModel(Group group, String requestState){
        List<Long> memberIdList = new ArrayList<>();

        for(Player player : group.getMembers()){
            memberIdList.add(player.getId());
        }


        return new GroupModel(
                group.getId(),
                group.getName(),
                memberIdList.stream().count(),
                group.getAdmin().getName(),
                requestState
        );
    }

    public GroupModel toGroupModel(Group group, Player currentPlayer){

        List<PlayerModel> playerModelList = new ArrayList<>();
        List<EventModel> eventModelList = new ArrayList<>();

        for (Player player : group.getMembers()){
            playerModelList.add(toPlayerModel(player));
        }

        for (Event event : group.getEvents()){
            eventModelList.add(toEventModel(event, currentPlayer));
        }

        return new GroupModel(
                group.getId(),
                group.getName(),
                playerModelList,
                group.getAdmin().getName(),
                eventModelList
        );
    }

    public EventModel toEventModel(Event event, Player currentPlayer){
        List<String> participantList = new ArrayList<>();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(event.getDate());
        for (Player player : event.getParticipants()){
            participantList.add(player.getName());
        }
        Boolean currentPlayerParticipates = event.getParticipants().contains(currentPlayer);
        return new EventModel(
                event.getId(),
                date,
                event.getPlace(),
                event.getDescription(),
                participantList,
                currentPlayerParticipates
        );
    }

    public Event toEvent(EventModel eventModel){
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.parse(eventModel.getEvent_date()), LocalTime.MIN);
        return new Event(
                eventModel.getId(),
                dateTime,
                eventModel.getLocation(),
                eventModel.getDescription(),
                new ArrayList<Player>()
        );
    }

    public JoinRequestModel toJoinRequestModel(JoinRequest joinRequest){
        return new JoinRequestModel(
                joinRequest.getUser().getLoginName(),
                joinRequest.getUser().getName(),
                joinRequest.getGroup().getId(),
                joinRequest.getState()
        );
    }
}
