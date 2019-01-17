package org.white.springtest.aop;

import java.lang.annotation.*;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: LogAop.java, v 0.1 2019年01月17日 14:23:00 white Exp$
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogAop {
}
