import java.awt.*;
import javax.swing.JFrame;
import remoteControl.RemoteControllerPanel;
import remoteControl.RoboticVacuumCleanerPanel;

/**************
 * 리모컨으로 제어하는 로봇청소기 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class RemoteControlRoboticVacuumCleanerGUI
{
	public static void main(String[] args) 
	{
		RoboticVacuumCleanerPanel appliance = new RoboticVacuumCleanerPanel();
		RemoteControllerPanel remoteController = new RemoteControllerPanel( appliance );

		JFrame frame = new JFrame( "로봇청소기" );
		frame.setLayout( new BorderLayout() );     
		frame.add( appliance, BorderLayout.EAST );
		frame.add( remoteController, BorderLayout.WEST );
		frame.setPreferredSize( new Dimension( 600,170 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


