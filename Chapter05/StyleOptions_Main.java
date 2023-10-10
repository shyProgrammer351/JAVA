import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StyleOptionsPanel extends JPanel  
{
	private JLabel saying;
	private JCheckBox bold, italic;

	// 패널 준비 
	public StyleOptionsPanel()
	{
		// Say it with style! 텍스트 레이블 준비 
		saying = new JLabel( "Say it with style!" );
		saying.setFont( new Font("Helvetica", Font.PLAIN, 36 ) );

		// 진하게 및 이탤릭 속성 준비 
		bold = new JCheckBox ("Bold");
		bold.setBackground (Color.cyan);
		
		italic = new JCheckBox ("Italic");
		italic.setBackground (Color.cyan);

		// 진하게 및 이탤릭 속성 변경시 작동하도록 listener를 등록 
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);	
		italic.addItemListener(listener);	

		// Say it with style!, 진하게 속성, 이탤릭 속성을 패널에 등록 
		add (saying);
		add (bold);
		add (italic);

		// 패널 배경색과 크기 설정
		setBackground (Color.cyan);
		setPreferredSize (new Dimension(300, 100));
		// 패널 준비 완료 
	}
	private class StyleListener implements ItemListener	
	{
		// 속성값 변경시 작동 시작 
		public void itemStateChanged(ItemEvent event)	
		{
			int style = Font.PLAIN;

			// 진하게 속성을 선택했으면 글자를 진하게 설정 
			if (bold.isSelected())
				style = Font.BOLD;

			// 이탤릭 속성을 선택했으면 글자를 이탤릭체로 설정 
			if (italic.isSelected())
				style += Font.ITALIC;

			// 글자를 Helvetica 폰트, 36크기로 지정된 속성에 맞춰 출력 
			saying.setFont (new Font ("Helvetica", style, 36));	
			// 속성값 변경 완료 
			return;
		}
	}
}

// 진하게 속성 클릭하기(선택)
// 이탤릭체 속성 클릭하기(선택)
// 진하게 속성 클릭하기(해제)
// 프레임 우측상단 X버튼 클릭하기(종료)	
public class StyleOptions_Main
{
	// 프로그램시작 
	public static void main (String[] args)
	{
		// 틀 준비 
		JFrame frame = new JFrame ("Style Options");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// 패널 준비 
		frame.getContentPane().add (
						new StyleOptionsPanel());

		// 틀에 패널 끼우고 실행 준비 완료 
		frame.pack();
		frame.setVisible(true);
		
		// 프로그램 종료 
		return;
	}
}

