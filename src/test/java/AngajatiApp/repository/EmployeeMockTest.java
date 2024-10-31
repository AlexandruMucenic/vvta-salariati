package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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

    //    TESTE MODIFY EMPLOYEE
    @Test
    void modifyEmployee_TC01() {
        Employee mihai = employeeMock.getEmployeeList().stream()
                .filter(emp -> "Ion".equals(emp.getFirstName()) && "Dumitrescu".equals(emp.getLastName()))
                .findFirst()
                .orElse(null);

        employeeMock.modifyEmployeeFunction(mihai, DidacticFunction.ASSISTENT);
        assert mihai != null;
        assertEquals(DidacticFunction.ASSISTENT, mihai.getFunction());
    }

    @Test
    void modifyEmployee_TC02() {
        List<DidacticFunction> originalFunctions = employeeMock.getEmployeeList().stream()
                .map(Employee::getFunction)
                .collect(Collectors.toList());

        employeeMock.modifyEmployeeFunction(null, DidacticFunction.ASSISTENT);
        for (int i = 0; i < employeeMock.getEmployeeList().size(); i++) {
            assertEquals(originalFunctions.get(i), employeeMock.getEmployeeList().get(i).getFunction());
        }
    }
}