package hw7.competition;

public interface Obstacle {
    String getName();

    int getCharacteristic();

    String overcome(Participant participant);
}
