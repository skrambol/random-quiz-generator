package ph.edu.uplb.ics.cs191.randomquizgenerator;

public class Question {
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;

    public Question(String question, String a, String b, String c, String d, String answer) {
        this.question = question;
        this.choiceA = a;
        this.choiceB = b;
        this.choiceC = c;
        this.choiceD = d;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return question;
    }
}
