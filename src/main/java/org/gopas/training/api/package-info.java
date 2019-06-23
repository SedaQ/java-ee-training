@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type = LocalDate.class,
            value = LocalDateAdapter.class),
    @XmlJavaTypeAdapter(type = LocalDateTime.class,
            value = LocalDateTimeAdapter.class),
    @XmlJavaTypeAdapter(type = Duration.class,
            value = DurationAdapter.class)
})
package org.gopas.training.api;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import org.gopas.training.utils.adapters.DurationAdapter;
import org.gopas.training.utils.adapters.LocalDateAdapter;
import org.gopas.training.utils.adapters.LocalDateTimeAdapter;
