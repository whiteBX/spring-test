package org.white.springtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.white.springtest.aop.LogAspect;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: BeanConfiguration.java, v 0.1 2019年01月17日 15:08:00 white Exp$
 */
@Configuration
public class BeanConfiguration {


    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
