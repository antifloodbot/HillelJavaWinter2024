package hw7.competition;

public class Wall implements Obstacle {
    private int height;
    private String name;

    public Wall(int height, String name) {
        this.height = height;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCharacteristic() {
        return height;
    }

    @Override
    public String overcome(Participant participant) {
        if (participant.jump(height)) {
            return "Participant [" + participant.getName() +
                    "] passed an obstacle [" + name +
                    "] on height [" + height + "]m.";
        } else {
            return "Participant [" + participant.getName() +
                    "] didn't pass an obstacle [" + name +
                    "] on height [" + height +
                    "]m. Passed [" + participant.getMaxJumpHeight() + "]m.";
        }
    }
}
