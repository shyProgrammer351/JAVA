package rockPaperScissors;
import java.util.Scanner;

/**
 * 가위바위보 게임 클래스 
 * @author So Young Park
 * @version 0.8
 */
public class RockPaperScissors
{
	/**
	 * 가위를 나타내는 상수 
	 */
	public final int SCISSORS = 0;
	/**
	 * 바위를 나타내는 상수 
	 */
	public final int ROCK = 1;
	/**
	 * 보를 나타내는 상수 
	 */
	public final int PAPER = 2;

	/** 
	 * 가위바위보 참여자의 선택 결과    
	 */	
	protected int playerA;
	/** 
	 * 가위바위보 상대편의 선택 결과    
	 */	
	protected int playerB;

	/**
	 * 가위바위보 참여자는 키보드에서 입력받고 상대편은 임의로 입력받아 가위바위보 게임의 승패를 판정
	 * @param scan 키보드 입력을 위한 Scanner 객체
	 * @return 가위바위보 게임을 진행한 결과
	 */
	public String play( Scanner scan )
	{	
		this.playerA = selectRockPaperScissors( scan );
		return play( this.playerA );
	}
	
	/**
	 * 가위바위보 참여자의 선택 결과는 전달받고 상대편은 임의로 입력받아 가위바위보 게임의 승패를 판정
	 * @param playerA 가위바위보 참여자의 선택 결과
	 * @return 가위바위보 게임을 진행한 결과
	 */
	public String play( int playerA )
	{
		this.playerA = playerA;
		this.playerB = selectRockPaperScissors();
		
		String result = "";
		result += "참여자는 " + getInt2String( playerA ) +"를 냈습니다.\n";
		result += "상대편은 " + getInt2String( playerB ) +"를 냈습니다.\n";
		result += "판정결과는 " + judge( playerA, playerB ) + "\n";
		return result;
	}
	
	/**
	 * 가위바위보 선택 결과(int형)를 문자열로 변환
	 * @param player 가위바위보 선택 결과(int형)
	 * @return 가위바위보 선택 결과(문자열)
	 */
	public String getInt2String( int player )
	{
		if ( player == SCISSORS )
			return "가위";
		else if ( player == ROCK )
			return "바위";
		else
			return "보"; 
	}
	
	/**
	 * 가위바위보 선택 결과(문자열)를 int형으로 변환
	 * @param player 가위바위보 선택 결과(문자열)
	 * @return 가위바위보 선택 결과(int형)
	 */
	public int getSting2Int( String player )
	{
		if ( player.equals( "가위" ) )
			return SCISSORS;
		else if ( player.equals( "바위" ) )
			return ROCK;
		else
			return PAPER; 
	}
	
	/**
	 * 가위바위보 참여자가 입력한 선택 결과 전달 
	 * @param scan 키보드 입력을 위한 Scanner 객체
	 * @return 가위바위보 참여자의 선택 결과
	 */
	protected int selectRockPaperScissors( Scanner scan )
	{
		String player;
		
		do
		{
			System.out.print( "가위, 바위, 보 중 하나를 입력하세요 : ");
			player = scan.next();
			
		} while( !player.equals( "가위" ) && !player.equals( "바위" ) && !player.equals( "보" ) );
			
		return getSting2Int( player );
	}

	/**
	 * 임의로 가위바위보 중에서 하나를 선택
	 * @return 가위(0), 바위(1), 보(2) 중 임의의 값
	 */
	protected int selectRockPaperScissors()
	{
		return (int)(Math.random()*3);		
	}
	
	/**
	 * 가위바위보 참여자와 상대편의 선택 결과를 바탕으로 승패 판정
	 * @param playerA 가위바위보 참여자의 선택 결과
	 * @param playerB 가위바위보 상대편의 선택 결과
	 * @return 가위바위보 승패 판정 결과
	 */
	protected String judge( int playerA, int playerB )
	{
		if ( playerA == playerB )
		{
			return "상대편과 참여자가 비겼습니다";
		}
		else if ( ( ( playerA == SCISSORS ) && ( playerB == PAPER ) )
				|| ( ( playerA == ROCK ) && ( playerB == SCISSORS ) )
				|| ( ( playerA == PAPER ) && ( playerB == ROCK ) ) )
		{
			return "참여자가 이겼습니다";
		}
		else
		{
			return "상대편이 이겼습니다";
		}	
	}
}

