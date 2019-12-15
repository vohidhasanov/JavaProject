package JavaConcepts.GenericCollections.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
    }
}
