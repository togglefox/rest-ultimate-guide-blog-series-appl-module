package xxtf.oracle.apps.xxtf.restdemo.server;

import oracle.jbo.domain.Date;

public class RestInvoiceQueryVOImpl extends RestInvoicesVOImpl {

  public RestInvoiceQueryVOImpl() {
  }

  public void executeQuery(String invoiceNum, Date invoiceDateFrom, Date invoiceDateTo, String customerNum) {
    setWhereClauseParams(new Object[] { invoiceNum,invoiceDateFrom,invoiceDateTo,customerNum } );
    executeQuery();
  }


}
