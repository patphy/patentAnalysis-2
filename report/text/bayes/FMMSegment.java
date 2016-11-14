package com.report.text.bayes;

import java.io.*;
import java.util.ArrayList;

public class FMMSegment {
	// ������һ��Dictionary���͵�ȫ�ֱ�����������������������Ҫ���ֵ䡣
	TernarySearchTrie dic = new TernarySearchTrie("SDIC.txt");

	public FMMSegment() {
	}

	public String[] split(String sentence)// ����һ���ַ�����ΪҪ����Ķ���
	{
		if(sentence==null){
			return null;
		}
		int senLen = sentence.length();// ���ȼ�����������仰���ַ�����
		
		int i = 0;// i����������ƥ�����ʼλ�õı���
		ArrayList<String> result = new ArrayList<String>(senLen);

		while (i < senLen)// ���iС�ڴ˾仰�ĳ��Ⱦͽ���ѭ��
		{
			String word = dic.matchLong(sentence, i);// ������󳤶�ƥ��
			if (word != null)// �Ѿ�ƥ����
			{
				// �´�ƥ����������֮��
				i += word.length();
				// ���������Ǵʿ��е���ô�ʹ�ӡ����
				// System.out.print(word + " ");
				result.add(word);
			} else// ���������������ķ�Χ��һֱ��û���ҵ�ƥ���ϵĴʣ��Ͱ������з�
			{
				word = sentence.substring(i, i + 1);
				// ��ӡһ����
				// System.out.print(word + " ");
				result.add(word);
				++i;// �´�ƥ���������ַ�֮��
			}
		}

		return result.toArray(new String[result.size()]);
	}

	public ArrayList<String> getWords(String sentence)// ����һ���ַ�����ΪҪ����Ķ���
	{
		int senLen = sentence.length();// ���ȼ�����������仰���ַ�����
		int i = 0;// i����������ƥ�����ʼλ�õı���
		ArrayList<String> result = new ArrayList<String>(senLen);

		while (i < senLen)// ���iС�ڴ˾仰�ĳ��Ⱦͽ���ѭ��
		{
			String word = dic.matchLong(sentence, i);// ������󳤶�ƥ��
			if (word != null)// �Ѿ�ƥ����
			{
				// �´�ƥ����������֮��
				i += word.length();
				// ���������Ǵʿ��е���ô�ʹ�ӡ����
				// System.out.print(word + " ");
				result.add(word);
			} else// ���������������ķ�Χ��һֱ��û���ҵ�ƥ���ϵĴʣ��Ͱ������з�
			{
				word = sentence.substring(i, i + 1);
				// ��ӡһ����
				// System.out.print(word + " ");
				result.add(word);
				++i;// �´�ƥ���������ַ�֮��
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		FMMSegment seg = new FMMSegment();

		String sentence = "��������ҵ��ѧ�����о���Ժ";
		String[] ret = seg.split(sentence);
		for (String word : ret) {
			System.out.print(word + " ");
			System.out.print(' ');
		}
		// long start = System.currentTimeMillis();
		// long end = System.currentTimeMillis();
		// System.out.print("time: "+(end - start));
	}
}
