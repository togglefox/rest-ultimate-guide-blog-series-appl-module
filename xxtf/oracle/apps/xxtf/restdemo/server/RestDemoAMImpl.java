/* ***************************************************************************
 * Copyright 2020 togglefox
 * 
 * Ver   When    Who             What
 * ----- ------- --------------- -------------------------
 * 1.0   08Feb20 Michael Carroll Initial creation.
 * 
*****************************************************************************/
package xxtf.oracle.apps.xxtf.restdemo.server;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityImpl;
import xxtf.oracle.apps.xxtf.restdemo.service.beans.InvoiceLine;
import xxtf.oracle.apps.xxtf.restdemo.service.common.DemoServiceException;
import xxtf.oracle.apps.xxtf.restdemo.utils.SimpleLogger;

/**
 * Application Module Service to provide CRUD support for tables XXTF_REST_INVOICES and XXTF_REST_INVOICE_LINES.
 * @rep:scope public
 * @rep:product XXTF
 * @rep:displayname XxtfRestDemoAM
 * @rep:category BUSINESS_ENTITY XXTF_REST_INVOICES
 * @rep:category IREP_CLASS_SUBTYPE AM_SERVICES
 */
public class RestDemoAMImpl extends OAApplicationModuleImpl {

  public RestDemoAMImpl() {
  }

  public static void main(String[] args) {
    launchTester("xxtf.oracle.apps.xxtf.restdemo.server", /* package name */
      "RestDemoAMLocal" /* Configuration Name */);
  }

  public RestInvoicesVOImpl getRestInvoicesVO1() {
    return (RestInvoicesVOImpl)findViewObject("RestInvoicesVO1");
  }

  public RestInvoiceLinesVOImpl getRestInvoiceLinesVO1() {
    return (RestInvoiceLinesVOImpl)findViewObject("RestInvoiceLinesVO1");
  }

  public ViewLinkImpl getRestInvoiceToLinesVL1() {
    return (ViewLinkImpl)findViewLink("RestInvoiceToLinesVL1");
  }

  public RestInvoiceQueryVOImpl getRestInvoiceQueryVO1() {
    return (RestInvoiceQueryVOImpl)findViewObject("RestInvoiceQueryVO1");
  }

  /**
  * 
  * Get an invoice by key
  *
  * @param invoiceId Invoice Id
  * @rep:paraminfo {@rep:required} {@rep:key_param}
  * @return Invoice
  * @rep:paraminfo {@rep:innertype xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice}
  * @rep:scope public
  * @rep:displayname Get Invoice
  * @rep:httpverb get
  */
  public Invoice getInvoice(java.lang.Number invoiceId) throws DemoServiceException {
    try {
      SimpleLogger.log("start getInvoice invoiceId = " + invoiceId.toString());
      Invoice invoice = createInvoiceBean(findInvoiceByKey(invoiceId));
      SimpleLogger.log("end getInvoice invoice = " + invoice);
      return invoice;
    }
    catch (DemoServiceException ex) {
      throw ex;
    }
    catch (Throwable th) {
      throw new DemoServiceException("GET_ERROR","Error in get invoice",null,th);
    }
  }

  /**
  * 
  * Get invoices for search parameters
  *
  * @param invoiceNum Invoice Number
  * @param invoiceDateFrom Invoice Date From
  * @param invoiceDateTo Invoice Date To
  * @param customerNum Customer Number
  * @param offset begin offset position
  * @param limit maximum number of records
  * @return Invoice
  * @rep:paraminfo {@rep:innertype xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice}
  * @rep:scope public
  * @rep:displayname Get Invoices
  * @rep:httpverb get
  */
  public List<Invoice> getInvoices(String invoiceNum, java.util.Date invoiceDateFrom, java.util.Date invoiceDateTo, String customerNum, String offset, String limit) throws DemoServiceException {
    try {
      SimpleLogger.log("start getInvoices");
      outputCtxParameters();
      SimpleLogger.log("invoiceNum = " + invoiceNum);
      SimpleLogger.log("invoiceDateFrom = " + invoiceDateFrom);
      SimpleLogger.log("invoiceDateTo = " + invoiceDateTo);
      SimpleLogger.log("customerNum = " + customerNum);

      Date jboDateFrom = getJboDate(invoiceDateFrom);
      Date jboDateTo = getJboDate(invoiceDateTo);
      RestInvoiceQueryVOImpl vo = getRestInvoiceQueryVO1();
      vo.executeQuery(invoiceNum,jboDateFrom,jboDateTo,customerNum);
      ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
      while (vo.hasNext()) {
        invoiceList.add(createInvoiceBean((RestInvoicesVORowImpl)vo.next()));
      }
      SimpleLogger.log("end getInvoices invoiceList size = " + invoiceList.size());
      return invoiceList;
    }
    catch (DemoServiceException ex) {
      throw ex;
    }
    catch (Throwable th) {
      throw new DemoServiceException("GET_ERROR","Error in get invoices",null,th);
    }
  }

