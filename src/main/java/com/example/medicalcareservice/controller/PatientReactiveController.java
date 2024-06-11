package com.example.medicalcareservice.controller;

import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.service.PatientReactiveService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Base exposed object to work with patient domain.
 *
 * @version 0.0.1
 */
@RestController("/patient")
@RequiredArgsConstructor
public class PatientReactiveController {

    private final PatientReactiveService patientReactiveService;

    /**
     * Fetches all {@link PatientDto}'s.
     *
     * @return Flux of {@link PatientDto}.
     */
    @GetMapping
    public Flux<PatientDto> findAllPatients() {
        return patientReactiveService.findAll();
    }

    /**
     * Fetches {@link PatientDto} by his unique {@code id}.
     *
     * @param id Unique {@link PatientDto#id()} of a patient.
     * @return Mono of {@link PatientDto}.
     */
    @GetMapping("/{id}")
    public Mono<PatientDto> findById(@PathVariable @NotNull @PositiveOrZero Long id) {
        return patientReactiveService.findById(id);
    }

    /**
     * Saves {@link PatientDto}.
     *
     * @param patientDto DTO to save.
     * @return Mono of newly created {@link PatientDto}.
     */
    @PostMapping
    public Mono<PatientDto> create(@RequestBody PatientDto patientDto) {
        return patientReactiveService.save(patientDto);
    }

    /**
     * Updates {@link PatientDto} by his unique {@code id}.
     *
     * @param id Patient unique {@code id}.
     * @param patientDto Patient DTO to exchange on existing one.
     * @return Mono of updated {@link PatientDto}.
     */
    @PutMapping("/{id}")
    public Mono<PatientDto> updateById(@PathVariable @NotNull @PositiveOrZero Long id, @RequestBody PatientDto patientDto) {
        return patientReactiveService.update(id, patientDto);
    }

    /**
     * Deletes {@link PatientDto} by his unique {@code id}.
     *
     * @param id ID of a patient to find delete patient.
     * @return Mono of {@link Void}.
     */
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return patientReactiveService.deleteById(id);
    }

}
