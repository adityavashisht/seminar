package com.indasil.seminar.domain;

import com.indasil.seminar.service.SeminarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vashishta on 9/30/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/service-config.xml"

})
@Transactional
public class DomainTest {

    @Autowired
    private SeminarService seminarService;


    @Test
    @Rollback(false)
    public void testSeminar() {
        seminarService.addSeminar(new Seminar());
    }
}
