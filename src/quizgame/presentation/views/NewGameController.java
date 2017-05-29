package quizgame.presentation.views;

import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import quizgame.model.Question;
import quizgame.presentation.LayoutBaseController;

/**
 *
 * @author Emilia
 */
public class NewGameController extends LayoutBaseController {

    @FXML
    private VBox VBox;

    @FXML
    private Button BtnEasy, BtnMedium, BtnHard;

    @FXML
    private Button Cat1, Cat2;
    @FXML
    private HBox categories;

    @FXML
    private Label question_cat, question_que, question_ans;
    @FXML
    private Text question_txt;
    @FXML
    private Label a1_txt, a2_txt, a3_txt, a4_txt;
    @FXML
    private Label a1_bet, a2_bet, a3_bet, a4_bet;
    @FXML
    private JFXButton a1up, a1down, a2up, a2down, a3up, a3down, a4up, a4down;

    public GameBarController gbController;

    @FXML
    private HBox navbar;
    @FXML
    private JFXButton nextBtn;
    @FXML
    private Label lostLabel;

    @FXML
    private JFXButton toMenuBtn;
    @FXML
    private Label victoryList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @Override
    public void init() {

        formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        try {
            System.out.println("quizgame.presentation.views.NewGameController.init() -  try level buttons");
            BtnEasy.setOnAction(e -> handleEasyBtn());
            BtnMedium.setOnAction(e -> handleMediumBtn());
            BtnHard.setOnAction(e -> handleHardBtn());
        } catch (NullPointerException e) {

        }
        
       

    }

    public JFXButton getNextBtn() {
        return nextBtn;
    }


    /*--Difficulty level button views initialization--*/
    private void handleEasyBtn() {
        getRootLayoutController().game.setTimer(60);
        getRootLayoutController().setChooseCategory();
    }

    private void handleMediumBtn() {
        getRootLayoutController().game.setTimer(40);
        getRootLayoutController().setChooseCategory();
    }

    private void handleHardBtn() {
        getRootLayoutController().game.setTimer(20);
        getRootLayoutController().setChooseCategory();
    }

    /*--game bar--*/
    public void setGameBarController(GameBarController c) {
        gbController = c;
    }

    /*--categories--*/
    private void prepareCategories() {
        List<String> categories = new ArrayList<String>(getRootLayoutController().game.getQuestionService().getAllCategories());
        Collections.shuffle(categories);
        Cat1.setText(categories.get(0));
        if (categories.size() > 1) {
            Cat2.setText(categories.get(1));
        } else {
            this.categories.getChildren().remove(Cat2);
        }

    }

    private void handleCat1Btn() {
        getRootLayoutController().game.setCurrentCategory(Cat1.getText());
        getRootLayoutController().setShowQuestion();
    }

    private void handleCat2Btn() {
        getRootLayoutController().game.setCurrentCategory(Cat2.getText());
        getRootLayoutController().setShowQuestion();
    }

    public void initCategories() {
        try {
            System.out.println("quizgame.presentation.views.NewGameController.initCategories()");

            prepareCategories();
            Cat1.setOnAction(e -> handleCat1Btn());
            Cat2.setOnAction(e -> handleCat2Btn());

            getRootLayoutController().game.nextQuestion();

        } catch (NullPointerException e) {

        }
    }

    /*--question--*/
    public void initQuestion() {
        Question q = getRootLayoutController().game.generateQuestion();
        ArrayList<String> answers = q.getAnswers();

        question_cat.setText("Category: " + q.getCategory());
        question_txt.setText(q.getQuestion());

        question_txt.setWrappingWidth(800);
        question_txt.setTextAlignment(TextAlignment.CENTER);

        a1_txt.setText(answers.get(0));
        a2_txt.setText(answers.get(1));
        a3_txt.setText(answers.get(2));
        a4_txt.setText(answers.get(3));

        a1_bet.setText("Bet: " + formatter.format(0) + "$");
        a2_bet.setText("Bet: " + formatter.format(0) + "$");
        a3_bet.setText("Bet: " + formatter.format(0) + "$");
        a4_bet.setText("Bet: " + formatter.format(0) + "$");
        gbController.startTimer();

        attachBetButtonsActions();

        nextBtn.setOnAction(e -> handleNextBtn());
        hideNextBtn();

        updateBetAnswersLabel();
    }

    private void attachBetButtonsActions() {
        a1up.setOnAction(e -> handleA1AddBtn());
        a1down.setOnAction(e -> handleA1DownBtn());
        a2up.setOnAction(e -> handleA2AddBtn());
        a2down.setOnAction(e -> handleA2DownBtn());
        a3up.setOnAction(e -> handleA3AddBtn());
        a3down.setOnAction(e -> handleA3DownBtn());
        a4up.setOnAction(e -> handleA4AddBtn());
        a4down.setOnAction(e -> handleA4DownBtn());

    }

