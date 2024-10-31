package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    AngajatiApp.repository.EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
    }

    // TESTE ADD EMPLOYEE
    @Test
    void addEmployee_TC01() {
        Employee employee = new Employee("Mucenic", "Alex", "1234567890123", DidacticFunction.ASSISTENT, 3000.0);
        assertTrue(employeeMock.addEmployee(employee));
    }

    @Test
    void addEmployee_TC02() {
        Employee employee = new Employee("Mucenic", "Alex", "123456789012", DidacticFunction.ASSISTENT, 3000.0);
        assertFalse(employeeMock.addEmployee(employee));
    }

    @Test
    void addEmployee_TC03() {
        Employee employee = new Employee("Mucenic", "Alex", "1234567890123", null, 3000.0);
        assertThrows(NullPointerException.class, () -> employeeMock.addEmployee(employee));
    }

    @Test
    void addEmployee_TC04() {
        Employee employee = new Employee("Mucenic", "Alex", "1234567890123", DidacticFunction.ASSISTENT, 0.0);
        assertFalse(employeeMock.addEmployee(employee));
    }
}