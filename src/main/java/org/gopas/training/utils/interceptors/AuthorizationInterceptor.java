package org.gopas.training.utils.interceptors;

import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.gopas.training.utils.interceptors.bindings.IsAdminBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author SedaQ
 */
@Dependent
@IsAdminBinding
@Interceptor
public class AuthorizationInterceptor {

    private static final Logger logger
            = LoggerFactory.getLogger(AuthorizationInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        logger.debug("AuthorizationInterceptor - before EJB method invoke: "
                + ctx.getMethod().getName());

        try {
            authorizationCheck();
        } catch (Exception e) {
            logger.debug("Authorization check failed");
            throw e;
        }

        return ctx.proceed();
    }

    private void authorizationCheck() throws Exception {
        // Do some kind of authorization check.
        // Throw exception if user is not authorized
    }

}
