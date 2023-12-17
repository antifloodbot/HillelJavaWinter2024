package hw7.competition;

public class CompetitionRun {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Obama", 999, 20),
                new Cat("Murzik", 2000, 2),
                new Robot("Android", 4000, 3)
        };

        Obstacle[] obstacles = {
                new RunningTrack(1000, "Marathon"),
                new Wall(3, "Death Wall")
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                String result = obstacle.attempt(participant);
                System.out.println(result);
                if (result.contains("didn't pass")) {
                    break;
                }
            }
        }
    }
}
