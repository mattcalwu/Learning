package com.example.feign.learning.service;

import com.example.feign.learning.model.Post;

import java.util.List;

public interface JSONPlaceHolderService {
  List<Post> getPost();

  Post getPostById(Long id);

}
