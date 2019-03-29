package co.interleap.samples.errorhandling;

public class PortOpener {

  private Logger logger;

  public void openPort() {
    ACMEPort port = new ACMEPort(12);
    try {
      port.open();
    } catch (DeviceResponseException e) {
      reportPortError(e);
      logger.log("Device response exception", e);
    } catch (ATM1212UnlockedException e) {
      reportPortError(e);
      logger.log("Unlock exception", e);
    } catch (GMXError e) {
      reportPortError(e);
      logger.log("Device response exception");
    } finally {
    }
  }

  public void openPortWithWrapper() {

    LocalPort port = new LocalPort(12);
    try {
      port.open();
    } catch (PortDeviceFailure e) {
      reportError(e);
      logger.log(e.getMessage(), e);
    } finally {

    }
  }

  public class LocalPort {
    private ACMEPort innerPort;

    public LocalPort(int portNumber) {
      innerPort = new ACMEPort(portNumber);
    }

    public void open() {
      try {
        innerPort.open();
      } catch (DeviceResponseException e) {
        throw new PortDeviceFailure(e);
      } catch (ATM1212UnlockedException e) {
        throw new PortDeviceFailure(e);
      } catch (GMXError e) {
      }
    }
  }

  private void reportError(Exception e) {
  }


  private void reportPortError(Exception exception) {
  }

  private class ACMEPort {
    public ACMEPort(int port) {
    }

    public void open() throws DeviceResponseException, ATM1212UnlockedException, GMXError {
    }
  }

  private class DeviceResponseException extends Exception {
  }

  private class ATM1212UnlockedException extends Exception {
  }

  private class GMXError extends Exception {
  }

  private class PortDeviceFailure extends RuntimeException {
    public PortDeviceFailure(Exception e) {
    }
  }
}
