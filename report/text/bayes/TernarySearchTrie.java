package com.report.text.bayes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TernarySearchTrie {

	private static TernarySearchTrie dic = null;

	/**
	 * 
	 * @return the singleton of basic dictionary
	 */
	public static TernarySearchTrie getInstance() {
		if (dic == null) {
			dic = new TernarySearchTrie("SDIC.txt");
		}
		return dic;
	}

	public final class TSTNode {
		public String data;

		protected TSTNode loNode;
		protected TSTNode eqNode;
		protected TSTNode hiNode;

		public char spliter;

		public TSTNode(char key) {
			this.spliter = key;
		}

		public String toString() {
			return "data  ��" + data + "   spliter��" + spliter;
		}
	}

	public TSTNode rootNode;

	public static void main(String[] args) {
		TernarySearchTrie dic = new TernarySearchTrie("SDIC.txt");

		String sentence = "��������ҵ��ѧ�������";
		int offset = 0;
		String ret = dic.matchLong(sentence, offset);
		System.out.println(sentence + " match:" + ret);
		// System.out.println(dic.rootNode.getPath());
	}

	public TernarySearchTrie(String str) {

		try {
			FileReader filereadnew = new FileReader(str);
			BufferedReader read = new BufferedReader(filereadnew);
			String temstr = "";
			try {
				while ((temstr = read.readLine()) != null) {
					TSTNode node = null;
					StringTokenizer st = new StringTokenizer(temstr, "\t");
					String key = st.nextToken();
					if (rootNode == null) {
						rootNode = new TSTNode(key.charAt(0));
					}
					int charIndex = 0;
					TSTNode currentNode = rootNode;
					while (true) {
						if (currentNode == null) {
							break;
						}
						int compa = (key.charAt(charIndex) - currentNode.spliter);
						if (compa == 0) {
							charIndex++;
							if (charIndex == key.length()) {
								node = currentNode;
								break;
							}
							currentNode = currentNode.eqNode;
						} else if (compa < 0) {
							currentNode = currentNode.loNode;
						} else {
							currentNode = currentNode.hiNode;
						}
					}
					if (node == null) {
						currentNode = creatTSTNode(key);
						currentNode.data = key;
						// System.out.println(currentNode);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ���ݸýڵ�Ļ�ȡ��ýڵ�ͬ�������нڵ�
	public ArrayList<TSTNode> getEqNodes(TSTNode tstNode) {
		ArrayList<TSTNode> childNodes = new ArrayList<TSTNode>();
		if (tstNode != null) {
			ArrayList<TSTNode> nodes = new ArrayList<TSTNode>();
			nodes.add(tstNode);// ��ӽڵ�
			childNodes = nodes;
			while (true) {
				ArrayList<TSTNode> newlist = new ArrayList<TSTNode>();
				for (TSTNode node : nodes) {
					if (node.loNode != null) {
						newlist.add(node.loNode);// �����ڵ�
					}
					if (node.hiNode != null) {
						newlist.add(node.hiNode);// ����ҽڵ�
					}
				}
				nodes = newlist;
				if (newlist.size() == 0) {
					return childNodes;
				}
				childNodes.addAll(nodes);
			}
		}
		return childNodes;
	}

	// ����һ�����
	public TSTNode creatTSTNode(String key) throws NullPointerException,
			IllegalArgumentException {
		if (key == null) {
			throw new NullPointerException("��ָ���쳣");
		}
		int charIndex = 0;
		TSTNode currentNode = rootNode;
		if (rootNode == null) {
			rootNode = new TSTNode(key.charAt(0));
		}
		while (true) {
			int compa = (key.charAt(charIndex) - currentNode.spliter);
			if (compa == 0) {
				charIndex++;
				if (charIndex == key.length()) {
					return currentNode;
				}
				if (currentNode.eqNode == null) {
					currentNode.eqNode = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.eqNode;
			} else if (compa < 0) {
				if (currentNode.loNode == null) {
					currentNode.loNode = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.loNode;
			} else {
				if (currentNode.hiNode == null) {
					currentNode.hiNode = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.hiNode;
			}
		}
	}

	public String matchLong(String key, int offset) {
		String ret = null;
		if (key == null || rootNode == null || "".equals(key)) {
			return ret;
		}
		TSTNode currentNode = rootNode;
		int charIndex = offset;
		while (true) {
			if (currentNode == null) {
				return ret;
			}
			int charComp = key.charAt(charIndex) - currentNode.spliter;

			if (charComp == 0) {
				charIndex++;

				if (currentNode.data != null) {
					ret = currentNode.data; // ��ѡ�ƥ���
				}
				if (charIndex == key.length()) {
					return ret; // �Ѿ�ƥ����
				}
				currentNode = currentNode.eqNode;
			} else if (charComp < 0) {
				currentNode = currentNode.loNode;
			} else {
				currentNode = currentNode.hiNode;
			}
		}
	}
}
