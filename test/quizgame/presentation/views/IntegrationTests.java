/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.presentation.views;

import java.util.List;
import java.util.Set;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;
import quizgame.Main;
import quizgame.model.Game;
import quizgame.model.Question;
import quizgame.model.QuestionService;

/**
 *
 * @author Emilia
 */
public class IntegrationTests extends ApplicationTest {
    Main m;

    @Override
    public void start(Stage stage) throws Exception {
        m = new Main();
        m.start(stage);
        Parent sceneRoot = new Main().rootLayout;

    }

    public IntegrationTests() {
    }

    
    
    /**
     * Test of generateQuestion method, of class Game.
     */
    @Test
    public void testGenerateQuestion() {
        System.out.println("generateQuestion");
        Game instance = new Game();
        String expResult = "Sport";
        instance.setCurrentCategory("Sport");
        Question result = instance.generateQuestion();
        assertEquals(expResult, result.getCategory());
    }
    
    /**
     * Test of populateDB method, of class QuestionService.
     */
    @Test
    public void testPopulateDB() {
        System.out.println("populateDB");
        QuestionService instance = new QuestionService();
        instance.populateDB();
        Set<String> resultCat = instance.getAllCategories();
        List<Question> resultQue = instance.getAllQuestions();
        assertNotNull(resultCat);
        assertNotNull(resultQue);
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
    public void should_give_categories_choice_after_correctly_answering_question() {
        // when:
        clickOn("#BtnNewGame");
        clickOn("#BtnMedium");
        clickOn("#Cat1");
        
        int step = m.mainController.game.getStep();
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
        
        assertTrue(GuiTest.exists("#Cat1"));
        assertTrue(GuiTest.exists("#Cat2"));

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