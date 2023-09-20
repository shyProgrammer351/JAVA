import java.lang.System;
import java.util.Scanner;

public class ScoreSort
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		int[] score = new int[ 3 ];
	
		// 점수들 입력  
		for( int index = 0; index < score.length; index ++ )							
		{
			System.out.print( "0점 ~ 100점 사이의 점수를 입력하세요: " );
			score[ index ] = scan.nextInt(); 
		} 
		// 점수 정렬 
		// 영역의 마지막 칸에 가장 큰 값을 저장하면서, 영역을 한 칸씩 앞으로 좁혀가기 
		for ( int max = score.length - 1; max >= 0; max-- )				
		{
			// 영역의 첫번째 칸부터 인접한 두 값을 비교하면서  
			for ( int index = 0; index < max; index++ )				
			{
				// 앞이 뒤보다 크면 두 값을 맞바꾸기하면서 뒤쪽에 큰 값을 저장 
				if ( score[ index ] > score[ index + 1 ] )
				{
					int temp = score[ index ];
					score[ index ] = score[ index + 1 ];							
					score[ index + 1 ] = temp;								
				}
			}	
		}

		// 정렬된 점수 출력 
		for ( int index = 0; index < score.length; index++ )							
		{
			System.out.println( ( index + 1 ) + ") " + score[ index ] + " " );
		} 
		// 프로그램 종료 
		return;
	}
}

