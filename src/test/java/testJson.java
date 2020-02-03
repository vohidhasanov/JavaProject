import JSON.Name;
import JSON.Student;
import com.jsoniter.JsonIterator;
import com.jsoniter.ValueType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class testJson {

    @Test
    public void whenParseUsingBindAPI_thenConvertedToJavaObjectCorrectly () {
        String input  = "{\"id\":1, \"name\": {\"firstName\": \"Joe\", \"surname\": \"Blogg\"}}";
        Student student = JsonIterator.deserialize(input, Student.class);
        assertEquals(1, student.getId());
        assertEquals("Joe", student.getFirstName());
        assertEquals("Blogg", student.getSurname()) ;
       // assertEquals("Blogg", student.get)

    }

    @Test
    public void whenParsedUsingIteratorAPI_thenFieldValuesExtractedCorrcctly() throws IOException {
        Name name = new Name();
        String input = "{\"firstName\":\"Joe\", \"surname\":\"Blogg\"}";
        JsonIterator iterator = JsonIterator.parse(input);

        for (String field = iterator.readObject();
             field != null;
             field = iterator.readObject()) {

            switch(field) {
                case "firstName":
                    if (iterator.whatIsNext() == ValueType.STRING) {
                        name.setFirstName(iterator.readString());
                    }
                    continue;

                case "surname":
                    if (iterator.whatIsNext() == ValueType.STRING) {
                        name.setLastName(iterator.readString());
                    }
                    continue;
                default:
                        iterator.skip();

            }
        }

        assertEquals(name.getFirstName(), "Joe");
        assertEquals(name.getLastName(), "Blogg");
    }



}
