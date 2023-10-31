import javax.swing.JFrame;
import java.awt.Dimension;
import chat.ChatbotPanel;

/**************
 * 챗봇 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class ChatbotGUI
{
	public static void main(String[] args) 
	{
		ChatbotPanel panel = new ChatbotPanel();

		JFrame frame = new JFrame( "챗봇" );
		frame.getContentPane().add( panel );
		frame.setPreferredSize( new Dimension( 320, 445 ) );	
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


