package com.example.demo.junitTesting;


import com.example.demo.service.IRPFCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IRPFCalculatorTest {

    IRPFCalculator irpfcalculator = new IRPFCalculator();


    @Test
    void calculateIRPFTest() {

        assertAll(
                () -> assertEquals(0.15, irpfcalculator.calculateIRPF(1)),
                () -> assertEquals(0, irpfcalculator.calculateIRPF(0)),
                () -> assertEquals(75, irpfcalculator.calculateIRPF(500))
        );
    }
}
