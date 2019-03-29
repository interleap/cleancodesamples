package co.interleap.samples.errorhandling;

public class Logger {
  public static Logger getLogger(Class loggerClass) {
    return new Logger();
  }

  public void log(String message) {

  }

  public void log(Exception exception) {

  }

  public void log(String device_response_exception, Throwable e) {

  }
}
