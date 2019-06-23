package org.gopas.training.api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SedaQ
 */
public class MeetingsInPastDto {

    private Long idMeeting;
    private LocalDateTime startTime;
    private Duration duration;
    private String place;
    private String note;
    private Set<PersonOnMeetingDto> persons = new HashSet<>();

    public MeetingsInPastDto() {
    }

    public MeetingsInPastDto(Long idMeeting, LocalDateTime startTime, Duration duration, String place, String note) {
        this.idMeeting = idMeeting;
        this.startTime = startTime;
        this.duration = duration;
        this.place = place;
        this.note = note;
    }

    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<PersonOnMeetingDto> getPersons() {
        return persons;
    }

    public void setPersons(Set<PersonOnMeetingDto> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "ActiveMeetingsDto{" + "idMeeting=" + idMeeting + ", startTime=" + startTime + ", duration=" + duration + ", place=" + place + ", note=" + note + ", persons=" + persons + '}';
    }

}
