package com.example.springbootswagger2.model;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class AircraftsEntityTest {
    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenAircraftsIdTooLong() {
        AircraftsEntity entity = new AircraftsEntity();
        entity.setAircraftCode("1234");
        entity.setModel("weg");
        entity.setRange(5);

        Set<ConstraintViolation<AircraftsEntity>> violations = validator.validate(entity);
        assertEquals(1, violations.size());
    }

    @Test
    public void whenAircraftsIdisBlank() {
        AircraftsEntity entity = new AircraftsEntity();
        entity.setAircraftCode("");
        entity.setModel("weg");
        entity.setRange(5);

        Set<ConstraintViolation<AircraftsEntity>> violations = validator.validate(entity);
        assertEquals(1, violations.size());
    }

}