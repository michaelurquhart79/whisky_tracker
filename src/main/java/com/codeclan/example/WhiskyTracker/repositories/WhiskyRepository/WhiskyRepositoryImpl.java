package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional

    public List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(String name, int age) {
//    public List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(int age) {
//    public List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(String name) {

        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Whisky.class);
        criteria.add(Restrictions.eq("age", age));
        criteria.createAlias("distillery", "distilleryAlias");
        criteria.add(Restrictions.eq("distilleryAlias.name", name));
//        criteria.add(Restrictions.eq("distillery.name", name)); DOESN'T WORK IN PLACE OF PREVIOUS 2 LINES
        result = criteria.list();

        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesByRegion(String region) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Whisky.class);
        criteria.createAlias("distillery", "distilleryAlias");
        criteria.add(Restrictions.eq("distilleryAlias.region", region));
        result = criteria.list();

        return result;
    }

}
