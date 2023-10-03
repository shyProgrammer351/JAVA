package rockPaperScissors;
/**
 * RockPaperScissors_Lose 클래스는 RockPaperScissors를 상속받아 지는 가위바위보를 모델링 
 * @author 박소영
 */
public class RockPaperScissors_Lose extends RockPaperScissors 
{
		/**
	 * 가위바위보 게임을 초기화하는 생성자
	 */
	public RockPaperScissors_Lose()		 
	{	
		super();					 
	}
	/**
	 * 플레이어A와 플레이어B의 지는 가위바위보 승패 판정
	 * @param playerA : 플레이어A의 가위바위보 선택 결과
	 * @param playerB : 플레이어A의 가위바위보 선택 결과
	 * @return 지는 가위바위보 승패 판정 결과
	 */
	// 지는 가위바위보 게임 생성 
	protected String judge( String playerA, String playerB )	
	{
		// 가위바위보의 판정 결과를 반대로 수정 
		String result = super.judge( playerA, playerB );
		
		if ( result.equals( "플레이어 A가 이겼습니다" ) )
		{
			return "플레이어 B가 이겼습니다";
		}
		else if ( result.equals( "플레이어 B가 이겼습니다" ) )
		{
			return "플레이어 A가 이겼습니다";
		}
		else
		{
			return result;
		}	
	}
}

