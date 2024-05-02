package com.example.feign.learning.service.impl;

import com.example.feign.learning.clients.JSONPlaceHolderClient;
import com.example.feign.learning.model.Post;
import com.example.feign.learning.service.JSONPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JSONPlaceHolderServiceImpl implements JSONPlaceHolderService {

  private JSONPlaceHolderClient jsonPlaceHolderClient;

  @Autowired
  public JSONPlaceHolderServiceImpl(JSONPlaceHolderClient jsonPlaceHolderClient) {
    this.jsonPlaceHolderClient = jsonPlaceHolderClient;
  }

  @Override
  public List<Post> getPost() {
    return jsonPlaceHolderClient.getPosts();
  }

  @Override
  public Post getPostById(Long id) {
    return jsonPlaceHolderClient.getPostById(id);
  }
}
