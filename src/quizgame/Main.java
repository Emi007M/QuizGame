package quizgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import quizgame.presentation.RootLayoutController;

/**
 *
 * @author Dagna and Emilia
 */
public class Main extends Application {

    public Stage primaryStage;
    public BorderPane rootLayout;
    public RootLayoutController mainController;

    public static void main(String[] args) throws IOException {
        //needed for buiding .exe file
        Application.launch(Main.class, (java.lang.String[]) null);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Quiz Game");

        this.primaryStage.getIcons().add(new Image("file:W:/Netbeans Projects/AdminApp/src/adminapp/presentation/resources/images/ico128.png"));

        initRootLayout();
    }

    public void initRootLayout() {

        try {

            Font.loadFont(Main.class.getResource("presentation/resources/fonts/fontawesome-webfont.ttf").toExternalForm(), 10);

            // Load root layout from fxml file.            
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("presentation/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            mainController = loader.getController();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            mainController.setPrimaryStage(primaryStage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
