import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GameScores {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter your filename: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File gameFile = new File(fileName);
        Scanner fileReader = new Scanner(gameFile);

        TreeMap<String, String> scores = new TreeMap<String, String>();

        while (fileReader.hasNext()){
            String line = fileReader.nextLine();
            String[] splitLine = line.split(" ");
            scores.put(splitLine[0], splitLine[1]);
        }

        for (Map.Entry<String, String> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
