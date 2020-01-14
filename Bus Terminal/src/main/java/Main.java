import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  Menu  \n========\n\n1)Arrive\n2)Depart\n3)Terminal-Information\n\n4)Exit");
        String input = scanner.nextLine();

        switch (input){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                System.exit(0);
                break;
                default:
                    System.out.println("Invalid Input!");
                    break;

        }
    }
}
