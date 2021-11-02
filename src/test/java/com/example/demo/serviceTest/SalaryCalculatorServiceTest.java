package com.example.demo.serviceTest;

import com.example.demo.domain.Employee;
import com.example.demo.service.IRPFCalculator;
import com.example.demo.service.IVACalculator;
import com.example.demo.service.SalaryCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de SalaryCalculatorService")
public class SalaryCalculatorServiceTest {

    @DisplayName("Comprobar la función 'calculateSalary'")
    @Test
    void calculateSalaryTest() {
        IRPFCalculator irpf = new IRPFCalculator();
        IVACalculator iva = new IVACalculator();
        SalaryCalculatorService salaryCalculator = new SalaryCalculatorService(irpf, iva);

        assertAll(
                () -> assertNotNull(salaryCalculator)
        );

        Employee empleado = new Employee();
        empleado.setAge(30);

        assertAll(
                () -> assertNotNull(empleado.getAge()),
                () -> assertEquals(45919.5,salaryCalculator.calculateSalary(empleado))
        );
    }
}
