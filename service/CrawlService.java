package com.patent.service;

import java.util.List;
import com.patent.ORM.Newsrule;

/** ���Ųɼ��������ҵ���߼��ӿ� */
public interface CrawlService {
	/** ������Ųɼ����� */
	public List<Newsrule> browseNewsrule();	
	/** װ��ָ�������Ųɼ����� */	
	public Newsrule loadNewsrule(Integer id);	
	/** ɾ��ָ�������Ųɼ����� */	
	public boolean delNewsrule(Integer id);	
	/** �������޸����Ųɼ����� */
	public boolean saveOrUpdateNewsrule(Newsrule rule);	
}
