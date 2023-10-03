import java.util.Scanner;
import remoteControl.AirConditioner;
public class AirConditioner_Main 								
{
	// 프로그램시작 
	public static void main( String[] args ) 	
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String result = "";
		
		// 에어컨 리모컨 객체 생성 	 
		AirConditioner aircon = new AirConditioner();

		// 에어컨 리모컨의 입력에 따라 에어컨을 제어하고 그 결과를 출력	 
		do
		{
			System.out.print( "에어컨 리모컨의 상, 하, 좌, 우, 전원, 종료 중 하나를 입력하세요 : ");
			result = scan.next();
			
			// 전원을 입력하면 전원을 켜거나 끄기	 
			if ( result.equals( "전원" ) )
			{
				System.out.println( aircon.clickPower() );
			}
			// 상을 입력하면 온도를 +1 이동	 
			else if ( result.equals( "상" ) )
			{
				System.out.println( aircon.clickUp() );
			}
			// 하를 입력하면 온도를 -1 이동	 
			else if ( result.equals( "하" ) )
			{
				System.out.println( aircon.clickDown() );
			}
			// 좌를 입력하면 풍량을 -1 이동	 
			else if ( result.equals( "좌" ) )
			{
				System.out.println( aircon.clickLeft() );
			}
			// 우를 입력하면 풍량을 +1 이동	 
			else if ( result.equals( "우" ) )
			{
				System.out.println( aircon.clickRight() );
			}				

		} while( !result.equals( "종료" ) );
						
		// 프로그램 종료 
		return;		
	}
}

