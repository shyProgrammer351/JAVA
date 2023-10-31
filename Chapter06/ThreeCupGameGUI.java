import javax.swing.JFrame;
import threeCupGame.ThreeCupGamePanel;

/**************
 * 구슬찾기 게임의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */	
public class ThreeCupGameGUI
{
	public static void main(String[] args) 
	{
		ThreeCupGamePanel panel = new ThreeCupGamePanel();

		JFrame frame = new JFrame( "구슬찾기" );
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


