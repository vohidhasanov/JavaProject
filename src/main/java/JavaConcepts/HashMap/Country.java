package JavaConcepts.HashMap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Country implements Comparable <Country> {
    private String name;
    private int population;

    Country () {};
    Country (String name, int population ) {
        this.name = name;
        this.population = population;

    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public static<K,V extends Comparable<V>>  Map<K, V> sortByValues (Map <K,V> map) { //<K, V extends  Comparable<V>>
        Comparator <K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare==0)
                    return 1;
                else
                    return compare;

            }
        };

        Map <K,V> sortedByValues = new TreeMap<K,V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Country other = (Country) o;
//        if (name == null) {
//            if (other.name != null)
//                return false;
//        } else if (!name.equals(other.name))
//            return false;
//
//        return true;
//    }
    //////////////////////////////////////////////////////
//        return population == country.population &&
//                name.equals(country.name);
//}



//    @Override
//    public int hashCode() {
//        return Objects.hash(name, population);
//    }

    public static void main(String[] args) {
//        Country india1 = new Country();
//        india1.setName("India");
//        Country india2 = new Country();
//        india2.setName("India2");
//
//        System.out.println("Is india1 equals to inida2: "+india1.equals(india2));


 //       HashMap <Country, String> countryCapitalMap= new HashMap<>();
//            Country india1= new Country();
//        india1.setName("India");
//            Country india2 = new Country();
//        india2.setName("India");

//        countryCapitalMap.put(india1, "Delhi");
//        countryCapitalMap.put(india2, "Delhi");
      //Iterator countryCapitaIter = countryCapitalMap.keySet().iterator();

        TreeMap <Country, String> countryCapitalMap = new TreeMap<>();  //(o1, o2)->o1.name.compareToIgnoreCase(o2.name)
        Country india = new Country("India", 1000);
        Country uzbeksitan = new Country("Uzbeksitan",500);
        countryCapitalMap.put(uzbeksitan, "Tashkent");
        countryCapitalMap.put(india, "Yehli" );


        Map sortedMap = sortByValues(countryCapitalMap);

      Set sortedSet = sortedMap.entrySet();
      Iterator iterator = sortedSet.iterator();

      while (iterator.hasNext()) {
          Map.Entry me = (Map.Entry) iterator.next();
          System.out.print(me.getKey()+": ");
          System.out.println(me.getValue());

      }





   //     Iterator countryCapitalIter = countryCapitalMap.keySet().iterator();

//        while (countryCapitalIter.hasNext()) {
//            Country countryObj = (Country) countryCapitalIter.next();
//            String capital = countryCapitalMap.get(countryObj);
//            System.out.println("Capital of "+ countryObj.getName()+"---"+ capital);
//        }



    }

//    @Override
//    public int compare(Country o, Country t1) {
//        return o.getName().compareToIgnoreCase(t1.getName());
//    }

    @Override
    public int compareTo(@NotNull Country country) {
        return name.compareTo(country.getName());
    }


}
