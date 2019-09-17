package org.white.springtest.aop;

import java.lang.annotation.*;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: CircuitAop.java, v 0.1 2019年05月14日 11:38:00 white Exp$
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CircuitAop {

    String fallbackMethod();
}
