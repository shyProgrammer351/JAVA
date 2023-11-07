import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
public class ScoreVectorMain {
	// 프로그램 시작 	
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );
		Vector<Integer> scores = new Vector<Integer>(); 

		// 점수 입력   
		while( true ) {
			System.out.print( "0점 ~ 100점 사이의 점수를 입력하세요: " );
			int score = scan.nextInt(); 
			if ( ( score < 0 ) || ( 100 < score ) )
				break;
			scores.add( score );
		}

		// 점수 정렬  
		Collections.sort( scores );

		// 점수 출력  
		for( Integer score : scores )
			System.out.print( score + " " );

	// 프로그램 종료 	
	}
}

