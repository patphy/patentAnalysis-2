package com.patent.service;

import java.util.List;

import com.patent.ORM.Patent;

/**ר��ҵ���߼��ӿ�*/
public interface PatentService {

	/**���ר��*/
	public List<Patent> browsePatent();
	/**װ��ָ��ר��*/
	public Patent loadPatent(Integer id);
	/**ɾ��ָ����ר��*/
	public boolean delPatent(Integer id);
	/**�������޸�ר��*/
	public boolean saveOrUpdatePatent(Patent patent);
	
}
