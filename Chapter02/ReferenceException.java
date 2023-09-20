import java.util.*;

public class ReferenceException
{  
	// 프로그램 시작 
	public static void main(String args[]) 
	{ 
		// 변수 초기화
		String[] word = { "apple", "banana", "carrot" };

		try 											
		{
			for( int index = 0; index <= word.length; index++ )
			{
				System.out.println( ( index + 1 ) + ") " + word[ index ] + " " );
			}
		}	
		// 예외 처리 
	 	catch ( ArrayIndexOutOfBoundsException e )		
		{
			System.out.println( "\n배열 허용 범위 초과" );
		}
			
		try 											
		{
			// null 포인터 예외 발생 
			word = null;
			System.out.println( word[0] );
		}	
		catch ( NullPointerException e ) 				
		{
			System.out.println( "빈 객체 접근 오류" );
		}
		
		// 프로그램 종료 
		return;
	} 
}

