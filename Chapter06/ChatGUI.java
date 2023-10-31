import javax.swing.JFrame;
import java.awt.Dimension;
import chat.ChatPanel;

/**************
 * 채팅 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class ChatGUI
{
	public static void main(String[] args) 
	{
		ChatPanel panel = new ChatPanel();

		JFrame frame = new JFrame( "채팅" );
		frame.getContentPane().add( panel );
		frame.setPreferredSize( new Dimension( 320, 445 ) );	
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


