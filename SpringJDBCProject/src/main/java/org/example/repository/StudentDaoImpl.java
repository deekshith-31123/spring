package org.example.repository;

import org.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO students (name, city) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getCity());
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE students SET name = ?, city = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setCity(rs.getString("city"));
            return s;
        }
    }
}
