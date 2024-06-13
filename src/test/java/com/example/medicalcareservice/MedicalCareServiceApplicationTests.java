package com.example.medicalcareservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql("classpath:db/sql/schema.test.sql")
class MedicalCareServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
