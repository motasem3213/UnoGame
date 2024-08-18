import java.util.Scanner;

public class GetUserInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberInRange(int from, int to) {

        System.out.print("Enter number from (" + from + " - " + to + ") : ");

        while (true) {
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num < from || num > to) {
                System.out.println("Invalid Number Choice");
            } else {
                return num;
            }
        }
    }


    public static Card.Color getColor() {

        System.out.print("Enter Color Name (RED,BLUE,GREEN,YELLOW) : ");
        while (true) {
            String color = scanner.nextLine().toUpperCase();
            try {
                return Card.Color.valueOf(color);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Color");
            }
        }

    }



}
