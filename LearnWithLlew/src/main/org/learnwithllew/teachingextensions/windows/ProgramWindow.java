package org.learnwithllew.teachingextensions.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.learnwithllew.teachingextensions.logo.Colors;
import org.learnwithllew.teachingextensions.logo.ImageBackground;
import org.learnwithllew.teachingextensions.logo.Paintable;
import org.learnwithllew.teachingextensions.logo.VirtualProctorWeb;

import com.spun.util.FrameCloser;
import com.spun.util.WindowUtils;

public class ProgramWindow extends JPanel
{
  private ArrayList<Paintable> additional = new ArrayList<Paintable>();
  public ProgramWindow(String title)
  {
    this();
    JFrame frame = new JFrame(title);
    frame.getContentPane().add(this);
    ProgramWindow.createStandardFrame(frame);
  }
  public ProgramWindow()
  {
    setPreferredSize(new Dimension(627, 442));
    setColor(Colors.Whites.White);
  }
  public static void createStandardFrame(JFrame frame)
  {
    WindowUtils.testFrame(frame, new VirtualProctorWeb(), new FrameCloser());
  }
  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    for (Paintable p : additional)
    {
      p.paint((Graphics2D) g, this);
    }
  }
  public void setColor(Color backgroundColor)
  {
    setBackground(backgroundColor);
  }
  public void addPaintable(Paintable additional)
  {
    this.additional.add(additional);
    repaint();
  }
  public void removePaintable()
  {
    additional.clear();
    repaint();
  }
  public void addMouseRightClickListener(MouseRightClickListener listener)
  {
    addMouseListener(new RightClickMouseAdapter(listener));
  }
  public void addMouseLeftClickListener(MouseLeftClickListener listener)
  {
    addMouseListener(new LeftClickMouseAdapter(listener));
  }
  public void setBackgroundImage(String url)
  {
    addPaintable(new ImageBackground(url));
  }
}
