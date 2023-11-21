package network;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * 멀티클라이언트 서버의 네트워크 연결 및 입출력 담당 클래스
 * @author So Young Park
 * @version 0.8
 * @see     net.Network()
 */	
public class MultiClientServer extends Network
{
	/** 
	 * 클라이언트 목록
	 */	
	private ArrayList<Client> clients;

	/**
	 * 멀티클라이언트 서버 생성 초기화 
	 */
	public MultiClientServer()
	{ 
		// 네트워크 서버 초기화 
		super();
		// 클라이언트 목록 초기화  
		clients = new ArrayList<Client>();
	}

	/**
	 * 멀티클라이언트 서버 연결 초기화 
	 */
	public void connectAsMultiClientServer()
	{
		try 
		{
			// 서버 소켓 연결 
			serverSocket = new ServerSocket( serverPort ); 
			System.out.println( "[Server] 서버 대기중" );

			// 각 클라이언트마다 반복 
			while ( true )
			{
				// 클라이언트에서 서버로 연결 요청시 연결 활성화 
				socket = serverSocket.accept();
				// 서버-클라이언트를 1:1로 연결후 네트워크 입출력 초기화 
				Client client = new Client( this );
				System.out.println( "[Server] 클라이언트 연결 : " + client );
				clients.add( client ); 
				// 클라이언트에서 보낸 데이터가 서버에 도착할 때까지 대기 시작 
				client.start();  
			} // while 반복 
		}
		catch ( Exception e )
		{ 
			e.printStackTrace();
		} 
	}
	
	/**************
	 * 클라이언트 관리 목록에 있는 모든 클라이언트에게 데이터 전달
	 * @param data 전달할 데이터 
	 */
	public void broadcast( String data ) 
	{
		for( Client client : clients )
		{
			client.write( data );	
		} 
	}

	/**
	 * 멀티클라이언트 서버 연결 해제  
	 */
	public void disconnect() 
	{
		// 각 클라이언트 연결 해제  
		for( Client client : clients )
		{
			client.interrupt(); 
			client.disconnect(); 
			clients.remove( client );
		}
		
		// 네트워크 서버 연결 해제  
		super.disconnect();
	}
} 

