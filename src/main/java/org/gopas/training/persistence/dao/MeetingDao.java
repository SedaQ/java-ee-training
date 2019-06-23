package org.gopas.training.persistence.dao;

import java.util.List;
import javax.ejb.Remote;
import org.gopas.training.persistence.model.Meeting;

/**
 *
 * @author SedaQ
 */
@Remote
public interface MeetingDao extends Dao<Long, Meeting> {

    List<Meeting> getMeetingsInPast();
}
