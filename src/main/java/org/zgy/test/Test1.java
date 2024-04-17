package org.zgy.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author z
 * @create 2022/9/7 10:22
 */
public class Test1 {

  public static void main(String[] args) {
    double a = 3.3;
    double b = 1.1;
    System.out.println(a/b);

    BigDecimal b1 = new BigDecimal("1");
    BigDecimal b2 = new BigDecimal("3");
    System.out.println(b1.divide(b2,200000000, RoundingMode.HALF_UP));

    BigDecimal b3 = new BigDecimal(0.625);
    System.out.println(b3);
  }
}
