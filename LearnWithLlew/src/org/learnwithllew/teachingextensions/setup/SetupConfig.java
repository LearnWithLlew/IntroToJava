package org.learnwithllew.teachingextensions.setup;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import org.learnwithllew.teachingextensions.setup.SetupValidator.SetupCheckPoints;

import com.spun.util.ObjectUtils;
import com.spun.util.SystemUtils;
import com.spun.util.io.FileUtils;
import com.spun.util.servlets.ValidationError;

public class SetupConfig
{
  public ValidationError setup              = new ValidationError(SetupCheckPoints.values());
  public String          workspacePath      = ".";
  public String          eclipsePath        = SystemUtils.isWindowsEnviroment()
      ? eclipsePathWindows
      : getEclipsePathForMac();
  public static String   eclipsePathWindows = "c:\\eclipse\\eclipse.exe";
  public void assertSetupIsCorrect()
  {
    if (!setup.isOk()) { throw setup; }
  }
  public static String getEclipsePathForMac()
  {
    File baseDir = new File(System.getProperty("user.home") + "/eclipse");
    FileFilter filter = new FileFilter()
    {
      @Override
      public boolean accept(File pathname)
      {
        return pathname.getAbsolutePath().endsWith("Contents/MacOS/eclipse");
      }
    };
    File[] possible = FileUtils.getRecursiveFileList(baseDir, filter);
    File found = null;
    for (File file : possible)
    {
      if (found == null || isFileNewer(file, found))
      {
        found = file;
      }
    }
    return found == null ? "" : found.getAbsolutePath();
  }
  private static boolean isFileNewer(File f1, File f2)
  {
    try
    {
      FileTime time1 = Files.readAttributes(f1.toPath(), BasicFileAttributes.class).creationTime();
      FileTime time2 = Files.readAttributes(f2.toPath(), BasicFileAttributes.class).creationTime();
      return time1.compareTo(time2) > 0;
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
