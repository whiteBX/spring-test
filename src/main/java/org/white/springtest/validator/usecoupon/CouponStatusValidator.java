package org.white.springtest.validator.usecoupon;

import org.springframework.stereotype.Component;
import org.white.springtest.model.entity.ValidateResult;
import org.white.springtest.model.request.UseCouponRequest;
import org.white.springtest.validator.Validator;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: CouponStatusValidator.java, v 0.1 2018年12月12日 16:57:00 white Exp$
 */
@Component
public class CouponStatusValidator implements Validator<UseCouponRequest> {
    @Override
    public ValidateResult validate(UseCouponRequest request) {
        return null;
    }
}
