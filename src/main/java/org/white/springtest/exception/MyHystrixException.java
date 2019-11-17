package org.white.springtest.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: MyHystrixException.java, v 0.1 2019年10月21日 14:43:00 white Exp$
 */
public class MyHystrixException extends HystrixBadRequestException {

    private int code;

    public MyHystrixException(String message, int code) {
        super(message);
        this.code = code;
    }

    public MyHystrixException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
