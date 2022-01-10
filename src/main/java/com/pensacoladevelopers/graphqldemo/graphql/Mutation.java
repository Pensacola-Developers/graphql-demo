package com.pensacoladevelopers.graphqldemo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pensacoladevelopers.graphqldemo.dao.AuthorDao;
import com.pensacoladevelopers.graphqldemo.model.Author;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private AuthorDao authorDao;

  public Author addAuthor(String name, String thumbnail) throws SQLException {
    int authorId = authorDao.addAuthor(name, thumbnail);
    return authorDao.getAuthor(authorId);
  }
}
