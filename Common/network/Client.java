package network;	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 멀티클라이언트 서버에서 서버-클라이언트를 1:1로 입출력 연결하기 위한 스레드 클래스이며, 메인 스레드와 별개로 작동
 * @author So Young Park
 * @version 0.8
 */
public class Client extends Thread  
{
	/**
	 * 멀티클라이언트 네트워크 서버
	 */
	private MultiClientServer server;
	/** 
	 * 네트워크에서 데이터를 읽기 위한 객체
	 */	
	private BufferedReader in;
	/** 
	 * 네트워크에 데이터를 쓰기 위한 객체
	 */	
	private PrintWriter out;

	/**
	 * 각 클라이언트의 네트워크 입출력 연결 초기화 
	 * @param server 멀티 클라리언트용 네트워크 서버 객체
	 */
	public Client( MultiClientServer server )
	{
		try 
		{
			// 서버와 각 클라이언트가 데이터를 주고 받을 수 있도록 1:1로 네트워크 입출력 연결 초기화 
			this.server = server;
			this.in = new BufferedReader( new InputStreamReader( server.socket.getInputStream() ) );
			this.out = new PrintWriter( server.socket.getOutputStream(), true );
		} 
		catch ( Exception e )
		{ 
			e.printStackTrace();
		} 
	}

	/**
	 * 멀티클라이언트 서버에 데이터 도착시 모든 클라이언트와 공유 
	 */
	@Override
	public void run() 
	{
		try 
		{
			// 특정 클라이언트에서 보낸 데이터를 읽기 
			for( String data = null; ( data = in.readLine() ) != null; )
			{
				// 읽은 데이터를 서버에서 관리하는 모든 클라이언트에 전송 
				System.out.println("[Server] 데이터 도착 : " + this + " " + data );
				server.broadcast( data );  
			}
		} 
		catch ( Exception e )
		{ 
			e.printStackTrace();
		} 
	}

	/**
	 * 각 클라이언트의 네트워크 연결 해제 
	 */
	public void disconnect() 
	{
		try 
		{
			if( in != null )
			{
				in.close();
				in = null;
			}
			if( out != null )
			{
				out.close();
				out = null;
			}
		} 
		catch ( Exception e )
		{ 
			e.printStackTrace();
		}
	}
	
	/**
	 * 네트워크에 보낼 데이터 쓰기 
	 * @param data 네트워크에 보낼 데이터 
	 */
	public void write( String data ) 
	{
		try 
		{
			// 상대 클라이언트의 네트워크 연결 종료시 데이터 전송 불가 
			if ( this.getState() == Thread.State.TERMINATED )	 
			{
				System.out.println( "[Server] 클라이언트 연결 해제 : " + this );
			}		
			// 상대 클라이언트의 네트워크 연결 유효시 데이터 전송 
			else if ( out != null )
			{
				System.out.println("[Server] 데이터 전송 : " + this + " " + data );
				out.println( data );
			}
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}

