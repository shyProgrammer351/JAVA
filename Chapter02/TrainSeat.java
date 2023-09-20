import java.lang.System;
import java.util.Scanner;

public class TrainSeat 
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String[][] seat = { {"","","","",""},				
		                    {"","","","",""}, 
		                    {"","","","",""}, 
		                    {"","","","",""} };
		String reservedSeat = "A1";

		do
		{
	 	   // 예약 좌석은 (예약)으로 출력하면서 
		  seat[ (int)( reservedSeat.charAt(0) - 'A' ) ][ (int)( reservedSeat.charAt(1) - '1' ) ] = "(예약)";		

		  // 전체 좌석에 대한 현재 예약 상태 출력 
		  System.out.printf( "#   %d %6d %6d %6d %6d\n", 1, 2, 3, 4, 5 ); 
		  System.out.printf( "A %6s %6s %6s %6s %6s\n", seat[0][0], seat[0][1], seat[0][2], seat[0][3], seat[0][4] );
		  System.out.printf( "B %6s %6s %6s %6s %6s\n", seat[1][0], seat[1][1], seat[1][2], seat[1][3], seat[1][4] );
		  System.out.printf( "C %6s %6s %6s %6s %6s\n", seat[2][0], seat[2][1], seat[2][2], seat[2][3], seat[2][4] );
		  System.out.printf( "D %6s %6s %6s %6s %6s\n", seat[3][0], seat[3][1], seat[3][2], seat[3][3], seat[3][4] );
		
		  // 사용자에게 예약 좌석 입력 받기 
		  System.out.print( "A2, B4, 0(종료)와 같이, 예약 희망 좌석을 입력하세요 : " );
		  reservedSeat = scan.nextLine().trim(); 

		// 입력 좌석이 유효하면 좌석 예약 및 출력을 반복 
		} while( ( 'A' <= reservedSeat.charAt(0) ) && ( reservedSeat.charAt(0) <= 'D' ) 
		    && ( '1' <= reservedSeat.charAt(1) ) && ( reservedSeat.charAt(1) <= '5' ) );
	
		// 프로그램 종료 
		return;
	}
}

