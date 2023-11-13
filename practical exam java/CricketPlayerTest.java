// Define a class CricketPlayer (name,no_of_innings,no_of_times_notout, totatruns, bat_avg). Create an array of n player objects .Calculate the batting average for each player using static method avg(). Define a static sort method which sorts the array on the basis of average. Display the player details in sorted order.

import java.util.Scanner;
import java.util.Arrays;

class CricketPlayer {
    private String name;
    private int noOfInnings;
    private int noOfTimesNotOut;
    private int totalRuns;

    public CricketPlayer(String name, int noOfInnings, int noOfTimesNotOut, int totalRuns) {
        this.name = name;
        this.noOfInnings = noOfInnings;
        this.noOfTimesNotOut = noOfTimesNotOut;
        this.totalRuns = totalRuns;
    }

    public static double avg(CricketPlayer player) {
        if (player.noOfInnings - player.noOfTimesNotOut == 0) {
            return 0.0;
        } else {
            return (double) player.totalRuns / (player.noOfInnings - player.noOfTimesNotOut);
        }
    }

    public static void sort(CricketPlayer[] players) {
        Arrays.sort(players, (player1, player2) -> Double.compare(avg(player2), avg(player1)));
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s", name, noOfInnings, noOfTimesNotOut, totalRuns, avg(this));
    }
}

public class CricketPlayerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int n = scanner.nextInt();
        CricketPlayer[] players = new CricketPlayer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Player " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Number of Innings: ");
            int noOfInnings = scanner.nextInt();
            System.out.print("Number of Times Not Out: ");
            int noOfTimesNotOut = scanner.nextInt();
            System.out.print("Total Runs: ");
            int totalRuns = scanner.nextInt();

            players[i] = new CricketPlayer(name, noOfInnings, noOfTimesNotOut, totalRuns);
        }

        CricketPlayer.sort(players);

        System.out.println("Player details sorted by batting average:");
        System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s", "Name", "Innings", "Not Outs", "Total Runs", "Batting Avg"));
        for (CricketPlayer player : players) {
            System.out.println(player);
        }

        scanner.close();
    }
}


// Enter the number of players: 2
// Enter details for Player 1:
// Name: yash
// Number of Innings: 100
// Number of Times Not Out: 10
// Total Runs: 4500
// Enter details for Player 2:
// Name: siddhi
// Number of Innings: 80
// Number of Times Not Out: 5
// Total Runs: 50000
// Player details sorted by batting average:
// Name           Innings        Not Outs       Total Runs     Batting Avg
// siddhi         80             5              50000          666.6666666666666
// yash           100            10             4500           50.0