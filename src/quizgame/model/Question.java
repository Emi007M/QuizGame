package quizgame.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Dagna
 */
public class Question {

    private String category;
    private String question;
    private String rightAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private boolean used;

    public Question(String category, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2,
            String wrongAnswer3) {
        this.category = category;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.used = false;
    }
    
    public ArrayList<String> getAnswers() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(rightAnswer);
        answers.add(wrongAnswer1);
        answers.add(wrongAnswer2);
        answers.add(wrongAnswer3);
        Collections.shuffle(answers);
        return answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Question [category=" + category + ", question=" + question + ", rightAnswer=" + rightAnswer
                + ", wrongAnswer1=" + wrongAnswer1 + ", wrongAnswer2=" + wrongAnswer2 + ", wrongAnswer3=" + wrongAnswer3
                + "]";
    }

}
