import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter triangle side 1 length: ");
        int sideOne = input.nextInt();
        System.out.println("Enter triangle side 2 length: ");
        int sideTwo = input.nextInt();
        System.out.println(hypotenuse(sideOne, sideTwo));
    }

    public static double hypotenuse(int side1, int side2) {
        double sides = (side1 * side1) + (side2 * side2);
        return (double) Math.sqrt(sides);
    }
}
