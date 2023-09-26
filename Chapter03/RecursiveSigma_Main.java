import java.util.Scanner;
	
class RecursiveSigma 
{
	// 0부터 n까지의 합계 계산하는 함수 시작 
	int sigma( int num )					
	{
		// n이 0 이하이면 Σ 연산 종료 
		if ( num <= 0 )							
		{
			System.out.print( num + " = " ); 			
			return num;						
		}
		// Σ n = n + Σ ( n - 1 ) 
		else
		{
			System.out.print ( num + " + " );
			return num += sigma( num - 1 );
		}
	// 0부터 n까지의 합계 계산하는 함수 종료 
	}
	
	int getNum( Scanner scan )
	{
		int num = 0;	
	
		System.out.print( "숫자를 입력하세요: ");
		num = scan.nextInt();
	
			return num;	
	}
}
	
public class RecursiveSigma_Main 
{
	// 프로그램 시작 
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner( System.in );
		RecursiveSigma calculation = new RecursiveSigma();
		int sum = 0, num = 0;
				
		// 숫자 n 입력받기 
		num = calculation.getNum( scan );
	
		// 0부터 n까지의 합계 계산하기 
		System.out.print( "Σ " + num + " = " );
		sum = calculation.sigma( num );
		
		// 합계 출력하기 
		System.out.print( sum ); 
	
		//프로그램 종료 
	return;
	}
}

