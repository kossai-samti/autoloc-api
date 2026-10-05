package tn.esprit.autoloc.service.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> retrieveAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee updateEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee retrieveEmployee(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }

    @Override
    public void removeEmployee(Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }

    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
}
