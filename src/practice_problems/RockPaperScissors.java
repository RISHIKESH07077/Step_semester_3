package practice_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        final int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < rounds; i++) {
                System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
                String playerMove = scanner.nextLine();

                String computerMove = generateComputerMove();
                String result = playRound(playerMove, computerMove);

                playerMoves[i] = playerMove;
                computerMoves[i] = computerMove;
                results[i] = result;

                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }

                System.out.println("Computer: " + computerMove);
                System.out.println("Result: " + result);
                System.out.println();
            }
        }

        printSummary(playerMoves, computerMoves, results, wins, losses, draws, rounds);
    }

    public static String generateComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        return moves[random.nextInt(moves.length)];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void printSummary(String[] playerMoves, String[] computerMoves,
                                    String[] results, int wins, int losses,
                                    int draws, int rounds) {
        System.out.println("Final Summary");
        System.out.println("---------------------------------------------");
        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | " + playerMoves[i] +
                    "       | " + computerMoves[i] + "       | " + results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("---------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercentage);
    }
}