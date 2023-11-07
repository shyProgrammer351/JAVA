import java.util.*;
import java.io.*;

/**
 * 챗봇 클래스
 * @author So Young Park
 * @version 0.8
 */
class Chatbot							 
{
	ArrayList<String[]> pairs = new ArrayList<String[]>();	
		
	public Chatbot() 
	{
		 String[][] dialogue = { { "이름이 뭐", "난 재석이야. 국민MC 유재석과 이름이 같아. ㅎㅎㅎ 넌 몇 살이니?" },
				  { "만나서 반가", "나도 반가워 친하게 지내자" } };
			for( String[] pair : dialogue )
				pairs.add( pair );																
	}

		// 챗봇 답변을 생성하는 메서드 시작					
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
		return userUtterance + "(시스템) 뭐 딴거 재밌는거 없을까?";		 
		// 챗봇 답변을 생성하는 메서드 종료 					
	}

	public String getFinalResponse()
	{
		return "(시스템) 그래 안녕! 담에 또 봐!";										 
	}
}

/**************
 * 챗봇 프로그램의 ChatbotFromFile 클래스
 * @author So Young Park
 * @version 0.8
 */	
class ChatbotFromFile extends Chatbot
{
	public ChatbotFromFile( String dialoguePairFilename  )
	{
		super();
		this.pairs.clear();	
		
		try
		{
			// 파일 준비 	
			BufferedReader inFile = new BufferedReader( new FileReader( new File( dialoguePairFilename ) ) ); 

			// 준비한 대화쌍 파일에서 읽어오기 
			for( String line = ""; ( line = inFile.readLine() ) != null; ) 
			{
				// 파일에서 읽은 대화쌍을 대화쌍 배열에 추가하기 
				StringTokenizer tokenizer = new StringTokenizer( line, "\t\n" ); 
				String[] pair = new String[2];
				pair[0] = tokenizer.nextToken();	
				pair[1] = tokenizer.nextToken();	
				pairs.add( pair );								
			}
			
			// 파일 닫기 
			inFile.close();	
		}
		catch ( IOException e ) 				 
		{
			System.out.println( "[오류] 파일을 열 수 없습니다!" );
			e.printStackTrace();
		}
	}
}

/**************
 * 챗봇 프로그램의 Main 클래스
 * @author So Young Park
 * @version 0.8
 */	
public class ChatbotFromFileMain							 
{
	 
	public static void main(String[] args) 	 
	{
		Scanner scan = new Scanner( System.in );  
		final String filename = "C:\\Users\\user\\Downloads\\dialogue.txt";
		
		ChatbotFromFile chatbot = new ChatbotFromFile( filename );

		// 사용자와 챗봇의 대화 반복 
		for ( String input = null, output = null;		                                          ( output = chatbot.getResponse( input ) ) != null; ) {
			System.out.print( output + "\n 사용자: " );
			input = scan.nextLine();
		}

		System.out.print( 
		                  chatbot.getFinalResponse() + "\n" );
		scan.close();
		return;	 
	}
}

