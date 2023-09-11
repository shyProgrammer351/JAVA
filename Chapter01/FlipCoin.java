import java.lang.System;
import java.util.Scanner;
import java.lang.Math;										

public class Main 
{

	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		Scanner scan = new Scanner( System.in );
		String str = null;
		int headsOrTails = 0;
		int user = 0;

		// 사용자는 동전의 앞면과 뒷면 중 하나를 선택	 
		System.out.println( "동전 던지기 게임을 시작합니다.\n" );
		System.out.print( "앞면(0), 뒷면(1) 중 하나를 선택하세요: " );
		user = scan.nextInt(); 
	
		// 사용자가 선택한 동전 상태 출력		 
		str = ( user == 0 ) ? "동전 앞면을 선택했습니다." : "동전 뒷면을 선택했습니다.";
		System.out.println( str );

		// 동전을 임의로 던져서 받기		 
		headsOrTails = (int)( Math.random() * 2 );			

		// 동전 던져서 받은 결과  출력		 
		str = ( headsOrTails == 0 ) ? "결과는 동전 앞면입니다. " : "결과는 동전 뒷면입니다. ";
		System.out.println( str );

		// 사용자가 동전의 상태를 맞추었는지 결과 출력	 
		str = ( headsOrTails == user ) ? "맞췄습니다.\n" : "틀렸습니다.\n";
		System.out.println( str );

		// 프로그램 종료 
		return;
	}
}

