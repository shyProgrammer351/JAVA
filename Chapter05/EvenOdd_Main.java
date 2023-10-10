import javax.swing.JOptionPane;
public class EvenOdd_Main
{
	// 프로그램시작 
	public static void main (String[] args)
	{
		String numStr, result;
		int num, again;

		// 반복시작 
		do 
		{
			// 숫자 입력 
			numStr = JOptionPane.showInputDialog ("Enter an integer: ");	
			num = Integer.parseInt(numStr); 	
			// 홀수인지 짝수인지 출력 
			result = "That number is " + ((num%2 == 0) ? "even" : "odd");
			JOptionPane.showMessageDialog (null, result);	
			// 계속 반복할지 확인 
			again = JOptionPane.showConfirmDialog (null, "Do Another?");	
		} while( again == JOptionPane.YES_OPTION );	
		// 프로그램 종료 
		return;
	}
}

