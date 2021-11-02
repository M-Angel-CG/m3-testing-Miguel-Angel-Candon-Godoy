package com.example.demo.serviceTest;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@DisplayName("Tests de las funciones de EmployeeServiceImpl")
public class EmployeeServiceImplTest {

    EmployeeRepository repositoryMock;
    EmployeeService service;

    @BeforeEach
    void setUp() {
        repositoryMock = mock(EmployeeRepositoryImpl.class);
        service = new EmployeeServiceImpl(repositoryMock);
    }

    @DisplayName("Comprobar la función 'count'")
    @Test
    void countTest() {
        when(repositoryMock.count()).thenReturn(3);

        Integer contado = service.count();

        assertAll(
                () -> assertNotNull(contado),
                () -> assertEquals(3, contado)
        );
    }

    @DisplayName("Comprobar la función 'findOne' con la id de valor 1")
    @Test
    void findOneTest() {
        Employee empleado = new Employee(1L, "Empleado", 45);
        when(repositoryMock.findOne(1L)).thenReturn(empleado);

        Employee empleadodevuelto = service.findOne(1L);

        assertAll(
                () -> assertNotNull(empleadodevuelto),
                () -> assertEquals(1, empleadodevuelto.getId())
        );
    }

    @DisplayName("Comprobar la función 'findOne' con cualquier valor para la id")
    @Test
    void findOneAnyTest() {
        Employee empleado = new Employee(2L, "Empleado", 45);
        when(repositoryMock.findOne(anyLong())).thenReturn(empleado);

        Employee empleadodevuelto = service.findOne(2L);

        assertAll(
                () -> assertNotNull(empleadodevuelto),
                () -> assertEquals(2L, empleadodevuelto.getId())
        );
    }

    @DisplayName("Comprobar la función 'findOneOptional'")
    @Test
    void findOneOptional() {
        Employee empleado = new Employee(3L, "Empleado", 45);
        when(repositoryMock.findOne(anyLong())).thenReturn(empleado);

        Optional<Employee> empleadodevuelto = service.findOneOptional(3L);

        assertAll(
                () -> assertTrue(empleadodevuelto.isPresent()),
                () -> assertEquals(3L,empleadodevuelto.get().getId())
        );
        verify(repositoryMock).findOne(anyLong());
    }

    @DisplayName("Comprobar la función 'save'")
    @Test
    void saveTest() {
        Employee empleado = new Employee(1L, "Empleado", 45);
        when(repositoryMock.save(any())).thenReturn(empleado);

        service.save(empleado);

        verify(repositoryMock).save(any());
    }

    @DisplayName("Comprobar la función 'delete'")
    @Test
    void deleteTest() {
        when(repositoryMock.delete(any())).thenReturn(true);

        boolean exito = service.delete(1L);

        assertTrue(exito);
        verify(repositoryMock).delete(any());
    }

    @DisplayName("Comprobar la función 'deleteAll'")
    @Test
    void deleteAllTest() {
        service.deleteAll();
        verify(repositoryMock).deleteAll();
    }

    @DisplayName("Comprobar la función 'findAll'")
    @Test
    void findAllTest() {
        List<Employee> empleados = Arrays.asList(
                new Employee(1l, "Paco", 35),
                new Employee(2l, "Pilar", 27),
                new Employee(3l, "Lola", 42),
                new Employee(4l, "Pedro", 19)
        );
        when(repositoryMock.findAll()).thenReturn(empleados);

        List<Employee> listaEmpleados = service.findAll();

        assertAll(
                () -> assertNotNull(listaEmpleados),
                () -> assertEquals(4, listaEmpleados.size())
        );

        verify(repositoryMock).findAll();
    }
}
