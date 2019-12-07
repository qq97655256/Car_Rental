package first.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyExcption {
    @ExceptionHandler(value = AuthorizationException.class)
    public Integer mycc() {
        return 600;
    }
}
