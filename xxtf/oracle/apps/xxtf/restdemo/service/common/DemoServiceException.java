/* ***************************************************************************
 * Copyright 2020 togglefox
 * 
 * Ver   When    Who             What
 * ----- ------- --------------- -------------------------
 * 1.0   08Feb20 Michael Carroll Initial creation.
 * 
*****************************************************************************/
package xxtf.oracle.apps.xxtf.restdemo.service.common;

import oracle.apps.fnd.isg.common.error.ISGException;

public class DemoServiceException extends ISGException {

  public static final String ISG_SERVICE_ERROR_PREFIX = "ISG_SERVICE_CUSTOM_ERROR_";

  public DemoServiceException(String errorCode, String message, String resolution, Throwable ex) {
    super(ISG_SERVICE_ERROR_PREFIX + errorCode, null, message, null, resolution, ex);
  }

}
