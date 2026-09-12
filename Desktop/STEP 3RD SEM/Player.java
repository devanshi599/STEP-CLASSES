import java.util.Arrays;

public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {

        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    static String draftAndRank(Player[] players) {

        int count = 0;

        for (Player player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(
                        player.matchesPlayed,
                        player.injured)) {

                count++;
            }
        }

        Player[] draftablePlayers = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(
                        player.matchesPlayed,
                        player.injured)) {

                draftablePlayers[index] = player;
                index++;
            }
        }

        Arrays.sort(draftablePlayers);

        String result = "";

        for (int i = 0; i < draftablePlayers.length; i++) {

            result += (i + 1)
                    + ". "
                    + draftablePlayers[i].name;

            if (i < draftablePlayers.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player(
                "Virat",
                15,
                48.0,
                false
            ),

            new Player(
                "Rahul",
                7,
                55.0,
                false
            ),

            new Player(
                "Sameer",
                3,
                60.0,
                false
            ),

            new Player(
                "Dev",
                12,
                20.0,
                true
            )
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}