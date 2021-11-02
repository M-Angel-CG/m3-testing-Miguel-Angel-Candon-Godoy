package com.example.demo.serviceTest;

import com.example.demo.service.IVACalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de IVACalculator")
public class IVACalculatorTest {
    IVACalculator ivacalculator = new IVACalculator();

    @DisplayName("Comprobar la función 'calculateIVA' con diferentes valores")
    @Test
    void calculateIVATest() {
        assertAll(
                () -> assertEquals(0, ivacalculator.calculateIVA(0)),
                () -> assertEquals(105, ivacalculator.calculateIVA(500)),
                () -> assertEquals(-105, ivacalculator.calculateIVA(-500))
        );
    }
}
