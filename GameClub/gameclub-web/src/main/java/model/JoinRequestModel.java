package model;

import gameclub.domain.JoinRequestState;

public class JoinRequestModel {
    private String userName;
    private String fullName;
    private Long groupId;
    private JoinRequestState state;
    private String decision;

    public JoinRequestModel(String userName, Long groupId, JoinRequestState state, String decision) {
        this.userName = userName;
        this.groupId = groupId;
        this.state = state;
        this.decision = decision;
    }

    public JoinRequestModel(String userName, String fullName, Long groupId, JoinRequestState state){
        this.userName = userName;
        this.fullName = fullName;
        this.groupId = groupId;
        this.state = state;
    }

    public JoinRequestModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public JoinRequestState getState() {
        return state;
    }

    public void setState(JoinRequestState state) {
        this.state = state;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "JoinRequestModel{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", groupId=" + groupId +
                ", state=" + state +
                ", decision='" + decision + '\'' +
                '}';
    }
}
