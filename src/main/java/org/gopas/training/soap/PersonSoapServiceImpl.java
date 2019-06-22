package org.gopas.training.soap;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebParam;
import org.gopas.training.api.PersonDto;
import org.gopas.training.facade.PersonFacadeSessionBean;

/**
 *
 * @author Seda
 */
@WebService(serviceName = "PersonSoapService",
        portName = "PersonSoapServicePort",
        endpointInterface = "org.gopas.training.soap.PersonSoapService")
public class PersonSoapServiceImpl implements PersonSoapService {

    @EJB
    private PersonFacadeSessionBean personFacade;

    public PersonSoapServiceImpl() {
    }

    public PersonSoapServiceImpl(PersonFacadeSessionBean personFacade) {
        this.personFacade = personFacade;
    }

    @Override
    public PersonDto getPersonById(@WebParam(name = "id") Long id) {
        return personFacade.getPersonById(id);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personFacade.getAllPersons();
    }
}
