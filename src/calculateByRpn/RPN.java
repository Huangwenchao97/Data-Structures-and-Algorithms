package calculateByRpn;

// ����׺���ʽת���ɺ�׺���ʽ,���沨��ʽ
// ͨ���沨��ʽ����ñ��ʽ��ֵ
// Ŀǰֻʶ�� +-*/  () �� 0-9����

import java.util.Stack;

public class RPN {
	
	// �����ʽת�����沨��ʽ
	public static String shiftTo(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		// ��sת�����ַ���
		char[] cl = s.toCharArray();
		char[] recieve = new char[length];
		int count=0;
		for(int i=0; i<length; i++) {
			// ��Ϊ���� ֱ�����
			if(cl[i] >= '0' && cl[i] <= '9') {
				recieve[count] = cl[i];
				count++;
			}
			// ��Ϊ +-*/ 
			else if(cl[i] == '+' || cl[i] == '-' || cl[i] == '*' || cl[i] == '/') {
				// ��ջ��Ϊ���ҵ�ǰ��������ȼ�������ջ����������ȼ�
				while(!stack.empty() && !priorityJudge(cl[i], stack.peek())) {
					recieve[count] = stack.pop();
					count++;
				}
				stack.push(cl[i]);
			}
			// ��Ϊ ( ���ջ
			else if(cl[i] == '(') {
				stack.push(cl[i]);
			}
			// ��Ϊ ) ��ƥ����ǰһ�� (, ����м�������
			else if(cl[i] == ')') {
				while(stack.peek() != '(' && !stack.empty()) {
					recieve[count] = stack.pop();
					count++;
				}
				if(stack.empty()) {
					System.out.println("���� û���ҵ�ƥ���'(' ");
				}
				// ( ��ջ
				stack.pop();
			} 
			else {
				System.out.println("�޷�ʶ���ַ�");
			}
		}
		// ��ջ��ʣ���ַ���ջ
		while(!stack.empty()) {
			recieve[count] = stack.pop();
			count++;
		}
		return String.valueOf(recieve).trim();
	}
	
	// �ж�+-*/�����ȼ�, ���� */ ���ȼ� ���� +- ���ȼ����� ( ���ȼ� ����Ϊ321
	private static boolean priorityJudge(char c1, char c2) {
		int value1 = valueOf(c1);
		int value2 = valueOf(c2);
		return value1 > value2;
	}
	
	// �� +-*/ �����ȼ� �������Ƚ����ȼ�
	private static int valueOf(char c) {
		int value = 0;
		switch (c) {
		case '+':
			value = 2;
			break;
		case '-':
			value = 2;
			break;
		case '*':
			value = 3;
			break;
		case '/':
			value = 3;
			break;
		case '(':
			value = 1;
			break;
		}
		// ����Ϊ +-*/
		if(value == 0) {
			System.out.println("�޷�ʶ�����");
		}
		return value;
	}
	
	// �����沨��ʽ���м���
	public static int calculate(String rpn) {
		Stack<Integer> stack = new Stack<>();
		int value = 0;
		int length = rpn.length();
		char[] arr = rpn.toCharArray();
		for(int i=0; i<length; i++) {
			// ��Ϊ���� ��ջ
			if(arr[i] <= '9' && arr[i] >= '0') {
				int tmp = (int)arr[i]-48;
				stack.push(tmp);
			}
			else {
				if(stack.size() >= 2) {
					int operand2 = stack.pop();
					int operand1 = stack.pop();
					int newOperand = 0;
					switch (arr[i]) {
					case '+':
						// ��ΪcharǿתΪ int��ֵΪascII�����ֵ�� ����Ӧ��48
						newOperand = operand1 + operand2;
						break;
					case '-':
						newOperand = operand1 - operand2;
						break;
					case '*':
						newOperand = operand1 * operand2;
						break;
					case '/':
						newOperand = operand1 / operand2;
						break;
					}
					stack.push(newOperand);
				}
				else {
					System.out.println("�沨��ʽ����");
				}
			}
		}
		value = (int)stack.pop();
		return value;
	}
}
