package com.patent.service;

import java.util.List;

import com.patent.DAO.BaseDAO;
import com.patent.ORM.Patent;

public class PatentServiceImpl implements PatentService {

	/**ͨ������ע��DAO���ʵ��**/
	BaseDAO dao;
	
	/**���ר��*/
	public List<Patent> browsePatent() {
		// TODO Auto-generated method stub
		return dao.listAll("Patent");
	}

	/**ɾ��ָ����ר��*/
	public boolean delPatent(Integer id) {
		// TODO Auto-generated method stub
		boolean status = false;
		try{
			dao.delById(Patent.class, id);
			status = true;
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return status;
	}

	/**����ĳ��ר��*/
	public Patent loadPatent(Integer id) {
		// TODO Auto-generated method stub
		return (Patent)dao.loadById(Patent.class, id);
	}

	public boolean saveOrUpdatePatent(Patent patent) {
		// TODO Auto-generated method stub
		boolean status = false;
		try{
			dao.saveOrUpdate(patent);
			status = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	
	

	
}
