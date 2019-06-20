package org.gopas.training.soap;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.gopas.training.api.PersonDto;
import org.gopas.training.facade.PersonFacade;

/**
 *
 * @author Seda
 */
@WebService(serviceName = "PersonSoapService")
public class PersonSoapService {

    @EJB
    private PersonFacade personFacade;

    public PersonSoapService(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getPersonById")
    public PersonDto getPersonById(@WebParam(name = "id") Long id) {
        return personFacade.getPersonById(id);
    }
}
