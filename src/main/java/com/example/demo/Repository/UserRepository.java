package com.example.demo.Repository;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper 정의
    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUserid(rs.getString("userid"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getBoolean("enabled"));
        return user;
    };

    // Insert Query
    public int save(User user) {
        String sql = "INSERT INTO users (userid, password, enabled) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserid(), user.getPassword(), user.getEnabled());
    }

    // Select All
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Find By ID
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // Update Query
    public int updateUser(Long id, String userid) {
        String sql = "UPDATE users SET userid = ? WHERE id = ?";
        return jdbcTemplate.update(sql, userid, id);
    }

    // Delete Query
    public int deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
