public class Hello {

    public static void main(String[] args) {
        String txt = "" +
                "Hello " +
                "world " +
                "to + " +
                " all";
        int count=1;

        for (int i=0; i<txt.length()-1; i++)
        if (txt.charAt(i)==' ' && txt.charAt(i)+1!=' ') {
            count++;
        }

        System.out.println("The number of word are= "+count);
    }
}
