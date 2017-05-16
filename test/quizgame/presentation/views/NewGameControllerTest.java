/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.presentation.views;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quizgame.model.Game;

/**
 *
 * @author dagna
 */
public class NewGameControllerTest {
    
    public NewGameControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class NewGameController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL location = null;
        ResourceBundle resources = null;
        NewGameController instance = new NewGameController();
        instance.initialize(location, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class NewGameController.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        NewGameController instance = new NewGameController();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameBarController method, of class NewGameController.
     */
    @Test
    public void testSetGameBarController() {
        System.out.println("setGameBarController");
        GameBarController c = null;
        NewGameController instance = new NewGameController();
        instance.setGameBarController(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initCategories method, of class NewGameController.
     */
    @Test
    public void testInitCategories() {
        System.out.println("initCategories");
        NewGameController instance = new NewGameController();
        instance.initCategories();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initQuestion method, of class NewGameController.
     */
    @Test
    public void testInitQuestion() {
        System.out.println("initQuestion");
        NewGameController instance = new NewGameController();
        instance.initQuestion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detachBetButtonsActions method, of class NewGameController.
     */
    @Test
    public void testDetachBetButtonsActions() {
        System.out.println("detachBetButtonsActions");
        NewGameController instance = new NewGameController();
        instance.detachBetButtonsActions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showNextBtn method, of class NewGameController.
     */
//    @Test
//    public void testShowNextBtn() {
//        System.out.println("showNextBtn");
//        NewGameController instance = new NewGameController();
//        Game ginstance = new Game();
//        ginstance.setBudget(1000000);
//        ginstance.changeBet(0, 500000);
//        instance.initQuestion();
//        boolean result = instance.getNextBtn().isVisible();
//        System.out.println("quizgame.presentation.views.NewGameControllerTest.testShowNextBtn() " + result + "XDDDDDDDDDDd" );
//        assertEquals(false, result);
//        ginstance.changeBet(1, 500000);
//        int moneyLeftToBet = ginstance.getBudget() - ginstance.sumBets();
//        assertEquals(moneyLeftToBet, 0);
//        result = instance.getNextBtn().isVisible();
//        System.out.println("quizgame.presentation.views.NewGameControllerTest.testShowNextBtn() " + result + "XDDDDDDDDDDd" );
//        assertEquals(true, result);
//        
//        
//        //instance.showNextBtn();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of hideNextBtn method, of class NewGameController.
     */
    @Test
    public void testHideNextBtn() {
        System.out.println("hideNextBtn");
        NewGameController instance = new NewGameController();
        instance.hideNextBtn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showCorrect method, of class NewGameController.
     */
    @Test
    public void testShowCorrect() {
        System.out.println("showCorrect");
        NewGameController instance = new NewGameController();
        instance.showCorrect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initDefeat method, of class NewGameController.
     */
    @Test
    public void testInitDefeat() {
        System.out.println("initDefeat");
        NewGameController instance = new NewGameController();
        instance.initDefeat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initVictory method, of class NewGameController.
     */
    @Test
    public void testInitVictory() {
        System.out.println("initVictory");
        NewGameController instance = new NewGameController();
        instance.initVictory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleStopTimerBtn method, of class NewGameController.
     */
    @Test
    public void testHandleStopTimerBtn() {
        System.out.println("handleStopTimerBtn");
        NewGameController instance = new NewGameController();
        instance.handleStopTimerBtn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
