package remoteControl;
import java.util.Scanner;

/**
 * TV 클래스는 TV 리모컨을 모델링(리모컨 기능을 포함하므로 부모클래스 RemoteControl을 상속)
 * @author 박소영
 *
 */
public class TV implements RemoteControl 
{				
	// TV 전원, 채널, 음량 변수 
	private boolean power;	 
	private int channel; 
	private int volume;		 
	
	/**
	 * TV 생성자로 TV 상태 초기화
	 * @return 생성자이므로 해당사항 없음
	 */
	public TV()					 
	{
		this.power = OFF;		 
		this.channel = 100; 
		this.volume = 10;		 
	}
	
	/**
	 * TV 리모컨에서 전원버튼 눌렀을 때 전원을 켜거나 끄기
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
	 * TV 리모컨에서 상(△) 버튼을 눌렀을 때 채널을 +1 이동	
	 * @return 채널 상태 
	 */
	public String clickUp()		 
	{
		return "현재 채널은 " + ( ++this.channel ) + "번입니다";		 
	}
	
	/**
	 * TV 리모컨에서 하(▽) 버튼을 눌렀을 때 채널을 -1 이동
	 * @return 채널 상태 
	 */
	public String clickDown()				 
	{
		return "현재 채널은 " + ( --this.channel ) + "번입니다";		 
	}
	
	/**
	 * TV 리모컨에서 좌(◁) 버튼을 눌렀을 때 음량을 -1 이동	
	 * @return 음량 상태 
	 */
	public String clickLeft()			 
	{
		return "현재 음량은 " + ( --this.volume ) + "입니다";		 
	}
	
	/**
	 * TV 리모컨에서 우(▷) 버튼을 눌렀을 때 음량을 +1 이동
	 * @return 음량 상태 
	 */
	public String clickRight()		 
	{
		return "현재 음량은 " + ( ++this.volume ) + "입니다";		 
	}
}

