package quizgame.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import quizgame.model.Game;
import quizgame.presentation.views.GameBarController;
import quizgame.presentation.views.MenuController;
import quizgame.presentation.views.NewGameController;

/**
 *
 * @author Emilia
 */
public class RootLayoutController implements Initializable {

    private Stage primaryStage;

    @FXML
    private BorderPane mainPane;

    NewGameController ngController;

    boolean initialized = false;

    public Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setMenu();
        initialized = true;
    }

    public void init() {
        System.out.println("quizgame.presentation.RootLayoutController.init()");

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("views/Menu.fxml"));
            mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            MenuController controller = (MenuController) loader.getController();
            controller.setRootController(this);

            controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.setMenu()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNewGame() {

        game = new Game();

        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("views/ChoosingLevel.fxml"));
            mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            ngController = (NewGameController) loader.getController();
            ngController.setRootController(this);

            ngController.init();
            System.out.println("quizgame.presentation.RootLayoutController.setNewGame()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setChooseCategory() {
        //append top bar
        if (ngController.gbController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("views/GameBar.fxml"));
                mainPane.getChildren().clear();
                mainPane.setTop((HBox) loader.load());

                GameBarController controller = (GameBarController) loader.getController();
                controller.setParentController(ngController);
                controller.init();
                ngController.setGameBarController(controller);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //set new view
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(ngController);

            loader.setLocation(getClass().getResource("views/ChoosingCategory.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            //  MenuController controller = (MenuController) loader.getController();
            //   controller.setRootController(this);
            //   controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.ChoosingCategory()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ngController.initCategories();
        ngController.gbController.updateBar();
    }

    public void setShowQuestion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(ngController);

            loader.setLocation(getClass().getResource("views/Question.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            //  MenuController controller = (MenuController) loader.getController();
            //   controller.setRootController(this);
            //   controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.setShowQuestion()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ngController.initQuestion();
    }

    public void setDefat() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(ngController);

            loader.setLocation(getClass().getResource("views/Defeat.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            //  MenuController controller = (MenuController) loader.getController();
            //   controller.setRootController(this);
            //   controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.setDefat()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ngController.initDefeat();
    }

    public void setVictory() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(ngController);

            loader.setLocation(getClass().getResource("views/Victory.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());

            //  MenuController controller = (MenuController) loader.getController();
            //   controller.setRootController(this);
            //   controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.setDefat()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ngController.initVictory();
    }

}
