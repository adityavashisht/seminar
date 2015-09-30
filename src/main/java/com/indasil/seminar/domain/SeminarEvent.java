package com.indasil.seminar.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vashishta on 9/30/15.
 */
public class SeminarEvent implements Serializable {

    private Long id;// This is the primary key, by convention should be "id"
    private Seminar seminar;
    private Date startDate;
    private Date endDate;
    private String speaker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
