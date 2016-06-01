package org.learnwithllew.courseware.recipes.quizzes.graders;

import org.learnwithllew.teachingextensions.windows.MessageBox.MessageBoxInstance;

public class MessageBoxMock extends MessageBoxInstance
{
  public String lastMessage;
  @Override
  public void showMessage(String message)
  {
    lastMessage = message;
  }
}
