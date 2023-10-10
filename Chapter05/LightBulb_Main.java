import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class LightBulbControls extends JPanel	
{
	private LightBulbPanel bulb;
	private JButton onButton, offButton;
	// 전구 제어 패널 준비 
	public LightBulbControls (LightBulbPanel bulbPanel)
	{
		// 전구 이미지를 변경할 수 있도록 준비 
		bulb = bulbPanel;
		// on 버튼 준비 
		onButton = new JButton ("On");
		onButton.setEnabled (false);
		onButton.setMnemonic ('n');
		onButton.setToolTipText ("Turn it on!");
		// on 버튼 클릭시 작동하는 리스너 등록 
		onButton.addActionListener (new OnListener());	
		// off 버튼 준비 
		offButton = new JButton ("Off");
		offButton.setEnabled (true);
		offButton.setMnemonic ('f');
		offButton.setToolTipText ("Turn it off!");
		// off 버튼 클릭시 작동하는 리스너 등록 
		offButton.addActionListener (new OffListener());	
		setBackground (Color.black);
		add (onButton);
		add (offButton);
	// 전구 제어 패널 준비 완료 
	}
	private class OnListener implements ActionListener	
	{
		// on 버튼 클릭시 작동 시작 
		public void actionPerformed (ActionEvent event)	
		{
			// 전구를 켜고 on 버튼 비활성화 
			bulb.setOn (true);
			onButton.setEnabled (false);
			// 나중에 전구를 끌 수 있도록 off 버튼 활성화 
			offButton.setEnabled (true);
			// 전구 이미지 패널 화면 업데이트 
			bulb.repaint();
		// on 버튼 클릭시 작동 완료 
		}
	}
	private class OffListener implements ActionListener	
	{
		// off 버튼 클릭시 작동 시작 
		public void actionPerformed (ActionEvent event)	
		{
			// 전구를 끄고 off 버튼 비활성화 
			bulb.setOn (false);
			// 나중에 전구를 켤 수 있도록 on 버튼 활성화 
			onButton.setEnabled (true);
			offButton.setEnabled (false);
			// 전구 이미지 패널 화면 업데이트 
			bulb.repaint();
		// off 버튼 클릭시 작동 완료 
		}
	}
}
class LightBulbPanel extends JPanel	
{
	private boolean on;
	private ImageIcon lightOn, lightOff;
	private JLabel imageLabel;
	// 전구 이미지 패널 준비 
	public LightBulbPanel()
	{
		// 전구가 켜진 이미지와 전구가 꺼진 이미지 준비  
		lightOn = new ImageIcon ("./Chapter05/image/lightBulbOn.gif");
		lightOff = new ImageIcon ("./Chapter05/image/lightBulbOff.gif");
		setBackground (Color.black);
		// 전구가 켜진 이미지로 초기화하여 출력 
		on = true;
		imageLabel = new JLabel (lightOff);
		add (imageLabel);
	// 전구 이미지 패널 준비 완료
	}
	public void paintComponent (Graphics page)
	{
		super.paintComponent(page);
		if (on)
			imageLabel.setIcon (lightOn);
		else
			imageLabel.setIcon (lightOff);
	}
	public void setOn (boolean lightBulbOn)
	{
		on = lightBulbOn;
	}
}
// off 버튼을 클릭
// 프레임 우측상단 X버튼 클릭하기(종료)	
public class LightBulb_Main
{
	// 프로그램 시작 
	public static void main (String[] args)
	{
		// 프레임 생성 
		JFrame frame = new JFrame ("Light Bulb");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		// 전구 이미지 패널과 전구 제어 패널 생성 
		LightBulbPanel bulb = new LightBulbPanel();
		LightBulbControls controls = new LightBulbControls (bulb);
		// 큰 패널에 전구 이미지 패널과 전구 제어 패널 두 개를 추가 
		JPanel panel = new JPanel();
		panel.setBackground (Color.black);
		panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add (Box.createRigidArea (new Dimension (0, 20)));
		panel.add (bulb);
		panel.add (Box.createRigidArea (new Dimension (0, 10)));
		panel.add (controls);
		panel.add (Box.createRigidArea (new Dimension (0, 10)));
		// 프레임에 큰 패널을 추가하고 화면에 출력 
		frame.getContentPane().add( panel );		
		frame.pack();
		frame.setVisible(true);
		// 프로그램 종료 
		return;
	}
}

