package com.indasil.seminar.domain;

import com.samao.seminar.domain.Seminar;
import com.samao.seminar.service.SeminarService;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by vashishta on 10/5/15.
 */
public class MyJUnitTest {

    private SessionFactory sessionFactory;
    private ClassPathXmlApplicationContext applicationContext;
    private SeminarService seminarService;

    // After every test call the setup method
    @Before
    public void setUp() {
        System.out.println("Setup was called");

        applicationContext = new ClassPathXmlApplicationContext(new String[]{"/service-config.xml"});
        Assert.notNull(applicationContext);
        sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        seminarService = (SeminarService) applicationContext.getBean("seminarService");
    }

    // after every test call the teardown method
    @After
    public void tearDown() {
        System.out.println("Teardown was called");
        applicationContext.destroy();

    }


    // Run all my tests
    @Test
    public void testFirst() {

        Seminar seminar = new Seminar();
        seminarService.addSeminar(seminar);

    }

    @Test
    public void testLast() {
        System.out.println("Test Last");
    }
}
