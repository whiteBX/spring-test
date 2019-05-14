package org.white.springtest;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.white.springtest.model.request.GrantCouponRequest;
import org.white.springtest.model.request.UseCouponRequest;
import org.white.springtest.service.HelloService;
import org.white.springtest.validator.ValidateProcessor;
import org.white.springtest.validator.Validator;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAspectJAutoProxy
public class SpringTestApplicationTests {

    @Autowired
    private ValidateProcessor                  validateProcessor;
    @Autowired
    private Set<Validator<GrantCouponRequest>> validatorList;
    @Autowired
    private Set<Validator<UseCouponRequest>>   useCouponValidatorList;
    @Autowired
    private HelloService                       helloService;

    @Test
    public void contextLoads() {
        System.out.println(validatorList);
        System.out.println(useCouponValidatorList);
    }

    @Test
    public void test() {
        helloService.sayHello(1);
    }

}
