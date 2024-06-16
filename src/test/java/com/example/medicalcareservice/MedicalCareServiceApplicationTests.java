package com.example.medicalcareservice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.jdbc.Sql;

@DataR2dbcTest
@Sql("classpath:db/sql/schema.test.sql")
class MedicalCareServiceApplicationTests {

    @Test
    @Disabled
    void contextLoads() {
    }

}
