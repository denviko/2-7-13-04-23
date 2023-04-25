package sky.pro;

import sky.pro.collections.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department, int age);

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);


    Map<String, Employee> getEmployees();
}
