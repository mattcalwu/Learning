package com.example.feign.learning.service;

import com.example.feign.learning.clients.JSONPlaceHolderClient;
import com.example.feign.learning.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {
  @Override
  public List<Post> getPosts() {
    return Collections.emptyList();
  }

  @Override
  public Post getPostById(Long postId){
    return null;
  }
}
