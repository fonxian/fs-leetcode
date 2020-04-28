package com.fonxian.base.design.strategy;

import javax.annotation.Generated;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Documented
public @interface PayType {

    int type();

    String document();

}
