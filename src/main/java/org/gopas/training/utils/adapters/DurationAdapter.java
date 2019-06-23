package org.gopas.training.utils.adapters;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Pavel Seda
 */
public class DurationAdapter extends XmlAdapter<Long, Duration> {

    @Override
    public Duration unmarshal(Long duration) throws Exception {
        return Duration.of(duration, ChronoUnit.NANOS);
    }

    @Override
    public Long marshal(Duration duration) throws Exception {
        return duration.toMillis();
    }

}
