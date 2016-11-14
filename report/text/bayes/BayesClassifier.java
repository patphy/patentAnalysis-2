package com.report.text.bayes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * ���ر�Ҷ˹������
 */
public class BayesClassifier {
	private TrainingData tdm;// ѵ����������
	private static FMMSegment spliter = new FMMSegment();

	// private String trainnigDataPath;//ѵ����·��
	// private static double zoomFactor = 10.0f;
	/**
	 * Ĭ�ϵĹ���������ʼ��ѵ����
	 */
	public BayesClassifier() {
		tdm = new TrainingData();
	}

	/**
	 * ����������ı���������X�ڸ����ķ���Cj�е����������� <code>ClassConditionalProbability</code>����ֵ
	 * 
	 * @param d
	 *            �������ı���������
	 * @param Cj
	 *            ���������
	 * @return ����������������ֵ����<br>
	 */
	float calcProd(String[] d, String Cj) {
		float ret = 0.0F;
		// ��������������
		for (int i = 0; i < d.length; i++) {
			String wi = d[i];
			// ��Ϊ�����С�����������֮ǰȡ������������ս������Ӱ�죬��Ϊ����ֻ�ǱȽϸ��ʴ�С����
			ret += Math.log(ClassConditionalProbability.calculatePwc(wi, Cj));
		}
		// �ٳ����������
		ret += Math.log(PriorProbability.calculatePc(Cj));
		return ret;
	}

	/**
	 * ȥ��ͣ�ô�
	 * 
	 * @param text
	 *            �������ı�
	 * @return ȥͣ�ôʺ���
	 */
	public String[] dropStopWords(String[] oldWords) {
		Vector<String> v1 = new Vector<String>();
		for (int i = 0; i < oldWords.length; ++i) {
			if (StopWordsHandler.IsStopWord(oldWords[i]) == false) {// ����ͣ�ô�
				v1.add(oldWords[i]);
			}
		}
		String[] newWords = new String[v1.size()];
		v1.toArray(newWords);
		return newWords;
	}

	/**
	 * �Ը������ı����з���
	 * 
	 * @param text
	 *            �������ı�
	 * @return ������
	 */
	public String classify(String text) {
		System.out.println("----------��ʼ�ж�-----------------");
		String[] terms = spliter.split(text);// ���ķִʴ���(�ִʺ������ܻ�������ͣ�ôʣ�
		terms = dropStopWords(terms);// ȥ��ͣ�ôʣ�����Ӱ�����

		String[] classes = tdm.getTraningClassifications();// �������е�����
		float probility = 0.0F;
		List<ClassifyResult> crs = new ArrayList<ClassifyResult>();// ������
		for (int i = 0; i < classes.length; i++) {
			String ci = classes[i];// ��i������
			probility = calcProd(terms, ci);// ����������ı���������terms�ڸ����ķ���Ci�еķ�����������
			// ���������
			ClassifyResult cr = new ClassifyResult(ci, probility);
			// System.out.println(Ci + "��" + probility);
			crs.add(cr);
		}

		// ���ظ������ķ���
		float maxPro = crs.get(0).probility;
		String c = crs.get(0).classification;
		for (ClassifyResult cr : crs) {
			if (cr.probility > maxPro) {
				c = cr.classification;
				maxPro = cr.probility;
			}
		}
		System.out.println("------------------�жϳɹ�--------------------------");
		return c;
	}

	public static void main(String[] args) throws IOException {
		String text = "΢��˾�����446����Ԫ�ļ۸��չ��Ż��й���2��1�ձ��� ��������Ϣ��΢��˾�����446����Ԫ�ֽ�ӹ�Ʊ�ļ۸��չ�������վ�Ż���˾��΢�������ÿ��31��Ԫ�ļ۸��չ��Ż���΢����չ����۽��Ż�1��31�յ����̼�19.18��Ԫ���62%��΢��˾���Ż���˾�Ĺɶ�����ѡ�����ֽ���Ʊ���н��ס�΢����Ż���˾��2006��׺�2007�������Ѱ��˫���������������꣬�Ż�һֱ�����������г��ݶ��»�����Ӫҵ�����ѡ��ɼ۴���µ���������ͼ�ڻ������г�������Ϊ��΢����˵���չ��Ż�������һ���ݾ�����Ϊ˫�����зǳ�ǿ�Ļ����ԡ�(С��)";
		BayesClassifier classifier = new BayesClassifier();// ����Bayes������
		String result = classifier.classify(text);// ���з���
		System.out.println("��������[" + result + "]");
		
		
	}
	
	
}