/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dagna
 */
public class GameTest {
    
    public GameTest() {
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resetCurrentTimer method, of class Game.
     */
    @Test
    public void testResetCurrentTimer() {
        System.out.println("resetCurrentTimer");
        Game instance = new Game();
        instance.setTimer(20);
        instance.setCurrentTime(15);
        instance.resetCurrentTimer();
        int expResult = instance.getTimer();
        int result = instance.getCurrentTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRunningTimer method, of class Game.
     */
    @Test
    public void testGetRunningTimer() {
        System.out.println("getRunningTimer");
        Game instance = new Game();
        //int expResult = 0;
        instance.setTimer(20);
        int expResult = instance.getCurrentTime()-1;
        int result = instance.getRunningTimer();
       // System.out.println("quizgame.model.GameTest.testGetRunningTimer() " + expResult + " " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStep method, of class Game.
     */
//    @Test
//    public void testGetStep() {
//        System.out.println("getStep");
//        Game instance = new Game();
//        int expResult = 0;
//        int result = instance.getStep();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of changeBet method, of class Game.
     */
    @Test
    public void testChangeBet() {
        System.out.println("changeBet");
        int number1 = 0;
        int number2 = 1;
        int amount1 = 50000;
        int amount2 = 100000;
        Game instance = new Game();
        int expResult = amount1+amount2;
        instance.changeBet(number1, amount1);
        instance.changeBet(number2, amount2);
        int result = instance.sumBets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of sumBets method, of class Game.
     */
    @Test
    public void testSumBets() {
        System.out.println("sumBets");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.sumBets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimer method, of class Game.
     */
    @Test
    public void testGetTimer() {
        System.out.println("getTimer");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getTimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimer method, of class Game.
     */
    @Test
    public void testSetTimer() {
        System.out.println("setTimer");
        int timer = 0;
        Game instance = new Game();
        instance.setTimer(timer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalQuestions method, of class Game.
     */
    @Test
    public void testGetTotalQuestions() {
        System.out.println("getTotalQuestions");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getTotalQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemainingQuestions method, of class Game.
     */
    @Test
    public void testGetRemainingQuestions() {
        System.out.println("getRemainingQuestions");
        Game instance = new Game();
        
        int expResult = instance.getRemainingQuestions()-1;
        instance.nextQuestion();
        int result = instance.getRemainingQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionService method, of class Game.
     */
    @Test
    public void testGetQuestionService() {
        System.out.println("getQuestionService");
        Game instance = new Game();
        QuestionService expResult = null;
        QuestionService result = instance.getQuestionService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextQuestion method, of class Game.
     */
    @Test
    public void testNextQuestion() {
        System.out.println("nextQuestion");
        Game instance = new Game();
        instance.nextQuestion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudget method, of class Game.
     */
    @Test
    public void testGetBudget() {
        System.out.println("getBudget");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getBudget();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBudget method, of class Game.
     */
    @Test
    public void testSetBudget() {
        System.out.println("setBudget");
        int budget = 0;
        Game instance = new Game();
        instance.setBudget(budget);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentCategory method, of class Game.
     */
    @Test
    public void testGetCurrentCategory() {
        System.out.println("getCurrentCategory");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getCurrentCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentCategory method, of class Game.
     */
    @Test
    public void testSetCurrentCategory() {
        System.out.println("setCurrentCategory");
        String currentCategory = "";
        Game instance = new Game();
        instance.setCurrentCategory(currentCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestion method, of class Game.
     */
    @Test
    public void testGetCurrentQuestion() {
        System.out.println("getCurrentQuestion");
        Game instance = new Game();
        Question expResult = null;
        Question result = instance.getCurrentQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentQuestion method, of class Game.
     */
    @Test
    public void testSetCurrentQuestion() {
        System.out.println("setCurrentQuestion");
        Question currentQuestion = null;
        Game instance = new Game();
        instance.setCurrentQuestion(currentQuestion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTime method, of class Game.
     */
    @Test
    public void testGetCurrentTime() {
        System.out.println("getCurrentTime");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getCurrentTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentTime method, of class Game.
     */
    @Test
    public void testSetCurrentTime() {
        System.out.println("setCurrentTime");
        int currentTime = 0;
        Game instance = new Game();
        instance.setCurrentTime(currentTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
