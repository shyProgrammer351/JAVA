
public class GenericMethodMain {
	// 정렬 메서드 
	public static <T extends Comparable<T>> void sort( T[] list ) {
		// 영역의 마지막 칸에 가장 큰 값을 저장하면서, 영역을 한 칸씩 앞으로 좁혀가기 
		for ( int max = list.length - 1; max >= 0; max-- )				
		{
			// 영역의 첫번째 칸부터 인접한 두 값을 비교하면서  
			for ( int index = 0; index < max; index++ )				
			{
				// 첫 번째 칸 단어보다 알파벳순으로 더 앞에 있는 단어를 만나면 두 단어를 맞바꾸기  
				if ( list[ index ].compareTo( list[ index + 1 ] ) > 0 )				
				{
					T temp = list[ index ];						
					list[ index ] = list[ index + 1 ]; 
					list[ index + 1 ] = temp; 
				}
			}
		}
	}
	
	public static <T> void print( T[] list ) 
	{	
		for ( int index = 0; index < list.length; index ++ )  					 
		{
			System.out.print( ( index + 1 ) + ") " + list[ index ] + " " );
		} 
		System.out.println();
	}		
	
	// 프로그램 시작  
	public static void main(String[] args) {

		// 점수 정렬  
		Integer[] scores = new Integer[]{ 90, 89, 86 };
		// 점수 정렬  
		sort( scores );
		// 점수 출력  
		print( scores );

		// 단어 입력  
		String[] words = new String[]{ "carrot", "banana", "apple" };
		// 단어 정렬  
		sort( words );
		// 단어 출력  
		print( words );

		// 프로그램 종료   
	}
}

