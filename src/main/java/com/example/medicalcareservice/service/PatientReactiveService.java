package com.example.medicalcareservice.service;

import com.example.medicalcareservice.mapper.PatientMapper;
import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.model.entity.Patient;
import com.example.medicalcareservice.repository.PatientReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Reactive service for working with patient domain.
 * Contains (<a href="https://en.wikipedia.org/wiki/Create,_read,_update_and_delete">CRUD</a>) methods for retrieving, updating, creating and deleting patients.
 *
 * @version 0.0.1
 */
@Service
@RequiredArgsConstructor
public class PatientReactiveService {

    private final PatientMapper patientMapper;
    private final PatientReactiveRepository patientReactiveRepository;

    /**
     * Method for retrieving all patients.
     * @return Flux of DTOs (N or zero).
     */
    public Flux<PatientDto> findAll() {
        return patientReactiveRepository.findAll()
                .map(patientMapper::toDto);
    }

    /**
     * Method for retrieving patient by his {@code id}.
     * @return Mono of DTO (one or none).
     */
    public Mono<PatientDto> findById(UUID id) {
        return patientReactiveRepository.findById(id)
                .map(patientMapper::toDto);
    }

    /**
     * Saves new patient.
     * @param patientDto Patient DTO to save.
     * @return Saved patient DTO.
     */
    public Mono<PatientDto> save(PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        return patientReactiveRepository.save(patient)
                .map(patientMapper::toDto);
    }

    /**
     * Saves all new patients.
     * @param patientDtos Patient DTOs to save.
     * @return Flux of all saved patients.
     */
    public Flux<PatientDto> saveAll(List<PatientDto> patientDtos) {
        List<Patient> patients = patientDtos.stream()
                .map(patientMapper::toEntity)
                .collect(Collectors.toList());
        return patientReactiveRepository.saveAll(patients)
                .map(patientMapper::toDto);
    }

    /**
     * Updates existing patient.
     * @param id Patient ID.
     * @param patientDto Patient DTO to update.
     * @return Updated patient DTO.
     */
    public Mono<PatientDto> update(UUID id, PatientDto patientDto) {
        return findById(id).map(patient ->
            new PatientDto(
                    id,
                    patientDto.name(),
                    patientDto.gender(),
                    patientDto.birthDate()))
                .flatMap(this::save);
    }

    /**
     * Method for deleting patient by his {@code id}.
     * @return Mono of {@link Void}
     */
    public Mono<Void> deleteById(UUID id) {
        return patientReactiveRepository.deleteById(id);
    }

}
