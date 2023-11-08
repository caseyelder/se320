import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class ReadText {
    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.split("\\s+");
                for (String word : wordArray) {
                    words.add(word);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Non-duplicate words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
