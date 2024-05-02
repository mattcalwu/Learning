package com.example.feign.learning.clients;

import com.example.feign.learning.config.ClientConfiguration;
import com.example.feign.learning.service.JSONPlaceHolderFallback;
import com.example.feign.learning.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * What's cool about feign is that I don't need to implement
 * any code for the client itself.
 * This in itself provides default feign clients
 */
@FeignClient(value = "jplaceholder",
    url = "https://jsonplaceholder.typicode.com/",
    configuration = ClientConfiguration.class,
    fallback = JSONPlaceHolderFallback.class)
public interface JSONPlaceHolderClient {
  @RequestMapping(method = RequestMethod.GET, value = "/posts")
  List<Post> getPosts();

  @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}",
  produces = "application/json")
  Post getPostById(@PathVariable("postId") Long postId);
}
