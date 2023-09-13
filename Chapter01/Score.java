import java.lang.System;
import java.util.Scanner;

public class Score
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		int score = 0;

		// 사용자에게 점수 입력받기 
		System.out.println( "0점 ~ 100점 사이의 점수를 입력하세요: ");
		score = scan.nextInt(); 

		switch ( score / 10 )							
		{
			// 90점이상이면 와! 끝내주게 잘 했다를 출력 
			case 10: case 9: 							
				System.out.println( "와! ");
			// 80점이상이면 끝내주게 잘 했다를 출력 
			case 8: 									
				System.out.println( "끝내주게 ");
			// 70점이상이면 잘 했다를 출력 
			case 7:										
				System.out.println( "잘 ");
			// 나머지는 했다를 출력 
			default:									
				System.out.println( "했다");
		}

		// 프로그램 종료 
		return;
	}
}

