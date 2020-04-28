package com.fonxian.base.design.strategy;

import java.math.BigDecimal;

/**
 * @author Michael Fang
 * @since 2020-04-10
 */
public interface IPayService {

    String pay(BigDecimal amount);

}
