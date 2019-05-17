package huffmanTree;

import java.util.ArrayList;

import huffmanTree.HuffmanTree.Node;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<Node<Character>> nodes = new ArrayList<Node<Character>>();
		nodes.add(new Node<Character>(27, 'A'));
		nodes.add(new Node<Character>(8, 'B'));
		nodes.add(new Node<Character>(15, 'C'));
		nodes.add(new Node<Character>(15, 'D'));
		nodes.add(new Node<Character>(30, 'E'));
		nodes.add(new Node<Character>(5, 'F'));
		
		HuffmanTree tree = new HuffmanTree(nodes);
		Node<Character> root = tree.getRoot();
		
		// ≤‚ ‘”√µƒ
		System.out.println(root.leftChild.leftChild.data);
		System.out.println(root.leftChild.rightChild.data);
		System.out.println(root.rightChild.rightChild.data);
		System.out.println(root.rightChild.leftChild.rightChild.data);
		System.out.println(root.rightChild.leftChild.rightChild.data);
		System.out.println(root.rightChild.leftChild.leftChild.leftChild.data);
		System.out.println(root.rightChild.leftChild.leftChild.rightChild.data);
	}
}
