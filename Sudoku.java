import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File textFile = new File(fileName);

        Scanner fileReader = new Scanner(textFile);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            String[] numStrings = line.split(" ");
            for (String element: numStrings){
                int number = Integer.parseInt(element);
                numbers.add(number);
            }
        }

        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < 9) {
            System.out.println("There is a duplicate.");
        } else {
            System.out.println("There is no duplicate.");
        }

    }
}
