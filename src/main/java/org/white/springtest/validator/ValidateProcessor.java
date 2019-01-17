package org.white.springtest.validator;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.white.springtest.model.entity.ValidateResult;
import org.white.springtest.model.request.GrantCouponRequest;


/**
 * <p></p >
 *
 * @author white
 * @version $Id: ValidateProcessor.java, v 0.1 2018年12月12日 16:23:00 white Exp$
 */
@Service
public class ValidateProcessor {

    @Autowired
    private Set<Validator<GrantCouponRequest>> validatorList;

    /**
     * 验证
     * @param grantCouponRequest
     * @return
     */
    public ValidateResult validate(GrantCouponRequest grantCouponRequest) {
        for (Validator<GrantCouponRequest> validator : validatorList) {
            ValidateResult result = validator.validate(grantCouponRequest);
            if (result.getCode() != 0) {
                return result;
            }
        }
        return new ValidateResult();
    }

}
