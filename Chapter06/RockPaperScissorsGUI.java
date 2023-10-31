import javax.swing.JFrame;
import rockPaperScissors.RockPaperScissorsPanel;

/**************
 * 가위바위보 게임의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class RockPaperScissorsGUI
{
	public static void main(String[] args) 
	{
		RockPaperScissorsPanel panel = new RockPaperScissorsPanel();

		JFrame frame = new JFrame( "가위바위보" );
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


