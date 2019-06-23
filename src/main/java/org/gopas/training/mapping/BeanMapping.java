package org.gopas.training.mapping;

import java.util.*;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;

/**
 * @author Pavel Šeda
 */
@Dependent
public class BeanMapping {

    @Inject
    private ModelMapper modelMapper;

    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        List<T> mappedCollection = new ArrayList<>();
        objects.forEach(object -> {
            mappedCollection.add(modelMapper.map(object, mapToClass));
        });
        return mappedCollection;
    }

    public <T> Set<T> mapToSet(Collection<?> objects, Class<T> mapToClass) {
        Set<T> mappedCollection = new HashSet<>();
        for (Object object : objects) {
            mappedCollection.add(modelMapper.map(object, mapToClass));
        }
        return mappedCollection;
    }

    public <T> Optional<T> mapToOptional(Object u, Class<T> mapToClass) {
        return Optional.ofNullable(modelMapper.map(u, mapToClass));
    }

    public <T> T mapTo(Object u, Class<T> mapToClass) {
        return modelMapper.map(u, mapToClass);
    }

    public boolean isCollection(Object obj) {
        return (obj instanceof Collection) || (obj instanceof Map);
    }

}
