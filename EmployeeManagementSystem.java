import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// This is the blueprint for one single worker (employee)
class Employee {
    private String workerName;
    private int workerAge;
    private String workerDept;
    private double workerSalary;

    public Employee(String name, int age, String dept, double salary) {
        this.workerName = name;
        this.workerAge = age;
        this.workerDept = dept;
        this.workerSalary = salary;
    }

    // Simple methods to get the data
    public String getName() { return workerName; }
    public int getAge() { return workerAge; }
    public String getDept() { return workerDept; }
    public double getSalary() { return workerSalary; }
}

// Main program class
public class EmployeeDataProcessor {

    public static void main(String[] args) {
        
        // 1. Read the data and store it in a simple list
        List<Employee> allWorkers = new ArrayList<>();
        allWorkers.add(new Employee("Alice Johnson", 25, "Sales", 65000.00));
        allWorkers.add(new Employee("Bob Smith", 42, "IT", 95000.00));
        allWorkers.add(new Employee("Charlie Brown", 35, "HR", 72000.00));
        allWorkers.add(new Employee("David Lee", 28, "Sales", 60000.00));
        allWorkers.add(new Employee("Eve Wilson", 51, "IT", 110000.00));
        
        System.out.println("--- Employee Data Processing ---");

        // --- Operation 1: Use Function to create a simple string ---
        
        // This is our Function. It takes an Employee and returns a String.
        // It's a rule that says: "Give me the name and the department."
        Function<Employee, String> nameAndDeptMaker = 
            worker -> worker.getName() + " is in " + worker.getDept();

        // --- Operation 2 & 3: Stream, Transform, and Collect ---
        
        // Use the stream to apply that Function to EVERY worker
        List<String> workerSummaryList = allWorkers.stream()
            .map(nameAndDeptMaker) // Apply our Function here!
            .collect(Collectors.toList());
            
        System.out.println("\n1. Worker Summary List:");
        workerSummaryList.forEach(System.out::println);


        // --- Operation 4 & 5: Filter, Find Average Salary ---

        int ageThreshold = 30;
        
        // This whole thing is one long stream operation!
        double averageSalary = allWorkers.stream()
            .filter(worker -> worker.getAge() > ageThreshold) // Filter: only keep workers older than 30
            .mapToDouble(Employee::getSalary) // Change the stream to just simple salary numbers
            .average() // Stream's built-in tool to find the average
            .orElse(0.0); // Default if the list is empty

        System.out.println("\n2. Average Salary of Workers OLDER than " + ageThreshold + ":");
        if (averageSalary > 0) {
            System.out.printf("The average salary is $%.2f\n", averageSalary);
        } else {
            System.out.println("No workers found older than " + ageThreshold + ".");
        }
    }
}
