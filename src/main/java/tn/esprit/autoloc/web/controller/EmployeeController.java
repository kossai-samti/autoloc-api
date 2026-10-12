package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.service.strategy.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    IEmployeeService employeeService;

    @GetMapping("/retrieve-all-employees")
    public List<Employee> retrieveAllEmployees() {
        return employeeService.retrieveAllEmployees();
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee e) {
        return employeeService.addEmployee(e);
    }

    @PutMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee e) {
        return employeeService.updateEmployee(e);
    }

    @GetMapping("/retrieve-employee/{id-employee}")
    public Employee retrieveEmployee(@PathVariable("id-employee") Long idEmployee) {
        return employeeService.retrieveEmployee(idEmployee);
    }

    @DeleteMapping("/remove-employee/{id-employee}")
    public void removeEmployee(@PathVariable("id-employee") Long idEmployee) {
        employeeService.removeEmployee(idEmployee);
    }

    @PostMapping("/add-employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addEmployees(employees);
    }
}
