package com.example.medicalcareservice.model.api;

import com.example.medicalcareservice.model.GenderType;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO representing patient.
 *
 * @param id Unique identification of patient.
 * @param name Full name of patient.
 * @param gender patient gender.
 * @param birthDate birthdate of a patient.
 *
 * @version 0.0.1
 */
@Builder
public record PatientDto(
        @Nullable
        UUID id,
        @Nullable
        @Size(min = MIN_FULL_NAME_LENGTH, max = MAX_FULL_NAME_LENGTH)
        String name,
        @Nullable
        @Enumerated(EnumType.STRING)
        GenderType gender,
        @Nullable
        @PastOrPresent(message = "Birth date must not be in the future!")
        LocalDateTime birthDate
) {

        /**
         * Constant representing maximum full name length, including first name,
         * middle name and last name, assuming the length of one type of name is 255 maximum
         * and considering 2 spaces ("\s").
         */
        public static final int MAX_FULL_NAME_LENGTH = 255 * 3 + 2;

        /**
         * Constant representing maximum full name length, including first name,
         * middle name and last name, assuming the length of one type of name is 255 maximum
         * and considering 2 spaces ("\s").
         */
        public static final int MIN_FULL_NAME_LENGTH = 2 * 3 + 2;

}
