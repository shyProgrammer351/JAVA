import java.util.Scanner;

/**
 * RockPaperScissors 클래스는 가위바위보 게임을 모델링
 * @author 박소영
 */
class RockPaperScissors							
{
	// 가위, 바위, 보에 해당하는 정수값
	public final int ROCK = 0;					
	public final int PAPER = 1;					
	public final int SCISSORS = 2;				

	// 플레이어 A, 플레이어 B는 가위바위보 중 하나를 값으로 선택
	private String playerA;					
	private String playerB;					

	/**
	 * 가위바위보 게임을 초기화하는 생성자
	 */
	public RockPaperScissors()					
	{	
		this.playerA = "가위";					
		this.playerB = "바위";					
	}
	
	/**
	 * 플레이어 A 값은 키보드에서 입력받고 플레이어 B 값은 임의로 입력받아 가위바위보 게임의 승패를 판정
	 * @param scan : 키보드 입력을 위한 Scanner 변수 전달
	 * @return 가위바위보 게임을 진행한 결과
	 */
	// 가위바위보 게임 진행하는 메서드 시작 
	public String play( Scanner scan )						
	{	
		// 플레이어 A는 키보드에서 입력받아 가위바위보 선택  
		this.playerA = selectRockPaperScissors( scan );
		
		// 플레이어 B의 임의로 가위바위보 선택 
		this.playerB = selectRockPaperScissors();

		// 가위바위보 게임을 진행한 결과를 반환 
		String result = getResult( this.playerA, this.playerB );

		// 가위바위보 게임 진행하는 메서드 종료 
		return result;
	}
	
	/**
	 * 플레이어 A 값은 전달받고 플레이어 B 값은 임의로 입력받아 가위바위보 게임의 승패를 판정
	 * @param playerA : 플레이어 A의 가위바위보 중 하나
	 * @return 가위바위보 게임을 진행한 결과
	 */
	public String play( String playerA )		
	{
		// 플레이어 A는 전달받아 가위바위보 선택
		this.playerA = playerA;					
		
		// 플레이어 B의 임의로 가위바위보 선택 
		this.playerB = selectRockPaperScissors();

		// 가위바위보 게임을 진행한 결과를 반환
		String result = getResult( this.playerA, this.playerB );

		return result;
	}
	
	/**
	 * 가위바위보 게임을 진행한 결과
	 * @param playerA : 플레이어 A의 가위바위보 중 하나
	 * @return 가위바위보 게임을 진행한 결과
	 */
	private String getResult( String playerA, String playerB )	
	{
		// 플레이어 A와 플레이어 B의 현재 상태 
		String result = "";
		result += "플레이어 A는 " + playerA +"를 냈습니다.\n";
		result += "플레이어 B는 " + playerB +"를 냈습니다.\n";
		
		// 플레이어 A와 플레이어 B의 가위바위보 승패 판정 
		result += "판정결과는 " 
		                  + judge( playerA, playerB ) + "\n";
		
		return result;
	}

	/**
	 * 키보드에서 입력받아 가위바위보 선택
	 * @param scan : 키보드 입력을 위한 Scanner 변수 전달
	 * @return 가위바위보 중 하나
	 */
	private String selectRockPaperScissors( Scanner scan )	
	{
		String result = "";
		
		do
		{
			System.out.print( "가위, 바위, 보 중 하나를 입력하세요 : ");
			result = scan.next();
			
		} while( !result.equals( "가위" ) && !result.equals( "바위" ) && !result.equals( "보" ) );
			
		return result;
	}

	/**
	 * 임의로 가위바위보 선택
	 * @return 가위바위보 중 하나
	 */
	private String selectRockPaperScissors()					
	{
		int num = (int)(Math.random()*3);
		String result = "";
		
		if ( num == SCISSORS )
		{
			result = "가위";
		}
		else if ( num == ROCK )
		{
			result = "바위";
		}
		else
		{
			result = "보"; 
		}
		
		return result; 
	}
			
	/**
	 * 플레이어 A와 플레이어 B의 가위바위보 승패 판정
	 * @param playerA : 플레이어 A의 가위바위보 선택 결과
	 * @param playerB : 플레이어 A의 가위바위보 선택 결과
	 * @return 가위바위보 승패 판정 결과
	 */
	private String judge( String playerA, String playerB )	
	{
		String result = "";
		if ( playerA.equals( playerB ) )
		{
			result = "플레이어 A와 플레이어 B가 비겼습니다";
		}
		else if ( ( playerA.equals( "가위" ) && playerB.equals( "보" ) ) 
				|| ( playerA.equals( "바위" ) && playerB.equals( "가위" ) )
				|| ( playerA.equals( "보" ) && playerB.equals( "바위" ) ) )
		{
			result = "플레이어 A가 이겼습니다";
		}
		else
		{
			result = "플레이어 B가 이겼습니다";
		}	
		
		return result;
	}
}

public class Main							
{
	// 프로그램시작 
	public static void RockPaperScissors_Main(String[] args) 	
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );	
		
		// 가위바위보 객체 생성 	 
		RockPaperScissors game = new RockPaperScissors();
		// 가위바위보 게임 진행 	 
		String result = game.play( scan );
		        
		// 가위바위보 게임 결과 출력 	 
		System.out.println( result );
		
		// 프로그램 종료 
		return;
	}
}

