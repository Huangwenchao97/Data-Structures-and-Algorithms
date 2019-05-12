package calculateByRpn;

// 将中缀表达式转换成后缀表达式,即逆波兰式
// 通过逆波兰式计算该表达式的值
// 目前只识别 +-*/  () 和 0-9整数

import java.util.Stack;

public class RPN {
	
	// 将表达式转换成逆波兰式
	public static String shiftTo(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		// 将s转换成字符串
		char[] cl = s.toCharArray();
		char[] recieve = new char[length];
		int count=0;
		for(int i=0; i<length; i++) {
			// 若为数字 直接输出
			if(cl[i] >= '0' && cl[i] <= '9') {
				recieve[count] = cl[i];
				count++;
			}
			// 若为 +-*/ 
			else if(cl[i] == '+' || cl[i] == '-' || cl[i] == '*' || cl[i] == '/') {
				// 若栈不为空且当前运算符优先级不大于栈顶运算符优先级
				while(!stack.empty() && !priorityJudge(cl[i], stack.peek())) {
					recieve[count] = stack.pop();
					count++;
				}
				stack.push(cl[i]);
			}
			// 若为 ( 则进栈
			else if(cl[i] == '(') {
				stack.push(cl[i]);
			}
			// 若为 ) 则匹配至前一个 (, 输出中间的运算符
			else if(cl[i] == ')') {
				while(stack.peek() != '(' && !stack.empty()) {
					recieve[count] = stack.pop();
					count++;
				}
				if(stack.empty()) {
					System.out.println("出错， 没有找到匹配的'(' ");
				}
				// ( 出栈
				stack.pop();
			} 
			else {
				System.out.println("无法识别字符");
			}
		}
		// 将栈中剩余字符出栈
		while(!stack.empty()) {
			recieve[count] = stack.pop();
			count++;
		}
		return String.valueOf(recieve).trim();
	}
	
	// 判断+-*/的优先级, 设置 */ 优先级 大于 +- 优先级大于 ( 优先级 依次为321
	private static boolean priorityJudge(char c1, char c2) {
		int value1 = valueOf(c1);
		int value2 = valueOf(c2);
		return value1 > value2;
	}
	
	// 给 +-*/ 赋优先级 好用来比较优先级
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
		// 若不为 +-*/
		if(value == 0) {
			System.out.println("无法识别符号");
		}
		return value;
	}
	
	// 利用逆波兰式进行计算
	public static int calculate(String rpn) {
		Stack<Integer> stack = new Stack<>();
		int value = 0;
		int length = rpn.length();
		char[] arr = rpn.toCharArray();
		for(int i=0; i<length; i++) {
			// 若为数字 入栈
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
						// 因为char强转为 int的值为ascII表里的值， 所以应减48
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
					System.out.println("逆波兰式出错！");
				}
			}
		}
		value = (int)stack.pop();
		return value;
	}
}
