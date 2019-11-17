package org.white.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.white.springtest.service.HelloService;

import javax.annotation.Resource;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloService.java, v 0.1 2019年05月09日 11:45:00 white Exp$
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloSentinelService;

    @GetMapping("/testHello/{message}")
    public String testHello(@PathVariable("message") int message) {
        return helloSentinelService.sayHello(message);
    }

    @GetMapping("/testHelloTimeOut/{time}")
    public String testHelloTimeOut(@PathVariable("time") long time) throws InterruptedException {
        return helloSentinelService.sayHelloTimeOut(time);
    }

}
