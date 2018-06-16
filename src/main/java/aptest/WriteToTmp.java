package aptest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteToTmp {

  private static transient PrintWriter pw;

  static void write(Object data) {
      if(pw == null) {
          try {
              pw = new PrintWriter(new FileOutputStream(new File("/tmp/stream.out"), true), true);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
    pw.println(data.toString());
  }
}
