package com.indasil.seminar.integration;

import com.indasil.seminar.domain.*;
import com.indasil.seminar.service.SeminarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by vashishta on 9/30/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/integration-h2.xml"

})
@Transactional
public class SeminarIntegrationTest {

    @Autowired
    private SeminarService seminarService;


    @Test
    @Rollback(false)
    public void testSeminar() {

        TechTalk techTalk = new TechTalk();
        techTalk.setSpeaker("Aditya");
        techTalk.setStartDate(new Date());
        techTalk.setEndDate(new Date());
        techTalk.setTechTalkType(TechTalkType.HEALTH_CARE);
        techTalk.setDayOfWeek(DayOfWeek.THURSDAY);

        SeminarEvent seminarEvent = new SeminarEvent();

        seminarEvent.setStartDate(new Date());
        seminarEvent.setEndDate(new Date());
        seminarEvent.setActive(true);

        // Tell child about parent
        techTalk.setSeminarEvent(seminarEvent);
        // ADd child to parent collection
        seminarEvent.getTechTalkSet().add(techTalk);


        Seminar seminar = new Seminar();
        seminar.setName("Health Care Stuff");

        // Tell child about parent
        seminarEvent.setSeminar(seminar);
        // ADd child to parent collection
        seminar.getSeminarEventSet().add(seminarEvent);



        seminar.setStart(new Date());

        seminarService.addSeminar(seminar);


    }

    @Test
    public void testGetSeminarById() {
        Seminar seminar = seminarService.getSeminarById(1L);
        Assert.assertEquals("Health Care Stuff", seminar.getName());

    }


}
