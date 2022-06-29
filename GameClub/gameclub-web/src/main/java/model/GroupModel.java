package model;

import gameclub.domain.Player;

import java.util.List;

public class GroupModel {
    private Long id;
    private String name;
    private Long membersNum;
    private List<PlayerModel> playerList;
    private String adminName;
    private String requestStatus;
    private List<EventModel> eventList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PlayerModel> getPlayerList(){return playerList;}

    public Long getMembersNum() {
        return membersNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getRequestStatus() {return requestStatus;}

    public List<EventModel> getEventList() {
        return eventList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembersNum(Long membersNum) {
        this.membersNum = membersNum;
    }

    public void setPlayerList(List<PlayerModel> playerList) {
        this.playerList = playerList;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setEventList(List<EventModel> eventList) {
        this.eventList = eventList;
    }

    public GroupModel(Long id, String name, Long members, String admin, String requestStatus) {
        this.id = id;
        this.name = name;
        this.membersNum = members;
        this.adminName = admin;
        switch (requestStatus){
            case "REQUESTED":
                this.requestStatus = "Membership requested";
                break;
            case "NOT_REQUESTED":
                this.requestStatus = "Request to join";
                break;
            default:
                this.requestStatus  = requestStatus;
        }
    }

    public GroupModel(Long id, String name, List<PlayerModel> players, String adminName, List<EventModel> eventList){
        this.id = id;
        this.name = name;
        this.playerList = players;
        this.adminName = adminName;
        this.eventList = eventList;
    }

    public GroupModel() {
    }

}
