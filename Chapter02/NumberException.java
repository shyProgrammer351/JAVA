import java.util.*;

public class NumberException
{  
	// 프로그램 시작 
	public static void main(String args[]) 
	{ 

		try 											
		{
			Scanner scan = new Scanner( System.in );
			// 사칙연산을 위한 숫자 입력 
			System.out.print( "사칙연산을 위한 첫번째 숫자를 입력하세요: " );
			int num1 = Integer.parseInt(
				                             scan.nextLine() ); 
			System.out.print( "사칙연산을 위한 두번째 숫자를 입력하세요: " );
			int num2 = scan.nextInt();
			
			// 사칙연산 수행 및 결과 출력 
			System.out.println( num1 + " + " + num2 + " = " + ( num1 + num2 ) );
			System.out.println( num1 + " - " + num2 + " = " + ( num1 - num2 ) );
			System.out.println( num1 + " * " + num2 + " = " + ( num1 * num2 ) );
			System.out.println( num1 + " / " + num2 + " = " + ( num1 / num2 ) );
		}	
		// 예외 처리 
		catch ( NumberFormatException e )				
		{
			System.out.println("숫자 형식 불일치");
		}
		catch ( InputMismatchException e ) 				
		{
	 		System.out.println( "입력 자료형 불일치" );
		}
		catch ( ArithmeticException e ) 				
		{
			System.out.println( "산술 연산 오류" );
		} 
		finally 										
		{
			System.out.println( "예외 실습 완료" );
		} 
		
		
		// 프로그램 종료 
		return;
	} 
}

