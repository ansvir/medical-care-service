package com.example.medicalcareservice.repository;

import com.example.medicalcareservice.model.entity.Patient;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Reactive patient domain repository extension.
 *
 * @since 0.0.1
 */
@Repository
public interface PatientReactiveRepository extends ReactiveCrudRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p LIMIT :to OFFSET :from")
    Flux<Patient> findAllPaged(int from, int to);

}
