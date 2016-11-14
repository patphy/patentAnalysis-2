package com.report.textrank;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dependency.nnparser.util.math;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;

/**
 * TextRank �Զ�ժҪ
 * @author M.Line
 *
 */
public class TextRankSummary {

	/**
	 * ����ϵ��(DampingFactor)��һ��ȡΪ0.85f
	 */
	final double d = 0.85f;
	
	/**
	 * ����������
	 */
	final int max_iter = 200;
	final double min_diff = 0.001f;
	
	/**
	 * �ĵ����ӵĸ���
	 */
	int D;
	
	/**
	 * ���Ϊ[����[����]]��ʽ���ĵ�
	 */
	List<List<String>> docs;
	
	/**
	 * ���������ս��
	 */
	TreeMap<Double, Integer> top;
	
	/**
	 * ���Ӻ��������ӵ���س̶�
	 */
	double[][] weight;
	
	/**
	 * �þ��Ӻ�����������س̶�ֻ��
	 */
	double[] weight_sum;
	
	/**
	 * ����֮��������Ȩ��
	 */
	double[] vertex;
	
	/**
	 * BM25���ƶ�
	 */
	
	BM25 bm25;
	public TextRankSummary(List<List<String>> docs)
	{
		this.docs = docs;
		bm25 = new BM25(docs);
		D = docs.size();
		weight = new double[D][D];
		weight_sum = new double[D];
		vertex = new double[D];
		top = new TreeMap<Double, Integer>(Collections.reverseOrder());
		solve();
		
	}
	
	private void solve()
	{
		int cnt = 0;
		for(List<String> sentence : docs)
		{
			double[] scores = bm25.simAll(sentence);
			weight[cnt] = scores;
			weight_sum[cnt] = sum(scores) - scores[cnt];
			vertex[cnt] = 1.0;
			++cnt;
		}
		
		for(int _ = 0; _ < max_iter; ++_)
		{
			double[] m = new double[D];
			double max_diff = 0;
			for(int i = 0;i < D; i++)
			{
				m[i] = 1-d;
				for(int j = 0; j < D; ++j)
				{
					if(j == i || weight_sum[j] == 0) continue;
					m[i] += (d * weight[j][i] / weight_sum[j] * vertex[j]);
				}
				double diff = Math.abs(m[i] - vertex[i]);
				if(diff > max_diff)
				{
					max_diff = diff;
				}
			}
			vertex = m;
			if(max_diff <= min_diff) break;
		}
		//����������
		for(int i = 0; i < D; i++)
		{
			top.put(vertex[i], i);
		}
	}
	
	
	/**
	 * ��ȡ�����ؼ���
	 * @param size ����
	 * @return  ���عؼ����ӵ��±�
	 */
	public int[] getTopSentence(int size)
	{
		Collection<Integer> values = top.values();
		size = Math.min(size, values.size());
		int[] indexArray = new int[size];
		Iterator<Integer> it = values.iterator();
		for(int i = 0; i < size; i++)
		{
			indexArray[i] = it.next();
		}
		return indexArray;
	}
	
	/**
	 * �򵥵����
	 * @param array
	 * @return
	 */
	private static double sum(double[] array)
	{
		double total = 0;
		for(double v : array)
		{
			total += v;
		}
		return total;
	}
	
	/**
	 * �����·ָ�Ϊ����
	 * @param document
	 * @return
	 */
	static List<String> splitSentence(String document)
	{
		List<String> sentences = new ArrayList<String>();
		if(document == null) return sentences;
		for(String line : document.split("[\r\n]"))
		{
			line = line.trim();
			if(line.length() == 0)
				continue;
			for(String sent : line.split("[��,��:��������?��!��;]"))
			{
				sent = sent.trim();
				if(sent.length() == 0)
					continue;
				sentences.add(sent);
			}
		}
		return sentences;
	}
	
	/**
	 * �Ƿ�Ӧ�������term������㣬�����������ʣ����ʣ����ʣ����ݴ�
	 * @param term
	 * @return
	 */
	public static boolean shouldInclude(Term term)
	{
		return CoreStopWordDictionary.shouldInclude(term);
	}
	
	/**
	 * һ�仰���ýӿ�
	 * @param document Ŀ���ĵ�
	 * @param size  ��Ҫ�Ĺؼ���ĸ���   
	 * @return �ؼ����б�
	 */
	public static List<String> getTopSentenceList(String document, int size)
	{
		List<String> sententceList = splitSentence(document);
		List<List<String>> docs = new ArrayList<List<String>>();
		for(String sentence : sententceList)
		{
			List<Term> termList = HanLP.segment(sentence);
			List<String> wordList = new LinkedList<String>();
			for(Term term : termList)
			{
				if(shouldInclude(term)){
					wordList.add(term.word);
				}
			}
			docs.add(wordList);
		}
		
		TextRankSummary textRankSummary = new TextRankSummary(docs);
		int[] topSentence = textRankSummary.getTopSentence(size);
		List<String> resultList = new LinkedList<String>();
		
		for(int i : topSentence)
		{
			resultList.add(sententceList.get(i));
		}
		return resultList;
		
	}
	
	public static void main(String[] args){
		 String document = "�㷨�ɴ��·�Ϊ�����㷨�����ݽṹ���㷨�������㷨�����㼸�ε��㷨��ͼ���㷨����̬�滮�Լ���ֵ�����������㷨�������㷨�������㷨��������㷨�������㷨�����ױ���ģ�͡����ɭ���㷨��\n" +
	                "�㷨���Կ��ķ�Ϊ���࣬\n" +
	                "һ�����޵�ȷ�����㷨�������㷨�����޵�һ��ʱ������ֹ�����ǿ���Ҫ���ܳ�ʱ����ִ��ָ�������񣬵��Խ���һ����ʱ������ֹ�������㷨�ó��Ľ����ȡ��������ֵ��\n" +
	                "�������޵ķ�ȷ���㷨�������㷨�����޵�ʱ������ֹ��Ȼ��������һ������һЩ����������ֵ���㷨�Ľ��������Ψһ�Ļ�ȷ���ġ�\n" +
	                "�������޵��㷨������Щ����û�ж�����ֹ��������������������޷���������������������ֹ���е��㷨��ͨ���������㷨�Ĳ���������δ��ȷ���Ķ�����ֹ������";
	        System.out.println(TextRankSummary.getTopSentenceList(document, 3));
	}
	
}