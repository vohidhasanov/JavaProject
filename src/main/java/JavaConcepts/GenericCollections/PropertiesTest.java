package JavaConcepts.GenericCollections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

    public static void main(String[] args) {
        Properties table = new Properties();

        table.setProperty("color", "blue");
        table.setProperty("width", "200");

        System.out.println("After setting properties");
        listProperties(table);

        //replace color value
        table.setProperty("color", "red");
        System.out.println("After replacing properties");
        listProperties(table);

        saveProperties(table);

        table.clear(); //empty table
        System.out.println("After clearing the table");

        loadProperties(table);

        Object value = table.getProperty("color");
        if (value!=null) {
            System.out.printf("Property color's value is %s%n", value);
        }
        else {
            System.out.println("Property color is not in table");
        }

    }

    private static void loadProperties(Properties table) {
        try {
            FileInputStream input = new FileInputStream("prop.dat");
            table.load(input);
            input.close();
            System.out.println("After loading properties");
            listProperties(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveProperties(Properties table) {
        try {
            FileOutputStream output = new FileOutputStream("prop.dat");
            table.store(output, "Sample Properties");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void listProperties(Properties table) {
        Set<Object> keys = table.keySet();

        for (Object key : keys) {
            System.out.printf("%s\t%s%n", key, table.getProperty((String) key));
            System.out.println();
        }

    }
}
