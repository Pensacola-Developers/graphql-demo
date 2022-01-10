package com.pensacoladevelopers.graphqldemo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pensacoladevelopers.graphqldemo.dao.PostDao;
import com.pensacoladevelopers.graphqldemo.model.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {

  @Autowired
  private PostDao postsDao;

  public List<Post> getRecentPosts(int count, int offset) {
    return postsDao.getRecentPosts(count, offset);
  }

  public PostDao getPostsDao() {
    return postsDao;
  }

  public void setPostsDao(PostDao postDao) {
    this.postsDao = postDao;
  }
}