package com.indasil.seminar.service;

import com.indasil.seminar.domain.Seminar;
import com.indasil.seminar.domain.SeminarEvent;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vashishta on 9/30/15.
 */
@Component
@Transactional
public class SeminarService {

    @Autowired
    private SessionFactory sessionFactory;

    public void addSeminar(Seminar seminar) {
        sessionFactory.getCurrentSession().save(seminar);

    }

    /**
     * @param id
     * @return
     */
    public Seminar getSeminarById(Long id) {
        return sessionFactory.getCurrentSession().load(Seminar.class, id);
    }

    /**
     * @param startDate
     * @return
     */
    public Seminar getByStartDate(Date startDate) {
        // Create HQL query to query the "Objects" not tables

        String HQL = "from Seminar s where s.start = ?"; // HQL syntax  Hibernate Query Language

        Query query = sessionFactory.getCurrentSession().createQuery(HQL);

        // Bind the parameters on the HSQL using setParameter and then query for a list

        List<Seminar> seminarList = query.setParameter(0, startDate).list();

        Seminar seminar = null;

        if (seminarList != null && !seminarList.isEmpty()) {
            seminar = seminarList.get(0);
        }
        return seminar;

    }


    /**
     * @param startDate
     * @return
     */
    public Seminar getByStartDateByNamedParameter(Date startDate) {
        // Create HQL query to query the "Objects" not tables

        String HQL = "from Seminar s where s.start =:start"; // HQL syntax  Hibernate Query Language

        Query query = sessionFactory.getCurrentSession().createQuery(HQL);

        // Bind the parameters on the HSQL using setParameter and then query for a list

        List<Seminar> seminarList = query.setParameter("start", startDate).list();

        Seminar seminar = null;

        if (seminarList != null && !seminarList.isEmpty()) {
            seminar = seminarList.get(0);
        }
        return seminar;

    }

    public Seminar getByDateAndNamedQuery(Date startDate) {

        Query query = sessionFactory.getCurrentSession().getNamedQuery("query.Seminar.getByStartDate").setParameter("start", startDate);


        List<Seminar> seminarList = query.list();

        Seminar seminar = null;

        if (seminarList != null && !seminarList.isEmpty()) {
            seminar = seminarList.get(0);
        }
        return seminar;


    }


    public Seminar getByCriteria(Date startDate) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Seminar.class);
        criteria.add(Restrictions.between("start", startDate, startDate))

        ;

        List<Seminar> seminarList = criteria.list();

        Seminar seminar = null;

        if (seminarList != null && !seminarList.isEmpty()) {
            seminar = seminarList.get(0);
        }
        return seminar;


    }

    public List<SeminarEvent> getEventsBySeminarId(Long id) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SeminarEvent.class);
        criteria.add(Restrictions.eq("seminar.id", id));

        return criteria.list();

    }

}
