import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumQuestions {
    private final static ArrayList<Question> MEDIUM_QUESTIONS = new ArrayList<>(List.of(
            new Question("Which country is known as the birthplace of Arabica coffee?","Ethiopia","Also known as the cradle of humanity."),
            new Question("What is the rarest blood type?","AB Negative","It's a combination of two letters and a sign."),
            new Question("What is the capital of Canada?","Ottawa","Located in the province of Ontario."),
            new Question("Which planet has the most moons?","Saturn","It is famous for its rings."),
            new Question("In what year did the Titanic sink?","1912","Early 20th century."),
            new Question("What infectious disease was the first to be completely eradicated by humans?","Smallpox","It was officially declared gone by the WHO in 1980."),
            new Question("Who was the leader of the Soviet Union during WW2?","Joseph Stalin","Part of the 'big three' alongside Churchill and FDR."),
            new Question("Which 1937 animated film is the first-ever feature-length animated movie?","Snow White and the Seven Dwarfs","It was produced by Walt Disney."),
            new Question("In the movie 'Pulp Fiction', what is the name given to a Quarter Pounder with Cheese in Paris?","Royale with Cheese","It's because of the metric system."),
            new Question("What country has won the most World Cup titles in men's soccer?","Brazil","They have won it 5 times.")

    ));
    private final static Random RANDOM = new Random();

    private static int getIndex() {
        if (MEDIUM_QUESTIONS.isEmpty()) {
            return -1;
        } else {
            return RANDOM.nextInt(MEDIUM_QUESTIONS.size());
        }
    }

    public static Question getQnA() {
        int index = getIndex();
        if (index == -1) {
            return null;
        } else {
            return MEDIUM_QUESTIONS.remove(index);
        }
    }
}

