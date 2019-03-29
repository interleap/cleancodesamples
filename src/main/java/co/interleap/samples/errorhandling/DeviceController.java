package co.interleap.samples.errorhandling;



public class DeviceController {
  private static final String DEV1 = "/random/path";
  private static final String DEVICE_SUSPENDED = null;
  private DeviceRecord record = null;
  private static final Logger logger = Logger.getLogger(DeviceController.class);

  public void sendShutDown() {
    DeviceHandle handle = getHandle(DEV1);
    // Check the state of the device
    if (handle != DeviceHandle.INVALID) {
      // Save the device status to the record field
      retrieveDeviceRecord(handle);
      // If not suspended, shut down
      if (record.getStatus() != DEVICE_SUSPENDED) {
        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
      } else {
        logger.log("Device suspended. Unable to shut down");
      }
    } else {
      logger.log("Invalid handle for: " + DEV1.toString());
    }
  }

  private void closeDevice(DeviceHandle handle) {

  }

  private void clearDeviceWorkQueue(DeviceHandle handle) {

  }

  private void pauseDevice(DeviceHandle handle) {

  }

  private void retrieveDeviceRecord(DeviceHandle handle) {

  }

  private DeviceHandle getHandle(String dev1){
    return DeviceHandle.INVALID;
  }
}