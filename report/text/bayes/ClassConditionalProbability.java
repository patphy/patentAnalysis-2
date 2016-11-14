package com.report.text.bayes;

/**
 * <b>��</b>�������ʼ���
 *
 * <h3>����������</h3> P(x<sub>j</sub>|c<sub>j</sub>)=( N(X=x<sub>i</sub>, C=c<sub>j
 * </sub>)+1 ) <b>/</b> ( N(C=c<sub>j</sub>)+M+V ) <br>
 * ���У�N(X=x<sub>i</sub>, C=c<sub>j</sub>����ʾ���c<sub>j</sub>�а�������x<sub>
 * i</sub>��ѵ���ı�������N(C=c<sub>j</sub>)��ʾ���c<sub>j</sub>�е�ѵ���ı�������Mֵ���ڱ���
 * N(X=x<sub>i</sub>, C=c<sub>j</sub>����С�����������⣻V��ʾ����������
 *
 * <h3>��������</h3> <b>����</b> ��A, B�������¼�����P(A)>0 ��<br>
 * <tt>P(B�OA)=P(AB)/P(A)</tt><br>
 * Ϊ������A�·����������¼�B�������������ʡ�
 */

public class ClassConditionalProbability {
	private static TrainingData tdm = new TrainingData();
	private static final float M = 0F;

	/**
	 * ��������������
	 * 
	 * @param w
	 *            �����Ĵ�
	 * @param c
	 *            �����ķ���
	 * @return ���������µ�����������
	 */
	public static float calculatePwc(String w, String c) {
		// ���ظ��������а������������ʵ�ѵ���ı�����Ŀ
		float dfwc = tdm.getCountContainKeyOfClassification(c, w);
		// ����ѵ���ı������ڸ��������µ�ѵ���ı���Ŀ
		float Nc = tdm.getClassDocNum(c);
		// �������
		float V = tdm.getTraningClassifications().length;
		return ((dfwc + 1) / (Nc + M + V));
	}
}
