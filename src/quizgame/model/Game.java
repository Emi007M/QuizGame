/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.model;

/**
 *
 * @author Emilia
 */
public class Game {
    
    private int timer;
    private int totalQuestions;
    private int remainingQuestions;
    private QuestionService questionService;
    private int budget;
    
    private String currentCategory;
    private Question currentQuestion;
    private int currentTime;

    private int[] bets;
    

    
    
    public Game(){
        totalQuestions = 4;
        remainingQuestions = totalQuestions;
        questionService = new QuestionService();
        questionService.populateDB();
        budget = 1000000;
        currentCategory = "-";
        bets = new int[4];
    }
    
    
    public Question generateQuestion(){
        currentQuestion = questionService.getRandomQuestionByCategory(currentCategory);
        return currentQuestion;
    }
    
    public void resetCurrentTimer() {
        currentTime = timer;
    }
    
    public int getRunningTimer(){
        return --currentTime;
    }
    
    /**
     * used by add/subtract answer buttons
     * @param number number of an answer
     * @param amount money to put/take
     */
    public int changeBet(int number, int amount){
        //check if 3 other already bet
        int betQuestionsButThis = 0;
        for(int i =0; i<4;i++){
            if(i!=number && bets[i]>0)
                betQuestionsButThis++;
        }
        if (betQuestionsButThis==3) return bets[number];
        
        if(amount<0){ //if substracting
            if(bets[number]+amount>0)
                bets[number] += amount;
            else
                bets[number] = 0;
        }else { //if increasing bet
            int sum_bet = bets[0]+bets[1]+bets[2]+bets[3];
            if(sum_bet+amount <= budget)
                bets[number] += amount;
        }
        return bets[number];
    }
    
    
    

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
        this.currentTime = timer;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getRemainingQuestions() {
        return remainingQuestions;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

   public void nextQuestion(){
       remainingQuestions--;
       for(int i=0;i<4;i++)
           bets[i]=0;
   }
   
   public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
    
    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }
    
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
    
    

    
}
