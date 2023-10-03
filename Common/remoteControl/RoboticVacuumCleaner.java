package remoteControl;

/**
 * RoboticVacuumCleaner 클래스는 로봇청소기 리모컨을 모델링 
 * @author 박소영
 *
 */
public class RoboticVacuumCleaner implements RemoteControl 
{				
	// 로봇청소기 전원 
	private boolean power;						
	
	/**
	 * RoboticVacuumCleaner 생성자로 로봇청소기 상태 초기화
	 * @return 생성자이므로 해당사항 없음
	 */
	public RoboticVacuumCleaner()									
	{
		this.power = OFF;						
	}
	
	/**
	 * 로봇청소기 리모컨에서 전원버튼 눌렀을 때 전원을 켜거나 끄기
	 * @return 전원 상태   
	 */
	public String clickPower()					
	{
		if( this.power == OFF )					
		{
			this.power = ON;					
			return "전원을 켭니다";
		}
		else 
		{
			this.power = OFF;					
			return "전원을 끕니다";
		}
	}
	
	/**
	 * 로봇청소기 리모컨에서 상(△) 버튼을 눌렀을 때 직진
	 * @return 주행 상태 
	 */
	public String clickUp()						
	{
		return "직진합니다";	 
	}
	
	/**
	 * 로봇청소기 리모컨에서 하(▽) 버튼을 눌렀을 때 후진
	 * @return 주행 상태 
	 */
	public String clickDown()					
	{
		return "후진합니다";	 
	}
	
	/**
	 * 로봇청소기 리모컨에서 좌(◁) 버튼을 눌렀을 때 좌회전
	 * @return 주행 상태 
	 */
	public String clickLeft()					
	{
		return "좌회전합니다";
	}
	
	/**
	 * 로봇청소기 리모컨에서 우(▷) 버튼을 눌렀을 때 우회전
	 * @return 주행 상태 
	 */
	public String clickRight()					
	{
		return "우회전합니다";
	}
}


