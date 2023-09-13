import java.lang.System;
import java.util.Scanner;

public class RockPaperScissors 
{
	// 프로그램시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String playerA = null;									
		String playerB = null;									

		// A양이 가위바위보중 하나를 선택 
		System.out.print("A양, 가위, 바위, 보 중 하나를 선택하세요: " );
		playerA = scan.nextLine().trim(); 						
		// A양이 선택한 결과를 출력 
		System.out.println( playerA + "를 냈습니다." ); 

		// B군이 가위바위보중 하나를 선택 
		System.out.print("B군, 가위, 바위, 보 중 하나를 선택하세요: " );
		playerB = scan.nextLine().trim();						
		// B군이 선택한 결과를 출력 
		System.out.println( playerB + "를 냈습니다." ); 

		// A양과 B군의 가위바위보 승패 출력 
		// A양과 B군이 같으면 비김  
		if ( playerA.equals( playerB ) )								
		{
			System.out.println( "\nA양과 B군이 비겼습니다." ); 
		}
		// A양이 가위이고 B군이 보를 낸 경우 A양 승리 
		else if ( playerA.equals( "가위" ) && playerB.equals( "보" ) )	
		{	
			System.out.println( "A양이 이겼습니다." ); 
		}
		// A양이 바위이고 B군이 가위를 낸 경우 A양 승리 
		else if ( playerA.equals( "바위" ) && playerB.equals( "가위" ) )	
		{
			System.out.println( "A양이 이겼습니다." ); 
		}
		// A양이 보이고 B군이 바위를 낸 경우 A양 승리 
		else if ( playerA.equals( "보" ) && playerB.equals( "바위" ) )	
		{
			System.out.println( "A양이 이겼습니다." ); 
		}
		// 나머지 경우는 B군이 승리  
		else
		{
			System.out.println( "B군이 이겼습니다." ); 
		}

		// 프로그램 종료 
		return;
	}
}

