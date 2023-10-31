package chat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 챗봇 클래스
 * @author So Young Park
 * @version 0.8
 */
public class Chatbot 
{
	ArrayList<String[]> pairs = new ArrayList<String[]>();
	public Chatbot()
	{
		String[][] pairsOfDialogue = { { "이름이 뭐", "난 재석이야. 국민MC 유재석과 이름이 같아. ㅎㅎㅎ 넌 몇 살이니?" },
					  { "몇 살", "난 20살이야. 남들이 다 부러워하는 나이지. 넌 어디 살아?" },
					  { "어디 살", "난 홍지동 살아. 북한산 아래 있어서 공기가 무지 맑아.ㅎㅎㅎ 취미가 뭐니?" },
					  { "만나서 반가", "나도 반가워 친하게 지내자" } };
		
		for( String[] pair : pairsOfDialogue )
			pairs.add( pair );
	}

	public String getResponse( String userUtterance )
	{
		// 시스템 답변 출력  
		if ( userUtterance == null )
		{
			return "[챗봇] 안녕? 넌 이름이 모야?";
		}		
		else if ( userUtterance.contains( "바이" ) == true )
		{
			return null;
		}

		// 준비한 대화쌍에서 
		for ( String[] pair : pairs )
		{
			// 적절한 답변을 찾으면 시스템 답변을 출력  
			if ( userUtterance.contains( pair[0] ) == true ) 	
			{
				return "[챗봇] " + pair[1]; 
			}
		}

		// 적절한 답변을 못 찾으면 '뭐 딴거 재밌는거 없을까?' 출력 
		return userUtterance + "[챗봇] 뭐 딴거 재밌는거 없을까?";
	}

	public String getFinalResponse()
	{
		return "[챗봇] 그래 안녕! 담에 또 봐";
	}
}

