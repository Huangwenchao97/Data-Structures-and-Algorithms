package calculateByRpn;


public class Test {
	
	public static void main(String[] args) {
		String s = "1+(3-1)*2+4/2";
		
		String rpn = RPN.shiftTo(s);
		System.out.println("��׺���ʽΪ:" + s);
		System.out.println("�沨��ʽΪ:" + rpn);

		int value = RPN.calculate(rpn);
		System.out.println("ͨ���沨��ʽ����õ�ֵΪ:" + value);
	}
}
