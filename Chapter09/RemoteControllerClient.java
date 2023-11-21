import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import remoteControl.RemoteControlNetwork;

/**
 * 가전제품을 제어하는 리모컨 프로그램의 네트워크 클라이언트 버전
 * @author So Young Park
 * @version 0.8
 */	
public class RemoteControllerClient
{
	public static void main(String[] args) 
	{
		String serverIP = "localhost";			
		RemoteControlNetwork panel = new RemoteControlNetwork( serverIP );

		JFrame frame = new JFrame( "리모컨(클라이언트)" );
		frame.getContentPane().add( panel );
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) { 
				panel.close();
			}
		} );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );		
	}
}


