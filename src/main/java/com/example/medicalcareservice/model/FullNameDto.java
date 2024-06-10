package com.example.medicalcareservice.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Model that represents full name of a person.
 *
 * @version 0.0.1
 */
@Builder
public record FullNameDto(
        @Nullable
        @Size(min = 2, message = "First name min length must be 2 or more!")
        String firstName,
        @Nullable
        @Size(min = 2, message = "Middle name min length must be 2 or more!")
        String middleName,
        @Nullable
        @Size(min = 2, message = "Last name min length must be 2 or more!")
        String lastName
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
