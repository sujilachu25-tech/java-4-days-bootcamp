import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your college name: ");
        String college = sc.nextLine();

        System.out.println("\nMy name is " + name +
            ". I am " + age +
            " years old. I study at " + college + ".");

        sc.close();
    }
}
