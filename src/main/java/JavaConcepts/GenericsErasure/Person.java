package JavaConcepts.GenericsErasure;



import java.util.ArrayList;
import java.util.List;

public class Person <T> {
 T personObject;

    public Person(T personObject) {
        this.personObject = personObject;
    }

    public Person() {

    }


    public void setPersonObject(T personObject) {
        this.personObject = personObject;
    }

    public int processPeople(List<Person> people) {
        for (Person person: people) {
            System.out.println("Processing persons: "+person.toString());
        }
        return people.size();
    }

    public int processEmployees(List<Employee> people) {
        for (Person person: people) {
            System.out.println("Processing persons: "+person.toString());
        }
        return people.size();
    }

    public int commonList(List <? extends Person> people) {
        for (Person person: people) {
            System.out.println("Processing common: "+person.toString());
        }
        return people.size();
    }




}

class Employee extends Person {
    String name;
    int age;


    public Employee( String name, int age   ) {
      //  super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee("Andrew",20));
//        employees.add(new Employee("Bob", 25));
        Person person = new Person(new Employee("Andy", 15));

        //person.processEmployees(employees);
        person.commonList(employees);
       



    }
}
