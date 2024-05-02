package com.example.feign.learning.controllers;

import com.example.feign.learning.clients.JSONPlaceHolderClient;
import com.example.feign.learning.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignClientController {
  private JSONPlaceHolderClient jsonPlaceHolderClient;

  @Autowired
  public FeignClientController(JSONPlaceHolderClient jsonPlaceHolderClient){
    this.jsonPlaceHolderClient = jsonPlaceHolderClient;
  }

  @GetMapping(value = "/")
  public String homePage() {
    String intro = "Hello, in this repository I messed around with feign" +
        "Check out the posts, posts/{id} to see what this app does!";
    return intro;
  }

  @GetMapping(value = "posts")
  public List<Post> getPosts() {
    return jsonPlaceHolderClient.getPosts();
  }
  @GetMapping(value = "posts/{id}")
  public Post getPostById(@PathVariable(value = "id") Long id) {
    return jsonPlaceHolderClient.getPostById(id);
  }

}
