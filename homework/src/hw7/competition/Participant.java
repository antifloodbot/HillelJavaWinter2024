package hw7.competition;

public interface Participant {
    boolean run(int distance);

    boolean jump(int height);

    String getName();

    int getMaxRunDistance();

    int getMaxJumpHeight();
}
