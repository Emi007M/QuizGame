/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class QuestionServiceUnitTests {
    
    public QuestionServiceUnitTests() {
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
     * Test of getRandomQuestionByCategory method, of class QuestionService.
     */
    @Test
    public void testGetRandomQuestionByCategory() {
        System.out.println("getRandomQuestionByCategory");
        String category = "Sport";
        QuestionService instance = new QuestionService();
        instance.populateDB();

        Set<Question> allQuestions = new HashSet<>();
        for(int i=0;i<instance.getAllQuestions().size();i++){
            if(instance.getAllQuestions().get(i).getCategory().equals(category))
              allQuestions.add(instance.getAllQuestions().get(i));
        }
        int expResult = allQuestions.size();
        Set<Question> randomQuestions = new HashSet<>();
        Question q;
        for(int i=0;i<expResult*100;i++){
            q = instance.getRandomQuestionByCategory(category);
            if(q!=null)
            randomQuestions.add(q);
        }
        System.out.println("random questions to string " + randomQuestions.toString());
        int result = randomQuestions.size();
        assertEquals(expResult, result);
    }

    
}
