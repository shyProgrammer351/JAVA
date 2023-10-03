public class AutoboxingUnboxingExample 
{
	// 프로그램시작 
	public static void main( String[] args ) 
	{
		int num1 = 10;

		// Autoboxing 예제	
		Integer num2 = num1;
		// Wrapper 클래스 활용 예제
		num2 = Integer.parseInt( "20" );

		// Unboxing 예제	
		num1 = num2;
		System.out.println( "num1 = " + num1 + ", num2 = " + num2);
		// 프로그램 종료 
	}
}

