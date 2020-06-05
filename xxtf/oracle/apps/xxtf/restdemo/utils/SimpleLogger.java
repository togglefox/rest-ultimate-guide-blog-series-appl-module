/* ***************************************************************************
 * Copyright 2020 togglefox
 * 
 * Ver   When    Who             What
 * ----- ------- --------------- -------------------------
 * 1.0   08Feb20 Michael Carroll Initial creation.
 * 
*****************************************************************************/
package xxtf.oracle.apps.xxtf.restdemo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleLogger {

  public static final String FILE_NAME = "/tmp/togglefox.log";
  public static final String DATE_FORMAT_MASK = "ddMMMyy HH:mm:ss.SSS";
  public static final String DELIMITER = "\n";
  public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_MASK);

  private SimpleLogger() {
  }

  private static String getCurrentFormattedDate() {
    return DATE_FORMAT.format(new Date());
  }

/*
 * to switch to console logging instead
 * 
  public static void log(String text) {
    consoleLog(text);
  }
 */

  // console logging in $EBS_DOMAIN_HOME/servers/oafm_server1/logs/oafm_server1.out
  public static void consoleLog(String text) {
    System.out.println("XXTF: " + text);
  }

  public static void log(String text) {
      try {
        File file = new File(FILE_NAME);
        FileOutputStream stream = new FileOutputStream(file, true);
        stream.write((getCurrentFormattedDate() + ": ").getBytes());
        stream.write(text.getBytes());
        stream.write(new byte[] { '\r', '\n' });
        stream.close();
      }
      catch (Exception ex) {
        consoleLog("failed to write " + text + " exception: " + ex.getMessage());
      }
  }

}
