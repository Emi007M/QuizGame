/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.model;

import java.util.ArrayList;
import java.util.List;
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
public class GameUnitTests {
    
    public GameUnitTests() {
    }
    

    
    /**
     * Test of getRunningTimer method, of class Game.
     */
    @Test
    public void testGetRunningTimer() {
        System.out.println("getRunningTimer");
        Game instance = new Game();
        instance.setTimer(20);
        int expResult = instance.getCurrentTime()-1;
        int result = instance.getRunningTimer();
        assertEquals(expResult, result);
    }


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
    }

    /**
     * Test of nextQuestion method, of class Game.
     */
    @Test
    public void testNextQuestion() {
        System.out.println("nextQuestion");
        Game instance = new Game();
        int remainingQuestions = instance.getRemainingQuestions();
        instance.nextQuestion();
        int remainingQuestions2 =  instance.getRemainingQuestions();
        int result = remainingQuestions - remainingQuestions2;
        assertEquals(1,result);
        result = instance.sumBets();
        assertEquals(0, result);
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
    }


    


    

}
