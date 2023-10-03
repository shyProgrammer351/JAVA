import java.util.Scanner;
import rockPaperScissors.RockPaperScissors_Lose;
public class RockPaperScissors_Lose_Main							 
{
	// 프로그램시작 
	public static void main(String[] args) 	 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );	
		
		// 지는 가위바위보 객체 생성 	 
		RockPaperScissors_Lose game = new RockPaperScissors_Lose();
		// 지는 가위바위보 게임 진행 	 
		String result = game.play( scan );
		        
		// 지는 가위바위보 게임 결과 출력 	 
		System.out.println( result );
		
		// 프로그램 종료 
		return;
	}
}


