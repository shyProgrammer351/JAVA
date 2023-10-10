//다른 좌표를 한번 찍고 종료하는 실행 순서
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

class CoordinatesPanel extends JPanel	
{
	private final int SIZE = 6;
	private int x = 50, y = 50; 

	// 패널 준비 
	public CoordinatesPanel()
	{
		// 패널 내에서 마우스 이벤트 발생시 반응하도록 준비 
		addMouseListener( new CoordinatesListener() );	
		setBackground( Color.black );
		setPreferredSize( new Dimension(300, 200) );
		// 패널 준비 완료 
	}
	public void paintComponent (Graphics page)
	{
		super.paintComponent(page);
		page.setColor (Color.green);
		page.fillOval (x, y, SIZE, SIZE);
		page.drawString ("Coordinates: (" + x + ", " + y + ")", 5, 15);
	}
	private class CoordinatesListener implements MouseListener	
	{
		// 마우스 이벤트 발생시 작동 시작 
		public void mousePressed (MouseEvent event)	
		{
			// 현재 마우스의 xy 좌표 값 확인   
			x = event.getX();
			y = event.getY();
			// 패널 화면 업데이트 
			repaint();
		// 마우스 이벤트 발생시 작동 완료 
		}
		public void mouseClicked (MouseEvent event) {}
		public void mouseReleased (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
	}
}

// (211,142) 좌표에 클릭
// 프레임 우측상단 X버튼 클릭하기(종료)	

public class Coordinates_Main
{
	// 프로그램시작 
	public static void main (String[] args)
	{
		// 프레임 준비 
		JFrame frame = new JFrame ("Coordinates");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		// 패널 생성하고 후 프레임에 추가 
		frame.getContentPane().add (
				new CoordinatesPanel());
		// 프레임에 묶어준 뒤 화면에 출력 
		frame.pack();
		frame.setVisible(true);
		// 프로그램 종료 
		return;
	}
}

