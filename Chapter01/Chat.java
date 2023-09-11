import java.lang.System;										
import java.util.Scanner;										

public class Main 
{
	// 프로그램시작 
	public static void main( String[] args )  						
	{
		// 변수 선언 및 초기화
		Scanner scan = new Scanner( System.in );				
		String name = null;										
		String job = null;										
		String hobby = null;									
		String color = null;									

		// 친구와! 대화하기 
		// 이름 물어보고 답하기 
		System.out.print( "안녕? 넌 이름이 뭐야: " ); 
		name = scan.nextLine();									
		System.out.println( "만나서 반가워, " + name + ". " );	

		// 직업 물어보고 답하기 
		System.out.print( "넌 주로 뭐하고 살아: " );	
		job = scan.nextLine();									
		System.out.println( job + "? 나도 마찬가지야 ㅎㅎ " );	

		// 취미 물어보고 답하기 
		System.out.print( "그럼 심심할 때 뭐하니: " );
		hobby = scan.nextLine();								
		System.out.println( hobby + "? 나랑 똑같네. " );

		// 좋아하는 색 물어보고 답하기 
		System.out.print( "혹시 좋아하는 색은 뭐야 : " );	
		color = scan.nextLine();								
		System.out.println( color + "이라구? 와! 이것도 나랑 똑같네. 신기하다." );

		// 친하게 지내자고 인사하기 
		System.out.println( "앞으로 우리 친하게 지내자." );

		// 프로그램 종료 
		return;
	}
}

