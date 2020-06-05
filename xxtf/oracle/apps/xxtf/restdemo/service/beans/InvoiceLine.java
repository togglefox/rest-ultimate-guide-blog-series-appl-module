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
import java.math.BigDecimal;

public class InvoiceLine implements Serializable {

  Long invoiceLineId;
  Long invoiceId;
  Integer lineNum;
  String description;
  Long quantity;
  BigDecimal price;
  BigDecimal lineAmount;

  public InvoiceLine() {
  }

  @Override
  public String toString() {
    return "Invoice " +
    "invoiceLineId: " + (invoiceLineId != null ? invoiceLineId.toString() : "") +
    " invoiceId: " + (invoiceId != null ? invoiceId.toString() : "") +
    " lineNum: " + lineNum +
    " description: " + description +
    " quantity: " + quantity +
    " price: " + price +
    " lineAmount: " + lineAmount;
  }

  public void setInvoiceLineId(Long invoiceLineId) {
    this.invoiceLineId = invoiceLineId;
  }

  public Long getInvoiceLineId() {
    return invoiceLineId;
  }

  public void setInvoiceId(Long invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Long getInvoiceId() {
    return invoiceId;
  }

  public void setLineNum(Integer lineNum) {
    this.lineNum = lineNum;
  }

  public Integer getLineNum() {
    return lineNum;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setLineAmount(BigDecimal lineAmount) {
    this.lineAmount = lineAmount;
  }

  public BigDecimal getLineAmount() {
    return lineAmount;
  }
}
