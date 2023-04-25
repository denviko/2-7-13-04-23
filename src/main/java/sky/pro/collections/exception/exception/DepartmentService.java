package sky.pro.collections.exception.exception;
import org.springframework.stereotype.Service;
import sky.pro.EmployeeService;
import sky.pro.collections.Employee;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;


@Service
public class DepartmentService {
    private final EmployeeService employeeService;


    public DepartmentService() {
        this(null);
    }

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findMaxSalaryEmployee(int department) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);


    }

    public Employee findMinSalaryEmployee(int department) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);


    }

    public Collection<Employee> findByDepartment(int department) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> groupByDepartment() {
        return employeeService.getEmployees().values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}





