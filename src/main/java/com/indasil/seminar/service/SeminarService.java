package com.indasil.seminar.service;

import com.indasil.seminar.domain.Seminar;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vashishta on 9/30/15.
 */
@Component
@Transactional
public class SeminarService {

    @Autowired
    private SessionFactory sessionFactory;

    public void addSeminar(Seminar seminar) {

    }
}
