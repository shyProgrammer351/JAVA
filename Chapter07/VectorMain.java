import java.util.Vector;
public class VectorMain 
{
	// 프로그램 시작 	
	public static void main(String[] args) 
	{
		// 벡터 생성 
		Vector list = new Vector( 3 ); 
		// 벡터에 객체를 추가 
		list.add( "Vector" ); 
		list.add( 1 ); 
		list.add( 2.5 ); 
		list.add( 0, "Collection" ); 
		list.add( 2, null ); 
		// 벡터에서 객체를 제거 
		list.remove( 0 ); 
		list.remove( 1 ); 
		
		// 벡터의 객체를 출력 
		for( int i=0; i < list.size(); i++ ) {
			System.out.println( i + ") " + list.get(i) );
		}
		
		System.out.println( "총객체수 = " + list.size() );
		System.out.println( "공간크기 = " + list.capacity() ); 

		// 벡터에서 객체를 확인 
		if( list.contains( "Collection" ) )
			System.out.println( "Collection 포함" );
		else 
			System.out.println( "Collection 미포함" );

		if( list.contains( 2.5 ) )
			System.out.println( "2.5 포함" );
		else 
			System.out.println( "2.5 미포함" );
		
		// 벡터를 비우기 
		list.clear();
		if( list.isEmpty() )
			System.out.println( "빈 리스트" );

		// 프로그램 종료 	
	}
}

