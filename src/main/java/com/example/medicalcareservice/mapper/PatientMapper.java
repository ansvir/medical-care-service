package com.example.medicalcareservice.mapper;

import com.example.medicalcareservice.model.FullNameDto;
import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.model.entity.Patient;
import org.mapstruct.Mapper;

import static com.example.medicalcareservice.model.FullNameDto.NAME_DIVIDER;

/**
 * Mapper for patient domain.
 *
 * @version 0.0.1
 */
@Mapper
public interface PatientMapper {

    /**
     * Factory method for creating (mapping) DTO to database entity.
     * @param dto DTO to map.
     * @return Mapped entity.
     */
    Patient toEntity(PatientDto dto);

    /**
     * Factory method for creating (mapping) database entity to DTO.
     * @param entity Entity to map.
     * @return Mapped DTO.
     */
    PatientDto toDto(Patient entity);

    /**
     * Custom mapping method to convert a full name String to a {@link FullNameDto}.
     *
     * @param fullName The full name as a String.
     * @return Built {@link FullNameDto} object.
     */
    default FullNameDto mapStringToFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return null;
        }

        String[] nameParts = fullName.trim().split(NAME_DIVIDER);
        String firstName = nameParts.length > 0 ? nameParts[0] : null;
        String middleName = nameParts.length > 1 ? nameParts[1] : null;
        String lastName = nameParts.length > 2 ? nameParts[2] : null;

        return FullNameDto.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }

    /**
     * Custom mapping method to convert {@link FullNameDto} to a String.
     *
     * @param fullNameDto The {@link FullNameDto} object to convert.
     * @return The full name as a String build from DTO.
     */
    default String mapFullNameToString(FullNameDto fullNameDto) {
        if (fullNameDto == null) {
            return null;
        }

        StringBuilder fullName = new StringBuilder();
        if (fullNameDto.firstName() != null) {
            fullName.append(fullNameDto.firstName());
        }
        if (fullNameDto.middleName() != null) {
            fullName.append(NAME_DIVIDER).append(fullNameDto.middleName());
        }
        if (fullNameDto.lastName() != null) {
            fullName.append(NAME_DIVIDER).append(fullNameDto.lastName());
        }
        return fullName.toString();
    }

}