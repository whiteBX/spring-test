package org.white.springtest.model.entity;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: ValidateResult.java, v 0.1 2018年12月12日 16:06:00 white Exp$
 */
public class ValidateResult {
    /**
     * 验证码
     */
    private int    code = 0;
    /**
     * 验证消息
     */
    private String message;

    public ValidateResult() {
    }

    public ValidateResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
