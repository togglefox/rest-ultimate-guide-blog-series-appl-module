/* ***************************************************************************
 * Copyright 2020 togglefox
 * 
 * Ver   When    Who             What
 * ----- ------- --------------- -------------------------
 * 1.0   08Feb20 Michael Carroll Initial creation.
 * 
*****************************************************************************/
package xxtf.oracle.apps.xxtf.restdemo.service.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {

  Long invoiceId;
  String invoiceNum;
  Date invoiceDate;
  String customerNum;
  List<InvoiceLine> lines;

  public Invoice() {
    lines = new ArrayList<InvoiceLine>();
  }

  @Override
  public String toString() {
    return "Invoice "+
    "invoiceId: " + (invoiceId != null ? invoiceId.toString() : "") +
    " invoiceNum: " + invoiceNum +
    " invoiceDate: " + (invoiceDate != null ? invoiceDate.toString() : "") +
    " customerNum: " + customerNum +
    " lines size:" + lines.size();
  }

  public void setInvoiceId(Long invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Long getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceNum(String invoiceNum) {
    this.invoiceNum = invoiceNum;
  }

  public String getInvoiceNum() {
    return invoiceNum;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setCustomerNum(String customerNum) {
    this.customerNum = customerNum;
  }

  public String getCustomerNum() {
    return customerNum;
  }

  public void setLines(List<InvoiceLine> lines) {
    this.lines = lines;
  }

  public List<InvoiceLine> getLines() {
    return lines;
  }

}
