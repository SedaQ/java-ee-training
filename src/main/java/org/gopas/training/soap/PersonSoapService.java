package org.gopas.training.soap;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.gopas.training.api.PersonDto;
import org.gopas.training.facade.PersonFacadeSessionBean;

/**
 *
 * @author Seda
 */
@WebService(serviceName = "PersonSoapService")
public class PersonSoapService {

    @EJB
    private PersonFacadeSessionBean personFacade;

    public PersonSoapService() {
    }

    public PersonSoapService(PersonFacadeSessionBean personFacade) {
        this.personFacade = personFacade;
    }

    @WebMethod(operationName = "getPersonById")
    public PersonDto getPersonById(@WebParam(name = "id") Long id) {
        return personFacade.getPersonById(id);
    }

    @WebMethod(operationName = "getAllPersons")
    public List<PersonDto> getAllPersons() {
        return personFacade.getAllPersons();
    }
}
