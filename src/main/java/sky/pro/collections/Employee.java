package sky.pro.collections;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int salary;
    private final int department;
    private final int age;



    public String getFirstName() {return firstName;}

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {return lastName;}
    public String getFullName() {return firstName + " " + lastName;}

    public Employee(String firstName, String lastName, int salary, int department, int age) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", age=" + age +
                '}';
    }
}

