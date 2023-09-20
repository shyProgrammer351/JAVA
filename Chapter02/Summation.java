import java.lang.System;
import java.util.Scanner;

public class Summation 
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		int num=0, sum=0;

		// 숫자 n 입력받기 
		System.out.print( "숫자를 입력하세요: ");
		num = scan.nextInt(); 
	
		// 0부터 n까지의 합계 계산하기 
		System.out.print( "Σ " + num + " = " );
		for( ; num > 0; num-- )
		{
			System.out.print( num + " + " );	
			sum += num;				
		}
	
		// 합계 출력하기 
		System.out.println( num + " = " + sum ); 

		//프로그램 종료 
		return;
	}
}

