package quizgame.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
//    private ManageTournamentsTabController manageTournamentsController;
//    @FXML
//    private Tab tabCurrentTournament;
//    private CurrentTournamentTabController currentTournamentController;
//    @FXML
//    private Tab tabSettings;
//    private SettingsTabController settingsController;

    NewGameController ngController;

    boolean initialized = false;

    public Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            FXMLLoader loader0 = new FXMLLoader(getClass().getResource("views/menu.fxml"));
//            loader0.setResources(resources);
//            tabs.getTabs().get(0).setContent(loader0.load());
//            manageTournamentsController = loader0.getController();
//
//            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("currentTournamentTab/CurrentTournamentTab.fxml"));
//            loader1.setResources(resources);
//            tabs.getTabs().get(1).setContent(loader1.load());
//            currentTournamentController = loader1.getController();
//            currentTournamentController.setRootController(this);
//
//            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("settingsTab/SettingsTab.fxml"));
//            loader2.setResources(resources);
//            tabs.getTabs().get(2).setContent(loader2.load());
//            settingsController = loader2.getController();
//
//        } catch (IOException ex) {
//            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        setMenu();
//        tabs.getTabs().get(1).setDisable(true);
//        tabs.getTabs().get(2).setDisable(true);
//        tabs.getTabs().get(3).setDisable(true);
        initialized = true;
    }

    public void init() {
        System.out.println("quizgame.presentation.RootLayoutController.init()");
        // currentTournamentController.init();
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
            //loader.setResources(Dictionary.getBundle());
            loader.setLocation(getClass().getResource("views/Menu.fxml"));
            mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());
            //mainFlow.getChildren().setAll((FlowPane) loader.load());

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
            //loader.setResources(Dictionary.getBundle());
            loader.setLocation(getClass().getResource("views/ChoosingLevel.fxml"));
            mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());
            //mainFlow.getChildren().setAll((FlowPane) loader.load());

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
                //loader.setResources(Dictionary.getBundle());
                loader.setLocation(getClass().getResource("views/GameBar.fxml"));
                mainPane.getChildren().clear();
                mainPane.setTop((HBox) loader.load());
                //mainFlow.getChildren().setAll((FlowPane) loader.load());

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
            //loader.setResources(Dictionary.getBundle());
            loader.setLocation(getClass().getResource("views/ChoosingCategory.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());
            //mainFlow.getChildren().setAll((FlowPane) loader.load());

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
            //loader.setResources(Dictionary.getBundle());
            loader.setLocation(getClass().getResource("views/Question.fxml"));
            // mainPane.getChildren().clear();
            mainPane.setCenter((VBox) loader.load());
            //mainFlow.getChildren().setAll((FlowPane) loader.load());

            //  MenuController controller = (MenuController) loader.getController();
            //   controller.setRootController(this);
            //   controller.init();
            System.out.println("quizgame.presentation.RootLayoutController.setShowQuestion()");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ngController.initQuestion();
    }

}
