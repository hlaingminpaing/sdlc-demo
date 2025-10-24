package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from Java Spring Boot!";
    }

    @GetMapping("/db")
    public String testDb() {
        try {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS test_table (id INT AUTO_INCREMENT PRIMARY KEY, message VARCHAR(255))");
            jdbcTemplate.execute("INSERT INTO test_table (message) VALUES ('Data from Java App')");
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM test_table", Integer.class);
            return "✅ Connected to MySQL (Rows: " + count + ")";
        } catch (Exception e) {
            return "❌ DB Error: " + e.getMessage();
        }
    }
}

