package com.report.text.bayes;

/**
* ������ʼ���
* <h3>������ʼ���</h3>
* P(c<sub>j</sub>)=N(C=c<sub>j</sub>)<b>/</b>N <br>
* ���У�N(C=c<sub>j</sub>)��ʾ���c<sub>j</sub>�е�ѵ���ı�������
* N��ʾѵ���ı�����������
*/

public class PriorProbability 
{
	private static TrainingData trainingData=TrainingData.getInstance();//ѵ����������

	/**
	* �������
	* @param c �����ķ���
	* @return ���������µ��������
	*/
	public static float calculatePc(String c)
	{
		float Nc = trainingData.getClassDocNum(c);//���������ѵ���ı���
		float N = trainingData.getTotalNum();//ѵ�������ı�����
		return (Nc / N);
	}
}