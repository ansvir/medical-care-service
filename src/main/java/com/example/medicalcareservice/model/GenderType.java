package com.example.medicalcareservice.model;

import java.util.Locale;

/**
 * Constants of person genders.
 *
 * @version 0.0.1
 */
public enum GenderType {
    /**
     * Man gender (he/his)
     */
    MALE,

    /**
     * Woman gender (she/her)
     */
    FEMALE;

    /**
     * @return converted gender constant name to readable format.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ENGLISH);
    }

}
