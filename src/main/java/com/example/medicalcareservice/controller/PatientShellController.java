package com.example.medicalcareservice.controller;

import com.example.medicalcareservice.model.GenderType;
import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.service.PatientReactiveService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@ShellComponent
@ConditionalOnProperty(value = "app.shell", havingValue = "true")
@RequiredArgsConstructor
public class PatientShellController {

    private final PatientReactiveService patientReactiveService;

    @ShellMethod
    public String generate100Patients() {
        Faker faker = new Faker(Locale.forLanguageTag("ru"));
        List<PatientDto> patients = IntStream.range(0, 100)
                .boxed()
                .map(ignored -> {
                    GenderType gender = GenderType.values()[new Random().nextInt(2)];
                    return PatientDto.builder()
                            .name(faker.name().fullName())
                            .birthDate(faker.date().birthday().toLocalDateTime())
                            .gender(gender)
                            .build();
                }).toList();
        List<PatientDto> saved = patientReactiveService.saveAll(patients)
                .collectList().block();
        return saved.size() + " patients were saved!";
    }

    @ShellMethod
    public String showPatients() {
        StringBuilder result = new StringBuilder("UUID | Name | Gender | Birth Date\n");
        patientReactiveService.findAll()
                .collectList()
                .block()
                .forEach(patient -> buildPatientRecord(result, patient));
        return result.toString();
    }

    private void buildPatientRecord(StringBuilder result, PatientDto patient) {
        if (result == null || patient == null) {
            return;
        }
        result.append(patient.id());
        result.append(" | ");
        result.append(patient.name());
        result.append(" | ");
        result.append(patient.gender());
        result.append(" | ");
        result.append(patient.birthDate());
        result.append("\n");
    }

}
