/**
 * Employee class represents an employee in the company with attributes:
 * name, age, department, and salary.
 * 
 * This class demonstrates proper encapsulation with private fields
 * and public getter methods for accessing employee information.
 */
public class Employee {
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

    // Getter methods for accessing private fields
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
        return String.format("Employee{name='%s', age=%d, department='%s', salary=%.2f}",
                name, age, department, salary);
    }
}
