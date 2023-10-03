import java.util.Scanner;
import remoteControl.*;

public class RemoteControl_All_Main 
{
	// 프로그램시작 
	public static void main (String[] args) 
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String result = "";

		// 리모컨 객체 생성 	 
		RemoteControl rc[] = {
				new TV(),						 	
				new AirConditioner(),						
				new RoboticVacuumCleaner() };											
		
		// 리모컨의 입력에 따라 TV, 에어컨, RC카를 제어하고 그 결과를 출력	 
			do
			{
				System.out.print( "리모컨의 상, 하, 좌, 우, 전원, 종료 중 하나를 입력하세요 : ");
				result = scan.next();

				// 전원을 입력하면 TV, 에어컨, RC카의 전원을 켜거나 끄기	 
				if ( result.equals( "전원" ) )
				{
					for ( int i = 0; i < rc.length; i++ )
					{
						System.out.println(
							rc[i].clickPower() );	 
					}
				}
				// 상 버튼 입력시 TV, 에어컨, RC카의 기능 작동	 
				else if ( result.equals( "상" ) )
				{
					for ( int i = 0; i < rc.length; i++ )
					{
						System.out.println(
							rc[i].clickUp() );	 
					}
				}
				// 하 버튼 입력시 TV, 에어컨, RC카의 기능 작동	 
				else if ( result.equals( "하" ) )
				{
					for ( int i = 0; i < rc.length; i++ )
					{
						System.out.println(
							rc[i].clickDown() );	 
					}
				}
				// 좌 버튼 입력시 TV, 에어컨, RC카의 기능 작동	 
				else if ( result.equals( "좌" ) )
				{
					for ( int i = 0; i < rc.length; i++ )
					{
						System.out.println(
							rc[i].clickLeft() );	 
					}
				}
				// 우 버튼 입력시 TV, 에어컨, RC카의 기능 작동	 
				else if ( result.equals( "우" ) )
				{
					for ( int i = 0; i < rc.length; i++ )
					{
						System.out.println(
							rc[i].clickRight() );	 
					}
				}				

			} while( !result.equals( "종료" ) );

		// 프로그램 종료 
		return;		
	}
}

