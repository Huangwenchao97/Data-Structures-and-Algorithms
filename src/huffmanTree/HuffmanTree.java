package huffmanTree;

import java.util.ArrayList;

public class HuffmanTree {
	// ���ڵ�
	private Node<Character> root ;
	
	/**
	 * .������
	 * .1.��arrayList nodes��ȡ������Ȩֵ��С�Ľ��min1��min2��������������nodes��ɾ����
	 * .2.��nodes��Ľ�����һ��ʱ��ѭ����
	 * .	2.1.����һ��ֵλ'#'���½�㣬������Ϊmin1��min2�ĸ��ڵ㣬Ȼ�󽫸ø��ڵ����nodes, ֵΪ'#'��ʾ�ý�����������������ӽ��ĸ������
	 * @param nodes
	 */
	public HuffmanTree(ArrayList<Node<Character>> nodes) {
		if(nodes.isEmpty()) {
			return;
		}
		Node<Character> min1, min2, parents;
		int weightSum = 0;
		while(nodes.size() != 1) {
			min1 = getMin(nodes);
			min2 = getMin(nodes);
			weightSum = min1.weight + min2.weight;
			parents = new Node<Character>(weightSum, '#');
			parents.leftChild = min1;
			parents.rightChild = min2;
			nodes.add(parents);
		}
		if(nodes.size() == 1) {
			root = nodes.get(0);
		}
	}
	
	/**
	 * .��ȡnodes��Ȩֵ��С��node���,�������arrayList��ɾ��
	 * @param nodes
	 * @return
	 */
	public Node<Character> getMin(ArrayList<Node<Character>> nodes){
		if (nodes.isEmpty())
			return null;
		Node<Character> min = nodes.get(0);
		for(int i=0; i<nodes.size(); i++) {
			Node<Character> tmp = nodes.get(i);
			if(min.weight > tmp.weight) {
				min = tmp;
			}
		}
		nodes.remove(min);
		return min;
	}
	
	public Node<Character> getRoot(){
		return root;
	}
	
	@SuppressWarnings("hiding")
	public static class Node<Character>{
		public int weight;		// Ȩֵ
		public char data;
		public Node<Character> leftChild;
		public Node<Character> rightChild;
		
		public Node(int weight, char data){
			this.weight = weight;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
}
