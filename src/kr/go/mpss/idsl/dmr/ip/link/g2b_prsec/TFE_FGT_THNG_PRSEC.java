package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data
@XmlRootElement(name = "TFE_FGT_THNG_PRSEC")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlCustomizer(NullCustomizer.class)
@Entity
@IdClass(TFE_FGT_THNG_PRSEC_ID.class)
public class TFE_FGT_THNG_PRSEC {
	@Id
	@XmlElement(name="Acceptance.Number.Text")
	private String psexam_no;
	
	@Id
	@XmlElement(name="Inspection.Organization.Identifier")
	private String prsec_org;
	
	@XmlElement(name="Inspection.Organization.Name")
	private String prsec_org_nm;
	
	@XmlElement(name="Inspection.RequestNumber.Text")
	private String prsec_req_no;
	
	@XmlElement(name="Contract.Number.Text")
	private String cntrct_no;
	
	@XmlElement(name="Contract.SequenceNumber.Value")
	private String cntrct_sn;
	
	@XmlElement(name="Delivery.RequestNumber.Text")
	private String suply_dmd_no;
	
	@XmlElement(name="Item.Classification.Identifier")
	private String thng_cl_no;
	
	@XmlElement(name="Item.Name")
	private String thng_cl_mn;
	
	@XmlElement(name="Item.Identifier")
	private String thng_idntfc_no;
	
	@XmlElement(name="Item.Description.Text")
	private String thng_idntfc_nm;
	
	@XmlElement(name="Company.Organization.Identifier")
	private String bsnm_regist_no;
	
	@XmlElement(name="Company.Name")
	private String maker_nm;
	
	@XmlElement(name="Type.ApprovalNumber.Text")
	private String form_cfm_no;
	
	@XmlElement(name="Inspection.Employee.Name")
	private String prsec_nm;
	
	@XmlElement(name="Inspection.End.Date")
	private String fdrm_prsec_de;
	
	@XmlElement(name="Production.LotNumber.Text")
	private String prduct_lot_no;
	
	@XmlElement(name="Product.Validity.Indicator")
	private String prduct_valid_at;
}
