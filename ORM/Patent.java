package com.patent.ORM;

public class Patent implements java.io.Serializable{

	private Integer id;                  //ר��id
	private String applicationNo;    //�����
	private String patentName;       //ר������
	private String applicationDate;  //ר����������
	private String lawState;         //����״̬
	private String MIPC;             //�������
	private String IPC;              //�����
	private String applicant;        //������
	private String inventor;         //������
	private String publicNumber;     //������
	private String publicDate;       //��������
	private String agentORG;         //������֯
	private String address;          //��ַ
	private String priority;         //����Ȩ
	private String provinceCode;     //ʡ�����
	private String abs;              //ժҪ
	private String mainClaim;        //��Ȩ����
	
	
	public Patent(){
		
	}
	
	public Patent(String applicationNo, String patentName, String IPC, String address){
		
		this.applicationNo = applicationNo;
		this.patentName = patentName;
		this.IPC = IPC;
		this.address = address;
	}
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getPatentName() {
		return patentName;
	}

	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getLawState() {
		return lawState;
	}

	public void setLawState(String lawState) {
		this.lawState = lawState;
	}

	public String getMIPC() {
		return MIPC;
	}

	public void setMIPC(String mIPC) {
		MIPC = mIPC;
	}

	public String getIPC() {
		return IPC;
	}

	public void setIPC(String iPC) {
		IPC = iPC;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getInventor() {
		return inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	public String getPublicNumber() {
		return publicNumber;
	}

	public void setPublicNumber(String publicNumber) {
		this.publicNumber = publicNumber;
	}

	public String getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	public String getAgentORG() {
		return agentORG;
	}

	public void setAgentORG(String agentORG) {
		this.agentORG = agentORG;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public String getMainClaim() {
		return mainClaim;
	}

	public void setMainClaim(String mainClaim) {
		this.mainClaim = mainClaim;
	}
	
	
	
}
