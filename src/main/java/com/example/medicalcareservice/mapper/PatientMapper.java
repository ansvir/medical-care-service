package com.example.medicalcareservice.mapper;

import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.model.entity.Patient;
import org.mapstruct.Mapper;

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
}
