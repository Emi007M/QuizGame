package quizgame.presentation.views;


import com.jfoenix.controls.JFXButton;
import quizgame.presentation.LayoutBaseController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

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
        //tabController.setResults();
        //getRootLayoutController().setMenu();
    }


    /*--Button views initialization--*/
//    private void setPrimaryBtnSet() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("PrimaryBtnSet.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            PrimaryBtnSetController controller = (PrimaryBtnSetController) loader.getController();
//            controller.setTabController(this);
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private void setNullBtnSet() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("NullBtnSet.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            NullBtnSetController controller = (NullBtnSetController) loader.getController();
//            controller.setTabController(this);
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    /*--Executive views initialization--*/
//    protected void setContestants() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("views/Contestants.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            ContestantsController controller = (ContestantsController) loader.getController();
//            controller.setTabController(this);
//
//            controller.init();
//
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    protected void setStartingLists() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("views/StartingLists.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            StartingListsController controller = (StartingListsController) loader.getController();
//            controller.setTabController(this);
//
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    protected void setManageBoards() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("views/ManageBoards.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            ManageBoardsController controller = (ManageBoardsController) loader.getController();
//            controller.setTabController(this);
//
//            controller.init();
//
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    protected void setResults() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("views/Results.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            ResultsController controller = (ResultsController) loader.getController();
//            controller.setTabController(this);
//
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    protected void setChooseTournament() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setResources(Dictionary.getBundle());
//            loader.setLocation(getClass().getResource("views/ChooseTournament.fxml"));
//            mainFlow.getChildren().clear();
//            mainFlow.getChildren().setAll((FlowPane) loader.load());
//
//            ChooseTournamentController controller = (ChooseTournamentController) loader.getController();
//            controller.setTabController(this);
//            controller.updateList();
//
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
