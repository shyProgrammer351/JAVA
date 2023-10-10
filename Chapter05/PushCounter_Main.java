import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PushCounterPanel extends JPanel	
{
	private int count;
	private JButton push;
	private JLabel label;

	// 패널 준비 
	public PushCounterPanel () 		
	{
		count = 0;

		// Push Me! 버튼 준비 
		push = new JButton ("Push Me!");
		push.addActionListener (new ButtonListener());	

		// Pushes 횟수 출력 준비 
		label = new JLabel ("Pushes: " + count);

		add (push);
		add (label);

		setBackground (Color.cyan);
		setPreferredSize (new Dimension(300, 40));
		
		// 패널 준비 완료 
	}

	private class ButtonListener implements ActionListener 	
	{
		// 버튼 클릭시 작동 시작 
		public void actionPerformed (ActionEvent event) 	
		{
			// 클릭 횟수 증가 후 출력 
			count++;
			label.setText("Pushes: " + count);	
			
			// 버튼 클릭시 작동 완료 
			return;
		}
	}
}

// Push Me! 버튼 첫번째 클릭하기
// Push Me! 버튼 두번째 클릭하기
// 프레임 우측상단 X버튼 클릭하기(종료)	
public class PushCounter_Main
{
	// 프로그램시작 
	public static void main (String[] args)
	{
		// 틀 준비 
		JFrame frame = new JFrame ("Push Counter");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// 패널 준비 
		PushCounterPanel panel = new PushCounterPanel();
		frame.getContentPane().add(panel);

		// 틀에 패널 끼우고 실행 준비 완료 
		frame.pack();
		frame.setVisible(true);
		
		// 프로그램 종료 
		return;
	}
}

