package threeCupGame;

public class BombDodgeGame extends ThreeCupGame 
{
			// 폭탄 피하기 게임 생성  
	public BombDodgeGame() 
	{
		super(); 
			// 구슬 찾기 게임용 메시지를 폭탄 피하기 게임용 메시지로 다음과 같이 수정 
			// 구슬을 찾았다, 놓쳤다는 메시지를 폭탄을 찾으면 펑!!, 놓치면 휴우!하는 메시지로 수정 
		super.message = " 1, 2, 3 중에서 폭탄[●]이 있는 상자를 피하세요 : ";		
		super.strMeet   = "  펑!!  ";		
		super.strDodge  = "  휴우! ";		
	}
}

