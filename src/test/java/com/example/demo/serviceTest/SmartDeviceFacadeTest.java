package com.example.demo.serviceTest;

import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.SmartWatch;
import com.example.demo.service.SmartDeviceFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.demo.domain.SmartDevice;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de las funciones de SmartDeviceFacade")
public class SmartDeviceFacadeTest {

    @DisplayName("Comprobar la función 'createSmartPhone'")
    @Test
    void createSmartPhoneTest() {
        SmartDevice device = SmartDeviceFacade.createSmartPhone();

        assertAll(
                () -> assertNotNull(device),
                () -> assertTrue(device instanceof SmartPhone),
                () -> assertFalse(device instanceof SmartWatch),
                () -> assertNotNull(device),
                () -> assertNotNull(device.getCpu()),
                () -> assertTrue(device.getCpu().getOn()),
                () -> assertNotNull(device.getRam()),
                () -> assertNotNull(device.getBattery())
        );

        SmartPhone phone = (SmartPhone) device;
        assertNotNull(phone.getCamera());
    }

    @DisplayName("Comprobar la función 'createSmartWatch'")
    @Test
    void createSmartWatchTest(){
        SmartDevice device = SmartDeviceFacade.createSmartWatch();

        assertAll(
                () -> assertNotNull(device),
                () -> assertFalse(device instanceof SmartPhone),
                () -> assertTrue(device instanceof SmartWatch),
                () -> assertNotNull(device),
                () -> assertNotNull(device.getCpu()),
                () -> assertNotNull(device.getRam()),
                () -> assertNotNull(device.getBattery())

        );

        SmartWatch watch = (SmartWatch) device;

        assertAll(
                () -> assertNotNull(watch.getMonitor()),
                () -> assertNotNull(watch.getMonitor().getBloodPressure()),
                () -> assertNotNull(watch.getMonitor().getSleepQuality())
        );
    }
}
