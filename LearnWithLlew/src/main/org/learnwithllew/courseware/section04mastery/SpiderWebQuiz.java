package org.learnwithllew.courseware.section04mastery;

import org.learnwithllew.courseware.recipes.quizzes.graders.SpiderQuiz;
import org.learnwithllew.courseware.recipes.quizzes.graders.SpiderWebQuizGrader;

public class SpiderWebQuiz extends SpiderQuiz
{
  //*this needs to be translated from the SmallBasic original into Java
  public void question1()
  {
    //         Do the following the current number of times
    //        Call circle()
    //        Repeat
  }
  //
  //      Question2
  //       Create a subroutine called circleAround which 
  //      Does the following 3 times
  //      Call adjust()
  //       Call question1
  //      Repeat
  //
  //
  //      Question3
  //      Create a subroutine called grow which 
  //       Changes the current length so it is multiplied by 2.5
  //
  //
  //      Question4
  //      Create a subroutine called shrink which 
  //       Decreases the current length by 9 pixels
  //
  //
  //      Question5
  //      Create a subroutine called expand which
  //      Increases the current number by 12
  //
  public static void main(String[] args)
  {
    new SpiderWebQuizGrader().grade(new SpiderWebQuiz());
  }
}
