package com.example.demo.pruebaMock1Test;

import com.example.demo.pruebamock1.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de FacturaServicio")
public class FacturaServicioTest {

    @DisplayName("Comprobar la función 'calcularPrecio'")
    @Test
    void calcularPrecioTest() {
        OperacionesAritmeticas aritmeticas = new OperacionesAritmeticas();
        OperacionesMatematicas operaciones = new OperacionesMatematicas(aritmeticas);
        Calculadora calculadora = new Calculadora(operaciones);
        FacturaServicio facturaServicio = new FacturaServicio(calculadora);
        Factura factura = new Factura(1L, 100d, 10, 10d, 0.21);

        double precio = facturaServicio.calcularPrecio(factura);

        assertAll(
                () -> assertNotNull(precio),
                () -> assertEquals(1210.0, precio)
        );
    }
}
