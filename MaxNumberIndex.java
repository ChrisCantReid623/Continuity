import java.util.*;

public class MaxNumberIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Double> doublesList = new ArrayList<Double>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Input a number: ");
            doublesList.add(i, input.nextDouble());
        }

        double maxVal = 0;
        int maxInt = 0;
        for (int i = 0; i < doublesList.size(); i++){
            if (doublesList.get(i) > maxVal) {
                maxVal = doublesList.get(i);
                maxInt = i;
            }
        }

        System.out.println(maxInt);
        System.out.println(maxVal);

    }
}