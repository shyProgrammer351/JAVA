class MyList<T> {
	private Object[] array;
	private int index; 
	private int size; 
	
	public MyList( int size ) {
		index = 0; 
		this.size = size; 
		array = new Object[size];
	}
	
	public MyList() {
		this(10);
	}
	
	public void add( T item ) {
		if( index == size ) {
			Object[] newArray = new Object[ size * 2 ];
			for( int i = 0; i < size; i++ )
				newArray[i] = array[i];
			array = newArray;
			size = size*2;
		}
		array[index++] = item;
	}
	
	public T remove() {
		if( index == 0 )
			return null;
		return (T)array[--index]; 
	}
	
	public T get( int index ) {
		return (T)array[index];
	}
	
	public int size() {
		return index;
	}
}

public class GenericClassMain {
	public static void main(String[] args) {
		MyList<String> strList = new MyList<String>(2);

		// MyList에 문자열 추가  
		strList.add( "carrot" );
		strList.add( "banana" );
		// MyList에 문자열 제거
		strList.remove();
		// MyList를 출력
		System.out.print( "(strList) " );
		for( int i=0; i < strList.size(); i++ )
			System.out.print( 
			                  strList.get(i) + " " );

		// MyList에 정수 추가 
		MyList<Integer> intList = new MyList<Integer>(2); 
		intList.add( 10 );
		intList.add( 20 );
		intList.add( 30 );
		// MyList에 정수 제거
		intList.remove();
		// MyList를 출력
		System.out.print( "\n(intList) " );
		for( int i=0; i < intList.size(); i++ )
			System.out.print( intList.get(i) + " " );
	}
}

