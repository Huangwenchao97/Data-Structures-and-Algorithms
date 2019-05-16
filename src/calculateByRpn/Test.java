package calculateByRpn;


public class Test {
	
	public static void main(String[] args) {
		String s = "1+(3-1)*2+4/2";
		
		String rpn = RPN.shiftTo(s);
		System.out.println("中缀表达式为:" + s);
		System.out.println("逆波兰式为:" + rpn);

		int value = RPN.calculate(rpn);
		System.out.println("通过逆波兰式计算得到值为:" + value);
	}
}
