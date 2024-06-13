package com.example.medicalcareservice.controller;

import com.example.medicalcareservice.model.FullNameDto;
import com.example.medicalcareservice.model.GenderType;
import com.example.medicalcareservice.model.api.PatientDto;
import com.example.medicalcareservice.model.entity.Patient;
import com.example.medicalcareservice.service.PatientReactiveService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.reactive.ReactiveWebServerFactoryAutoConfiguration;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@ShellComponent
@ConditionalOnProperty(value = "app.shell", havingValue = "true", matchIfMissing = true)
@RequiredArgsConstructor
public class PatientShellController {

    private final PatientReactiveService patientReactiveService;
    private final ReactiveWebServerFactoryAutoConfiguration reactiveWebServerFactoryAutoConfiguration;

    @ShellMethod
    public String generatePatients(int amount) {
        if (amount > 200) {
            return "Patients amount could not be more than 200!";
        }
        Faker faker = new Faker(Locale.forLanguageTag("ru"));
        List<PatientDto> patients = IntStream.range(0, amount)
                .boxed()
                .map(ignored -> {
                    GenderType gender = GenderType.values()[new Random().nextInt(2)];
                    PatientDto.PatientDtoBuilder patientBuilder = PatientDto.builder()
                            .id(UUID.randomUUID())
                            .birthDate(faker.date().birthday().toLocalDateTime())
                            .gender(gender);
                    if (gender == GenderType.MALE) {
                        patientBuilder.name(FullNameDto.builder()
                                .firstName(faker.name().malefirstName())
                                .middleName(faker.name().nameWithMiddle())
                                .lastName(faker.name().lastName())
                                .build());
                    } else {
                        patientBuilder.name(FullNameDto.builder()
                                .firstName(faker.name().femaleFirstName())
                                .middleName(faker.name().nameWithMiddle())
                                .lastName(faker.name().lastName())
                                .build());
                    }
                    return patientBuilder.build();
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

    @ShellMethod
    public String showPatients(int from, int to) {
        StringBuilder result = new StringBuilder("UUID | Name | Gender | Birth Date\n");
        patientReactiveService.findAllPaged(from, to)
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
