package chat;
import java.awt.event.ActionEvent;

/**
 * 챗봇 GUI 화면 관리 클래스
 * @author So Young Park
 * @version 0.8
 */

public class ChatbotPanel extends ChatPanel
{
	/**
	 * 챗봇
	 */
	protected Chatbot	 chatbot;
			
	/**
	 * 챗봇 GUI 화면 초기화 
	 */
	public ChatbotPanel() 
	{
		// 챗봇 초기화 
		super();
		chatbot = new Chatbot();
		// 채팅 GUI 화면 초기화 
		showChatBotResponse( null );	
	}
	
	/**
	 * 사용자가 발화를 입력시 챗봇 답변 출력하여 채팅 상황 업데이트 
	 * @param ActionEvent e : 이벤트
	 * @return 없음
	 */
	@Override
	public void actionPerformed( ActionEvent e )	
	{
		// 챗봇 사용자의 입력 내용을 가져오기 
		String userUtterance = inputField.getText();
		// 챗봇 사용자의 입력 내용을 채팅창에 출력 
		super.actionPerformed( e );	
		// 챗봇 답변을 채팅창에 출력 
		showChatBotResponse( userUtterance );	
	}

	/**
	 * 챗봇 답변을 채팅창에 출력하는 메서드 
	 * @param String userUtterance : 사용자 발화
	 */
	public void showChatBotResponse( String userUtterance )
	{
		// 사용자 발화에 적절한 챗봇 답변을 찾기 
		String botResponse = chatbot.getResponse( userUtterance );
		if ( botResponse == null ) 
			botResponse = chatbot.getFinalResponse();
		
		// 챗봇 답변 출력 
		chatWindow.append( botResponse + "\n" );
		chatWindow.setCaretPosition( chatWindow.getText().length() );
	}	
}

