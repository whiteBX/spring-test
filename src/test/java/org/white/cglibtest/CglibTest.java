package org.white.cglibtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: CglibTest.java, v 0.1 2019年05月09日 15:12:00 white Exp$
 */
@RunWith(SpringRunner.class)
public class CglibTest {

    public void testHello() {
        System.out.println("hello cglib");
    }

    @Test
    public void testAround() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before execute" + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after execute" + method.getName());
            return result;
        });
        CglibTest cglibTest = (CglibTest) enhancer.create();
        cglibTest.testHello();
    }

}
