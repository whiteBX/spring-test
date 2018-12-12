package org.white.springtest.model.request;

/**
 * <p></p >
 *
 * @author baixiong
 * @version $Id: GrantCouponRequest.java, v 0.1 2018年12月12日 16:54:00 baixiong Exp$
 */
public class GrantCouponRequest {

    private String uid;

    private String couponId;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
