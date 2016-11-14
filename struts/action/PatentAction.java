package com.patent.struts.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.patent.ORM.Patent;
import com.patent.service.PatentService;

@SuppressWarnings("serial")
public class PatentAction extends ActionSupport implements ModelDriven<Patent>{

	/**ͨ������ע��PatentService���ʵ��*/
	PatentService service;
	
	/**ר����Ϣ�����г��õĲ���*/
	private String actionMsg;  //Action�䴫�ݵ���Ϣ����
	public List<Patent> patentList;  //ר���б�
	
	//����ģ������
	private Patent model = new Patent();  //���ڷ�װϵͳר������ģ��
	
	public Patent getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**�������ר������*/
	public String browsePatent(){
		
		if(actionMsg!= null){
			try{
				actionMsg = new String(actionMsg.getBytes("ISO8859-1"),"gbk");
			}catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			addActionMessage(actionMsg);
		}
		patentList = service.browsePatent();
		return SUCCESS;		
	}
	
	/**�������ר������*/
	public String addPatent(){
		Patent tempPatent = new Patent();
		tempPatent.setAbs(model.getAbs());
		tempPatent.setAddress(model.getAddress());
		tempPatent.setAgentORG(model.getAgentORG());
		tempPatent.setApplicant(model.getApplicant());
		tempPatent.setApplicationDate(model.getApplicationDate());
		tempPatent.setApplicationNo(model.getApplicationNo());
		tempPatent.setInventor(model.getInventor());
		tempPatent.setIPC(model.getIPC());
		tempPatent.setLawState(model.getLawState());
		tempPatent.setMainClaim(model.getMainClaim());
		tempPatent.setMIPC(model.getMIPC());
		tempPatent.setPatentName(model.getPatentName());
		tempPatent.setPriority(model.getPriority());
		tempPatent.setProvinceCode(model.getProvinceCode());
		tempPatent.setPublicDate(model.getPublicDate());
		tempPatent.setPublicNumber(model.getPublicNumber());
		
		if(service.saveOrUpdatePatent(tempPatent)){
			addActionMessage(getText("patent_add_succ"));
		}else{
			addActionMessage(getText("patent_add_fail"));
		}
		
		return SUCCESS;
	}
	
	/**����ɾ��ר������*/
	public String delPatent(){
		if(model.getId()!=null){
			if(service.delPatent(model.getId())){
				actionMsg = getText("patent_del_succ");
			}else{
				actionMsg = getText("patent_del_fail");
			}
			
		}else{
			actionMsg = getText("patent_del_fail");
		}
		return "toBrowsePatent";
	}
	
	/**�������ר������*/
	public String updatePatent(){
		Patent tempPatent = service.loadPatent(model.getId());
		tempPatent.setAbs(model.getAbs());
		tempPatent.setMainClaim(model.getMainClaim());
		if(service.saveOrUpdatePatent(tempPatent)){
			addActionMessage(getText("patent_edit_succ"));
		}else{
			addActionMessage(getText("patent_edit_fail"));
		}
		return INPUT;
		
	}
	
}
