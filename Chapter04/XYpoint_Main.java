import java.util.Scanner;
import java.lang.Math; 

/**
 * XYpoint 클래스는 점을 모델링 
 * @author 박소영
 *
 */
class XYpoint 
{
	/**
	 * 점의 x좌표 값
	 */
	private int x;
	/**
	 * 점의 y좌표 값
	 */
	private int y;
	
	/**
	 * XYpoint 생성자로 점 좌표 초기화
	 */
	public XYpoint( int x, int y )									
	{
		this.x = x;						
		this.y = y;						
	}
	
	/**
	 * XYpoint 생성자로 원점 초기화
	 */
	public XYpoint()									
	{
		this( 0, 0 );						
	}

	/**
	 * 점과 다른 점의 좌표값을 비교
	 * @return 두 점의 좌표가 일치하면 true, 아니면 false 
	 */
	public boolean equals( XYpoint that )					
	{
		return ( this.x == that.x) && ( this.y == that.y );
	}

	/**
	 * 점 좌표를 문자열로 표현
	 * @return 문자열 (x,y) 
	 */
	public String toString()					
	{
		return "(" + this.x + "," + this.y + ")";
	}

	/**
	 * 점과 다른 점의 거리를 계산
	 * @return 두 점 사이의 거리
	 */
	public double distanceTo( XYpoint that )					
	{
		return Math.sqrt( Math.pow( ( this.x - that.x ), 2 ) + Math.pow( ( this.y - that.y ), 2 ) );
	}
}
	
public class XYpoint_Main 
{
	// 프로그램시작 
	public static void main( String[] args ) 
	{
		// 점의 좌표값 입력	
		int x = 0, y = 0;
		Scanner scan = new Scanner( System.in );
		System.out.print( "점의 x좌표 값을 입력하세요 : " );
		x = scan.nextInt();
		System.out.print( "점의 y좌표 값을 입력하세요 : " );
		y = scan.nextInt();

		// 원점과 입력한 점 초기화		
		XYpoint origin = new XYpoint();
		XYpoint point = new XYpoint( x, y );

		// 원점과 입력한 점과 까지의 거리 계산	
		if ( origin.equals( point ) )
		{
			System.out.println( "이 점은 원점입니다" );
		}
		else
		{
			System.out.println( origin + "과" + point + "사이의 거리는 " + point.distanceTo( origin ) + "입니다" );
		}

	// 프로그램 종료 
	}
}

