import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import threeCupGame.ThreeCupGameNetwork;

/**
 * 구슬찾기 프로그램의 네트워크 서버 버전
 * @author So Young Park
 * @version 0.8
 */	
public class ThreeCupGameServer
{
	public static void main(String[] args) 
	{
		ThreeCupGameNetwork panel = new ThreeCupGameNetwork();

		JFrame frame = new JFrame( "구슬찾기(서버)" );
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


