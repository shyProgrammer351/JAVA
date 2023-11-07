import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class WordArrayListMain {
	// 프로그램 시작 	
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );
		ArrayList<String> words = new ArrayList<String>(); 

		// 단어 입력   
		while( true ) {
			System.out.print( "단어를 입력하세요(종료시quit): " );
			String word = scan.nextLine(); 
			if ( word.equals("quit") )
				break;
			words.add( word );
		}

		// 단어 정렬  
		Collections.sort( words );

		// 단어 출력  
		for( String word : words )
			System.out.print( word + " " );

	// 프로그램 종료 	
	}
}

