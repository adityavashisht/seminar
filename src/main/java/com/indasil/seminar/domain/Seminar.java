package com.indasil.seminar.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 9/30/15.
 */
public class Seminar implements Serializable {
    private Long id;
    private String name;
    private Date start;

    private Set<SeminarEvent> seminarEventSet = new HashSet<>();

    public Set<SeminarEvent> getSeminarEventSet() {
        return seminarEventSet;
    }

    public void setSeminarEventSet(Set<SeminarEvent> seminarEventSet) {
        this.seminarEventSet = seminarEventSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
