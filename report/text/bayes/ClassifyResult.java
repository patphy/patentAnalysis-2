package com.report.text.bayes;

/**
 * ������
 */
public class ClassifyResult {
	public float probility;// ����ĸ���
	public String classification;// ����

	public ClassifyResult(String c, float p) {
		this.probility = p;
		this.classification = c;
	}
}
