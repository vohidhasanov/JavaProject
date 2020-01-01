package JavaConcepts.GenericCollections.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployee {

    public static void main(String[] args) {
        Employee [] employees = new Employee[7];
        employees[0] = new Employee("Jason", "Red", 5000, "IT");
        employees[1] = new Employee("Ashley", "Green", 7600, "IT");
        employees[2] = new Employee("Matthew", "Indigo", 3587.5, "Sales");
        employees[3] = new Employee("James", "Indigo", 4700.77, "Marketing");
        employees[4] = new Employee("Luke", "Indigo", 6200, "IT");
        employees[5] = new Employee("Jason", "Blue", 3200, "Sales");
        employees[6] = new Employee("Wendy", "Brown", 4236.4, "Marketing");

        List<Employee> list = Arrays.asList(employees);

        //display all employees
        System.out.println("Complete employee list: ");
        list.stream().forEach(System.out::println);

        //Predicatу that returns true for salaries in the range $4000-$6000
        Predicate<Employee> fourToSixThousand =
                    e->(e.getSalary() >= 4000 && e.getSalary()<=6000);

        //Display Employees wtih salaries in thу range $4000-$6000
        System.out.printf("%nEmployees earning $4000- $6000 per month sorted by salary:%n");
                list.stream()
                    .filter(fourToSixThousand)
                    .sorted(Comparator.comparing(Employee::getSalary))
                    .forEach(System.out::println);


        //Display first Employee with salary in the range $4000-$6000
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                        list.stream()
                            .filter(fourToSixThousand)
                            .findFirst()
                            .get());

        //Function for gettin first and last names from Employee
        Function <Employee, String> byFirstName = Employee::getFirstName;
        Function <Employee, String> byLastName = Employee::getLastName;

       //Comparator for comparing Emplyees by first name then last name
        Comparator <Employee> lastThenFirst =Comparator.comparing(byLastName)
                                            .thenComparing(byFirstName);

        //sort Employees by last name then by first Name
        System.out.printf("%nEmployees in ascending order by last name then firs name:%n");
                list.stream()
                        .sorted(lastThenFirst)
                        .forEach(System.out::println);

         //sort Employees in descending order by last name, then firs name
        System.out.printf("%nEmployees in descending order by last name then firs name:%n");
                list.stream()
                        .sorted(lastThenFirst.reversed())
                        .forEach(System.out::println);

         //display unique employee last names sorted
        System.out.printf("%nUnique employee last names: %n");
                list.stream()
                        .map(Employee::getLastName)
                        .distinct()
                        .sorted()
                        .forEach(System.out::println);

        //display only first and last names
        System.out.printf("%nEmployee names in order by last name then first name:%n");
                list.stream()
                        .sorted(lastThenFirst)
                        .map(Employee::getName)
                        .forEach(System.out::println);

        //group Emplyees by department
        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (depart, employeesInDepartmen) -> {
                    System.out.println(depart);
                    employeesInDepartmen.forEach(
                            employee -> System.out.printf("   %s%n", employee)
                    );
                } );

        //cout number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");
        Map <String, Long> employeeCountByDepartment =
                list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));
        employeeCountByDepartment.forEach(
                (depar, count)->System.out.printf(
                        "%s has %d employees%n",depar, count));


        //sum of Employee salaries wtih DoubleStream sum method
        System.out.printf("%nSum of Employees salaries (via method sum): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        //calculate sum of Employee salaries with Stream reduce method
        System.out.printf("Sum of Employees salaries (via reduce method): %.2f%n",
                list.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0, (value1, value2)->value1+value2));

        //average of Employee salaries with DoubleStream average method
        System.out.printf("Average of Employees salaries: %.2f%n",
                list.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0));
                //.getAsDouble());



    }
}
