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
}
