import java.lang.System;
import java.util.Scanner;

public class Calendar
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		// 날짜 및 요일 초기화
		int day = 0;
		int firstDay = 0;
		int lastDay = 0;
		int dayOfWeek = 0;
		final int sunday = 0;		
		final int saturday = 6;	

		// 시작요일을 입력 받기 
		System.out.print( "일(0),월(1),화(2),수(3),목(4),금(5),토(6) 중에서 \n이번달 1일은 무슨요일인가요 : " );
		firstDay = scan.nextInt(); 
	
		// 말일 입력 받기 
		System.out.print( "이번달 말일은 언제인가요 : " );
		lastDay = scan.nextInt(); 

		// 달력 출력 
		// 1일 이전은 공백 출력 
		for( dayOfWeek = sunday; dayOfWeek < firstDay; dayOfWeek++ )
		{
			System.out.print( "     " );
		}
	
		// 1일부터 말일까지 
		for ( day = 1; day <= lastDay; day++, dayOfWeek++ )
		{
			// 일주일을 한줄에 출력 
			System.out.printf( "%5d", day );			
			// 즉, 토요일 후 일요일은 새 줄에서 시작 
			if ( dayOfWeek == saturday )		 
			{
				System.out.println();
				dayOfWeek = sunday - 1;
			}
		}

		// 프로그램 종료 
		return;
	}
}

