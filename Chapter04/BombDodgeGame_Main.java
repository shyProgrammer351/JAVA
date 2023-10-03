import java.util.Scanner;
import threeCupGame.BombDodgeGame;
/**************
 * 구슬 찾기 프로그램에서 GUI 부분 Main 클래스
 * @author So Young Park
 * @version 0.8
 */	
public class BombDodgeGame_Main					 
{
	// 프로그램시작 
	public static void main(String[] args) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		// 폭탄 피하기 객체 생성 	 
		BombDodgeGame game = new BombDodgeGame();
			
		// 폭탄 피하기 게임 진행 	 
		for( String result = null; ( result = game.play( scan ) ) != null; )
		{
			// 폭탄 피하기 게임 결과 출력 	 
			System.out.println( result ); 
		}
		
		System.out.println( "\n게임을 종료합니다. 다음에 또 만나요!" ); 
	// 프로그램 종료 
	}
}

