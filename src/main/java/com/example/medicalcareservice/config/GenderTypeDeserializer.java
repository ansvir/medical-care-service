package com.example.medicalcareservice.config;

import com.example.medicalcareservice.model.GenderType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Locale;

public class GenderTypeDeserializer extends StdDeserializer<GenderType> {

    public GenderTypeDeserializer() {
        super(GenderType.class);
    }

    @Override
    public GenderType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String genderString = p.getValueAsString();
        return GenderType.valueOf(genderString.toUpperCase(Locale.ENGLISH));
    }

}