package org.white.springtest.validator.grantcoupon;

import org.springframework.stereotype.Component;
import org.white.springtest.model.entity.ValidateResult;
import org.white.springtest.model.request.GrantCouponRequest;
import org.white.springtest.validator.Validator;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: DayCountValidator.java, v 0.1 2018年12月12日 16:39:00 white Exp$
 */
@Component
public class DayCountValidator implements Validator<GrantCouponRequest> {


    @Override
    public ValidateResult validate(GrantCouponRequest request) {
        return null;
    }
}
