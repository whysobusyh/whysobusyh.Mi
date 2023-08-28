package com.peisia.dynamic_beat_1;
// 패키지 이름

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.RenderingHints;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class DynamicBeat extends JFrame {
//	JFrame 는 텍스트 기반이 아닌 GUI 그래픽 유저 인터페이스 기반의 프로그램을 만들기 위해서 상속받아야하는것
// 눈으로 보고 즐기는 게임을 만드는 기반	

	private Image screenImage;
	private Graphics screenGraphic;

	public void setScreenGraphic(Graphics screenGraphic) {
		this.screenGraphic = screenGraphic;
	}

	// 더블버퍼링을 위해서 전체 화면에 대한 이미지를 담는 인스턴스 객체
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackgroundImage.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// 메뉴 바를 생성
	
	private ImageIcon exitButtonBasicImage =  new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	
	private ImageIcon exitButtonEnteredImage =  new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	// 버튼 이미지 객체 생성
	
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage); 
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage); 
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	// 버튼을 화면에 출력
	
	
	private int mouseX, mouseY;
	// 마우스 x,y 좌표
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	// 현재 이 화면이 Main인지 game인지 보여주는 불리언
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	// 곡 선택 시 넣어야 될 것들을 하나의 ArrayList로 넣어서 한 번에 선언하겠다.
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic=null;
	private Music introMusic = new Music("kidding.mp3", true);
	private int nowSelected = 0;
	// 시작 곡은 arrayList 0 의 위치
	
	public static Game game;
	// 단 하나의 게임만 진행되니 동시에 여러개를 할 수 없으므로
	// 이 Game 변수는 Project에서 통용되는 하나의 변수라고 할 수 있기 때문에
	// public static을 넣어준다.
	
	public DynamicBeat() {
		
		setUndecorated(true);
		// 실행을 했을때 기본적으로 존재하는 메뉴바가 보이지 않게 된다.

		setTitle("Dynamic Beat");
		// 만들 게임의 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 게임창 크기를 설정하겠다.
		setResizable(false);
		// 한 번 게임창 크기를 사용자가 임의로 변경할 수 없음.
		setLocationRelativeTo(null);
		// 실행 했을때 컴퓨터 정중앙에 오게 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임창을 종료했을때 프로그램 전체가 종료되도록 한다.
		// 이를 설정하지 않으면 게임을 끄더라도 리소스를 계속 잡아먹어 반드시 설정해야한다.
		setVisible(true);
		// 게임창이 정상적으로 화면에 출력되도록 한다.
		// 기본값은 false여서 true로 설정해주어야한다.
		setBackground(new Color(0, 0, 0, 0));
		// 페인트 컴포넌트를 했을 때 회색이 아닌 하얀색으로 나오게 된다.
		setLayout(null);
		// 버튼이나 JLabel을 넣었을때 정말 그 위치 그 대로 두게 되는 것.
		
		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		trackList.add(new Track("고세구 팬서비스 Title Image.png", "고세구 팬서비스 Start Image.png",
				"고세구 팬서비스 Entered Image.png", "고세구 팬서비스 Selected.mp3", "고세구 팬서비스.mp3", "고세구 팬서비스"));
		trackList.add(new Track("릴파 LADY Title Image.png", "릴파 LADY Start Image.png",
				"릴파 LADY Entered Image.png", "릴파 LADY Selected.mp3", "릴파 LADY.mp3", "릴파 LADY"));
		trackList.add(new Track("주르르 Darling Title Image.png", "주르르 Darling Start Image.png",
				"주르르 Darling Entered Image.png", "주르르 Darling Selected.mp3", "주르르 Darling.mp3", "주르르 Darling"));
		

		exitButton.setBounds(1245, 0, 30, 30);
		// exit 버튼을 x좌표 1245픽셀 y좌표를 0픽셀 위치에서 30*30크기의 사진을 표시
		exitButton.setBorderPainted(false);
		// 외곽선 표시 x
		exitButton.setContentAreaFilled(false);
		// 배경화면 채울건가? x 누끼 = 배경화면 제거 해야함
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			// 마우스 위치나 클릭에 따른 이벤트 생성 함수
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스를 해당 사진 위에 올리면 발생
				exitButton.setIcon(exitButtonEnteredImage);
				// 이미지를 exitButtonEnteredImage로 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 마우스 커서를 HAND_CURSOR 손모양으로 바꿈
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 해당 이미지에서 벗어나면 발생
				exitButton.setIcon(exitButtonBasicImage);
				// 이미지를 exitButtonBasicImage로 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				// 마우스 커서 모양을 기본값으로 바꿈
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// 해당 버튼을 클릭하면 발생하는 이벤트
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				// 음악을 lockdown으로 하고 반복은 false
				buttonEnteredMusic.start();
				// 음악 실행시켜줘야함.
				try {
					Thread.sleep(1000);
					// 5초동안 재생한 뒤 종료; -> 음악이 제대로 나오는지 확인하기 위함
					// 단순한 클릭음이면 1000 1초로 변경 가능
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
				// 시스템을 종료하겠음
			}
		});
		add(exitButton);
		// 버튼을 생성
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				selectLeft();
			}
			
		});
		
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				selectRight();
			}
			
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Easy");
			}
			
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Hard");
			}
			
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				backMain();
			}
			
		});
		add(backButton);
		
		
		startButton.setBounds(40, 200, 400, 100);
		// exitButton함수랑 같으므로 생략
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				introMusic.close();
				enterMain();

			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3" ,false);
				buttonEnteredMusic.start();
				try {
				Thread.sleep(1000);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.exit(0);
			}
			
		});
		
		add(quitButton);
		
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		// 위치와 크기를 설정
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY= e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		// 메뉴바를 넣어줌

		
		

		background = new ImageIcon(Main.class.getResource("ReWind.jpg")).getImage();

		

		// 메인클래스의 위치를 기반으로 해서 리소스인 ReWind.jpg 이미지 파일을 얻어온 후
		// 이미지 인스턴스를 introbackground라는 이름의 이미지 변수에 초기화를 해주겠다.

	}

	public void paint(Graphics g) {
		// paint는 약속된 메소드
		// paint 함수는 JFrame 를 상속받은 이러한 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
		// 약속된 것이라 바뀌지 않는다.

		// 프로그램 화면 크기만큼 이미지를 생성해서 그 이미지를 우리가 screenDraw 함수를 통해
		// 원하는 내용에 맞게 그려준다.

		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 이미지크기를 SCREEN_WIDTH와 SCREEN_HEIGHT 크기에 맞게 만들어 준 뒤에 그것을 스크린 이미지에 넣겠다.
		screenGraphic = screenImage.getGraphics();
		// 스크린 이미지를 이용해서 그래픽 객체를 얻어온다.

		screenDraw((Graphics2D)screenGraphic);
		//
		g.drawImage(screenImage, 0, 0, null);
		// 스크린 이미지를 ( 0, 0 )의 위치에 생성시켜준다

	}

	public void screenDraw(Graphics2D g) {
		// 화면에 그려주는 함수
		g.drawImage(background, 0, 0, null);
		// 인트로 백그라운드 이미지를 전체 스크린 이미지에 그려줄 수 있도록 한다.
		// 일반적으로 이미지나 역동적인 움직임을 보여주는 이미지를 그려주는 함수
		
		
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		//
		
		if(isGameScreen) {
			game.screenDraw(g);
		}
		
		paintComponents(g);
		// 이미지를 단순하게 스크린 이미지라는 변수안에 그려주는것 외에 따로 JLabel같은 것들을
		// JFrame에 추가하면 그것을 그려주는 것을 의미한다.
		// drawImage로 그리는 방법도 있고
		// 메뉴 바 같은 경우는 항상 존재하는 이미지이고 역동적으로 움직이지 않기 떄문에
		// 하나의 버튼이나 고정된 버튼바는 paintComponents로 그려줄 예정
		// ScreenDraw 함수 내에 paintComponents부분은 메인프레임에 추가된 요소들을 보여주는것
		// add로 추가한 것들

		this.repaint();
		// 프로그램이 종료되는 순간까지 다시 페인트 함수를 불러온다.
		// paint 함수는 JFrame 를 상속받은 이러한 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
		// 약속된 것이라 바뀌지 않는다.
	}
	
	public void selectTrack(int nowSelected) {
		// 선택한 것에 대한 곡 이미지 및 음악 삽입 함수
		if(selectedMusic !=null) {
			// 선택한 음악의 값이 null 이 아니라면
			selectedMusic.close();
			// 실행 중인 음악을 일단 끄겠다
			titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
			System.out.println("타이틀 이미지 링크 :"+Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()));
			// 타이틀 이미지 값을 trackList에서 nowSelected에 있는 곳에서 불러오겠다.
			selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
			System.out.println("타이틀 이미지 링크 :"+Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()));
			// 선택된 이미지 값을 trackList에서 nowSelected에 있는 곳에서 불러오겠다.
			selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
			selectedMusic.start();
		}else {
			// selectedMusic.close();는 없으므로 하지 않음
			titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
			System.out.println("타이틀 이미지 링크 :"+Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()));
			// 타이틀 이미지 값을 trackList에서 nowSelected에 있는 곳에서 불러오겠다.
			selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
			System.out.println("타이틀 이미지 링크 :"+Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()));
			// 선택된 이미지 값을 trackList에서 nowSelected에 있는 곳에서 불러오겠다.
			selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
			selectedMusic.start();
		}
		
	}
	
	public void selectLeft() {
		//왼쪽으로 가기 버튼을 누르면 발생하는 이벤트 함수
		if(nowSelected == 0) {
			// 더이상 왼쪽으로 갈 수 없으면
			// 트랙리스트 사이즈-1 즉 맨 끝으로 가겠다. arrayList의 값은 0부터 시작해서 size-1이니깐
			nowSelected= trackList.size() - 1;
		}else {
			nowSelected--;
			// 아니면 --값으로 하겠다.
		}
		
		selectTrack(nowSelected);
		// 그 후 selectTrack 함수를 변경된 nowSelected값으로 변경된 nowSelected값으로 실행시키곘다.
	}
	
	public void selectRight() {
		// 오른쪽으로 가기 버튼을 누르면 발생하는 이벤트 함수
		if(nowSelected == trackList.size()-1) {
			//사이즈-1랑 같으면 즉 맨 마지막에 있는 것이면
			nowSelected= 0;
			// 0 맨 처음 List값으로 돌아가겠다.
		}else {
			nowSelected++;
			// 아니면 값을 더해주겠다
		}
		
		selectTrack(nowSelected);
		// 그 후 selectTrack함수를 변경된 nowSelected값으로 실행시키겠다.
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		// easyButton이나 hardButton을 누르면 발생하는 이벤트 함수 
		if(selectedMusic!=null) {
			// 음악이 있으면
			selectedMusic.close();
			// 음악이 중첩되서 들리지 않게 끄겠다.
			isMainScreen = false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			easyButton.setVisible(false);
			hardButton.setVisible(false);
			backButton.setVisible(true);
			background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
			// 화면이나 버튼을 바꾸기 위해 끄고 키겠다.
			isGameScreen=true;
			game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
			
		}else {
			// 음악이 없으면 끄는 행위를 하지 않음
			isMainScreen = false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			easyButton.setVisible(false);
			hardButton.setVisible(false);
			backButton.setVisible(true);
			background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
			isGameScreen=true;
			setFocusable(true);
			//메인 프레임에 키보드 포커스가 갖춰진다.
			// 주의할 점 화면이 바뀜에 따라서 포서스가 맞지 않을수도 있다.
			// 게임이 시작했을때 항상 메인에 키보드 포커스가 맞춰져있어야 정상적으로 이벤트가 발생한다.
			game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		}
	}
	
	public void backMain() {
		// backButton을 누르면 발생하는 이벤트 함수
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		isGameScreen=false;
		selectTrack(nowSelected);
		// 각종 버튼을 보이거나 안보이게 하고 화면 변경 및 selectTrack함수를 실행 
		game.close();
		// 게임 뒤로가기 누르면 게임 실행일떄 곡을 종료하고 다시 복귀
		
	}
	
	public void enterMain() {
		selectTrack(nowSelected);
		
		startButton.setVisible(false);
		quitButton.setVisible(false);
		isMainScreen = true;
		// 게임시작버튼을 누르면 시작 및 종료 버튼을 안보이게 함
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		// 백그라운으 이미지를 실행화면 이미지로 변경
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		// 게임시작버튼을 누르면 좌우버튼 생성
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}
}
