package org.gopas.training.persistence.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.gopas.training.persistence.dao.AbstractJpaDao;
import org.gopas.training.persistence.dao.MeetingDao;
import org.gopas.training.persistence.model.Meeting;

/**
 * @author Pavel Seda
 */
@Stateless
public class MeetingDaoImpl extends AbstractJpaDao<Long, Meeting> implements MeetingDao {

    public MeetingDaoImpl() {
    }

    @Override
    public List<Meeting> getMeetingsInPast() {
        // "SELECT m FROM Meeting m JOIN FETCH m.persons p WHERE ((m.startTime + m.duration * (interval '1 millisecond')) < CURRENT_TIMESTAMP)"

        TypedQuery<Meeting> meetings = entityManager
                .createQuery("SELECT m FROM Meeting m JOIN FETCH m.persons p WHERE m.startTime < CURRENT_TIMESTAMP", Meeting.class);
        return meetings.getResultList();
    }
}
