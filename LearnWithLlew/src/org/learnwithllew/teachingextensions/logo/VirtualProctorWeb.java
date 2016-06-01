package org.learnwithllew.teachingextensions.logo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lambda.actions.Action0;

import com.spun.util.ThreadLauncher;
import com.spun.util.ThreadUtils;

public class VirtualProctorWeb extends WindowAdapter
{
  private boolean finished = false;
  @Override
  public void windowClosing(WindowEvent event)
  {
    final BufferedImage scaled = ScreenCapture.getScaledImageOf(event.getComponent(), 200, 150);
    ThreadLauncher.launch(new Action0()
    {
      @Override
      public void call()
      {
        sendImageToWeb(scaled);
        finished = true;
      }
    });
  }
  public void sendImageToDisk(BufferedImage image) throws IOException
  {
    String filename = "C:\\temp\\VirtualProctor.png";
    ImageIO.write(image, "png", new File(filename));
  }
  @Override
  public void windowClosed(WindowEvent e)
  {
    while (!finished)
    {
      ThreadUtils.sleep(50);
    }
  }
  public void sendImageToWeb(BufferedImage image)
  {
  }
}
