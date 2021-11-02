package com.example.demo.serviceTest;

import com.example.demo.domain.SmartWatch;
import com.example.demo.service.SmartWatchServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de SmartWatchServiceImpl")
public class SmartWatchServiceImplTest {
    SmartWatchServiceImpl service = new SmartWatchServiceImpl();

    @DisplayName("Comprobar la función 'count'")
    @Test
    void countTest() {
        Integer contado = service.count();

        assertAll(
                () -> assertNotNull(contado),
                () -> assertEquals(3, contado)
        );
    }

    @DisplayName("Comprobar la función 'findAll'")
    @Test
    void findAllTest() {
        List<SmartWatch> listaWatches = service.findAll();

        assertAll(
                () -> assertNotNull(listaWatches),
                () -> assertEquals(3, listaWatches.size())
        );
    }

    @DisplayName("Comprobar la función 'findOne'")
    @Test
    void findOneTest() {
        SmartWatch watch = service.findOne(1L);

        assertAll(
                () -> assertNotNull(watch),
                () -> assertEquals(1L, watch.getId()),
                () -> assertNull(service.findOne(999L))
        );
    }

    @DisplayName("Comprobar la función 'save'")
    @Test
    void saveTest() {
        assertEquals(3,service.count());

        SmartWatch watch = new SmartWatch();
        service.save(watch);

        assertEquals(4,service.count());
    }

    @DisplayName("Comprobar la función 'delete'")
    @Test
    void deleteTest() {
        boolean exito = service.delete(1L);

        assertAll(
                () -> assertTrue(exito),
                () -> assertNull(service.findOne(1L))
        );
    }

    @DisplayName("Comprobar la función 'deleteAll'")
    @Test
    void deleteAllTest() {
        assertEquals(3,service.count());

        service.deleteAll();

        assertEquals(0,service.count());
    }
}
