package remoteControl;

/**
 * AirConditioner 클래스는 에어컨 리모컨을 모델링 
 * @author 박소영
 *
 */
public class AirConditioner implements RemoteControl 

{				
	// 에어컨 전원, 온도, 풍량 변수 
	private boolean power;						
	private int temperature;						
	private int windStrength;							
	
	/**
	 * AirConditioner 생성자로 에어컨 상태 초기화
	 * @return 생성자이므로 해당사항 없음
	 */
	public AirConditioner()									
	{
		this.power = OFF;						
		this.temperature = 18;						
		this.windStrength = 10;						
	}
	
	/**
	 * 에어컨 리모컨에서 전원버튼 눌렀을 때 전원을 켜거나 끄기
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
	 * 에어컨 리모컨에서 상(△) 버튼을 눌렀을 때 온도를 +1 이동	
	 * @return 온도 상태 
	 */
	public String clickUp()						
	{
		return "현재 온도는 " + ( ++this.temperature ) + "도입니다";		
	}
	
	/**
	 * 에어컨 리모컨에서 하(▽) 버튼을 눌렀을 때 온도를 -1 이동
	 * @return 온도 상태 
	 */
	public String clickDown()					
	{
		return "현재 온도는 " + ( --this.temperature ) + "도입니다";		
	}
	
	/**
	 * 에어컨 리모컨에서 좌(◁) 버튼을 눌렀을 때 풍량을 -1 이동	
	 * @return 풍량 상태 
	 */
	public String clickLeft()					
	{
		return "현재 풍량은 " + ( --this.windStrength ) + "입니다";		
	}
	
	/**
	 * 에어컨 리모컨에서 우(▷) 버튼을 눌렀을 때 풍량을 +1 이동
	 * @return 풍량 상태 
	 */
	public String clickRight()					
	{
		return "현재 풍량은 " + ( ++this.windStrength ) + "입니다";		
	}
}

