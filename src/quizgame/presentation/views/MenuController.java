package quizgame.presentation.views;

import com.jfoenix.controls.JFXButton;
import quizgame.presentation.LayoutBaseController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Emilia
 */
public class MenuController extends LayoutBaseController {

    @FXML
    private JFXButton BtnNewGame, BtnQuit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        init();

    }

    public void init() {

        BtnNewGame.setOnAction(e -> handleNewGameBtn());
        BtnQuit.setOnAction(e -> handleQuitBtn());

    }

    @FXML
    private void handleNewGameBtn() {
        System.out.println("new game btn clicked...");
        //tabController.setResults();
        getRootLayoutController().setNewGame();
    }

    @FXML
    private void handleQuitBtn() {
        System.out.println("quit game btn clicked...");

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quit Quiz Game");
        alert.setHeaderText("Quit");
        alert.setContentText("Do you really want to quit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            getRootLayoutController().getPrimaryStage().close();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

}
