public class Question {
    private final String QUESTION, ANSWER, HINT;

    public Question(String question, String answer, String hint) {
        this.ANSWER = answer;
        this.HINT = hint;
        this.QUESTION = question;
    }

    public String getQuestion() {
        return QUESTION;
    }

    public String getAnswer() {
        return ANSWER;
    }

    public String getHint() {
        return HINT;
    }

}
