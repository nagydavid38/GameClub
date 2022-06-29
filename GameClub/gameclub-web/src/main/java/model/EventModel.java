package model;

import gameclub.webapplication.validation.FutureDateConstraint;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class EventModel {

    private Long id;
    @FutureDateConstraint
    private String event_date;
    @NotBlank(message = "Location must be filled!")
    private String location;
    @NotBlank(message = "Description must be filled!")
    private String description;
    private List<String> participants;
    private Boolean currentPlayerParticipates;

    public Long getId() {
        return id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public Boolean getCurrentPlayerParticipates() {
        return currentPlayerParticipates;
    }

    public void setCurrentPlayerParticipates(Boolean currentPlayerParticipates) {
        this.currentPlayerParticipates = currentPlayerParticipates;
    }

    public EventModel(Long id, String event_date, String location, String description, List<String> participants, Boolean currentPlayerParticipates) {
        this.id = id;
        this.event_date = event_date;
        this.location = location;
        this.description = description;
        this.participants = participants;
        this.currentPlayerParticipates = currentPlayerParticipates;
    }

    public EventModel() {
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", event_date='" + event_date + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", participants=" + participants +
                ", currentPlayerParticipates=" + currentPlayerParticipates +
                '}';
    }
}
