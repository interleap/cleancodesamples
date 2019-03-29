package co.interleap.samples.functions;

import java.util.logging.Logger;

//with nested if-else
class NestedIfElse1 {


  private static final int E_OK = 1;
  private static final int E_ERROR = 2;
  private Registry registry;
  private ConfigKeys configKeys;
  private Logger logger;

  public int delete(Page page) {
    if (deletePage(page) == E_OK) {
      if (registry.deleteReference(page.name) == E_OK) {
        if (configKeys.deleteKey(page.name) == E_OK) {
          logger.info("page deleted");
        } else {
          logger.info("configKey not deleted");
        }
      } else {
        logger.info("deleteReference from registry failed");
      }
    } else {
      logger.info("delete failed");
      return E_ERROR;
    }
    return E_OK;
  }

  private int deletePage(Page page) {
    return 0;
  }
}


//after refactor with exception
class NestedIfElse2 {

  private Logger logger;
  private Registry registry;
  private ConfigKeys configKeys;

  public void delete(Page page) {
    try {
      deletePage(page);
      registry.deleteReference(page.name);
      configKeys.deleteKey(page.name);
    } catch (Exception e) {
      logger.info(e.getMessage());
    }
  }

  private void deletePage(Page page) {

  }
}

class Page {
  public String name;
}

class Registry {
  public int deleteReference(String name) {
    return 0;
  }
}

class ConfigKeys {

  public int deleteKey(String name) {
    return 0;
  }
}

public class NestedIfElse {

}