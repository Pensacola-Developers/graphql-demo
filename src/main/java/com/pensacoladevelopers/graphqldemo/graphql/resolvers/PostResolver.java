package com.pensacoladevelopers.graphqldemo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pensacoladevelopers.graphqldemo.dao.AuthorDao;
import com.pensacoladevelopers.graphqldemo.model.Author;
import com.pensacoladevelopers.graphqldemo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

  @Autowired
  private AuthorDao authorDao;

  public Author getAuthor(Post post) {
    return authorDao.getAuthor(post.getAuthorId());
  }
}
