package hw7.competition;

public class RunningTrack implements Obstacle {
    private int length;
    private String name;

    public RunningTrack(int length, String name) {
        this.length = length;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCharacteristic() {
        return length;
    }

    @Override
    public String attempt(Participant participant) {
        if (participant.run(length)) {
            return "Participant [" + participant.getName() +
                    "] passed and obstacle [" + getName() +
                    "] on distance [" + getCharacteristic() + "]m.";

        } else {
            return "Participant [" + participant.getName() +
                    "] didn't pass an obstacle [" + getName() +
                    "] on distance [" + length +
                    "]m. Passed [" + participant.getMaxRunDistance() + "]m.";

        }
    }
}
