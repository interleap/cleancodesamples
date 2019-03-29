package co.interleap.samples.errorhandling;

public class DeviceControllerWithExceptions {
  private static final DeviceID DEV1 = new DeviceID("/random/path");
  private static final String DEVICE_SUSPENDED = null;
  private DeviceRecord record = null;
  private static final Logger logger = Logger.getLogger(DeviceController.class);

  public void sendShutDown() {
    try {
      tryToShutDown();
    } catch (DeviceShutDownError e) {
      logger.log(e);
    }
  }

  private void tryToShutDown() throws DeviceShutDownError {
    DeviceHandle handle = getHandle(DEV1);
    DeviceRecord record = retrieveDeviceRecord(handle);
    pauseDevice(handle);
    clearDeviceWorkQueue(handle);
    closeDevice(handle);
  }

  private void closeDevice(DeviceHandle handle) {

  }

  private void clearDeviceWorkQueue(DeviceHandle handle) {

  }

  private void pauseDevice(DeviceHandle handle) {

  }

  private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) {
      return null;
  }

  private DeviceHandle getHandle(DeviceID id) throws DeviceShutDownError {
    throw new DeviceShutDownError("Invalid handle for: " + id.toString());
  }

}
