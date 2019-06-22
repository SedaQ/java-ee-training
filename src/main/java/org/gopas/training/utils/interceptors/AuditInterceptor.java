package org.gopas.training.utils.interceptors;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.gopas.training.utils.interceptors.bindings.Auditable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author SedaQ
 */
@Dependent
@Auditable
@Interceptor
public class AuditInterceptor {

    private static final Logger logger
            = LoggerFactory.getLogger(AuditInterceptor.class.getName());

    @AroundInvoke
    public Object audit(InvocationContext ctx) throws Exception {
        Object[] parameters = ctx.getParameters();
        logger.debug("LoggingInterceptor - before method invoke: "
                + ctx.getMethod().getName() + System.lineSeparator()
                + " at time: " + LocalDateTime.now(Clock.systemUTC())
                + " with parameters: " + Arrays.toString(parameters));

        Object result = ctx.proceed();

        logger.debug("LoggingInterceptor - after method invoke: "
                + ctx.getMethod().getName() + System.lineSeparator()
                + " at time: " + LocalDateTime.now(Clock.systemUTC())
                + " with parameters: " + Arrays.toString(parameters));

        return result;
    }

}
