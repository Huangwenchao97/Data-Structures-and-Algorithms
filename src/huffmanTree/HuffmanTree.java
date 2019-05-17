package huffmanTree;

import java.util.ArrayList;

public class HuffmanTree {
	// 根节点
	private Node<Character> root ;
	
	/**
	 * .构造器
	 * .1.从arrayList nodes中取出两个权值最小的结点min1和min2，并将两个结点从nodes中删除。
	 * .2.当nodes里的结点大于一个时，循环：
	 * .	2.1.创建一个值位'#'的新结点，将它设为min1和min2的父节点，然后将该父节点加入nodes, 值为'#'表示该结点是新生成用来连接结点的辅助结点
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
	 * .获取nodes里权值最小的node结点,并将其从arrayList里删除
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
		public int weight;		// 权值
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
