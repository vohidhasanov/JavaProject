package JavaConcepts.GenericCollections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {

    public static void main(String[] args) throws IOException {
        //Купуч епрфе matches one omore consecutive  whitespace characters
        Pattern pattern = Pattern.compile("\\s+");

        //count occurrences of each word in a Stream<String> sorted by word
        Map<String, Long> wordCounts =
                Files.lines(Paths.get("Chapter2Paragraph.txt"))
                .map(line-> line.replaceAll("(?!')\\p{P}", ""))
                .flatMap(line -> pattern.splitAsStream(line))
                .collect(Collectors.groupingBy(String::toLowerCase,
                                 TreeMap::new, Collectors.counting()));

//        for (Map.Entry<String, Long > itr :   wordCounts.entrySet() ) {
//            System.out.println(itr.getKey());
//        }


        //display the words grouped by starting letter
        wordCounts.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                        TreeMap::new, Collectors.toList()))
                .forEach((letter, wordList) -> {
            System.out.printf("%n%C%n", letter);
            wordList.stream().forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
        });



    }


}
