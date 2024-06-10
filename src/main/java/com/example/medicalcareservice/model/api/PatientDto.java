package com.example.medicalcareservice.model.api;

import com.example.medicalcareservice.model.FullNameDto;
import com.example.medicalcareservice.model.GenderType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * DTO representing patient.
 *
 * @param id Unique identification of patient. Cannot be null
 * @param name Full name of patient.
 * @param gender patient gender.
 * @param birthDate birthdate of a patient.
 *
 * @version 0.0.1
 */
@Builder
public record PatientDto(
        @Nullable
        @PositiveOrZero
        Long id,
        @Nullable
        FullNameDto name,
        @Nullable
        GenderType gender,
        @Nullable
        @PastOrPresent(message = "Birth date must not be in the future!")
        LocalDateTime birthDate
) {
}
