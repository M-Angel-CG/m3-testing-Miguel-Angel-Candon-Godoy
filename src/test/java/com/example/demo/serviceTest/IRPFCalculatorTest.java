package com.example.demo.serviceTest;

import com.example.demo.service.IRPFCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de IRPFCalculator")
public class IRPFCalculatorTest {

    @DisplayName("Comprobar la función 'calculateIRPF' con diferentes valores")
    @Test
    void calculateIRPFAllTest() {
        IRPFCalculator irpfcalculator = new IRPFCalculator();

        assertAll(
                () -> assertEquals(0, irpfcalculator.calculateIRPF(0)),
                () -> assertEquals(75, irpfcalculator.calculateIRPF(500)),
                () -> assertEquals(-75, irpfcalculator.calculateIRPF(-500))
        );
    }
}
