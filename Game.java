import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final ArrayList<Player> players = new ArrayList<>();
    private int playerNum, topScore = 0;
    private String winnerName = "";
    private final static Scanner INPUT = new Scanner(System.in);
    private Question currentQuestion;
    private int pointValue;

    public void checkHints(int i) {
        if (players.get(i).hasHints()) {
            System.out.println("\t(" + players.get(i).getHints() + " hint(s) available!)");
        }
    }

    public void getQuestion(int round) {
        if (round == 1) {
            currentQuestion = EasyQuestions.getQnA();
            pointValue = 1;
        } else if (round == 2) {
            currentQuestion = MediumQuestions.getQnA();
            pointValue = 2;
        } else { //ROUND == 3
            currentQuestion = HardQuestions.getQnA();
            pointValue = 3;
        }
    }

    public void displayRound(int round) {
        if (round == 1) {
            System.out.print("ROUND 1: EASY QUESTIONS! 1 point each...\t");
        } else if (round == 2) {
            System.out.print("ROUND 2: HARDER QUESTIONS! 2 points each...\t");
        } else { //ROUND == 3
            System.out.print("BONUS ROUND! RIDDLES! 3 points each...\t");
        }
    }

    private void displayCurrentPlayers() {
        System.out.println("######################");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i + 1) + ": " + players.get(i).getNAME() + "\tpoints: " + players.get(i).getPoints());
        }
        System.out.println("######################");
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void setup() { // player creation loop
        while (true) {
            System.out.print("\nHow many players would you like to add? "); //Should be less than number of questions in order to prevent error
            try {
                playerNum = Integer.parseInt(INPUT.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        for (int i = 0; i < playerNum; i++) {
            System.out.print("\nEnter name for next player: ");
            String playerName = INPUT.nextLine();
            players.add(new Player(playerName));
            displayCurrentPlayers();
        }
    }

    public void play() {
        String input;
        final int MAX_ROUND = 3;
        for (int round = 1; round <= MAX_ROUND; round++) {
            displayRound(round);
            pause(3000);
            System.out.println("\nPress any key to continue... ");
            INPUT.nextLine();
            for (int i = 0; i < players.size(); i++) {

                System.out.println("\n" + players.get(i).getNAME() + ", get ready for question " + (round) + "...");
                pause(3000);
                getQuestion(round);
                System.out.println("\n" + currentQuestion.getQuestion());
                checkHints(i);
                pause(2500);
                if (players.get(i).hasHints()) {
                    System.out.print("\nInput 'hint' or press ENTER to reveal the answer!\n");
                } else {
                    System.out.print("\nPress ENTER to reveal the answer!\n");
                }

                input = INPUT.nextLine().toLowerCase();

                if (input.equals("hint") && players.get(i).hasHints()) {
                    players.get(i).useHint();
                    System.out.println("\n" + currentQuestion.getHint());
                    System.out.print("\nPress ENTER to reveal the answer!\n");
                    INPUT.nextLine();
                }

                    System.out.println("\nAnswer: " + currentQuestion.getAnswer());
                    pause(2500);

                    while (true) {
                        System.out.print("\nDid " + players.get(i).getNAME() + " answer correctly? (y/N) ");
                        input = INPUT.nextLine().toLowerCase();
                        if (input.equals("y")) {
                            System.out.println("+ " + pointValue + " point(s)!");
                            players.get(i).addPoints(pointValue);
                            break;
                        } else if (input.equals("n") || input.isEmpty()) {
                            break;
                        } else {
                            System.out.println("Input not understood...");
                        }
                    }
                    System.out.println();
                    displayCurrentPlayers();
            }
        }
    }

    public void determineWinner() {
            ArrayList<String> scoreboard = new ArrayList<>();
            for (int i = 0; i < playerNum; i++) { //find top score
                if (players.get(i).getPoints() > topScore) {
                    topScore = players.get(i).getPoints();
                }
            }
            for (int i = 0; i < playerNum; i++) {
                if (players.get(i).getPoints() == topScore) {
                    winnerName = players.get(i).getNAME();
                    scoreboard.add(winnerName);
                }
            }

            System.out.println("TOP SCORE:" + topScore);
            pause(1500);
            if (scoreboard.size() == 1) {
                System.out.print("WINNER: ");
                System.out.print(winnerName + "!");
            } else {
                System.out.print("WINNERS: ");
                for (String s : scoreboard) {
                    System.out.print(s + "!\t");
                    pause(1000);
                }
            }
        }


}

