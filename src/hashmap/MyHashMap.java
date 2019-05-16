package hashmap;

// δ�����

public class MyHashMap<K, V>{

	// Ĭ�ϳ�ʼ����
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	// Ĭ����ֵ����
	private static final float DEFAULT_LOAD_FACTOR = 0.75F;
	
	private static final int MAXIMUM_CAPACITY = 1 << 30;
	// ����Node����
	int size;
	
	// ����
	Node<K, V>[] table = null;
	
	// �洢��һ����Ҫ���ݵ�sizeֵ��
	int threshold;
	
	// ��ֵ����
	final float loadFactor;
	
	//���캯��
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	public MyHashMap(int initialCapacity, float loadFactor) {
		if(initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
		}
		if(loadFactor <= 0 || Float.isNaN(loadFactor)) {
			throw new IllegalArgumentException("Illegal load factor: " +
					loadFactor);
		}
		this.threshold = tableSizeFor(initialCapacity);
		this.loadFactor = loadFactor;
	}
	
	// ������ת��Ϊ2�������η�������
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
	// �ڲ���ֵ����
	static class Node<K, V>{
		private int hash;
		private K key;
		private V value;
		private Node<K, V> next;
		
		public Node(int hash, K key, V value, Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public K getKey()        { return key; }
        public V getValue()      { return value; }
        public String toString() { return key + "=" + value; }
	}
	
	
	public V put(K key, V value) {
		
		return null;
	}
	
	public Node<K, V> get() {
		
		return null;
	}
	
}
