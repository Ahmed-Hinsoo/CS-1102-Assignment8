import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

   
    public String getName() { return workerName; }
    public int getAge() { return workerAge; }
    public String getDept() { return workerDept; }
    public double getSalary() { return workerSalary; }
}


public class EmployeeDataProcessor {

    public static void main(String[] args) {
        

        List<Employee> allWorkers = new ArrayList<>();
        allWorkers.add(new Employee("Alice Johnson", 25, "Sales", 65000.00));
        allWorkers.add(new Employee("Bob Smith", 42, "IT", 95000.00));
        allWorkers.add(new Employee("Charlie Brown", 35, "HR", 72000.00));
        allWorkers.add(new Employee("David Lee", 28, "Sales", 60000.00));
        allWorkers.add(new Employee("Eve Wilson", 51, "IT", 110000.00));
        
        System.out.println("--- Employee Data Processing ---");


        Function<Employee, String> nameAndDeptMaker = 
            worker -> worker.getName() + " is in " + worker.getDept();


        List<String> workerSummaryList = allWorkers.stream()
            .map(nameAndDeptMaker) 
            .collect(Collectors.toList());
            
        System.out.println("\n1. Worker Summary List:");
        workerSummaryList.forEach(System.out::println);



        int ageThreshold = 30;
        
     
        double averageSalary = allWorkers.stream()
            .filter(worker -> worker.getAge() > ageThreshold) 
            .mapToDouble(Employee::getSalary) 
            .average() 
            .orElse(0.0); 

        System.out.println("\n2. Average Salary of Workers OLDER than " + ageThreshold + ":");
        if (averageSalary > 0) {
            System.out.printf("The average salary is $%.2f\n", averageSalary);
        } else {
            System.out.println("No workers found older than " + ageThreshold + ".");
        }
    }
}
