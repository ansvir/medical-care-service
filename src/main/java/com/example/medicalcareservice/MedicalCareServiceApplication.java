package com.example.medicalcareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.tools.agent.ReactorDebugAgent;

/**
 * App boot class.
 *
 * @version 0.0.1
 */
@SpringBootApplication
public class MedicalCareServiceApplication {

    public static void main(String[] args) {
        ReactorDebugAgent.init();
        SpringApplication.run(MedicalCareServiceApplication.class, args);
    }

}
