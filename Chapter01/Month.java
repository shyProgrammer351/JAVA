import java.lang.System;
import java.util.Scanner;

public class Month 
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		int month = 0;

		// 사용자에게 달을 입력받기 
		System.out.print( "1월 ~ 12월 사이의 월을 입력하세요 : ");
		month = scan.nextInt(); 

		// 입력받은 달의 영어이름을 출력 
		switch ( month )								
		{
			// 1월이면 January를 출력 
			case 1: 									
				System.out.println( "1월의 영어이름은 January 입니다" );
				break;									
			// 2월이면 February를 출력 
			case 2: 									
				System.out.println( "2월의 영어이름은 February 입니다" );
				break;									
			// 3월이면 March를 출력 
			case 3:										
				System.out.println( "3월의 영어이름은 March 입니다" );
				break;									
			// 4월이면 April를 출력 
			case 4: 									
				System.out.println( "4월의 영어이름은 April 입니다" );
				break;									
			// 5월이면 May를 출력 
			case 5: 									
				System.out.println( "5월의 영어이름은 May 입니다" );
				break;									
			// 6월이면 June를 출력 
			case 6:										
				System.out.println( "6월의 영어이름은 June 입니다" );
				break;									
			// 7월이면 July를 출력 
			case 7: 									
				System.out.println( "7월의 영어이름은 July 입니다" );
				break;									
			// 8월이면 August를 출력 
			case 8: 									
				System.out.println( "8월의 영어이름은 August 입니다" );
				break;									
			// 9월이면 September를 출력 
			case 9:										
				System.out.println( "9월의 영어이름은 September 입니다" );
				break;									
			// 10월이면 October를 출력 
			case 10: 									
				System.out.println( "10월의 영어이름은 October 입니다" );
				break;									
			// 11월이면 November를 출력 
			case 11: 									
				System.out.println( "11월의 영어이름은 November 입니다" );
				break;									
			// 12월이면 December를 출력 
			default:									
				System.out.println( "12월의 영어이름은 December 입니다" );
		}

		// 프로그램 종료 
		return;
	}
}

