package tn.esprit.autoloc.service.strategy;

import tn.esprit.autoloc.domain.Employee;
import java.util.List;

public interface IEmployeeService {
    List<Employee> retrieveAllEmployees();
    Employee addEmployee(Employee e);
    Employee updateEmployee(Employee e);
    Employee retrieveEmployee(Long idEmployee);
    void removeEmployee(Long idEmployee);
    List<Employee> addEmployees(List<Employee> employees);
}
