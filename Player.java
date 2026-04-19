public class Player {

    private final String NAME;
    private int points;
    private int hints;

    public Player(String name) {
        this.NAME = name;
        this.points = 0;
        this.hints = 2;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return this.points;
    }

    public String getNAME() {
        return this.NAME;
    }

    public boolean hasHints() {
        return this.hints > 0;
    }

    public int getHints() {
        return this.hints;
    }

    public void useHint() {
        this.hints -= 1;
    }


}

