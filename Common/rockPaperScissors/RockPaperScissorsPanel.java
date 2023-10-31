package rockPaperScissors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 가위바위보 GUI 패널 
 * @author So Young Park
 * @version 0.8
 */
public class RockPaperScissorsPanel extends JPanel implements ActionListener  
{
	/** 
	 * 가위바위보 게임  
	 */	
	protected RockPaperScissors game;
	/** 
	 * 타이머  
	 */	
	private   Timer timer;
	
	/** 
	 * 가위바위보 참여자   
	 */	
	protected int[] playerA;
	/** 
	 * 가위바위보 상대편   
	 */	
	protected int[] playerB;

	/** 
	 * 가위바위보 참여자의 선택 결과를 이미지로 표현    
	 */	
	protected JLabel imgPlayerA;
	/** 
	 * 가위바위보 상대편의 선택 결과를 이미지로 표현  
	 */	
	protected JLabel imgPlayerB;

	/** 
	 * 가위바위보 참여자와 상대편의 상태를 문자열로 표현      
	 */	
	protected JLabel strPlayers;

	/** 
	 * 가위바위보 버튼      
	 */	
	protected JButton[] button;	
	/** 
	 * 가위바위보 3가지, 미선택 1가지, 승패 2가지를 2차원 배열로 고려하여 총 8(=(3+1)*2)가지 경우의 이미지를 준비      
	 */	
	protected ImageIcon[][] image;
	
	/** 
	 * 가위바위보 기본 이미지 상수 
	 */	
	protected final int BASE = 0;
	/** 
	 * 가위바위보 이겼을 때 이미지 상수  
	 */	
	protected final int WIN = 1;
	/** 
	 * 가위바위보 대기중 물음표 이미지 상수   
	 */	
	protected final int QUESTIONMARK = 3;

