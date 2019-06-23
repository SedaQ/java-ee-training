package org.gopas.training.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import org.gopas.training.persistence.dao.MeetingDao;
import org.gopas.training.persistence.model.Meeting;

/**
 *
 * @author SedaQ
 */
@Stateless
public class MeetingServiceSessionBean {

    @Resource(name = "java:comp/env/concurrent/LongRunningTasksExecutor")
    private ManagedExecutorService managedExecutorService;
    @EJB
    private MeetingDao meetingDao;

    public MeetingServiceSessionBean() {
    }

    public Future<List<Meeting>> meetingsInPast() throws InterruptedException, ExecutionException {
        Future<List<Meeting>> pastMeetings = managedExecutorService.submit(() -> {
            return meetingDao.getMeetingsInPast();
        });
        return pastMeetings;
    }

}
