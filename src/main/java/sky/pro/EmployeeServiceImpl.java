package sky.pro;

import org.springframework.stereotype.Service;
import sky.pro.collections.Employee;
import sky.pro.collections.exception.EmployeeNotFoundException;
import sky.pro.collections.exception.exception.EmployeeAlreadyAddedException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName,int salary,int department,int age) {
        Employee employee = new Employee(firstName, lastName, 500, 2, 30);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, 500, 2, 30);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, 500, 2, 30);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());

    }

}
