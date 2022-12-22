package com.temzu.freshcafe;

import com.temzu.freshcafe.enums.OrderTypes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreshCafeApplication {

  public static void main(String[] args) {
    Path uploadPath = Paths.get("src\\main\\resources\\static\\images");
    System.out.println(Files.exists(uploadPath));
    SpringApplication.run(FreshCafeApplication.class, args);
  }

}
