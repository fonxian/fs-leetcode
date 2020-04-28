package com.fonxian.base.design.strategy;

import java.math.BigDecimal;

/**
 * @author Michael Fang
 * @since 2020-04-10
 */
@PayType(document = "微信支付",type = 2)
public class WechatPayService implements IPayService{

    @Override
    public String pay(BigDecimal amount) {
        return null;
    }

}
