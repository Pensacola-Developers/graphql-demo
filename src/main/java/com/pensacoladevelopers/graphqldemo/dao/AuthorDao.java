package com.pensacoladevelopers.graphqldemo.dao;

import com.pensacoladevelopers.graphqldemo.model.Author;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorDao {

  private static final String GET_AUTHOR_QUERY = "SELECT * FROM AUTHOR WHERE id = ?";
  private static final String ADD_AUTHOR_STATEMENT = "INSERT INTO AUTHOR (name, thumbnail) VALUES (?, ?)";
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AuthorDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Author getAuthor(int id) {
    Author author = new Author();
    return jdbcTemplate.queryForObject(GET_AUTHOR_QUERY, new Object[]{id}, new AuthorRowMapper());
  }

  public int addAuthor(String name, String thumbnail) throws SQLException {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(ADD_AUTHOR_STATEMENT, new String[]{"id"});
      ps.setString(1, name);
      ps.setString(2, thumbnail);
      return ps;
    }, keyHolder);
    if (keyHolder.getKey() != null) {
      return keyHolder.getKey().intValue();
    } else {
      throw new SQLException("Exception returning primary key for Author " + name);
    }
  }

  public static class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
      Author author = new Author();
      author.setId(rs.getInt("id"));
      author.setName(rs.getString("name"));
      author.setThumbnail(rs.getString("thumbnail"));
      return author;
    }
  }

}
