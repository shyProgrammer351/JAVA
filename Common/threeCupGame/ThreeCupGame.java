package threeCupGame;
import java.util.Scanner;

/**
 * 구슬찾기 게임 클래스 
 * @author So Young Park
 * @version 0.8
 */
class ThreeCupGame							
{
	/**
	 * 게임종료를 나타내는 상수 
	 */
	public final int GAME_OVER = -1;	

	/**
	 * 컵 3개 표현  
	 */
	private String strCups;						
	/**
	 * 구슬이 있을 때 표현 
	 */
	private String strBall;						
	/**
	 * 구슬이 없을 때 표현  
	 */
	private String strBlanks;				
	
	/**
	 * 구슬 찾기 성공시 메시지 
	 */
	protected String strMeet;				
	/**
	 * 구슬 찾기 실패시 메시지 
	 */
	protected String strDodge;			
	/**
	 * 게임 안내 메시지
	 */
	protected String message;		

	/**
	 * 구슬 찾기 초기화  
	 */
	public ThreeCupGame() 	
	{		
		this.strCups   = "  ___    ___    ___  \n"		
				           + " |   |  |   |  |   | \n"
				           + " |   |  |   |  |   | \n";
		this.strBall   = "   ●   ";										
		this.strBlanks = "       ";										
		this.strMeet   = " 찾았다! ";										
		this.strDodge  = " 놓쳤다! ";										
		
		this.message = " 1, 2, 3 중에서 구슬[●]을 숨긴 컵을 찾으세요 : ";	
	} 

	/**
	 * 컵 3개 중 하나에 임의로 구슬을 숨기고, 참여자에게 컵 번호를 입력받아 구슬찾기 게임의 승패를 판정
	 * @param scan 키보드 입력을 위한 Scanner 객체
	 * @return 구슬찾기 게임을 진행한 결과
	 */
	// 구슬 찾기 게임 진행하는 메서드 
	public String play( Scanner scan )			 
	{	
		// 컵 3개 중 하나에 임의로 구슬을 숨기기 
		int ball = getRandomCup();
		//참여자는 컵 번호를 키보드에서 입력  
		int player = selectCup( scan );
		// 구슬찾기 게임의 승패를 판정 
		return  
		       getResult( player, ball );
	}

	/**
	 * 구슬찾기 참여자가 선택한 컵 번호 전달 
	 * @param scan 키보드 입력을 위한 Scanner 객체
	 * @return 구슬찾기 참여자의 선택 결과
	 */
	private int selectCup( Scanner scan )
	{
		int player = 0;
		try
		{
			System.out.print( message );
			player = scan.nextInt();
			// 컵 번호 1, 2, 3을 0, 1, 2로 대응하여 변환 
			if ( isPossibleValue( player - 1 ) == true )
				player = player - 1;
			else
				player = GAME_OVER;
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		return player;
	}

	/**
	 * 세 개의 컵 중에서 임의로 구슬이 있는 컵 번호 선택
	 * @return 0, 1, 2 중 임의의 값
	 */
	public int getRandomCup() 
	{ 
		return (int)( Math.random() * 3 );
	}
	
	/**
	 * 올바른 컵 번호인지 확인 
	 * @param selection 선택 결과
	 * @return 0, 1, 2이면 true, 아니면 false
	 */
	public boolean isPossibleValue( int selection )
	{
		return ( 0 <= selection ) && ( selection <= 2 );		
	}


	/**
	 * 참여자가 선택한 컵과 구슬을 숨긴 컵을 비교하여 게임 진행 결과를 전달
	 * @param player 참여자가 선택한 컵
	 * @param ball 구슬을 숨긴 컵
	 * @return 구슬찾기 게임을 진행한 결과
	 */
	private String getResult( int player, int ball ) 
	{ 
		if ( player == GAME_OVER )
			return null;
		
		String str = strCups;
		for ( int i = 0; i < 3; i++ )
		{
			if ( ball == i ) 
				str += strBall;
			else
				str += strBlanks;
		}
		
		str += "\n";
		for ( int i = 0; i < 3; i++ )
		{
			if ( ( player == i ) && ( player == ball ) )
				str += strMeet;
			else if ( player == i )
				str += strDodge;
			else
				str += strBlanks;
		}
		
		return str;
	}
}

