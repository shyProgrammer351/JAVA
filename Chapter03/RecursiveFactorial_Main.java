import java.util.Scanner;
		
class RecursiveFactorial 
{
	// 1부터 n까지의 곱을 계산하는 함수 시작 
	int factorial( int num )	
	{
		// n이 1 이하이면 !(factorial) 연산 종료 
		if ( num <= 1 )							
		{
			System.out.print( num + " = " ); 			
			return num;						
		}
		// n! = n * ( n - 1 )! 
		else
		{
			System.out.print ( num + " * " );
			return num *= factorial( num - 1 );
		}
	// 1부터 n까지의 곱을 계산하는 함수 종료 
	}
	
	int getNum( Scanner scan )
	{
		int num = 0;	
	
		System.out.print( "숫자를 입력하세요: ");
		num = scan.nextInt();
	
		return num;	
	}
}
	
public class RecursiveFactorial_Main 
{
	// 프로그램 시작 
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner( System.in );
		RecursiveFactorial calculation = new RecursiveFactorial();
		int result = 0, num = 0;
	
		// 숫자 n 입력받기 
		num = calculation.getNum( scan );
	
		// 1부터 n까지의 곱을 계산하기 
		System.out.print( num + "! = " );
		result = calculation.factorial( num );
		
		// 결과 출력하기 
		System.out.print( result ); 
	
		//프로그램 종료 
		return;
	}
}

