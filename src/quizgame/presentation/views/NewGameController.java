package quizgame.presentation.views;

import com.jfoenix.controls.JFXButton;
import quizgame.presentation.ViewBaseController;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
//     @FXML
//    private Label labelTime, labelMoney, labelQuestionNo;
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

//    public void updateList() {
//        //get tournaments from folder
//        ArrayList<Serializable> objs;
//        objs = Serializator.readAllFromFolder("tournaments");
//
//        //print tournaments
//        for (Serializable s : objs) {
//            Tournament t = (Tournament) s;
//
//            Button btn = new Button("(" + t.getDate() + ") " + t.getTitle());
//            btn.getStyleClass().add("tournamentBtn");
//            if (CurrentTournament.getTournament() != null
//                    && t.getDate().equals(CurrentTournament.getTournament().getDate())
//                    && t.getTitle().equals(CurrentTournament.getTournament().getTitle())) {
//                btn.getStyleClass().add("current");
//            }
//            btn.setOnAction(e -> setTournament(t));
//
//            VBox.getChildren().add(btn);
//
//        }
//    }
//    private void setTournament(Tournament t) {
//        CurrentTournament.setTournament(t);
//        tabController.init();
//    }

    /*--Button views initialization--*/
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

    public void initQuestion() {
        Question q = getRootLayoutController().game.generateQuestion();
        ArrayList<String> answers = q.getAnswers();

        question_cat.setText("Category: " + q.getCategory());
        question_txt.setText(q.getQuestion());

        a1_txt.setText(answers.get(0));
        a2_txt.setText(answers.get(1));
        a3_txt.setText(answers.get(2));
        a4_txt.setText(answers.get(3));

        gbController.startTimer();

        attachBetButtonsActions();
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

    private void handleA1AddBtn() {
        int bet = getRootLayoutController().game.changeBet(0, 10000);
        a1_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA1DownBtn() {
        int bet = getRootLayoutController().game.changeBet(0, -10000);
        a1_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA2AddBtn() {
        int bet = getRootLayoutController().game.changeBet(1, 10000);
        a2_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA2DownBtn() {
        int bet = getRootLayoutController().game.changeBet(1, -10000);
        a2_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA3AddBtn() {
        int bet = getRootLayoutController().game.changeBet(2, 10000);
        a3_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA3DownBtn() {
        int bet = getRootLayoutController().game.changeBet(2, -10000);
        a3_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA4AddBtn() {
        int bet = getRootLayoutController().game.changeBet(3, 10000);
        a4_bet.setText("Bet: " + formatter.format(bet) + "$");
    }

    private void handleA4DownBtn() {
        int bet = getRootLayoutController().game.changeBet(3, -10000);
        a4_bet.setText("Bet: " + formatter.format(bet) + "$");
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

}
