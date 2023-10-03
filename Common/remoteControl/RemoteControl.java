package remoteControl;

/**
 * 전원, 상, 하, 좌, 우 버튼이 있는 리모컨 
 * @author So Young Park
 * @version 0.8
 */	
public interface RemoteControl
{
	/**
	 * 전원 버튼 켜짐(ON) 상태 관련 상수
	 */
	public final boolean ON = true;
	/**
	 * 전원 버튼 꺼짐(OFF) 상태 관련 상수
	 */
	public final boolean OFF = false;	
	/**
	 * 리모컨에서 전원버튼 눌렀을 때 작동
	 * @return 리모컨 조정 후 가전제품 상태  
	 */
	public String clickPower();
	/**
	 * 리모컨에서 상(△) 버튼을 눌렀을 때 작동
	 * @return 리모컨 조정 후 가전제품 상태  
	 */
	public String clickUp();
	/**
	 * 리모컨에서 하(▽) 버튼을 눌렀을 때 작동
	 * @return 리모컨 조정 후 가전제품 상태  
	 */
	public String clickDown();
	/**
	 * 리모컨에서 좌(◁) 버튼을 눌렀을 때 작동
	 * @return 리모컨 조정 후 가전제품 상태  
	 */
	public String clickLeft();
	/**
	 * 리모컨에서 우(▷) 버튼을 눌렀을 때 작동
	 * @return 리모컨 조정 후 가전제품 상태  
	 */
	public String clickRight();
}

