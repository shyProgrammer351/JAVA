package chat;
import java.awt.event.*;
import javax.swing.JOptionPane;
import network.Network;

/**
 * 채팅 프로그램의 네트워크 담당 클래스
 * @author So Young Park
 * @version 0.8
 * @see     net.Network()
 */	
public class ChatNetwork extends ChatPanel implements Runnable
{	
	/** 
	 * 네트워크
	 */	
	private Network network;
	/** 
	 * 채팅 참여자 아이디
	 */	
	private String  id;
	/** 
	 * 채팅 프로그램의 메시지 헤더 
	 */	
	private final String header = "[CHAT] ";
		
	/**
	 * 채팅 프로그램의 네트워크 연결 초기화  
	 * @param serverIP 서버 IP 주소
	 */
	public ChatNetwork( String serverIP )
	{
		super();
		id = "[" + JOptionPane.showInputDialog( this, "아이디를 입력해주세요.", "아이디" ) + "]";

		network = new Network();
		network.connectAsClient( serverIP, this );
		network.write( header + id + "님이 들어오셨습니다" );
	}
		
	/**
	 * 대화 내용 입력시 상대편에게 대화 내용 전송 
	 * @param event 대화 입력 결과 
	 */
	@Override
	public void actionPerformed( ActionEvent event )
	{
		// 참여자가 입력한 대화 내용 읽기 
		String message = inputField.getText();			                 
		// 상대편에게 네트워크로 대화 내용 전송 
		network.write( header + id + message );  
		inputField.setText( "" );
	}

	/**
	 * 대화 내용 도착시 채팅 화면 업데이트 
	 */
	@Override
	public void run() 
	{	
		// 상대편이 네트워크로 보낸 대화 내용 읽기 
		for ( String message = null; ( message = network.read() ) != null; )
		{
			// 채팅 프로그램 대화 내용이 아니면 메시지 무시
			if ( !message.contains( header ) )
				continue;

			// 채팅 화면에 해당 대화 내용 쓰기 
			chatWindow.append( message.substring( header.length() ) + "\n" );
			chatWindow.setCaretPosition( chatWindow.getText().length() );				
		}  
	}

	/**
	 * 채팅 프로그램의 네트워크 연결 해제 
	 */
	public void close() 
   	{
		// 상대편에게 네트워크로 프로그램 종료 알림 
		network.write( header + " " + id + "님이 나가셨습니다" );
		// 네트워크 연결 해제
		network.disconnect();
	}
}

