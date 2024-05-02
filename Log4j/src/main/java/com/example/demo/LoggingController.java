package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggingController {

  final private Logger logger = LoggerFactory.getLogger(LoggingController.class);

  final private String emailJson = "{ \"emailList\":\"test@example.com\" }";

  final private String longEmailJson = "{ \"emailList\": [\"test@example.com\", " +
      "\"another@gmail.com\", \"tHiRd@Yahoo.com\"] }";

  @GetMapping("/test")
  public String getTest() {
    logger.debug("Hello world!");
    logger.info("Hi how does this work?");
    logger.info("test@example.com");
    logger.info(emailJson);
    logger.info(longEmailJson);

    return "hello everyone";
  }

}