  /**
  * 
  * Delete an Invoice by key
  *
  * @param invoiceId Invoice Id
  * @rep:paraminfo {@rep:required} {@rep:key_param}
  * @return Invoice
  * @rep:paraminfo {@rep:innertype xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice}
  * @rep:scope public
  * @rep:displayname Delete Invoice
  * @rep:httpverb get
  */
  public Invoice deleteInvoice(java.lang.Number invoiceId) throws DemoServiceException {
    try {
      SimpleLogger.log("start deleteInvoice invoiceId = " + invoiceId.toString());
      RestInvoicesVORowImpl invoiceRow = findInvoiceByKey(invoiceId);
      invoiceRow.remove();
      commit();
      SimpleLogger.log("end deleteInvoice");
      return new Invoice();
    }
    catch (DemoServiceException ex) {
      throw ex;
    }
    catch (Throwable th) {
      throw new DemoServiceException("DELETE_ERROR","Error in delete invoice",null,th);
    }
  }

  /**
  * 
  * Create an Invoice
  *
  * @param invoice Invoice
  * @return Invoice
  * @rep:paraminfo {@rep:innertype xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice}
  * @rep:scope public
  * @rep:displayname Create Invoice
  * @rep:httpverb post
  */
  public Invoice createInvoice(Invoice invoice) throws DemoServiceException {
    try {
      SimpleLogger.log("start createInvoice invoice = " + invoice);
      outputCtxParameters();
      RestInvoicesVOImpl invoiceVO = getRestInvoicesVO1();
      RestInvoicesVORowImpl invoiceRow = (RestInvoicesVORowImpl)invoiceVO.createRow();SimpleLogger.log("got new invoiceRow invoiceId = " + invoiceRow.getInvoiceId().stringValue());
      populateInvoiceRow(invoiceRow, invoice);
      invoiceVO.insertRow(invoiceRow);
      SimpleLogger.log("inserted invoiceRow");
      RowIterator linesItr = invoiceRow.getRestInvoiceLinesVO();
      SimpleLogger.log("linesItr = " + linesItr);
      for (InvoiceLine line : invoice.getLines()) {
        SimpleLogger.log("in line loop line = " + line);
        RestInvoiceLinesVORowImpl lineRow = (RestInvoiceLinesVORowImpl)linesItr.createRow();SimpleLogger.log("got new lineRow invoiceLineId = " + lineRow.getInvoiceLineId().stringValue());
        lineRow.setInvoiceId(invoiceRow.getInvoiceId());
        populateInvoiceLineRow(lineRow, line);
        SimpleLogger.log("insert lineRow");
        linesItr.insertRow(lineRow);
      }
      commit();
      invoice = createInvoiceBean(invoiceRow);
      SimpleLogger.log("end createInvoice invoice = " + invoice);
      return invoice;
    }
    catch (DemoServiceException ex) {
      throw ex;
    }
    catch (Throwable th) {
      throw new DemoServiceException("CREATE_ERROR","Error in create invoice",null,th);
    }
  }

