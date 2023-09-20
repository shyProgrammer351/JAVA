import java.lang.System;
import java.util.Scanner;

public class Elevator 
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		int currentFloor = 1;									
		int destinationFloor= 0;

		// 사용자에게 엘리베이터에서 내릴 층수 입력받기 
		System.out.print( "1층~5층 중 몇 층으로 올라가시나요 : " );
		destinationFloor= scan.nextInt(); 

		// 엘리베이터 문이 닫히면서 안내 메시지 출력 
		System.out.println( destinationFloor+ "층으로 올라갑니다. 문이 닫힙니다." );

		// 사용자가 내릴 층수까지 엘리베이터가 한 층씩 이동하기 
		while( currentFloor <= destinationFloor )						
		{
			// 현재 층수 출력하기 
			System.out.println( currentFloor + "↑" );
			// 현재 층수에서 한 층씩 내려가기 
			currentFloor++;								
		}

		// 엘리베이터 문이 열리면서 도착 메시지 출력 
		System.out.println( "딩~동~댕~동~~ ♪~♬~♩~~ " + destinationFloor+ "층입니다. 문이 열립니다" );

		// 프로그램 종료 
		return;
	}
}

