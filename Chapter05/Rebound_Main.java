//타이머 두번 호출 후 X버튼을 눌러 종료하는 실행 순서
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ReboundPanel extends JPanel	
{
	private final int WIDTH = 300, HEIGHT = 100;
	private final int DELAY = 20, IMAGE_SIZE = 35;
	private ImageIcon image;
	private Timer timer;
	private int x, y, moveX, moveY;
	
	// 패널 준비 
	public ReboundPanel()
	{
		// 타이머 및 스마일 이미지 준비 
		timer = new Timer(DELAY, new ReboundListener());
		image = new ImageIcon ("./Chapter05/image/happyFace.gif");
		// 이미지 초기 위치, 이동 간격, 이동 가능 영역 설정 
		x = 0;
		y = 40;
		moveX = moveY = 3;
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground (Color.black);
		timer.start();
		// 패널 준비 완료 
	}
	public void paintComponent (Graphics page)
	{
		super.paintComponent (page);
		image.paintIcon (this, page, x, y);
	}
	private class ReboundListener implements ActionListener	
	{
		// 타이머 활성화시 작동 시작 
		public void actionPerformed (ActionEvent event)	
		{
			// 이동 가능 영역내에서 이미지 위치 이동  
			x += moveX;
			y += moveY;
			if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
				moveX = moveX * -1;
			
			if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
				moveY = moveY * -1;
			
			// 패널 화면 업데이트 
			repaint();	
		// 타이머 활성화시 작동 완료 
		}
	}
}
// 첫번째 타이머 호출
// 두번째 타이머 호출
// 프레임 우측상단 X버튼 클릭하기(종료)	
public class Rebound_Main
{
	//프로그램시작 
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Rebound");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//패널 생성 및 추가 
		frame.getContentPane().add(
								new ReboundPanel());
		//프레임에 묶어준 뒤 화면에 출력 
		frame.pack();
		frame.setVisible(true);
		//프로그램 종료 
		return;
	}
}

