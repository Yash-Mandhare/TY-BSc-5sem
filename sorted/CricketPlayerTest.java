// Define a class CricketPlayer (name,no_of_innings,no_of_times_notout, totatruns, bat_avg). Create an array of n player objects .Calculate the batting average for each player using static method avg(). Define a static sort method which sorts the array on the basis of average. Display the player details in sorted order.

import java.util.Scanner;
import java.util.Arrays;

class Cricketplayerdata {
    private String Name;
    private int NoofInnings;
    private int NooftimeNotOut;
    private int TotalRuns;
    private double Avg;

    public Cricketplayerdata(String Name, int NoofInnings, int NooftimeNotOut, int TotalRuns, double Avg) {
        this.Name = Name;
        this.NoofInnings = NoofInnings;
        this.NooftimeNotOut = NooftimeNotOut;
        this.TotalRuns = TotalRuns;
        this.Avg = Avg;
    }

    public static void sort(Cricketplayerdata[] players) {
        Arrays.sort(players, (p1, p2) -> Double.compare(p2.Avg, p1.Avg));
    }

    public void display() {
        System.out.printf("| %-20s | %-20d | %-20d | %-20d | %-20.2f |\n", Name, NoofInnings, NooftimeNotOut, TotalRuns, Avg);
    }
}

public class CricketPlayerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of players: ");

        int n = input.nextInt();

        Cricketplayerdata[] player = new Cricketplayerdata[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Player " + (i + 1) + ":");
            System.out.print("Name: ");
            String Name = input.next();
            System.out.print("Number of Innings: ");
            int NoofInnings = input.nextInt();
            System.out.print("Number of Times Not Out: ");
            int NooftimeNotOut = input.nextInt();
            System.out.print("Total Runs: ");
            int TotalRuns = input.nextInt();
            double Avg = (double) TotalRuns / (NoofInnings - NooftimeNotOut);

            player[i] = new Cricketplayerdata(Name, NoofInnings, NooftimeNotOut, TotalRuns, Avg);
        }
        Cricketplayerdata.sort(player);

        System.out.println("Player details sorted by batting average:");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.println("|         Name         |  Number of Innings   | Number Times Not Out |     Total Runs       |          Avg         |");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");

        for (int i = 0; i < n; i++) {
            player[i].display();
        }
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
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