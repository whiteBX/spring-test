package org.white.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloService.java, v 0.1 2019年05月09日 11:45:00 white Exp$
 */
@Controller
public class HelloController {

    @GetMapping("/{message}")
    public String testHello(@PathVariable("message") String message) {
        return message;
    }
}
