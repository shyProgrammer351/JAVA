import java.lang.System;
import java.util.Scanner;

public class WordSort
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String[] word = new String[ 3 ];
	
		// 단어들 입력  
		for( int index = 0; index < word.length; index++ ) 									
		{
			System.out.print( "단어를 입력하세요: " );
			word[ index ] = scan.nextLine().trim();
		} 

		// 단어 정렬 
		// 영역의 마지막 칸에 가장 큰 값을 저장하면서, 영역을 한 칸씩 앞으로 좁혀가기 
		for ( int max = word.length - 1; max >= 0; max-- )				
		{
			// 영역의 첫번째 칸부터 인접한 두 값을 비교하면서  
			for ( int index = 0; index < max; index++ )				
			{
				// 첫 번째 칸 단어보다 알파벳순으로 더 앞에 있는 단어를 만나면 두 단어를 맞바꾸기  
				if ( word[ index ].compareTo( word[ index + 1 ] ) > 0 )				
				{
					String temp = word[ index ];						
					word[ index ] = word[ index + 1 ]; 
					word[ index + 1 ] = temp; 
				}
			}
		}

		// 정렬된 단어 출력 
		for ( int index = 0; index < word.length; index ++ )  								
		{
			System.out.println( ( index + 1 ) + ") " + word[ index ] + " " );
		} 

		// 프로그램 종료 
		return;
	}
}

