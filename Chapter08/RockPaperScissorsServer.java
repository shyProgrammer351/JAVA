import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import rockPaperScissors.RockPaperScissorsNetwork;

/**
 * 가위바위보 프로그램의 네트워크 서버 버전
 * @author So Young Park
 * @version 0.8
 */	
public class RockPaperScissorsServer
{
	public static void main(String[] args) 
	{
		RockPaperScissorsNetwork panel = new RockPaperScissorsNetwork();

		JFrame frame = new JFrame( "가위바위보(서버)" );
		frame.getContentPane().add( panel );
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) { 
				panel.close();
			}
		} );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
		
		panel.connectAsServer();
	}
}


