package remoteControl;
import java.awt.*;
import javax.swing.*;

/**
 * Robotic Vacuum Cleaner 클래스는 Robotic Vacuum Cleaner 리모컨을 모델링(리모컨 기능을 포함하므로 부모클래스 RemoteControl을 상속)
 * @author So Young Park
 * @version 0.8
 */
public class RoboticVacuumCleanerPanel extends JPanel implements RemoteControl 
{
	private final int WIDTH = 340, HEIGHT = 120;
	private final int IMAGE_SIZE = 30;
	private ImageIcon imgRobot;
	private ImageIcon imageBackground;
	private int robotX, robotY;
	/**
	 * 전원 변수
	 */
	private boolean power;
	/** 
	 *청소구역을 이미지로 표현  
	 */	
	private JLabel cleaningArea;
	
	/**
	 * Robotic Vacuum Cleaner GUI 화면 초기화 
	 */
	public RoboticVacuumCleanerPanel()
	{
		// Robotic Vacuum Cleaner 및 이동 가능 영역 초기화 
		power = OFF;
		robotX = robotY = 0;
		final String imgPath = "./Common/remoteControl/image/";
		imgRobot = new ImageIcon( new ImageIcon( imgPath + "robot.gif" ).getImage().getScaledInstance( IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH ) );
		imageBackground = new ImageIcon( new ImageIcon( imgPath + "blank.gif" ).getImage().getScaledInstance( WIDTH, HEIGHT, Image.SCALE_SMOOTH ) );
		cleaningArea = new JLabel( imageBackground );
		add( cleaningArea );
		setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
	}
	/**
	 * Robotic Vacuum Cleaner 리모컨에서 전원 버튼을 누르면 전원 상태 변경  
	 */
	public String clickPower()
	{
		if( power == OFF )
		{
			cleaningArea.setIcon( null );
			power = ON;
			return "전원을 켭니다";
		}
		else 
		{
			cleaningArea.setIcon( imageBackground );
			power = OFF;
			return "전원을 끕니다";
		}
	}
	
	/**
	 * Robotic Vacuum Cleaner 리모컨에서 상(△) 버튼을 누르면 위쪽으로 이동 
	 */
	public String clickUp()
	{
		move( 0, -10, power );	
		return "직진합니다";
	}
	
	/**
	 * Robotic Vacuum Cleaner 리모컨에서 하(▽) 버튼을 누르면 아래쪽으로 이동  
	 */
	public String clickDown()
	{
		move( 0, 10, power );	
		return "후진합니다";
	}
	
	/**
	 * Robotic Vacuum Cleaner 리모컨에서 좌(◁) 버튼을 누르면 왼쪽으로 이동  
	 */
	public String clickLeft()
	{
		move( -10, 0, power );	
		return "좌회전합니다";
	}
	
	/**
	 * Robotic Vacuum Cleaner 리모컨에서 우(▷) 버튼을 누르면 오른쪽으로 이동  
	 */
	public String clickRight()
	{
		move( 10, 0, power );	
		return "우회전합니다";
	}

	/**
	 * Robotic Vacuum Cleaner 이동 
	 */
	public void move( int x, int y, boolean power )
	{
		if ( power == RemoteControl.OFF )
			return;
			
		robotX += x;
		robotY += y;

		if ( robotX <= 0 )
			robotX = 0;
		else if ( robotX >= ( WIDTH - IMAGE_SIZE ) )
			robotX = WIDTH - IMAGE_SIZE;

		if ( robotY <= 0 )
			robotY = 0;
		else if ( robotY >= ( HEIGHT - IMAGE_SIZE ) )
			robotY = ( HEIGHT - IMAGE_SIZE );
   
		repaint();
	}

	/**
	 * Robotic Vacuum Cleaner 화면 업데이트
	 */
	public void paintComponent( Graphics page )
	{
		super.paintComponent( page );
		imgRobot.paintIcon( this, page, robotX, robotY );
	}
}

