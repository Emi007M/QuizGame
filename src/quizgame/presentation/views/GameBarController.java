package quizgame.presentation.views;

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
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import quizgame.presentation.LayoutBaseController;

/**
 *
 * @author Emilia
 */
public class GameBarController extends ViewBaseController {

    @FXML
    private VBox VBox;

    @FXML
    private Label labelTime, labelMoney, labelQuestionNo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
    
    private Timeline timeline;

    @Override
    public void init() {

    }

    /*--game bar--*/
    private void updateLabelTime(int t) {
        labelTime.setText("Time: " + t + "s");
    }

    private void updateLabelMoney(int t) {
        labelMoney.setText("Money: " + LayoutBaseController.formatter.format(t) + "$");
    }

    private void updateLabelQuestionNo(int t) {
        labelQuestionNo.setText("Question: " + t + "/" + parentController.getRootLayoutController().game.getTotalQuestions());
    }

    public void updateBar() {
        System.out.println("quizgame.presentation.views.GameBarController.updateBar()");
        int time = parentController.getRootLayoutController().game.getTimer();
        int money = parentController.getRootLayoutController().game.getBudget();
        int question = parentController.getRootLayoutController().game.getTotalQuestions() - parentController.getRootLayoutController().game.getRemainingQuestions();
        System.out.println(time + " " + money + " " + question);
        updateLabelTime(time);
        updateLabelMoney(money);
        updateLabelQuestionNo(question);
    }

    public void updateMoney() {
        int money = parentController.getRootLayoutController().game.getBudget();
        updateLabelMoney(money);
    }

    public void startTimer() {
        parentController.getRootLayoutController().game.resetCurrentTimer();
        int repeats = parentController.getRootLayoutController().game.getTimer();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            int time = parentController.getRootLayoutController().game.getRunningTimer();
            updateLabelTime(time);
        }));
        timeline.setCycleCount(repeats);
        timeline.setOnFinished(e -> {
            NewGameController c = (NewGameController) parentController;
            c.detachBetButtonsActions();
            c.showCorrect();
            c.showNextBtn();
        });
        timeline.play();
        //final int time = parentController.getRootLayoutController().game.getCurrentTime();
//         new Timer().schedule(
//    new TimerTask() {
//
//        @Override
//        public void run() {
//            int time = parentController.getRootLayoutController().game.getRunningTimer();
//            updateLabelTime(time);
//            if(time==0) this.cancel();
//        }
//    }, 0, 1000);

    }
    
    public void stopTimer(){
        if (timeline!=null){
            timeline.stop();
            
            NewGameController c = (NewGameController) parentController;
            c.detachBetButtonsActions();
            c.showCorrect();
            c.showNextBtn();    
        }
    }

}
