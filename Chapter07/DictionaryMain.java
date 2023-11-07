import java.util.*;
import java.io.*;

public class DictionaryMain 
{
	// 프로그램시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );	
		String word = "";
		String meaning = "";

		// 영어 단어를 입력 
		System.out.println( "영어단어를 입력하세요 : " );
		word = scan.nextLine(); 
		try
		{
			// 영한 사전을 열기 
			BufferedReader dictionary = new BufferedReader( new FileReader( new File( "C:\\Users\\user\\Downloads\\dictionary.txt" ) ) ); 	
			// 영한 사전에서 한 줄씩 읽고 
			while ( ( meaning = dictionary.readLine() ) != null ) 
			{
				// 해당 영어단어를 찾으면 뜻을 출력 
				if ( meaning.indexOf( word ) == 0 ) 
				{
					System.out.println( meaning );
					break;
				}
			}
		
			// 영한 사전 닫기 
			dictionary.close();	 
		}
		catch ( IOException e ) 
		{
			System.out.println( "[오류] 파일을 열 수 없습니다!" );
			e.printStackTrace();
		}

		// 프로그램 종료 
		return;
	}
}

