package com.indasil.seminar.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vashishta on 9/30/15.
 */
public class TechTalk implements Serializable {

    private Long id;
    private TechTalkType techTalkType;
    private Date startDate;
    private Date endDate;
    private String speaker;
    private SeminarEvent seminarEvent;

    public SeminarEvent getSeminarEvent() {
        return seminarEvent;
    }

    public void setSeminarEvent(SeminarEvent seminarEvent) {
        this.seminarEvent = seminarEvent;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TechTalkType getTechTalkType() {
        return techTalkType;
    }

    public void setTechTalkType(TechTalkType techTalkType) {
        this.techTalkType = techTalkType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechTalk techTalk = (TechTalk) o;

        if (!endDate.equals(techTalk.endDate)) return false;
        if (!speaker.equals(techTalk.speaker)) return false;
        if (!startDate.equals(techTalk.startDate)) return false;
        if (techTalkType != techTalk.techTalkType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = techTalkType.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + speaker.hashCode();
        return result;
    }
}
