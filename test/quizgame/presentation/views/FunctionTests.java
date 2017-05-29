/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.presentation.views;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeoutException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.loadui.testfx.Assertions.verifyThat;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;
import org.loadui.testfx.utils.FXTestUtils;
import org.testfx.api.FxToolkit;
import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.api.FxToolkit.setupStage;
import org.testfx.framework.junit.ApplicationTest;
import quizgame.Main;
import static quizgame.presentation.LayoutBaseController.formatter;

/**
 *
 * @author Emilia
 */
public class FunctionTests extends ApplicationTest {
    Main m;

    @Override
    public void start(Stage stage) throws Exception {
        m = new Main();
        m.start(stage);
        Parent sceneRoot = new Main().rootLayout;

    }

    public FunctionTests() {
    }


    @Test
    public void should_give_difficulty_choice_on_new_game() {
        // when:
        clickOn("#BtnNewGame");
        // then:
        assertTrue(GuiTest.exists("#BtnEasy"));
        assertTrue(GuiTest.exists("#BtnMedium"));
        assertTrue(GuiTest.exists("#BtnHard"));
        
    }
    
    @Test
    public void should_give_categories_choice_before_showing_question() {
        // when:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        
        JFXButton btn = GuiTest.find("#Cat1");
        String expResult = btn.getText();
        System.out.println(expResult);
        clickOn("#Cat1");
        
        String result = m.mainController.game.getCurrentCategory();
        // then:
        assertEquals(expResult, result);

    }
    
    @Test
    public void should_display_progress_bar() {
        // when:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");
        
        // then:
        assertTrue(GuiTest.exists("#labelQuestionNo"));

    }
    
     @Test
    public void should_be_able_to_place_bets() {
        // when:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");

        clickOn("#Cat1");
        clickOn("#a1up");
        Label lbl = GuiTest.find("#a1_bet");
        String result = lbl.getText();
        String expResult = "Bet: " + formatter.format(m.mainController.game.getStep()) + "$";
        // then:
         assertEquals(expResult, result);
  
    }
    
    @Test
    public void should_be_able_to_preview_question() {
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");
        
        Text txt = GuiTest.find("#question_txt");
        String result = txt.getText();
        assertNotNull(result);
        

    }
    
     @Test
    public void should_be_able_to_preview_answers() {
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");
        
        Label lbl = GuiTest.find("#a1_txt");
        String result = lbl.getText();
        assertNotNull(result);     
        
        lbl = GuiTest.find("#a2_txt");
        result = lbl.getText();
        assertNotNull(result); 
        
        lbl = GuiTest.find("#a3_txt");
        result = lbl.getText();
        assertNotNull(result); 
        
        lbl = GuiTest.find("#a4_txt");
        result = lbl.getText();
        assertNotNull(result); 

    }

    
    @Test
    public void should_allow_stopping_timer() throws InterruptedException {
        // given:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");

        // when:
        int total = m.mainController.game.getBudget();
        int step = m.mainController.game.getStep();
        
        for(int i=total/step; i>=0; i--)
            clickOn("#a1up");
        clickOn("#nextBtn");
        
        Label l = GuiTest.find("#labelTime");
        String expResult = l.getText();
        
        sleep(2000);
        String result = l.getText();

        // then:
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_display_game_over_while_fail() throws InterruptedException {
        // given:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");

        // when:
        int total = m.mainController.game.getBudget();
        int step = m.mainController.game.getStep();
        
        Label ans1 = GuiTest.find("#a1_txt");
        if (!m.mainController.game.getCurrentQuestion().getRightAnswer().equals(ans1.getText())) {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a1up");
            }
        } else {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a2up");
            }
        }

        clickOn("#nextBtn");
        clickOn("#nextBtn");


        // then:
        assertTrue(GuiTest.exists("#defeatL"));
    }
    
     @Test
    public void should_display_victory_while_won() throws InterruptedException {
        // given:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
         int step = m.mainController.game.getStep();
        int qsum = m.mainController.game.getTotalQuestions();
        for(int j=0;j<qsum;j++){
        clickOn("#Cat1");

        // when:
        int total = m.mainController.game.getBudget();
       
        
        Label ans1 = GuiTest.find("#a1_txt");
        Label ans2 = GuiTest.find("#a2_txt");
        Label ans3 = GuiTest.find("#a3_txt");
        
        if (m.mainController.game.getCurrentQuestion().getRightAnswer().equals(ans1.getText())) {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a1up");
            }
        } else if (m.mainController.game.getCurrentQuestion().getRightAnswer().equals(ans2.getText())) {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a2up");
            }
        }else if (m.mainController.game.getCurrentQuestion().getRightAnswer().equals(ans3.getText())) {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a3up");
            }
        }else {
            for (int i = total / step; i >= 0; i--) {
                clickOn("#a4up");
            }
        }

        clickOn("#nextBtn");
        clickOn("#nextBtn");
        }

        // then:
        assertTrue(GuiTest.exists("#victoryL"));
    }

    @Test
    public void should_ask_before_quitting() {
        // when:
        clickOn("#BtnQuit");
        push(ENTER);
        

        // then:
        assertTrue(GuiTest.getWindows().isEmpty());

    }
    
    @Test
    public void should_highlight_correct_answer_after_bet() throws InterruptedException {
        // given:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");

        // when:
        int total = m.mainController.game.getBudget();
        int step = m.mainController.game.getStep();
        
        for (int i = total / step; i >= 0; i--) {
            clickOn("#a1up");
        }
        clickOn("#nextBtn");
        
        Label ans1 = GuiTest.find("#a1_txt");
        Label ans2 = GuiTest.find("#a2_txt");
        Label ans3 = GuiTest.find("#a3_txt");
        Label ans4 = GuiTest.find("#a4_txt");
        String correctAns = m.mainController.game.getCurrentQuestion().getRightAnswer();
        
        Label ans = null;
        if(correctAns.equals(ans1.getText()))      ans = ans1;
        else if(correctAns.equals(ans2.getText())) ans = ans2;
        else if(correctAns.equals(ans3.getText())) ans = ans3;
        else if(correctAns.equals(ans4.getText())) ans = ans4;

        // then:
        assertTrue(ans.getStyleClass().contains("correct"));
    }
}