import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Win";
        }

        return "Loss";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        System.out.println("===== ROCK PAPER SCISSORS GAME =====");

        for (int i = 0; i < rounds; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            String playerMove = sc.nextLine().trim();

            // Convert first letter to uppercase
            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            // Validate player move
            if (!playerMove.equals("Rock")
                    && !playerMove.equals("Paper")
                    && !playerMove.equals("Scissors")) {

                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                i--;
                continue;
            }

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Determine result
            String result = game.playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Win")) {
                wins++;
            } else if (result.equals("Loss")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Summary table
        System.out.println("\n========== FINAL SCOREBOARD ==========");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | "
                    + playerMoves[i] + "       | "
                    + computerMoves[i] + "       | "
                    + results[i]);
        }

        // Calculate win percentage
        double winPercentage = ((double) wins / rounds) * 100;

        System.out.println("\n========== SUMMARY ==========");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}