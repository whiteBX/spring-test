package org.white.springtest.validator;


import org.white.springtest.model.entity.ValidateResult;

/**
 * <p></p >
 *
 * @author baixiong
 * @version $Id: Validator.java, v 0.1 2018年12月12日 16:03:00 baixiong Exp$
 */
public interface Validator<T> {

    /**
     * 验证
     * @param request
     */
    ValidateResult validate(T request);
}
