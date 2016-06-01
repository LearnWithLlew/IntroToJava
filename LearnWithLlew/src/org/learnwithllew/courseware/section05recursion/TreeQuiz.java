package org.learnwithllew.courseware.section05recursion;

import org.learnwithllew.courseware.recipes.quizzes.graders.TreeQuizAdapter;
import org.learnwithllew.courseware.recipes.quizzes.graders.TreeQuizGrader;

public class TreeQuiz extends TreeQuizAdapter
{
  public void questions1To4()
  {
    //   Question 1 
    //   doubleLength (recipe below) 
    //   ------------- Recipe for doubleLength 
    //       make the current length twice what it is
    //   ------------- End of doubleLength recipe
    //
    //   Question 2 
    //   decreaseTurn (recipe below) 
    //   ------------- Recipe for decreaseTurn 
    //      decrease the current turn by 1
    //   ------------- End of decreaseTurn recipe
    //
    //   Question 3 
    //   setNinety (recipe below) 
    //   ------------- Recipe for setNinety 
    //       sets the angle of the current turn to 90
    //   ------------- End of setNinety recipe
    //
    //   Question 4 
    //   angleFive (recipe below) 
    //   ------------- Recipe for angleFive 
    //       sets the 5th angle to 36 degrees
    //   ------------- End of angleFive recipe
  }
  public static void main(String[] args)
  {
    new TreeQuizGrader().grade(new TreeQuiz());
  }
}