  /**
  * 
  * Update an Invoice
  *
  * @param invoice Invoice
  * @return Invoice
  * @rep:paraminfo {@rep:innertype xxtf.oracle.apps.xxtf.restdemo.service.beans.Invoice}
  * @rep:scope public
  * @rep:displayname Update Invoice
  * @rep:httpverb post
  */
  public Invoice updateInvoice(Invoice invoice) throws DemoServiceException {
    try {
      SimpleLogger.log("start updateInvoice invoice = " + invoice);
      RestInvoicesVORowImpl invoiceRow = findInvoiceByKey(invoice.getInvoiceId());
      populateInvoiceRow(invoiceRow, invoice);
      SimpleLogger.log("updated invoiceRow");
      RowIterator linesItr = invoiceRow.getRestInvoiceLinesVO();
      SimpleLogger.log("linesItr = " + linesItr);
      for (InvoiceLine line : invoice.getLines()) {
        SimpleLogger.log("in line loop line = " + line);
        RestInvoiceLinesVORowImpl lineRow = findInvoiceLineByKey(linesItr, line.getInvoiceLineId());
        if (lineRow == null) {
          lineRow = (RestInvoiceLinesVORowImpl)linesItr.createRow();
          SimpleLogger.log("got new lineRow invoiceLineId = " + lineRow.getInvoiceLineId().stringValue());
          lineRow.setInvoiceId(invoiceRow.getInvoiceId());        
          populateInvoiceLineRow(lineRow, line);
          SimpleLogger.log("insert lineRow");
          linesItr.insertRow(lineRow);
        }
        else {
          SimpleLogger.log("found lineRow invoiceLineId = " + lineRow.getInvoiceLineId().stringValue());        
          populateInvoiceLineRow(lineRow, line);
          SimpleLogger.log("updated lineRow");
        }
      }
      linesItr.reset();
      while (linesItr.hasNext()) {
        RestInvoiceLinesVORowImpl lineRow = (RestInvoiceLinesVORowImpl)linesItr.next();SimpleLogger.log("found lineRow invoiceLineId = " + lineRow.getInvoiceLineId().stringValue());        
        if (lineRow.getRestInvoiceLineEO().getEntityState() == EntityImpl.STATUS_UNMODIFIED) {SimpleLogger.log("status = unmodified so delete");
          lineRow.remove();
        }
      }
      commit();
      invoice = createInvoiceBean(invoiceRow);
      SimpleLogger.log("end updateInvoice invoice = " + invoice);
      return invoice;
    }
    catch (DemoServiceException ex) {
      throw ex;
    }
    catch (Throwable th) {
      throw new DemoServiceException("UPDATE_ERROR","Error in update invoice",null,th);
    }
  }

  public void populateInvoiceRow(RestInvoicesVORowImpl invoiceRow, Invoice invoice) throws DemoServiceException {SimpleLogger.log("start populateInvoiceRow invoice = " + invoice);
    invoiceRow.setInvoiceNum(invoice.getInvoiceNum());
    invoiceRow.setInvoiceDate(getJboDate(invoice.getInvoiceDate()));
    invoiceRow.setCustomerNum(invoice.getCustomerNum());
    SimpleLogger.log("end populateInvoiceRow");
  }

  public void populateInvoiceLineRow(RestInvoiceLinesVORowImpl lineRow, InvoiceLine line) throws DemoServiceException {SimpleLogger.log("start populateInvoiceLineRow line = " + line);
    lineRow.setLineNum(getJboNumber("lineNum",line.getLineNum()));
    lineRow.setDescription(line.getDescription());
    lineRow.setQuantity(getJboNumber("quantity",line.getQuantity()));
    lineRow.setPrice(getJboNumber("price",line.getPrice()));
    lineRow.setLineAmount(getJboNumber("lineNum",line.getLineAmount()));
    SimpleLogger.log("end populateInvoiceRow");
  }

  protected void commit() {
    SimpleLogger.log("commit");
    getOADBTransaction().commit();
  }

  protected Invoice createInvoiceBean(RestInvoicesVORowImpl row) {
    SimpleLogger.log("start createInvoiceBean");
    Invoice invoiceBean = new Invoice();
    invoiceBean.setInvoiceId(row.getInvoiceId().longValue());
    invoiceBean.setInvoiceNum(row.getInvoiceNum());
    invoiceBean.setInvoiceDate(new java.util.Date(row.getInvoiceDate().getValue().getTime()));
    invoiceBean.setCustomerNum(row.getCustomerNum());
    RowIterator lineItr  = row.getRestInvoiceLinesVO();
    while (lineItr.hasNext()) {
      invoiceBean.getLines().add(createInvoiceLineBean((RestInvoiceLinesVORowImpl)lineItr.next()));
    }
    SimpleLogger.log("end createInvoiceBean = " + invoiceBean);
    return invoiceBean;
  }

