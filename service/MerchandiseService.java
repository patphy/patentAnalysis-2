package com.patent.service;

import java.util.List;
import com.patent.ORM.Merchandise;

/** ��Ʒ����ҵ���߼��ӿ� */
public interface MerchandiseService {
	/** �����Ʒ */
	public List<Merchandise> browseMerchandise();
	/** װ��ָ������Ʒ */	
	public Merchandise loadMerchandise(Integer id);	
	/** ɾ��ָ������Ʒ */	
	public boolean delMerchandise(Integer id);	
	/** �������޸���Ʒ */
	public boolean saveOrUpdateMerchandise(Merchandise merchandise);
}
