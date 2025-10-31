import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {
    
    public static void main(String[] args) {
        List<Employee> employees = initializeEmployeeDataset();

        Function<Employee, String> nameDepartmentConcatenator = employee -> 
            employee.getName() + " - " + employee.getDepartment();

        List<String> nameDepartmentList = employees.stream()
                .map(nameDepartmentConcatenator)
                .collect(Collectors.toList());
        
        System.out.println("Name-Department List:");
        nameDepartmentList.forEach(System.out::println);
        
  

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        
        System.out.printf("\nAverage Salary: $%,.2f%n", averageSalary);

        int ageThreshold = 30;
        List<Employee> employeesAboveThreshold = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .collect(Collectors.toList());
        
        System.out.println("\nEmployees Above Age " + ageThreshold + ":");
        employeesAboveThreshold.forEach(System.out::println);

        double avgSalaryFiltered = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        
        System.out.printf("\nAverage salary of employees above age %d: $%,.2f%n", ageThreshold, avgSalaryFiltered);
    }

    private static List<Employee> initializeEmployeeDataset() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice Johnson", 28, "IT", 75000));
        employees.add(new Employee("Bob Smith", 35, "Finance", 82000));
        employees.add(new Employee("Carol Williams", 42, "HR", 68000));
        employees.add(new Employee("David Brown", 31, "IT", 79000));
        employees.add(new Employee("Emma Davis", 29, "Marketing", 71000));
        employees.add(new Employee("Frank Miller", 38, "Finance", 91000));
        employees.add(new Employee("Grace Wilson", 45, "IT", 95000));
        employees.add(new Employee("Henry Taylor", 27, "Marketing", 65000));
        employees.add(new Employee("Isabel Anderson", 33, "HR", 73000));
        employees.add(new Employee("Jack Thomas", 40, "Finance", 88000));
        employees.add(new Employee("Kelly Martinez", 26, "IT", 72000));
        employees.add(new Employee("Leo Garcia", 36, "Marketing", 77000));
        return employees;
    }
}

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;




    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }


    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee[Name=%s, Age=%d, Dept=%s, Salary=$%,.0f]",
            name, age, department, salary);
    }
}
