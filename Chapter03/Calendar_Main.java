import java.util.Scanner;
	
class Calendar  
{
	// 월별 말일 		
	final int lastDayPerMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };  
	
	// 해당년도가 윤년인지 평년인지 결정하는 메서드 
	private boolean IsLeapYear( int year )										
	{
		// 400으로 나누어 떨어지는 해는 윤년으로 결정 
		if ( ( year % 400 ) == 0 )
		{
			return true;										
		}
		// 100으로 나누어 떨어지는 해는 평년으로 결정 
		else if ( ( year % 100 ) == 0 )
		{
			return false;										
		}
		// 4로 나누어 떨어지는 해는 윤년으로 결정 
		else if ( ( year % 4 ) == 0 )
		{
			return true;										
		}
		// 나머지는 평년으로 결정 
		else 
		{
			return false;										
		}
	}
	
	// 해당달의 말일을 구하는 메서드 
	public int getLastDay( int month, int year )									
	{
		// 해당달이 2월이고 윤년이면, 29일  
		if ( ( month == 2 ) && 
		                         IsLeapYear( year ) )
		{
			return lastDayPerMonth[ month ] + 1;							
		}
		// 아니면 월별 말일(31, 28, 31, 30, ... ) 값 적용  
		else
		{
			return lastDayPerMonth[ month ]; 							
		}
	}
			
	// 해당년도 1월1일부터 직전달 말일까지 날짜를 계산하는 메서드 
	private int getTotalDaysBetweenNewYearsDayAnd( int previousMonth, int thisYear )				
	{
		int totalDays = 0; 
		int month = 0;
		
		// 1월부터 직전달까지 월별 말일(31, 28, 31, 30, ... ) 더해서 전체 날짜 계산하기 
		for ( month = 1; month <= previousMonth; month++ )
		{
			totalDays += lastDayPerMonth[ month ];
		}
		// 이 때, 윤년 2월의 경우 2월 29일을 반영 
		if ( ( month >= 2 ) && IsLeapYear( thisYear ) )
		{
			totalDays++;
		}

		return totalDays;										
	}
	
	// 해당달의 시작요일을 계산하는 메서드 
	public int getFirstDay( int month, int year )							
	{
		// 1년1월1일부터 직전년도 12월31일까지 전체 날짜를 계산  
		int totalDays = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		// 해당년도 1월1일부터 직전달 말일까지 날짜 계산  
		totalDays += getTotalDaysBetweenNewYearsDayAnd( month-1, year );
		// 해당달 1일이 일요일부터 월요일 사이에 어느 요일인지 계산  
		return ( (totalDays+1) % 7 );									
	}
	
	// 달력을 출력하는 메서드 
	public void print( int year, int month, int firstDay, int lastDay )				
	{
		// 날짜 및 요일 초기화
		int day = 0;
		int dayOfWeek = 0;
		final int sunday = 0;		
		final int saturday = 6;		
	
		// 해당년도와 해당달을 출력  
		System.out.println( "\n              " + year + "년 " + month + "월\n" );
	
		// 1일 이전은 공백 출력  
		for( dayOfWeek = sunday; dayOfWeek < firstDay; dayOfWeek ++ )
		{
			System.out.print( "     " );
		}
	
		// 1일부터 말일까지  
		for( day = 1; day <= lastDay; dayOfWeek++, day++ )
		{
			// 일주일을 한줄에 출력  
			System.out.printf( "%5d", day );
			
			// 즉, 토요일 후 일요일은 새 줄에서 
			if ( dayOfWeek == saturday )
			{
				System.out.println();
				dayOfWeek = sunday - 1;
			}
		}
	}
}

public class Calendar_Main 
{  
	// 프로그램 시작 
	public static void main(String args[]) 
	{ 
		Scanner scan = new Scanner( System.in );
		Calendar calendar = new Calendar();
		
		// 년, 달, 말일, 시작요일 초기화
		int year  = 0;
		int month  = 0;
		int lastDay= 0;
		int firstDay = 0;
	
		// 년도와 달을 입력 
		System.out.print( "년도를 입력하세요: " );
		year = scan.nextInt();
		System.out.print( "월을 입력하세요: " );
		month = scan.nextInt();
		// 해당달의 시작요일과 말일을 계산하기 
		firstDay = calendar.getFirstDay( month, year );
		lastDay = calendar.getLastDay( month, year );
	
		// 달력을 출력 
		calendar.print( year, month, firstDay, lastDay );
	
	// 프로그램 종료 
	}
}

