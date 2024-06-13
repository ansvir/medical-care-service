package com.example.medicalcareservice.model.entity;

import com.example.medicalcareservice.model.GenderType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.medicalcareservice.model.FullNameDto.MAX_FULL_NAME_LENGTH;
import static com.example.medicalcareservice.model.FullNameDto.MIN_FULL_NAME_LENGTH;

/**
 * Entity, representing patient.
 *
 * @param id        Unique identification number of a patient.
 * @param name      Full name of a patient.
 * @param gender    Gender of a patient.
 * @param birthDate Birthdate of a patient in format <i>yyyy-MM-dd'T'HH:mm:ss</i>
 *
 * @version 0.0.1
 */
@Builder
public record Patient(
        @Id
        UUID id,
        @Size(min = MIN_FULL_NAME_LENGTH, max = MAX_FULL_NAME_LENGTH)
        @Nullable
        String name,
        @Nullable
        GenderType gender,
        @PastOrPresent
        @Nullable
        LocalDateTime birthDate
) {
}
