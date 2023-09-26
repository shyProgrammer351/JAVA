import java.util.Scanner;

/**
 * TV 클래스는 TV 리모컨을 모델링 
 * @author 박소영
 *
 */
class RetroTV 										
{
	// 전원버튼 켜짐(ON) 및 꺼짐(OFF) 상태 관련 상수
	public final boolean ON = true;				
	public final boolean OFF = false;			
			
	// TV 전원, 채널, 음량 변수 
	private boolean power;						
	private int channel;						
	private int volume;							
	
	/**
	 * TV 생성자로 TV 상태 초기화
	 * @return 생성자이므로 해당사항 없음
	 */
	public RetroTV()									
	{
		this.power = OFF;						
		this.channel = 100;						
		this.volume = 10;						
	}
	
	/**
	 * TV 리모컨에서 전원버튼 눌렀을 때 전원을 켜거나 끄기
	 * @return 전원 상태   
	 */
	public String clickPower()					
	{
		if( this.power == OFF )					
		{
			this.power = ON;					
			return "전원을 켭니다";
		}
		else 
		{
			this.power = OFF;					
			return "전원을 끕니다";
		}
	}
	
	/**
	 * TV 리모컨에서 상(△) 버튼을 눌렀을 때 채널을 +1 이동	
	 * @return 채널 상태 
	 */
	public String clickUp()						
	{
		return "현재 채널은 " + ( ++this.channel ) + "번입니다";		
	}
	
	/**
	 * TV 리모컨에서 하(▽) 버튼을 눌렀을 때 채널을 -1 이동
	 * @return 채널 상태 
	 */
	public String clickDown()					
	{
		return "현재 채널은 " + ( --this.channel ) + "번입니다";		
	}
	
	/**
	 * TV 리모컨에서 좌(◁) 버튼을 눌렀을 때 음량을 -1 이동	
	 * @return 음량 상태 
	 */
	public String clickLeft()					
	{
		return "현재 음량은 " + ( --this.volume ) + "입니다";		
	}
	
	/**
	 * TV 리모컨에서 우(▷) 버튼을 눌렀을 때 음량을 +1 이동
	 * @return 음량 상태 
	 */
	public String clickRight()					
	{
		return "현재 음량은 " + ( ++this.volume ) + "입니다";		
	}
}

public class RetroTV_Main 								
{
	// 프로그램시작 
	public static void main( String[] args ) 	
	{
		// 변수 초기화
		Scanner scan = new Scanner( System.in );
		String result = "";
		
		// TV 리모컨 객체 생성 	 
		RetroTV tv = new RetroTV();

		// TV 리모컨의 입력에 따라 TV를 제어하고 그 결과를 출력	 
		do
		{
			System.out.print( "TV 리모컨의 상, 하, 좌, 우, 전원, 종료 중 하나를 입력하세요 : ");
			result = scan.next();
			
			// 전원을 입력하면 전원을 켜거나 끄기	 
			if ( result.equals( "전원" ) )
			{
				System.out.println(
				                    tv.clickPower() );
			}
			// 상을 입력하면 채널을 +1 이동	 
			else if ( result.equals( "상" ) )
			{
				System.out.println(
				                    tv.clickUp() );
			}
			// 하를 입력하면 채널을 -1 이동	 
			else if ( result.equals( "하" ) )
			{
				System.out.println(
				                    tv.clickDown() );
			}
			// 좌를 입력하면 음량을 -1 이동	 
			else if ( result.equals( "좌" ) )
			{
				System.out.println(
				                    tv.clickLeft() );
			}
			// 우를 입력하면 음량을 +1 이동	 
			else if ( result.equals( "우" ) )
			{
				System.out.println(
				                    tv.clickRight() );
			}				

		} while( !result.equals( "종료" ) );
						
		// 프로그램 종료 
		return;		
	}
}

