package com.indasil.seminar.domain;

import com.indasil.seminar.config.AppConfig;
import com.indasil.seminar.service.SeminarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by vashishta on 9/30/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextHierarchy({
        @ContextConfiguration(classes = AppConfig.class)
})
public class JavaConfigTest {


    @Autowired
    private SeminarService seminarService;


    @Test
    public void testjavaConfig() {
        seminarService.addSeminar(new Seminar());
    }
}