  protected InvoiceLine createInvoiceLineBean(RestInvoiceLinesVORowImpl row) {
    SimpleLogger.log("start createInvoiceLineBean");
    InvoiceLine lineBean = new InvoiceLine();
    lineBean.setInvoiceLineId(row.getInvoiceLineId().longValue());
    lineBean.setInvoiceId(row.getInvoiceId().longValue());
    lineBean.setLineNum(row.getLineNum().intValue());
    lineBean.setDescription(row.getDescription());
    lineBean.setQuantity(row.getQuantity().longValue());
    lineBean.setPrice(row.getPrice().bigDecimalValue());
    lineBean.setLineAmount(row.getLineAmount().bigDecimalValue());
    SimpleLogger.log("end createInvoiceLineBean = " + lineBean);
    return lineBean;
  }

  protected RestInvoicesVORowImpl findInvoiceByKey(java.lang.Number invoiceId) throws DemoServiceException {
    RestInvoicesVOImpl invoiceVO = getRestInvoicesVO1();
    Key key = null;
    try {
      key = RestInvoiceEOImpl.createPrimaryKey(new Number(invoiceId));
    }
    catch (SQLException ex) {
      throw new DemoServiceException("INVALID_ID","Invoice id is invalid: " + invoiceId.toString(),"Correct the invoice id and retry",ex);
    }
    SimpleLogger.log("do find, key = " + key);
    Row[] rowset = invoiceVO.findByKey(key,1);
    if (rowset == null || rowset.length == 0) {
      throw new DemoServiceException("INVOICE_ID_NOT_FOUND","Invoice id not found: " + invoiceId.toString(),"Correct the invoice id and retry",null);      
    }
    return (RestInvoicesVORowImpl)rowset[0];
  }

  protected RestInvoiceLinesVORowImpl findInvoiceLineByKey(RowIterator linesItr, java.lang.Number lineId) throws DemoServiceException {
    Key key = null;
    try {
      key = RestInvoiceLineEOImpl.createPrimaryKey(new Number(lineId));
    }
    catch (SQLException ex) {
      throw new DemoServiceException("INVALID_LINE_ID","Invoice line id is invalid: " + lineId.toString(),"Correct the invoice line id and retry",ex);
    }
    SimpleLogger.log("do find, key = " + key);
    Row[] rowset = linesItr.findByKey(key,1);
    RestInvoiceLinesVORowImpl row = null;
    if (rowset != null && rowset.length != 0) {
      row = (RestInvoiceLinesVORowImpl)rowset[0];
    }
    return row;
  }

  protected void outputCtxParameters() {
    SimpleLogger.log("userId = " +getOADBTransaction().getUserId());
    SimpleLogger.log("userName = " +getOADBTransaction().getUserName());
    SimpleLogger.log("respId = " +getOADBTransaction().getResponsibilityId());SimpleLogger.log("respApplId = " +getOADBTransaction().getResponsibilityApplicationId());SimpleLogger.log("respName = " +getOADBTransaction().getResponsibilityName());SimpleLogger.log("securityGroupId = " +getOADBTransaction().getSecurityGroupId());SimpleLogger.log("orgId = " +getOADBTransaction().getOrgId());
  }

  protected Date getJboDate(java.util.Date utilDate) throws DemoServiceException {
    Date jboDate = null;
    if (utilDate != null) {
        jboDate = new Date(new java.sql.Date(utilDate.getTime()));
    }
    return jboDate;
  }

  protected java.util.Date getJboDateAsUtilDate(Date date) {
    return new java.util.Date(date.getValue().getTime());
  }

  protected Number getJboNumber(String name,Integer num) throws DemoServiceException {
    Number jboNumber = null;
    try {
      if (num != null) {
        jboNumber = new Number(num);
      }
    }
    catch (SQLException ex) {
      throw new DemoServiceException("INVALID_NUMBER",name + " is invalid: " + num.toString(),"Correct the number and retry",ex);
    }
    return jboNumber;
  }

  protected Number getJboNumber(String name,Long num) throws DemoServiceException {
    Number jboNumber = null;
    if (num != null) {
      jboNumber = new Number(num);
    }
    return jboNumber;
  }

  protected Number getJboNumber(String name,BigDecimal num) throws DemoServiceException {
    Number jboNumber = null;
    try {
      if (num != null) {
        jboNumber = new Number(num);
      }
    }
    catch (SQLException ex) {
      throw new DemoServiceException("INVALID_NUMBER",name + " is invalid: " + num.toString(),"Correct the number and retry",ex);
    }
    return jboNumber;
  }


}
