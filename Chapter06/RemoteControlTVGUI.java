import java.awt.*;
import javax.swing.JFrame;
import remoteControl.RemoteControllerPanel;
import remoteControl.TVPanel;

/**************
 * 리모컨으로 제어하는 TV 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class RemoteControlTVGUI
{
	public static void main(String[] args) 
	{
		TVPanel appliance = new TVPanel();
		RemoteControllerPanel remoteController = new RemoteControllerPanel( appliance );

		JFrame frame = new JFrame( "TV" );
		frame.setLayout( new BorderLayout() );     
		frame.add( appliance, BorderLayout.EAST );
		frame.add( remoteController, BorderLayout.WEST );
		frame.setPreferredSize( new Dimension( 600,170 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}
		

