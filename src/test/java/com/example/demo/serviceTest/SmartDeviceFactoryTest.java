package com.example.demo.serviceTest;

import com.example.demo.domain.SmartDevice;
import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.SmartWatch;
import com.example.demo.service.SmartDeviceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de SmartDeviceFactory")
public class SmartDeviceFactoryTest {

    @DisplayName("Comprobar la función 'createByType' con el parámetro 'phone'")
    @Test
    void createByTypePhoneTest() {
        SmartDevice devicePhone = SmartDeviceFactory.createByType("phone");

        assertAll(
                () -> assertNotNull(devicePhone),
                () -> assertTrue(devicePhone instanceof SmartPhone),
                () -> assertFalse(devicePhone instanceof SmartWatch),
                () -> assertNotNull(devicePhone),
                () -> assertNotNull(devicePhone.getCpu()),
                () -> assertTrue(devicePhone.getCpu().getOn()),
                () -> assertNotNull(devicePhone.getRam()),
                () -> assertNotNull(devicePhone.getBattery())
        );

        SmartPhone phone = (SmartPhone) devicePhone;
        assertNotNull(phone.getCamera());
    }

    @DisplayName("Comprobar la función 'createByType' con el parámetro 'watch'")
    @Test
    void createByTypeWatchTest() {
        SmartDevice deviceWatch = SmartDeviceFactory.createByType("watch");

        assertAll(
                () -> assertNotNull(deviceWatch),
                () -> assertFalse(deviceWatch instanceof SmartPhone),
                () -> assertTrue(deviceWatch instanceof SmartWatch),
                () -> assertNotNull(deviceWatch),
                () -> assertNotNull(deviceWatch.getCpu()),
                () -> assertNotNull(deviceWatch.getRam()),
                () -> assertNotNull(deviceWatch.getBattery())

        );

        SmartWatch watch = (SmartWatch) deviceWatch;

        assertAll(
                () -> assertNotNull(watch.getMonitor()),
                () -> assertNotNull(watch.getMonitor().getBloodPressure()),
                () -> assertNotNull(watch.getMonitor().getSleepQuality())
        );
    }

    @DisplayName("Comprobar la función 'createByType' con un parámetro que provoque un error")
    @Test
    void createByTypeExceptionTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SmartDeviceFactory.createByType("")
        );
    }
}
