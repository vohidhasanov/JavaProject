package File;

import java.io.*;
import java.util.Arrays;

public class TestFile {

    public static void main(String[] args) throws IOException {
        DataInputStream d = new DataInputStream(new FileInputStream("src/main/resources/ex.txt"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("src/main/resources/ex21.txt"));
        String count;

//        while ((count = d.readLine()) != null) {
//            if (count.length() >= 100) {
//                String arr[] = new String[0];
//               //arr = count.split(count.substring((count.length()/2), count.indexOf(" ", count.length()/2))) ;
//                arr = count.split(count.substring(count.substring(count.length()/2);
//              //  count.su
//               for (String s : arr) {
//                    s = s.toUpperCase();
//                    System.out.println(s);
//                    out.writeBytes(s + " ");
//
//                }
//            } else {
//
//                String u = count.toUpperCase();
//                System.out.println(u);
//                out.writeBytes(u);
//
//            }

        while ((count=d.readLine())!=null) {
            String arr[] = new String[0];
            arr = count.split(" ");
            int stringcount=0;

                   for (int x=0; x <arr.length ; x++ ) {

                       System.out.print(arr[x]+" ");
                       stringcount+= arr[x].length();
                       if ( stringcount>30) {
                           System.out.println();
                           stringcount=0;
                       }
                   }

        }
        d.close();
        out.close();
        }
//   d.close();
//        out.close();

    }
//}