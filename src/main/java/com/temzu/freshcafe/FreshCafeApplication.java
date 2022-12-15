package com.temzu.freshcafe;

import com.temzu.freshcafe.enums.OrderTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreshCafeApplication {

  public static void main(String[] args) {
    System.out.println(OrderTypes.DELIVERY);
    SpringApplication.run(FreshCafeApplication.class, args);
  }

}
