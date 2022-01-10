package com.pensacoladevelopers.graphqldemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pensacoladevelopers.graphqldemo.dao.AuthorDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

  private final AuthorDao authorDao;
  private final ObjectMapper objectMapper;

  @Autowired
  public AuthorController(AuthorDao authorDao, ObjectMapper objectMapper) {
    this.authorDao = authorDao;
    this.objectMapper = objectMapper;
  }

  @RequestMapping("/author/{id}")
  public String getAuthorById(@PathVariable("id") int id) throws IOException {
    return objectMapper.writeValueAsString(authorDao.getAuthor(id));
  }

}
