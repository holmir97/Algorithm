import java.util.Scanner;

public class Gambling {
    Scanner scanner = new Scanner(System.in);
    Person person[];

    public Gambling() {
        this.person = new Person[2];
    }

    public void Start() {
        boolean state = true;
        int i = 0;
        System.out.println("Game Start!!!!\n");

        while (state) {
            int num[] = new int[3];

            System.out.print(person[i % 2].getName() + "(ENTER): ");
            scanner.nextLine();
            for (int j = 0; j < 2; j++) {
                // Random num (0~2)
                num[j] = (int) (Math.random() * 3);
                System.out.print(num[j] + "! ");
            }System.out.println();


            if (num[0] == num[1]) {
                System.out.println("Winner!!! >> " + person[i % 2].getName());
                System.out.println("Game end!!");
                break;
            }else{
                System.out.println("Fail !! \n");
                i++;
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Gambling game = new Gambling();

        System.out.print("player 1: ");
        String player1 = scanner.next();
        game.person[0] = new Person(player1);

        System.out.print("player 2: ");
        String player2 = scanner.next();
        game.person[1] = new Person(player2);

        game.Start();

    }

}
