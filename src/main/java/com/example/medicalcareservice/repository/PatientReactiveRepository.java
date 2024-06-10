package com.example.medicalcareservice.repository;

import com.example.medicalcareservice.model.entity.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Reactive patient domain repository extension.
 *
 * @since 0.0.1
 */
@Repository
public interface PatientReactiveRepository extends ReactiveCrudRepository<Patient, Long> {
}
