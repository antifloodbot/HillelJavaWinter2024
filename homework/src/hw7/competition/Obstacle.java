package hw7.competition;

public interface Obstacle {
    String getName();

    int getCharacteristic();

    String attempt(Participant participant);
}
