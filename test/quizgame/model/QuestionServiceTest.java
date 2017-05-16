/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.model;

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
public class QuestionServiceTest {
    
    public QuestionServiceTest() {
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
     * Test of getAllQuestions method, of class QuestionService.
     */
    @Test
    public void testGetAllQuestions() {
        System.out.println("getAllQuestions");
        QuestionService instance = new QuestionService();
        List<Question> expResult = null;
        List<Question> result = instance.getAllQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCategories method, of class QuestionService.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        QuestionService instance = new QuestionService();
        Set<String> expResult = null;
        Set<String> result = instance.getAllCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomQuestionByCategory method, of class QuestionService.
     */
    @Test
    public void testGetRandomQuestionByCategory() {
        System.out.println("getRandomQuestionByCategory");
        String category = "";
        QuestionService instance = new QuestionService();
        Question expResult = null;
        Question result = instance.getRandomQuestionByCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
