package com.pensacoladevelopers.graphqldemo.dao;

import com.pensacoladevelopers.graphqldemo.model.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostDao {

  private static final String GET_POSTS_QUERY = "SELECT * FROM POST ORDER BY id LIMIT ? OFFSET ?";
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PostDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Post> getRecentPosts(int count, int offset) {
    List<Post> recentPosts = new ArrayList<>();

    List<Map<String, Object>> results = jdbcTemplate.queryForList(GET_POSTS_QUERY, count, offset);

    for (Map<String, Object> row : results) {
      Post post = new Post();
      post.setId((Integer) row.get("id"));
      post.setTitle((String) row.get("title"));
      post.setText((String) row.get("text"));
      post.setAuthorId((Integer) row.get("authorId"));
      recentPosts.add(post);
    }

    return recentPosts;
  }

}
