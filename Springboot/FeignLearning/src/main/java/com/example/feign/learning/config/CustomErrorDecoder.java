package com.example.feign.learning.config;

import com.example.feign.learning.exceptions.BadRequestException;
import com.example.feign.learning.exceptions.NotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    switch (response.status()){
      case 400:
        return new BadRequestException();
      case 404:
        return new NotFoundException("Not Found!");
      default:
        return new Exception("Generic Error");
    }
  }
}
