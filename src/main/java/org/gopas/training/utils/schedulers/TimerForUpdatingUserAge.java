package org.gopas.training.utils.schedulers;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.enterprise.context.ApplicationScoped;
import org.gopas.training.persistence.model.Person;
import org.gopas.training.service.PersonServiceSessionBean;

/**
 *
 * @author SedaQ
 */
@ApplicationScoped
public class TimerForUpdatingUserAge {

    @EJB
    private PersonServiceSessionBean personServiceSessionBean;

    public TimerForUpdatingUserAge() {
    }

    @Schedule(dayOfMonth = "*")
    public void checkUserAge() {
        List<Person> birthdays = personServiceSessionBean.getPersonsWithBirthday();
        birthdays.forEach(System.out::println);
    }

}
