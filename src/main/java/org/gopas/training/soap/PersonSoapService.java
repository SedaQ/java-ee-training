package org.gopas.training.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.gopas.training.api.MeetingsInPastDto;
import org.gopas.training.api.PersonDto;

/**
 *
 * @author SedaQ
 */
@WebService(name = "PersonSoapService")
public interface PersonSoapService {

    @WebMethod(operationName = "getPersonById")
    @WebResult(name = "person")
    public PersonDto getPersonById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "getAllPersons")
    @WebResult(name = "persons")
    public List<PersonDto> getAllPersons();

    @WebMethod(operationName = "getAllMeetingsInPast")
    @WebResult(name = "meetings")
    public List<MeetingsInPastDto> getAllMeetingsInPast();

}
