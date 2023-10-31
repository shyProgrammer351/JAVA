package threeCupGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 구슬찾기 패널 
 * @author So Young Park
 * @version 0.8
 */
public class ThreeCupGamePanel extends JPanel implements ActionListener	
{
	/** 
	 * 구슬찾기 참여자   
	 */	
	protected int player;
	/** 
	 * 구슬이 숨어 있는 위치
	 */	
	protected int ball;
	/** 
	 * 구슬찾기 버튼      
	 */	
	private JButton[] button;	
	/** 
	 * 타이머  
	 */	
	private Timer timer;
	/** 
	 * 구슬찾기 게임 상태를 문자열로 표현      
	 */	
	protected JLabel label;	
	/** 
	 * 구슬찾기 게임에서 컵 상태를 이미지로 표현     
	 */	
	private JLabel[] cup;	
	/** 
	 * 컵 이미지는 기본 컵, 구슬이 있는 컵, 구슬찾기에 실패한 컵의 3가지 경우를 준비      
	 */	
	private ImageIcon[] img;	
	/** 
	 * 기본 컵 이미지 번호  
	 */	
	private final int BASE = 0;
	/** 
	 * 구슬이 있는 컵 이미지 번호  
	 */	
	private final int BALL = 1;
	/** 
	 * 구슬찾기에 실패한 컵 이미지 번호 
	 */	
	private final int MISS = 2;

	/**
	 * 구슬찾기 GUI 패널 초기화 
	 */
	public ThreeCupGamePanel() 
	{
		// 기본 컵, 구슬이 있는 컵, 구슬찾기에 실패한 컵의 3가지 경우의 이미지를 준비 
		img = new ImageIcon[3];
		final String imgPath = "./Common/ThreeCupGame/image/";
		final String PathImgCup  = imgPath + "cup.jpg";
		final String PathImgBall = imgPath + "cup_ball.jpg";
		final String PathImgFail = imgPath + "cup_fail.jpg";		
		img[ BASE ] = new ImageIcon( new ImageIcon( PathImgCup  ).getImage().getScaledInstance( 200, 250, Image.SCALE_SMOOTH ) );
		img[ BALL ] = new ImageIcon( new ImageIcon( PathImgBall ).getImage().getScaledInstance( 200, 250, Image.SCALE_SMOOTH ) );
		img[ MISS ] = new ImageIcon( new ImageIcon( PathImgFail ).getImage().getScaledInstance( 200, 250, Image.SCALE_SMOOTH ) );

		// 컵 3개를 기본 이미지로 초기화 
		cup = new JLabel[3];
		cup[0] = new JLabel( img[ BASE ] );
		cup[1] = new JLabel( img[ BASE ] );
		cup[2] = new JLabel( img[ BASE ] );
		this.add( cup[0] );
		this.add( cup[1] );
		this.add( cup[2] );

		// 컵 3개 입력 버튼 초기화  
		button = new JButton[3];
		button[0] = new JButton( "                          1                           " );
		button[0].addActionListener( this ); 

		button[1] = new JButton( "                          2                           " );
		button[1].addActionListener( this ); 

		button[2] = new JButton( "                          3                           " );
		button[2].addActionListener( this ); 

		label = new JLabel( "구슬을 숨긴 컵을 선택하세요" );

		this.add( button[0] );
		this.add( button[1] );
		this.add( button[2] );
		this.add( label );

		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(630, 320));	

		// 구슬찾기 선택 후 잠깐 1초 쉬었다가 재시작할 수 있도록 타이머 설정  
		this.timer = new Timer( 1000, new TimerListener() );
	}
	
	/**
	 * 참여자가 버튼을 눌러서 선택한 구슬찾기 결과를 int형 자료로 변환
	 * @param event 버튼을 눌러서 선택한 결과 
	 * @return 구슬찾기 선택 결과 
	 */
	protected int selectCup( ActionEvent event )
	{
		if( event.getSource() == button[0] ) 
			return 0;
		else if ( event.getSource() == button[1] ) 
			return 1;
		else
			return 2;
	}
	
	/**
	 * 구슬찾기 선택 및 승패 결과를 화면에 업데이트
	 */
	protected void showGameResult( int player, int ball ) 
	{
		cup[ ball ].setIcon( img[ BALL ] ); 
		if ( player != ball )
			cup[ player ].setIcon( img[ MISS ] ); 	
	} 
	
	/**
	 * 구슬찾기 게임 진행하기 
	 * @param event : 참여자의 구슬찾기 선택 결과 
	 */
	public void actionPerformed( ActionEvent event )  
	{
		// 컵 3개 중 하나에 임의로 구슬을 숨기기 
		this.ball = (int)( Math.random() * 3 );
		// 참여자는 구슬을 숨긴 컵을 맞추기 
		this.player = this.selectCup( event );
		// 승패 결과를 GUI 화면에 업데이트 
		showGameResult( this.player, this.ball );
		
		// 다음 판은 잠시 대기 
		timer.start();		
		button[0].setEnabled( false );
		button[1].setEnabled( false );
		button[2].setEnabled( false );
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
			// 컵에 구슬 숨기고 구슬찾기 선택 허용
			cup[0].setIcon( img[ BASE ] ); 
			cup[1].setIcon( img[ BASE ] ); 
			cup[2].setIcon( img[ BASE ] ); 	
			button[0].setEnabled( true );
			button[1].setEnabled( true );
			button[2].setEnabled( true );
		}
	}
}

