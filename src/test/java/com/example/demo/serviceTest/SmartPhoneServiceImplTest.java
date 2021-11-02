package com.example.demo.serviceTest;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de SmartPhoneServiceImpl")
public class SmartPhoneServiceImplTest {
    SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();

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
        List<SmartPhone> listaPhones = service.findAll();

        assertAll(
                () -> assertNotNull(listaPhones),
                () -> assertEquals(3, listaPhones.size())
        );
    }

    @DisplayName("Comprobar la función 'findOne'")
    @Test
    void findOneTest() {
        SmartPhone phoneDevuelto = service.findOne(1L);

        assertAll(
                () -> assertNotNull(phoneDevuelto),
                () -> assertEquals(1L, phoneDevuelto.getId()),
                () -> assertNull(service.findOne(999L)),
                () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> service.findOne(null)
                        )
        );

        ;
    }

    @DisplayName("Comprobar la función 'save'")
    @Test
    void saveTest() {
        SmartPhone phone1 = new SmartPhone();
        service.save(phone1);
        SmartPhone phone2 = new SmartPhone();
        phone2.setId(-1L);
        SmartPhone phone3 = new SmartPhone();
        phone3.setId(1L);

        assertAll(
                () -> assertNotNull(phone1.getId()),
                () -> assertEquals(1L,phone3.getId()),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> service.save(null)
                    ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> service.save(phone2)
                    )
        );
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

    @DisplayName("Comprobar la función 'findByWifi'")
    @Test
    void findByWifiTest() {
        List<SmartPhone> phones = service.findByWifi(true);

        assertAll(
                () -> assertNotNull(phones),
                () -> assertEquals(2,phones.size())
        );
    }
}
