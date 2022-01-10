package com.pensacoladevelopers.graphqldemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pensacoladevelopers.graphqldemo.dao.PostDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

  private final PostDao postsDao;
  private final ObjectMapper objectMapper;

  @Autowired
  public PostsController(PostDao postsDao, ObjectMapper objectMapper) {
    this.postsDao = postsDao;
    this.objectMapper = objectMapper;
  }

  @RequestMapping("/posts")
  public String getRecentPost(@RequestParam("count") int count, @RequestParam("offset") int offset)
      throws IOException {
    return objectMapper.writeValueAsString(postsDao.getRecentPosts(count, offset));
  }

}
