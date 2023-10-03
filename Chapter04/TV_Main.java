import java.util.Scanner;
import remoteControl.TV;
public class TV_Main 							 
{
	// 프로그램시작 
	public static void main( String[] args ) 	 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String result = "";
		
		// TV 리모컨 객체 생성 	 
		TV tv = new TV();

		// TV 리모컨의 입력에 따라 TV를 제어하고 그 결과를 출력	 
		do
		{
			System.out.print( "TV 리모컨의 상, 하, 좌, 우, 전원, 종료 중 하나를 입력하세요 : ");
			result = scan.next();
			
			// 전원을 입력하면 전원을 켜거나 끄기	 
			if ( result.equals( "전원" ) )
			{
				System.out.println( tv.clickPower() );
			}
			// 상을 입력하면 채널을 +1 이동	 
			else if ( result.equals( "상" ) )
			{
				System.out.println( tv.clickUp() );
			}
			// 하를 입력하면 채널을 -1 이동	 
			else if ( result.equals( "하" ) )
			{
				System.out.println( tv.clickDown() );
			}
			// 좌를 입력하면 음량을 -1 이동	 
			else if ( result.equals( "좌" ) )
			{
				System.out.println( tv.clickLeft() );
			}
			// 우를 입력하면 음량을 +1 이동	 
			else if ( result.equals( "우" ) )
			{
				System.out.println( tv.clickRight() );
			}				

		} while( !result.equals( "종료" ) );
						
		// 프로그램 종료 
		return;		
	}
}