    private void updateBetAnswersLabel() {
        int moneyLeftToBet = getRootLayoutController().game.getBudget() - getRootLayoutController().game.sumBets();
        if (moneyLeftToBet > 0) {
            question_ans.setText("Bet Answers (still left " + formatter.format(moneyLeftToBet) + "$):");
            hideNextBtn();
        } else {
            question_ans.setText("Bet Answers:");
            showNextBtn();
        }
    }

    private void handleA1AddBtn() {
        int bet = getRootLayoutController().game.changeBet(0, getRootLayoutController().game.getStep());
        a1_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA1DownBtn() {
        int bet = getRootLayoutController().game.changeBet(0, getRootLayoutController().game.getStep()*(-1));
        a1_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA2AddBtn() {
        int bet = getRootLayoutController().game.changeBet(1, getRootLayoutController().game.getStep());
        a2_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA2DownBtn() {
        int bet = getRootLayoutController().game.changeBet(1, getRootLayoutController().game.getStep()*(-1));
        a2_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA3AddBtn() {
        int bet = getRootLayoutController().game.changeBet(2, getRootLayoutController().game.getStep());
        a3_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA3DownBtn() {
        int bet = getRootLayoutController().game.changeBet(2, getRootLayoutController().game.getStep()*(-1));
        a3_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA4AddBtn() {
        int bet = getRootLayoutController().game.changeBet(3, getRootLayoutController().game.getStep());
        a4_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    private void handleA4DownBtn() {
        int bet = getRootLayoutController().game.changeBet(3, getRootLayoutController().game.getStep()*(-1));
        a4_bet.setText("Bet: " + formatter.format(bet) + "$");
        updateBetAnswersLabel();
    }

    public void detachBetButtonsActions() {
        a1up.setOnAction(null);
        a1down.setOnAction(null);
        a2up.setOnAction(null);
        a2down.setOnAction(null);
        a3up.setOnAction(null);
        a3down.setOnAction(null);
        a4up.setOnAction(null);
        a4down.setOnAction(null);

    }

    public void showNextBtn() {
        navbar.setVisible(true);
        navbar.setManaged(true);
        System.out.println("quizgame.presentation.views.NewGameController.showNextBtn()");

    }

    public void hideNextBtn() {
        navbar.setVisible(false);
        navbar.setManaged(false);
        System.out.println("quizgame.presentation.views.NewGameController.hideNextBtn()");

    }

    private void handleNextBtn() {
        //stop timer
        if (getRootLayoutController().game.getCurrentTime() > 0) {
            handleStopTimerBtn();
            return;
        }

        if (getRootLayoutController().game.getBudget() == 0) {
            //show end loose view
            rootController.setDefat();
        } else {
            if (getRootLayoutController().game.getRemainingQuestions() == 0) {
                //show end victory view
                rootController.setVictory();
            } else {
                //show next question - cartegory choice
                rootController.setChooseCategory();
            }
        }
    }

    void showCorrect() {
        String right = getRootLayoutController().game.getCurrentQuestion().getRightAnswer();

        int ans = 0;

        a1_txt.getStyleClass().add("answered");
        a2_txt.getStyleClass().add("answered");
        a3_txt.getStyleClass().add("answered");
        a4_txt.getStyleClass().add("answered");

        if (a1_txt.getText().equals(right)) {
            a1_txt.getStyleClass().add("correct");
            ans = 0;
        } else if (a2_txt.getText().equals(right)) {
            a2_txt.getStyleClass().add("correct");
            ans = 1;
        } else if (a3_txt.getText().equals(right)) {
            a3_txt.getStyleClass().add("correct");
            ans = 2;
        } else if (a4_txt.getText().equals(right)) {
            a4_txt.getStyleClass().add("correct");
            ans = 3;
        }
        System.out.println("quizgame.presentation.views.NewGameController.showCorrect() - " + (ans + 1));

        int newMoney = getRootLayoutController().game.changeBet(ans, 0);
        int moneyLost = getRootLayoutController().game.getBudget() - newMoney;
        //update new budget
        getRootLayoutController().game.setBudget(newMoney);
        gbController.updateMoney();

        //update youu lost label
        lostLabel.setText("You have " + formatter.format(getRootLayoutController().game.getBudget()) + "$ left");
    }

    public void initDefeat() {
        toMenuBtn.setOnAction(e -> rootController.setMenu());
    }

    public void initVictory() {

        toMenuBtn.setOnAction(e -> rootController.setMenu());

        victoryList.setText("You won " + formatter.format(getRootLayoutController().game.getBudget()) + "$");

    }

    public void handleStopTimerBtn() {
        gbController.stopTimer();
        getRootLayoutController().game.setCurrentTime(0);
    }

}
