package quizgame.model;

/**
 *
 * @author Dagna
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class QuestionService {

    private List<Question> questions = new ArrayList<>();
    private Set<String> categories = new HashSet<>();

    public List<Question> getAllQuestions() {
        return questions;
    }

    public Set<String> getAllCategories() {
        return categories;
    }

    public Question getRandomQuestionByCategory(String category) {

        Collections.shuffle(questions);
        System.out.println(questions.toString());
        for (Question q : questions) {
            if (q.getCategory().equals(category) && q.isUsed() == false) {
                q.setUsed(true);
                updateCategories(category);
                return q;
            }
        }
        return null;
    }

    private void updateCategories(String category) {
        for (Question q : questions) {
            if (q.getCategory() == category && q.isUsed() == false) {
                return;
            }
        }
        categories.remove(category);
    }

    public void populateDB() {
        try {
            File file = new File("src/quizgame/model/pytania_quiz_game.txt");
            Scanner input = new Scanner(new FileInputStream(file), "UTF-8");
            while (input.hasNextLine()) {

                String line = input.nextLine();
                String[] data = line.split("\\|");
                Question newQuestion = new Question(data[0], data[1], data[2], data[3], data[4], data[5]);
                questions.add(newQuestion);
                categories.add(data[0]);
                //System.out.println(newQuestion.toString());
            }
            input.close();
            System.out.println(questions.size());
            System.out.println(categories.size());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
