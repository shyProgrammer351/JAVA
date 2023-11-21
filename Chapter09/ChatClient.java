import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import chat.ChatNetwork;

/**************
 * 채팅 프로그램의 네트워크 클라이언트 버전 
 * @author So Young Park
 * @version 0.8
 */	
public class ChatClient
{
	public static void main(String[] args) 
	{
		String serverIP = "localhost";
		ChatNetwork panel = new ChatNetwork( serverIP );

		JFrame frame = new JFrame( "채팅(클라이언트)" );
		frame.getContentPane().add( panel );
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) { 
				panel.close();
			}
		} );
		frame.setPreferredSize( new Dimension( 320, 445 ) );	
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}


