import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyQuestions {
    private final static ArrayList<Question> EASY_QUESTIONS = new ArrayList<>(List.of(
            new Question("What planet is closest to the sun?", "Mercury", "It's also the name of a liquid metal."),
            new Question("What is the capital of France?", "Paris", "Also known as the city of light."),
            new Question("How many days are in a leap year?", "366", "One more than a regular year."),
            new Question("What country has the largest population in the world as of 2024?","India","Recently overtook China for the top spot."),
            new Question("Which singer is nicknamed the 'King of Pop'","Michael Jackson","Released the world's best selling album, Thriller."),
            new Question("What is the name of the fictional land where The Lord of the Rings takes place?","Middle-earth","Home to Hobbits, Elves, and Orcs."),
            new Question("In what year did the United States declare its independence?","1776","It was the fourth of July."),
            new Question("Which artist painted the Mona Lisa?","Leonardo da Vinci","He was a master of the italian Renaissance."),
            new Question("What planet is known as the Red Planet?","Mars","Named after the Roman god of war."),
            new Question("What is the chemical symbol for water?","H2O","Two parts hydrogen, one part oxygen.")
    ));
    private final static Random RANDOM = new Random();

    private static int getIndex() {
        if (EASY_QUESTIONS.isEmpty()) {
            return -1;
        } else {
            return RANDOM.nextInt(EASY_QUESTIONS.size());
        }
    }

    public static Question getQnA() {
        int index = getIndex();
        if (index == -1) {
            return null;
        } else {
            return EASY_QUESTIONS.remove(index);
        }
    }
}

