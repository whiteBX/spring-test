package org.white.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.white.springtest.model.request.GrantCouponRequest;
import org.white.springtest.model.request.UseCouponRequest;
import org.white.springtest.validator.ValidateProcessor;
import org.white.springtest.validator.Validator;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestApplicationTests {

    @Autowired
    private ValidateProcessor validateProcessor;
    @Autowired
    private Set<Validator<GrantCouponRequest>> validatorList;
    @Autowired
    private Set<Validator<UseCouponRequest>> useCouponValidatorList;

    @Test
    public void contextLoads() {
        System.out.println(validatorList);
        System.out.println(useCouponValidatorList);
    }

}
