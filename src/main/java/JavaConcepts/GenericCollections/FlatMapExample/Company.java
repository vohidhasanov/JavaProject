package JavaConcepts.GenericCollections.FlatMapExample;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Company {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public Company(long id, String name, Gender gender, LocalDate dob, double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public String getName() { return name;  }
    public Gender getGender() {return gender; }
    public LocalDate getDob() {return dob;  }



    enum Gender {
        MALE, FEMALE
    }


    public static List<Company> persons () {
        Company ken = new Company(1, "Jame", Gender.MALE, LocalDate.of(1970, Month.MAY, 4), 6123.0);
        Company jeff = new Company(2, "Jeff", Gender.MALE, LocalDate.of(1971, Month.JULY, 5), 7112.0);
        Company donna = new Company(3, "Jane", Gender.FEMALE, LocalDate.of(1972, Month.JULY, 9), 8712.0);
        Company chris = new Company(4, "Jodd", Gender.MALE, LocalDate.of(1973, Month.DECEMBER,6), 1823.0);
        Company laynie = new Company(5, "Janey", Gender.FEMALE, LocalDate.of(1974, Month.DECEMBER, 3), 1234.0);
        Company lee = new Company(6, "Jason", Gender.MALE, LocalDate.of(1975,Month.MAY,8), 2412.0);

        //Create list of Persons
        List <Company> persons= Arrays.asList(ken, jeff, donna, chris, laynie, lee);
        return persons;
    }

    public static void main(String[] args) {
    Map <Gender, Map<Object, String>> personsByGenderAndDobMonth =
                Company.persons().stream()
                .collect(Collectors.groupingBy(Company::getGender,
                        Collectors.groupingBy(p->p.getDob().getMonth(),
                        Collectors.mapping(Company::getName, Collectors.joining(", "))))
                );

        System.out.println(personsByGenderAndDobMonth);


    Map<Gender, Map<Object, String>> personsByGenderandByName =
            Company.persons().stream()
                    .collect(Collectors.groupingBy(Company::getGender,
                            Collectors.groupingBy(m->m.getName(),
                                    Collectors.mapping(Company::toString, Collectors.joining(" ,"))
                            )));


   //     System.out.println(personsByGenderandByName);







        for (Map.Entry<Gender, Map<Object, String>> map: personsByGenderAndDobMonth.entrySet()) {
            System.out.println(map.getValue()+"--->" +map.getKey());
        }

//        for (int x=0; x<personsByGenderAndDobMonth.size(); x++) {
//            System.out.println(personsByGenderAndDobMonth.entrySet());
//        }

    }


}
