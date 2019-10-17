package org.white.cglibtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.white.springtest.SpringTestApplication;
import org.white.springtest.service.HelloService;

/**
 * <p></p >
 *
 * @author baixiong
 * @version $Id: CircuitTest.java, v 0.1 2019年10月16日 09:20:00 baixiong Exp$
 */
@SpringBootTest(classes = SpringTestApplication.class)
@RunWith(SpringRunner.class)
public class CircuitTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testHello() throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(helloService.testRejection())).start();
        }

        Thread.sleep(10000);
    }
}