	/**
	 * 가위바위보 GUI 패널 초기화 
	 */
	public RockPaperScissorsPanel() 
	{
		// 가위바위보 게임 초기화 
		this.game = new RockPaperScissors();
		// 가위바위보 선택 후 잠깐 1초 쉬었다가 재시작할 수 있도록 타이머 설정  
		this.timer = new Timer( 1000, new TimerListener() );
		
		// 참여자와 상대편의 가위바위보 선택 결과 및 승패의 2가지 정보를 저장 
		this.playerA = new int[2];
		this.playerB = new int[2];
		this.playerA[0] = this.playerB[0] = game.SCISSORS;
		this.playerA[1] = this.playerB[1] = BASE;
		// 가위바위보 3가지, 미선택 1가지, 승패 2가지를 2차원 배열로 고려하여 총 8(=(3+1)*2)가지 경우의 이미지를 준비 
		 final String imgPath = "./Common/rockPaperScissors/image/";
		image = new ImageIcon[4][2];
		final String pathImgScissors = imgPath + "scissors.gif";
		final String pathImgRock = imgPath + "rock.gif";
		final String pathImgPaper = imgPath + "paper.gif";
		final String pathImgScissorsWin = imgPath + "scissors_win.gif";
		final String pathImgRockWin = imgPath + "rock_win.gif";
		final String pathImgPaperWin = imgPath + "paper_win.gif";
		final String pathImgQuestionmark = imgPath + "questionmark.gif";
		image[QUESTIONMARK][BASE] = new ImageIcon( new ImageIcon( pathImgQuestionmark ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[QUESTIONMARK][WIN] = new ImageIcon( new ImageIcon( pathImgQuestionmark ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.SCISSORS][BASE] = new ImageIcon( new ImageIcon( pathImgScissors ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.SCISSORS][WIN] = new ImageIcon( new ImageIcon( pathImgScissorsWin ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.ROCK][BASE] = new ImageIcon( new ImageIcon( pathImgRock ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.ROCK][WIN] = new ImageIcon( new ImageIcon( pathImgRockWin ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.PAPER][BASE] = new ImageIcon( new ImageIcon( pathImgPaper ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
		image[game.PAPER][WIN] = new ImageIcon( new ImageIcon( pathImgPaperWin ).getImage().getScaledInstance( 200, 200, Image.SCALE_SMOOTH ) );
			
		// 참여자와 상대편의 가위바위보 이미지 화면 초기화 
		this.strPlayers = new JLabel( "<html><body>[너]<br>[나]</body></html>", JLabel.CENTER );		
		this.imgPlayerA = new JLabel( image[QUESTIONMARK][BASE] );
		this.imgPlayerB = new JLabel( image[QUESTIONMARK][BASE] );
		
		this.add( this.imgPlayerB );
		this.add( this.strPlayers );
		this.add( this.imgPlayerA );

		// 가위바위보 입력 버튼 3개 초기화  
		button = new JButton[3];
		button[game.SCISSORS] = new JButton( new ImageIcon( image[game.SCISSORS][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[game.SCISSORS].addActionListener( this ); 

		button[game.ROCK] = new JButton( new ImageIcon( image[game.ROCK][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[game.ROCK].addActionListener( this ); 

		button[game.PAPER] = new JButton( new ImageIcon( image[game.PAPER][BASE].getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
		button[game.PAPER].addActionListener( this ); 
		this.add( new JLabel("  가위 바위 보를 선택하세요  ") );
		this.add( button[game.SCISSORS] );
		this.add( button[game.ROCK] );
		this.add( button[game.PAPER] );

		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(220, 530));		
	}

	/**
	 * 참여자가 버튼을 눌러서 선택한 가위바위보 결과를 int형 자료로 변환
	 * @param event 버튼을 눌러서 선택한 결과 
	 * @return 가위바위보 선택 결과 
	 */
	protected int selectRockPaperScissors( ActionEvent event )
	{
		if( event.getSource() == button[game.SCISSORS] ) 
			return game.SCISSORS;
		else if ( event.getSource() == button[game.ROCK] ) 
			return game.ROCK;
		else
			return game.PAPER;
	}
	
	/**
	 * 가위바위보 선택 결과를 분석하여 누가 이겼는지 표기
	 */
	protected void setGameResult() 
	{
		String result = game.judge( playerA[0], playerB[0] );
		if ( result.contains( "참여자가 이겼습니다" ) )
		{ 			
			playerA[1] = WIN;
			playerB[1] = BASE;
		} 
		else if ( result.contains( "상대편이 이겼습니다" ) )
		{ 			
			playerA[1] = BASE;
			playerB[1] = WIN;
		} 
		else
		{
			playerA[1] = BASE;
			playerB[1] = BASE;	
		}
	} 
		
	/**
	 * 참여자가 가위바위보를 선택시 상대편 선택과 비교하여 승패 결과를 제시하고 게임 상황 업데이트 
	 * @param event : 참여자의 가위바위보 선택 결과 
	 */
	public void actionPerformed( ActionEvent event )  
	{
		// 참여자가 먼저 가위바위보 내기 
		playerA[0] = selectRockPaperScissors( event );
		// 상대편도 임의로 가위바위보 내기 
		playerB[0] = game.selectRockPaperScissors();

		// 승패 결과를 GUI 화면에 업데이트 
		setGameResult();
		imgPlayerA.setIcon( image[ playerA[0] ][ playerA[1] ] );
		imgPlayerB.setIcon( image[ playerB[0] ][ playerB[1] ] );	
		
		// 다음 판은 잠시 대기 
		button[0].setEnabled( false );
		button[1].setEnabled( false );
		button[2].setEnabled( false );
		timer.start();		
	}
	
	/**
	 * 타이머 클래스 
	 */
	private class TimerListener implements ActionListener 
	{
		/**
		 * 잠시 대기후 다음 판 허용 
		 */
		public void actionPerformed( ActionEvent event ) 
		{
			timer.stop();		
			imgPlayerB.setIcon( image[QUESTIONMARK][BASE] );
			button[0].setEnabled( true );
			button[1].setEnabled( true );
			button[2].setEnabled( true );
		}
	}
}	

