import java.util.ArrayList;
import java.util.Scanner;

/**
 * 챗봇 클래스
 * @author So Young Park
 * @version 0.8
 */
class Chatbot								
{
	private String[][] pairs = { { "이름이 뭐", "난 재석이야. 국민MC 유재석과 이름이 같아. ㅎㅎㅎ 넌 몇 살이니?" },
				  { "몇 살", "난 20살이야. 남들이 다 부러워하는 나이지. 넌 어디 살아?" },
				  { "어디 살", "난 홍지동 살아. 북한산 아래 있어서 공기가 무지 맑아.ㅎㅎㅎ 취미가 뭐니?" },
				  { "만나서 반가", "나도 반가워 친하게 지내자" } };
	
	public Chatbot()					
	{
	}

	// 챗봇 답변을 생성하는 메서드 					
	public String getResponse( String userUtterance ) 
	{
		// 챗봇 시작시 사용자에게 말 걸기  					
		if ( userUtterance == null )
		{
			return "(시스템) 안녕? 넌 이름이 모야?";								
		}		
		else if ( userUtterance.contains( "바이" ) == true ) 
		{
			return null;																	
		}

		// 준비한 대화쌍에서  
		for ( String[] pair : pairs )
		{
			// 적절한 답변을 찾으면 챗봇 답변을 출력  
			if ( userUtterance.contains( pair[0] ) == true ) 
			{
				return "(시스템) " + pair[1]; 									
			}
		}

		// 적절한 답변을 못 찾으면 '뭐 딴거 재밌는거 없을까?' 출력 
		return "(시스템) 뭐 딴거 재밌는거 없을까?";		
	}

	public String getFinalResponse()
	{
		return "(시스템) 그래 안녕! 담에 또 봐!";											
	}
}

/**************
 * 챗봇 프로그램의 Main 클래스
 * @author So Young Park
 * @version 0.8
 */	
public class Chatbot_Main								
{
	// 프로그램 시작 	
	public static void main(String[] args) 	
	{
		Scanner scan = new Scanner( System.in ); 
		
		Chatbot chatbot = new Chatbot();

		// 사용자와 챗봇의 대화 반복 
		for ( String input = null, output = null;		                                          ( output = chatbot.getResponse( input ) ) != null; ) {
			// 사용자 입력에 적절한 챗봇 답변 출력 	
			System.out.print( output + "\n 사용자: " );
			input = scan.nextLine();
		}

		// 사용자가 '바이'를 입력하면 '그래 안녕! 담에 또 봐!'를 출력 후 대화를 종료			
		System.out.print( 
		                  chatbot.getFinalResponse() + "\n" );
		scan.close();
		// 프로그램 종료 	
		return;	
	}
}

