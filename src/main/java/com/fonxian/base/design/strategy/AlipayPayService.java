package com.fonxian.base.design.strategy;

import java.math.BigDecimal;

/**
 * @author Michael Fang
 * @since 2020-04-10
 */
@PayType(document = "支付宝支付",type = 1)
public class AlipayPayService implements IPayService{

    @Override
    public String pay(BigDecimal amount) {
        return null;
    }

}
