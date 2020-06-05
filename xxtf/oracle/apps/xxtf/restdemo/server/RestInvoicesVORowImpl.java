package xxtf.oracle.apps.xxtf.restdemo.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RestInvoicesVORowImpl extends OAViewRowImpl {
  public static final int INVOICEID = 0;
  public static final int INVOICENUM = 1;
  public static final int INVOICEDATE = 2;
  public static final int CUSTOMERNUM = 3;
  public static final int CREATEDBY = 4;
  public static final int CREATIONDATE = 5;
  public static final int LASTUPDATEDBY = 6;
  public static final int LASTUPDATEDATE = 7;
  public static final int LASTUPDATELOGIN = 8;
  public static final int RESTINVOICELINESVO = 9;

  /**This is the default constructor (do not remove)
   */
  public RestInvoicesVORowImpl() {
  }

  /**Gets RestInvoiceEO entity object.
   */
  public RestInvoiceEOImpl getRestInvoiceEO() {
    return (RestInvoiceEOImpl)getEntity(0);
  }

  /**Gets the attribute value for INVOICE_ID using the alias name InvoiceId
   */
  public Number getInvoiceId() {
    return (Number) getAttributeInternal(INVOICEID);
  }

  /**Sets <code>value</code> as attribute value for INVOICE_ID using the alias name InvoiceId
   */
  public void setInvoiceId(Number value) {
    setAttributeInternal(INVOICEID, value);
  }

  /**Gets the attribute value for INVOICE_NUM using the alias name InvoiceNum
   */
  public String getInvoiceNum() {
    return (String) getAttributeInternal(INVOICENUM);
  }

  /**Sets <code>value</code> as attribute value for INVOICE_NUM using the alias name InvoiceNum
   */
  public void setInvoiceNum(String value) {
    setAttributeInternal(INVOICENUM, value);
  }

  /**Gets the attribute value for INVOICE_DATE using the alias name InvoiceDate
   */
  public Date getInvoiceDate() {
    return (Date) getAttributeInternal(INVOICEDATE);
  }

  /**Sets <code>value</code> as attribute value for INVOICE_DATE using the alias name InvoiceDate
   */
  public void setInvoiceDate(Date value) {
    setAttributeInternal(INVOICEDATE, value);
  }

  /**Gets the attribute value for CUSTOMER_NUM using the alias name CustomerNum
   */
  public String getCustomerNum() {
    return (String) getAttributeInternal(CUSTOMERNUM);
  }

  /**Sets <code>value</code> as attribute value for CUSTOMER_NUM using the alias name CustomerNum
   */
  public void setCustomerNum(String value) {
    setAttributeInternal(CUSTOMERNUM, value);
  }

  /**Gets the attribute value for CREATED_BY using the alias name CreatedBy
   */
  public Number getCreatedBy() {
    return (Number) getAttributeInternal(CREATEDBY);
  }

  /**Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy
   */
  public void setCreatedBy(Number value) {
    setAttributeInternal(CREATEDBY, value);
  }

  /**Gets the attribute value for CREATION_DATE using the alias name CreationDate
   */
  public Date getCreationDate() {
    return (Date) getAttributeInternal(CREATIONDATE);
  }

  /**Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate
   */
  public void setCreationDate(Date value) {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy
   */
  public Number getLastUpdatedBy() {
    return (Number) getAttributeInternal(LASTUPDATEDBY);
  }

  /**Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy
   */
  public void setLastUpdatedBy(Number value) {
    setAttributeInternal(LASTUPDATEDBY, value);
  }

  /**Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate
   */
  public Date getLastUpdateDate() {
    return (Date) getAttributeInternal(LASTUPDATEDATE);
  }

  /**Sets <code>value</code> as attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate
   */
  public void setLastUpdateDate(Date value) {
    setAttributeInternal(LASTUPDATEDATE, value);
  }

  /**Gets the attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin
   */
  public Number getLastUpdateLogin() {
    return (Number) getAttributeInternal(LASTUPDATELOGIN);
  }

  /**Sets <code>value</code> as attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin
   */
  public void setLastUpdateLogin(Number value) {
    setAttributeInternal(LASTUPDATELOGIN, value);
  }

  /**Gets the associated <code>RowIterator</code> using master-detail link RestInvoiceLinesVO
   */
  public RowIterator getRestInvoiceLinesVO() {
    return (RowIterator)getAttributeInternal(RESTINVOICELINESVO);
  }

  /**getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, 
                                         AttributeDefImpl attrDef) throws Exception {
    switch (index) {
    case INVOICEID:
      return getInvoiceId();
    case INVOICENUM:
      return getInvoiceNum();
    case INVOICEDATE:
      return getInvoiceDate();
    case CUSTOMERNUM:
      return getCustomerNum();
    case CREATEDBY:
      return getCreatedBy();
    case CREATIONDATE:
      return getCreationDate();
    case LASTUPDATEDBY:
      return getLastUpdatedBy();
    case LASTUPDATEDATE:
      return getLastUpdateDate();
    case LASTUPDATELOGIN:
      return getLastUpdateLogin();
    case RESTINVOICELINESVO:
      return getRestInvoiceLinesVO();
    default:
      return super.getAttrInvokeAccessor(index, attrDef);
    }
  }

  /**setAttrInvokeAccessor: generated method. Do not modify.
   */
  protected void setAttrInvokeAccessor(int index, Object value, 
                                       AttributeDefImpl attrDef) throws Exception {
    switch (index) {
    case INVOICEID:
      setInvoiceId((Number)value);
      return;
    case INVOICENUM:
      setInvoiceNum((String)value);
      return;
    case INVOICEDATE:
      setInvoiceDate((Date)value);
      return;
    case CUSTOMERNUM:
      setCustomerNum((String)value);
      return;
    case CREATEDBY:
      setCreatedBy((Number)value);
      return;
    case CREATIONDATE:
      setCreationDate((Date)value);
      return;
    case LASTUPDATEDBY:
      setLastUpdatedBy((Number)value);
      return;
    case LASTUPDATEDATE:
      setLastUpdateDate((Date)value);
      return;
    case LASTUPDATELOGIN:
      setLastUpdateLogin((Number)value);
      return;
    default:
      super.setAttrInvokeAccessor(index, value, attrDef);
      return;
    }
  }
}
