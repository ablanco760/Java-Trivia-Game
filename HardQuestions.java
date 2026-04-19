import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardQuestions {
    private final static ArrayList<Question> HARD_QUESTIONS = new ArrayList<>(List.of(
            new Question("What has to be broken before you can use it?","An Egg","You need it for an omelet."),
            new Question("What goes up but never comes down?","Age","It happens every birthday."),
            new Question("You measure my life in hours, and i serve you by expiring. I'm quick when i'm thin and slow when i'm fat. What am i?","A candle","The wind is my enemy."),
            new Question("I speak without a mouth and hear without ears. I have no body but come alive with the wind, what am I?","An echo","I only repeat what you say."),
            new Question("What month of the year has 28 days?","All of them","Don't overthink the calendar."),
            new Question("I have cities but no houses, I have mountains but no trees. I have water but no fish. What am i?","A map","I have four corners."),
            new Question("I have no wings, but i can fly. I have no eyes, but i can cry. What am i?","A cloud","I am made of vapor and change shape with the wind."),
            new Question("What is so fragile that saying its name breaks it?","Silence","I exist only when you stop making noise."),
            new Question("The man who built it doesn't want it. The man who bought it doesn't need it. The man who needs it doesn't know it. What is it?","A Coffin","It is the final 'vessel' for a passenger who can't see it."),
            new Question("What can travel the world while staying in a corner?","Stamp","I am stuck to an envelope.")
    ));
    private final static Random RANDOM = new Random();

    private static int getIndex() {
        if (HARD_QUESTIONS.isEmpty()) {
            return -1;
        } else {
            return RANDOM.nextInt(HARD_QUESTIONS.size());
        }
    }

    public static Question getQnA() {
        int index = getIndex();
        if (index == -1) {
            return null;
        } else {
            return HARD_QUESTIONS.remove(index);
        }
    }
}

