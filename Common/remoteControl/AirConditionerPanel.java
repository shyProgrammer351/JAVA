package remoteControl;
import java.awt.*;
import javax.swing.*;

/**
 * 에어컨 클래스는 에어컨 리모컨을 모델링(리모컨 기능을 포함하므로 부모클래스 RemoteControl을 상속)
 * @author 박소영
 *
 */
public class AirConditionerPanel extends JPanel implements RemoteControl 
{
	/** 
	 * 에어컨 전원
	 */	
	private boolean power;
	/** 
	 * 냉방 온도 
	 */	
	private int temperature;
	/** 
	 * 바람 세기
	 */	
	private int windStrength;
	/** 
	 * 바람 세기를 문자열로 표현
	 */	
	private final String strWindStrength[] = { "미풍", "약풍", "강풍" };
	/** 
	 * 선택 결과를 텍스트 레이블로 표현  
	 */	
	private JLabel label;
	
	
	/**
	 * 에어컨 GUI 화면 초기화 
	 */
	public AirConditionerPanel()
	{
		// 전원, 희망온도, 풍량 상태 초기화 
		power = OFF;
		temperature = 18;
		windStrength = 1;
			
		label = new JLabel( "" );
		label.setPreferredSize( new Dimension( 290, 120 ) );		
		label.setFont( new Font( "Serif", Font.BOLD, 40 ) );
		label.setForeground( Color.BLUE );
		label.setText( "<html>전원을 켜세요</html>" );

		add( label );
	}

	/**
	 * 에어컨 리모컨에서 전원 버튼을 누르면 전원 상태 변경 
	 */
	public String clickPower()
	{
		if( power == OFF )
		{
			power = ON;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
			return "전원을 켭니다";
		}
		else 
		{
			power = OFF;
			label.setText( "<html>전원을 켜세요</html>" );
			return "전원을 끕니다";
		}
	}
	
	/**
	 * 에어컨 리모컨에서 상(△) 버튼을 누르면 희망 온도 증가 
	 */
	public String clickUp()
	{
		if( power == ON )
		{
			++temperature;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
		return "현재 온도는 " + temperature + "도입니다";
	}
	
	/**
	 * 에어컨 리모컨에서 하(▽) 버튼을 누르면 희망 온도 감소  
	 */
	public String clickDown()
	{
		if( power == ON )
		{
			--temperature;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
		return "현재 온도는 " + temperature + "도입니다";
	}
	
	/**
	 * 에어컨 리모컨에서 좌(◁) 버튼을 누르면 바람 세기 감소 
	 */
	public String clickLeft()
	{
		if( power == ON )
		{
			windStrength = ( windStrength + (strWindStrength.length - 1 ) ) % strWindStrength.length;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
		return "현재 풍량은 " + windStrength + "입니다";
	}
	
	/**
	 * 에어컨 리모컨에서 우(▷) 버튼을 누르면 바람 세기 증가 
	 */
	public String clickRight()
	{
		if( power == ON )
		{
			windStrength = ( windStrength + 1 ) % strWindStrength.length;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
		return "현재 풍량은 " + windStrength + "입니다";
	}
}

