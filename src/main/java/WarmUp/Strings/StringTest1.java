package WarmUp.Strings;

public class StringTest1 {

    public static void main(String[] args) {
        String file ="C:/Users/Vohid-PC/Downloads/MOCK_DATA.xlsx";
        String file1 = file.substring(file.lastIndexOf('/')+1);
        System.out.println(file1);

    }
}
