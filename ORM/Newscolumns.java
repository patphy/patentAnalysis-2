package com.patent.ORM;

/**������Ŀ�ĳ־û���*/
public class Newscolumns implements java.io.Serializable{

	private Integer id;  //ID��
	private Newscolumns newscolumns;  //����Ŀ
	private String columnCode;  //������Ŀ���
	private String columnName;  //������Ŀ����
	
	public Newscolumns(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Newscolumns getNewscolumns() {
		return newscolumns;
	}

	public void setNewscolumns(Newscolumns newscolumns) {
		this.newscolumns = newscolumns;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	
	
}
