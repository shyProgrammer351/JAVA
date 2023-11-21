import network.MultiClientServer;

/**
 * 멀티클라이언트 서버 Main 클래스
 * @author So Young Park
 * @version 0.8
 */	
public class MultiClientServer_Main
{	 
	public static void main(String[] args) 
	{
		MultiClientServer server = new MultiClientServer();
		server.connectAsMultiClientServer();
	}
}

