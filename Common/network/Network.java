package network;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 네트워크 연결 및 입출력 전용 클래스
 * @author So Young Park
 * @version 0.8
 */
public class Network 
{
	/** 
	 * 서버 포트 번호 
	 */	
	protected int serverPort;
	/** 
	 * 서버로 네트워크를 개설하기 위한 소켓
	 */	
	protected ServerSocket serverSocket; 
	/** 
	 * 서버-클라이언트를 1:1로 연결하기 위한 네트워크 소켓 
	 */	
	protected Socket socket; 
	
	/** 
	 * 네트워크에서 데이터를 읽기 위한 객체
	 */	
	private BufferedReader in;
	/** 
	 * 네트워크에 데이터를 쓰기 위한 객체
	 */	
	private PrintWriter out; 
	/** 
	 * 네트워크에 상대편의 데이터가 도착할 때까지 계속 대기하고 있다가 데이터가 도착하면 활성화되는 스레드이며, 메인 스레드와 별개로 작동  
	 */	
	private Thread waitForCounterpart; 

	/**
	 * 네트워크 클래스 초기화
	 */
	public Network()
	{	
		serverPort = 7700;
		serverSocket = null;
		socket = null;
		in = null;
		out = null;
		waitForCounterpart = null;
	}
	
	/**
	 * 네트워크 서버 연결 초기화 
	 * @param obj 네트워크에 데이터 도착시 데이터 처리 담당 객체
	 */
	public void connectAsServer( Runnable obj )  
	{
		try 
		{
			// 서버 소켓 연결 
			serverSocket = new ServerSocket( serverPort ); 
			// 클라이언트에서 서버로 연결 요청시 연결 활성화 
			socket = serverSocket.accept();
			// 네트워크 입출력 연결 초기화 
			in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			out = new PrintWriter( socket.getOutputStream(), true );
			// 네트워크에 데이터가 도착할 때까지 대기 시작 
			waitForCounterpart = new Thread( obj ); 
			waitForCounterpart.start();  
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	} 

	/**
	 * 네트워크 클라이언트 연결 초기화   
	 * @param serverIP 서버 IP 주소 
	 * @param obj 네트워크에 데이터 도착시 데이터 처리 담당 객체
	 */
	public void connectAsClient( String serverIP, Runnable obj )  
	{
		try 
		{
			// 클라이언트에서 서버로 연결 요청  
			socket = new Socket( serverIP, serverPort );
			// 네트워크 입출력 연결 초기화 
			in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
			out = new PrintWriter( socket.getOutputStream(), true );
			// 네트워크에 데이터가 도착할 때까지 대기 시작  
			waitForCounterpart = new Thread( obj ); 
			waitForCounterpart.start();	
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 상대편이 네트워크로 보낸 데이터 읽기
	 * @return 네트워크에 도착한 데이터
	 */
	public String read() 
	{
		try 
		{
			if ( this.isConnecting() == true )
				return 
				       in.readLine(); // 네트워크에 상대편 데이터가 도착할 때까지 계속 대기
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 상대편에게 네트워크로 데이터 전송 
	 * @param data 네트워크에 보낼 데이터 
	 */
	public void write( String data ) 
	{
		try 
		{
			if ( this.isConnecting() == true )
				out.println( data );
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * 네트워크 연결 해제 
	 */
	public void disconnect() 
	{
		try 
		{
			if( waitForCounterpart != null )
			{
				waitForCounterpart.interrupt();	  
				waitForCounterpart = null;
			}
			if( in != null )
			{
				in.close();
				in=null;
			}			
			if( out != null )
			{
				out.flush();
				out.close();
				out = null;
			}
			if( socket != null )
			{
				socket.close();
				socket = null;
			}
			if( serverSocket != null )
			{
				serverSocket.close();
				serverSocket = null;
			}
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	/**
	 * 네트워크 연결 상태 확인
	 * @return 네트워크 연결중이면 true 아니면 false 
	 */
	public boolean isConnecting() 
	{
		if ( ( socket != null ) 
				&& ( in != null ) 
				&& ( out != null ) 
				&& ( waitForCounterpart != null ) 
				&& ( waitForCounterpart.getState() != Thread.State.TERMINATED ) )   
			return true;
		else
			return false;
	}
}

