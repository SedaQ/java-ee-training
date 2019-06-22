package org.gopas.training.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

/**
 *
 * Sometimes you want to inject a class that you can’t modify its source (that’s
 * imported from an external library or in the java classes).
 *
 * Other times you want to inject a bean that needs to have some initialization.
 *
 * The solution for both cases is to make a method that’s responsible for
 * generating the bean:
 *
 *
 *
 * @author SedaQ
 */
@ApplicationScoped
public class ProducesBeans {

    /**
     *
     * @return the instance of ModelMapper class to map entities to DTO or vice
     * versa
     */
    @Produces
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }

}
