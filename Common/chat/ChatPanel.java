package chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 채팅 GUI 화면 관리 클래스
 * @author So Young Park
 * @version 0.8
 */
public class ChatPanel extends JPanel implements ActionListener 
{
	/**
	 * 채팅창
	 */
	protected JTextArea  chatWindow;
	/**
	 * 대화 입력창
	 */
	protected JTextField inputField;

	/**
	 * 채팅 GUI 화면 초기화 
	 */
	public ChatPanel() 
	{
		// 채팅창 초기화 
		chatWindow = new JTextArea();
		chatWindow.setBackground( Color.lightGray );
		chatWindow.setEditable( false ); 		
		chatWindow.setLineWrap( true );
		// 채팅창이 길어지면 스크롤 활성화 
		JScrollPane scroll = new JScrollPane( chatWindow );
		scroll.setPreferredSize( new Dimension( 290, 360 ) );	
		add( scroll );
		// 입력창 초기화 
		inputField = new JTextField();
		inputField.setPreferredSize( new Dimension( 290, 30 ) );		
		inputField.addActionListener( this );	
		inputField.requestFocus(); 
		add( inputField );
		
		setVisible( true );
	} 

	/**
	 * 사용자가 대화를 입력시 채팅 상황 업데이트 
	 * @param ActionEvent e : 이벤트
	 * @return 없음
	 */
	@Override
	public void actionPerformed( ActionEvent e )
	{
		// 입력창에서 대화 입력 내용을 가져오기 
		String userUtterance = inputField.getText();
		inputField.setText( "" );
		// 대화 입력 내용을 채팅창에 출력 
		chatWindow.append( "[사용자] " + userUtterance + "\n" );
		chatWindow.setCaretPosition( chatWindow.getText().length() );
	}
}

