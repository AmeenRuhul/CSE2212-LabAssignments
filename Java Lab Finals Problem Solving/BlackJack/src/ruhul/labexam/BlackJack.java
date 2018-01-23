package ruhul.labexam;

import java.util.Scanner;
import java.util.*;

public class BlackJack {

    private int playersTotal = 0;
    private int delaersTotal = 0;
    private int hiddenVal = 0;


    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.start();
    }

    public boolean setThink(int a) {
        if (a >= 17)
            return false;
        else return true;
    }

    public int takeCard() {
        Random random = new Random();
        int pick = 0;

        pick = random.nextInt();
        pick = pick % 10;

        if (pick < 0)
            pick = pick * (-1);
        else if (pick == 0)
            return 10;
        else if (pick == 1)
            return 11;
        return pick;
    }

    public void init() {

        int pick1 = 0;
        int pick2 = 0;

        System.out.println("Welcome To BlackJack !");

        pick1 = takeCard();
        pick2 = takeCard();

        System.out.println("You get a " + pick1 + " and a " + pick2 + ".");
        playersTotal = pick1 + pick2;
        System.out.println("Your Tottal is " + playersTotal + ".");
        pick1 = takeCard();
        pick2 = takeCard();
        System.out.println("The dealer has a " + pick1 + " showing, and a hidden card.");
        delaersTotal = pick1 + pick2;
        hiddenVal = pick2;
        System.out.println("His total is hidden, too.");

    }


    public void start() {
        String takeInput = "";
        int takeVal = 0;

        Scanner scanner = new Scanner(System.in);

        init();

        while (true) {
            if (playersTotal >= 22) {
                System.out.println("Delear Wins!");
                return;
            }

            System.out.println("Would You like to \"hit\" or \"stay\" ?");
            takeInput = scanner.nextLine();

            if (takeInput.equals("hit")) {
                takeVal = takeCard();
                System.out.println("You drew a" + takeVal + ".");
                playersTotal = playersTotal + takeVal;
                System.out.println("Your total is " + playersTotal);
            } else {
                System.out.println("Okay,dealer's turn.");
                break;
            }
        }

        System.out.println("His hidden Card was " + hiddenVal + ".");
        System.out.println("His Total was" + delaersTotal);

        while (true) {
            if (delaersTotal >= 22) {
                System.out.println("You win");
                return;
            }

            while (setThink(delaersTotal)) {
                System.out.println("Dealer Chooses to hit.");
                takeVal = takeCard();
                System.out.println("He drew a " + takeVal);
                delaersTotal = delaersTotal + takeVal;
                System.out.println("His Total is" + delaersTotal);

                if (delaersTotal >= 22) {
                    System.out.println("You win!");
                    return;
                }
                if (playersTotal >= 22) {
                    System.out.println("DEALER WINS!");
                    return;
                }

                if (delaersTotal > playersTotal) {
                    System.out.println("DEALER WINS!");
                    return;
                } else if (delaersTotal < playersTotal) {
                    System.out.println("YOU WIN!");
                    return;
                } else {
                    System.out.println("DEALER WINS!");
                    return;
                }
            }

        }

    }
}
