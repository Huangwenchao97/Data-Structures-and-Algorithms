package binaryTree;

import java.util.Stack;

public class BinaryTree<T> {

	// ���ڵ�
	private TreeNode<T> root = null;
	// �������зǵݹ������ջ
	private Stack<TreeNode<T>> stack = new Stack<>();
	/**
	 *.������
	 * @param arr �����ȫ���������н����Ϣ�����飬 ���ð�����洢��ֵnull��ʾ�ýڵ㲻���ڡ�
	 *  .��{A, B, C, D, E, null, F}��ʾ
	 * 			   A
	 * 		B		      C
	 * 	D		E	  			F
	 */
	public BinaryTree(T[] nodes) {
		root = createBinaryTree(nodes, 0, nodes.length);
	}
	
	private TreeNode<T> createBinaryTree(T[] nodes, int i, int length) {
		// ��nodesΪ������
		if(nodes.length == 0)
			return null;
		// ��ΪҶ�ӽڵ�, ����nodes[i]ֵΪnull
		// nodes[i]ֵΪnull��ʾ�ýڵ㲻����
		if(i >= length || nodes[i] == null) {
			return null;
		}
		TreeNode<T> subRoot = new TreeNode<T>(i, nodes[i]);
		subRoot.setLeftChild(createBinaryTree(nodes, 2*i+1, length));
		subRoot.setRightChild(createBinaryTree(nodes, 2*i+2, length));
		return subRoot;
	}

	/**
	 * .��ȡ���ڵ�
	 * @return root
	 */
	public TreeNode<T> getRoot(){
		return root;
	}
	
	/**
	 * .��ȡ���Ľ����
	 * @param node
	 * @return
	 */
	public int getSize() {
		return getSize(root);
	}
	private int getSize(TreeNode<T> node) {
		if(node == null) {
			return 0;
		} else {
			return getSize(node.getLeftChild()) + getSize(node.getRightChild()) + 1;
		}
	}
	
	/**
	 *.��ȡ�������
	 *.1.�������Ľ�����size, ͨ����ʽdeep = log2(n) + 1 
	 *.2.���õݹ�,����ʹ���������
	 */
	public int getDeep() {
		return getDeep(root);
	}
	private int getDeep(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return 0;
		} else {
			int left = getDeep(node.getLeftChild());
			int right = getDeep(node.getRightChild());
			return (left>right) ? (left+1) : (right+1);
		}
	}
	
	/**
	 * .�ݹ��ǰ�����
	 * @param node
	 */
	public void recProTraverse() {
		System.out.println("------------------�ݹ�ǰ�����--------------------------");
		recProTraverse(root);
		System.out.print("\n");
	}
	private void recProTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			System.out.print(node.getData() + "\t");
			recProTraverse(node.getLeftChild());
			recProTraverse(node.getRightChild());
		}
	}
	
	/**
	 * .�ǵݹ��ǰ�����,����ջ��������ʵ��,��������
	 * .1.�������ѹ��ջ
	 * .2.ѭ���жϣ���ջ��Ϊ�գ�
	 * .  2.1.���ڵ��ջ
	 * .  2.2.���������ӽ�㣬�����ӽ��ѹ��ջ
	 * .  2.3.���������ӽڵ㣬�����ӽ��ѹ��ջ
	 * @param node
	 */
	public void nonRecProTraverse(TreeNode<T> node) {
		System.out.println("------------------�ǵݹ�ǰ�����--------------------------");
		if(node == null)
			return;
		TreeNode<T> tmp;
		stack.push(node);
		TreeNode<T> leftChild, rightChild;
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			System.out.print(tmp.getData() + "\t");
			if((rightChild = tmp.getRightChild()) != null)
				stack.push(rightChild);
			if((leftChild = tmp.getLeftChild()) != null)
				stack.push(leftChild);
		}
		System.out.print("\n");
	}
	

	/**
	 * .�ݹ���������
	 * @param node
	 */
	public void recInorderTraverse() {
		System.out.println("------------------�ݹ��������--------------------------");
		recInorderTraverse(root);
		System.out.print("\n");
	}
	private void recInorderTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			recInorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + "\t");
			recInorderTraverse(node.getRightChild());
		}
	}
	
	/**
	 *. �ǵݹ���������, �������£�
	 *.1.ѭ���ж�(��ջΪ����nodeΪ�գ���ʾ�Ѿ�������)
	 *.  1.1.�����ڵ㲻Ϊ�գ��򽫸����ѹ��ջ�������жϸ��ڵ�����ӽڵ�
	 *.  1.2.�����ڵ�Ϊ�գ���ʾ�ý��û�����ӽڵ㣬�����ջ�������ж������ӽڵ�
	 *.  ע����1.2�еĸ��������ӽ��Ϊ�գ���Ӧ����ø����ĸ���㣬���жϸø���㸸�������ӽ�㡣����ʱջ�����Ǹø����ĸ���㣬���Խ����ջ���ж����ҽ��
	 */
	public void nonRecInorderTraverse(TreeNode<T> node) {
		System.out.println("------------------�ǵݹ��������--------------------------");
		TreeNode<T> tmp;
		while(!stack.isEmpty() || node != null) {
			if(node != null) {
				stack.push(node);
				node = node.getLeftChild();
			} else {
				tmp = stack.pop();
				System.out.print(tmp.getData() + "\t");
				node = tmp.getRightChild();
			}
		}
		System.out.print("\n");
	}
	

	/**
	 * .�ݹ�ĺ������
	 * @param node
	 */
	public void recPostorderTraverse() {
		System.out.println("------------------�ݹ�������--------------------------");
		recPostorderTraverse(root);
		System.out.print("\n");
	}
	private void recPostorderTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			recPostorderTraverse(node.getLeftChild());
			recPostorderTraverse(node.getRightChild());
			System.out.print(node.getData() + "\t");
		}
	}
	
	/**
	 *. �ǵݹ�ĺ������
	 */
	public void nonRecPostorderTraverse(TreeNode<T> node) {
		System.out.println("------------------�ǵݹ�������--------------------------");
		if(node == null) {
			return;
		}
		TreeNode<T> tmp = node;
		TreeNode<T> lastAccess = null;
		while(!stack.isEmpty() || tmp != null) {
			while(tmp != null) {
				stack.push(tmp);
				tmp = tmp.getLeftChild();
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				if(node.getRightChild() == null || node.getRightChild() == lastAccess) {
					System.out.print(node.getData() + "\t");
					lastAccess = node;
				} else {
					stack.push(node);
					tmp = node.getRightChild();
				}
			}
		}
		System.out.print("\n");
	}

	/**
	 * .�����
	 * @author asus
	 *
	 * @param <T>
	 */
	public static class TreeNode<T>{
		private int index;
		private T data;
		private TreeNode<T> leftChild;
		private TreeNode<T> rightChild;
		
		public TreeNode(int index, T data) {
			 this.index = index;
			 this.data = data;
			 this.leftChild = null;
			 this.rightChild = null;
		}
		
		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public TreeNode<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}
	}

}
