package com.infoshareacademy.searchengine.interceptors;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.validation.constraints.Null;
import java.util.logging.Logger;

public class AddUserSetGenderInterceptor {

    Logger logger = Logger.getLogger(AddUserSetGenderInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();
        for (Object parameter : parameters) {
            User user = (User) parameter;
            if (user.getGender() == null) {
                try {
                    if (user.getName().endsWith("a")) {
                        user.setGender(Gender.WOMAN);
                    } else {
                        user.setGender(Gender.MAN);
                    }
                } catch (NullPointerException e) {
                    return context.proceed();
                }
            }
            logger.info("Gender interceptor: Gender has been set to: " + user.getGender().toString());
        }
        context.setParameters(parameters);
        return context.proceed();
    }
}
