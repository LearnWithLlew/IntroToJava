package org.learnwithllew.teachingextensions.logo.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.learnwithllew.teachingextensions.logo.Colors;
import org.learnwithllew.teachingextensions.logo.Paintable;
import org.learnwithllew.teachingextensions.windows.ProgramWindow;

public class Circle implements Paintable
{
  private final int   radius;
  private final Color mainColor;
  private int         x;
  private int         y;
  private int         percentTransparent;
  public Circle(int radius, Color color)
  {
    this.radius = radius;
    this.mainColor = color;
  }
  public void setCenter(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public void addTo(ProgramWindow panel)
  {
    panel.addPaintable(this);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Color color2 = Colors.getTransparentVersion(mainColor, percentTransparent);
    g.setColor(color2);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }
  public void setTransparency(int percentTransparent)
  {
    this.percentTransparent = percentTransparent;
  }
}
