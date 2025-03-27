package project4;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

// controller 개념
public class DiceGameController {
	// 멤버 변수 초기화
		// 총 주사위 횟수 
	int totalNum = 0;
	
		// 킵한 횟수
	int keepNum = 0;
	
		// 입력 초기화
	Scanner sc = new Scanner(System.in);
		// 플레이 주사위 저장 리스트 
	ArrayList<Integer> plDiceList = new ArrayList<Integer>();
	
		// 점수판 생성 
	DiceGameScoreBoard sb = new DiceGameScoreBoard();
	
	// 기본 생성자 (1)
	public DiceGameController() {};
	
	// 메서드 
		// loadingPrint()
	public void loadingPrint() throws InterruptedException {
		System.out.println("\r\n"
				+ "⠐⠀⠀⠀⠀⠂⠐⠀⠀⠀⠀⠐⠀⠂⠀⠀⠀⠀⠂⠐⠀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠂⠐⡀⠀⠀⠀\r\n"
				+ "⢁⠀⠀⠀⠈⡈⢀⠁⠀⠀⠀⡁⢈⠐⠀⠀⠀⢈⠀⡁⠂⠀⠀⠀⡁⢈⠠⠀⠀⠀⠈⡀⠁⠄⠀⠀⠀\r\n"
				+ "⠀⢀⠁⡈⡀⣀⢄⢤⢥⢬⢔⣤⡢⣔⡬⡤⣥⡢⣔⡤⣢⢥⢬⣔⢤⢤⡠⣠⣁⢈⠀⠀⠀⠀⠨⠀⡁\r\n"
				+ "⠠⢀⣲⡪⡯⣞⢽⢝⡮⡳⣝⢎⢮⢳⢹⢪⢪⢪⢣⢫⢪⢃⠣⡑⠩⠳⡹⣺⡪⡯⡯⣞⡴⡀⠁⠀⠠\r\n"
				+ "⢠⡳⣳⢽⢝⡮⡯⣳⢽⢝⡮⣫⢞⡵⣫⢮⡳⣳⢕⡧⡳⣕⢗⢼⡸⡰⡨⡪⡺⣝⣞⣗⢿⣽⡢⠀⠀\r\n"
				+ "⣜⢾⢽⢵⣻⡪⣟⢮⢗⡯⣞⡽⡵⣫⢗⣽⡺⣕⡯⣞⢽⣪⢯⡳⣝⢮⡳⣕⢝⢮⣺⣺⢽⣾⣻⡆⠀\r\n"
				+ "⡯⡯⡯⣳⡳⡽⡵⣫⢯⢞⣵⡫⡯⣞⡽⣪⢾⢕⡯⣞⢽⡪⣗⡽⣪⢗⡽⣪⡳⣝⣞⢾⢽⣯⡷⣟⠄\r\n"
				+ "⡿⡽⡽⡵⣫⢯⢯⡳⡯⣻⣪⢾⢝⣞⣞⢽⢵⣻⣪⢗⡯⡯⣺⡺⡽⡵⣫⢗⡽⣺⣪⢯⣟⣷⣿⣻⠄\r\n"
				+ "⣿⢽⢽⢽⢽⢽⢵⣫⢯⣳⣳⣫⢯⢞⡮⣯⣳⡳⣵⡻⣪⢯⣳⢽⢝⣞⡽⡵⣫⣗⡽⡽⣞⣿⡾⣿⠅\r\n"
				+ "⣯⢯⢯⢯⡳⣯⡳⣯⣳⣳⣳⣳⡫⣟⢾⢵⡳⣽⣺⡺⣝⣗⡽⡵⣻⣺⡺⡽⡵⣳⢽⢽⢯⣿⢽⡿⡅\r\n"
				+ "⣿⢽⣝⣗⢯⣗⣟⣞⣞⣞⢮⣞⡽⡝⢅⢃⠪⡘⡮⣻⣺⡺⣺⢽⢵⡳⡽⡽⡽⣵⡻⣽⣻⣿⢽⣯⡇\r\n"
				+ "⣿⢵⣳⣝⣗⣗⣗⣗⣗⣗⢯⣞⢾⢝⡐⠄⠅⣂⢯⣳⡳⣝⣗⢯⢗⡯⡯⡯⣞⢷⣝⡷⣻⣾⣟⡷⡇\r\n"
				+ "⣿⢽⣺⣺⣺⣺⣺⣺⡺⡮⣗⡯⣯⣳⢵⣕⡧⣗⣟⢮⢯⣳⢽⢽⣝⢾⢽⣝⣞⣗⣗⢿⣽⡷⣿⢽⡇\r\n"
				+ "⣯⣟⣞⣞⣞⣞⣞⣞⢾⣝⢷⢽⡺⡮⣗⢷⣝⣗⡽⡽⣝⡾⣝⢷⢽⣝⣗⣗⣗⢷⢽⢽⢾⣟⣯⣿⡅\r\n"
				+ "⣿⣺⣺⣺⣺⣺⣺⣺⣳⢽⢽⢽⢽⢽⣝⣗⣗⣗⢯⢯⣗⢯⢯⢯⣳⣳⣳⡳⡽⡽⣝⣯⢿⣿⣽⡷⡇\r\n"
				+ "⣿⣺⡵⣗⡷⣳⣳⣳⢽⢽⢽⢽⣝⣗⣗⣗⢷⢽⣝⢷⢽⢽⢽⢽⣺⡺⡮⡯⡯⣯⣗⣯⡿⣷⣯⣿⡃\r\n"
				+ "⣳⣟⡾⣽⢽⣽⡺⣞⣽⢽⢽⣳⣳⣳⣳⢽⣝⢷⢽⢽⢽⢽⢽⢽⢮⢯⡯⣟⣽⣳⣗⣿⣻⣿⡾⣗⡇\r\n"
				+ "⠸⣞⣯⡿⣽⣺⢽⣳⢯⢯⣟⣮⣗⣗⡯⣗⡯⣯⢯⡯⣯⢯⡯⣯⣟⡽⣞⣯⢾⣳⣟⣾⣿⣿⣻⣽⠂\r\n"
				+ "⠠⠹⣿⣽⡷⣿⣽⣽⣽⣻⣞⣾⣺⣗⡿⣽⣽⣽⡽⣞⣯⣯⣯⢷⣷⣻⣟⣾⡿⣯⣿⣿⣟⣯⡿⣞⠀\r\n"
				+ "⠀⠠⠙⠳⠿⡿⡷⣿⢾⣿⡾⣿⢷⣿⢿⡿⣾⣷⣿⡿⣿⣾⣯⣿⣾⣿⣻⡿⣿⣿⢿⣟⡿⡯⠟⢁⠐\r\n"
				+ "⠀⠐⠈⠀⠠⠀⠠⠀⠀⠀⠈⢀⠁⡀⠁⠈⠀⠀⠄⢈⠀⠀⠀⠀⠠⠀⠄⠈⠀⠀⠁⠠⠀⡀⠐⠀⠐\r\n"
				+ "");
  	
  	Thread.sleep(1000);
  	System.out.println();
  
		System.out.println("\r\n"
				+ "⠐⠀⢂⠀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠀⠂⠐⠀⠀⠀⠀⠀⠂\r\n"
				+ "⠁⠈⠠⠀⢀⠀⢀⠈⠄⠂⠀⡀⠀⡀⠈⠄⠂⠀⡀⠀⡀⠈⠄⠂⠀⡀⠀⡀⠈⠈⠀⢁⠀⠀⠀⡈⠠\r\n"
				+ "⠀⠀⠀⢐⢀⣐⢄⡤⣢⡢⣆⡦⡦⡦⡦⣢⢦⢦⢦⢦⢦⢦⢦⣢⢦⢦⣢⢆⡦⣄⣄⣀⢂⠁⡐⠀⠀\r\n"
				+ "⡀⢄⡮⣺⢕⡯⡳⠹⠘⡘⡑⡝⡜⡕⡝⡎⣗⢝⣕⢯⡳⣝⢵⡳⡽⣕⡯⣗⣟⣞⣞⢾⢵⣳⣔⠀⡀\r\n"
				+ "⢄⣗⢯⣳⢫⠪⡨⡢⡱⣜⣜⢮⡺⣪⢯⣺⣪⡳⡵⣳⢝⡮⣗⡽⣝⣞⣞⣵⣳⡳⡽⡽⣽⣺⢽⡆⡀\r\n"
				+ "⣸⡺⣝⢮⢣⡣⡳⣝⢞⡮⣺⢕⡯⣳⣝⣞⢞⣞⡽⡵⡯⡯⣞⡽⣺⣺⣺⣺⣪⢯⢯⣻⣺⣺⢯⣷⠀\r\n"
				+ "⢮⢯⡺⣕⢧⡫⡯⣺⢵⡫⣗⢯⢯⣳⡳⣵⡻⣺⡺⡽⣝⢾⢵⣫⣗⣗⣗⣗⣗⢯⣻⣺⣺⣺⡽⣾⠄\r\n"
				+ "⣯⣳⣻⡪⣗⢽⢝⡮⣗⢯⣳⣫⢗⣗⡽⣺⣺⡳⡽⣝⢾⣝⣗⣗⣗⣗⣗⣗⡽⣽⣺⡺⡮⣗⡿⣽⠅\r\n"
				+ "⣞⣞⣞⢮⡳⡯⡯⣞⣗⢯⣞⢮⣻⣪⢯⣳⡳⡽⡽⣺⣳⣳⣳⣳⣳⣳⣳⣳⢽⣺⢮⢯⢯⢷⣻⣻⠅\r\n"
				+ "⣗⣗⣗⢯⢯⢞⣽⡺⡮⣳⣳⣻⣺⣪⣗⣗⢯⢯⢯⣳⣳⣳⣳⣳⣳⣳⣳⣳⣻⣺⢽⢽⢽⣫⡷⣿⠅\r\n"
				+ "⣗⣗⣗⢯⢯⢯⢞⡾⣝⢏⠺⡘⢞⣞⣞⢮⢯⢯⣳⣳⣳⣳⣳⡳⡳⡹⡘⢞⣞⢾⢽⣝⡯⣗⣿⣽⡃\r\n"
				+ "⣗⡷⡽⡽⣝⡽⣳⣫⠇⢅⠑⠌⡂⣳⢽⢽⢽⣝⣞⣞⣞⣞⣮⠣⡊⠢⢈⠂⡯⡯⣗⣗⡯⣟⣾⣽⠆\r\n"
				+ "⣗⡯⡯⡯⣞⡽⣵⣫⢗⣅⢅⢅⢆⡯⡯⣯⣳⣳⣳⣳⣳⣳⢽⣣⣌⢌⢄⢕⡽⣽⣳⢽⡽⡽⡾⣾⡃\r\n"
				+ "⡷⡯⣯⡻⣮⣻⡺⣮⡻⡮⣗⢷⢽⣺⢽⣺⣺⣺⣺⣺⣺⣺⢽⣺⣺⢽⢽⣳⢯⣗⡯⣗⡿⣽⣻⣽⠆\r\n"
				+ "⡯⣟⣮⣻⡺⣮⣻⣪⢯⢯⢯⢯⣻⡺⣽⣺⣺⣺⣺⣺⣺⣺⢽⣺⢽⡽⣽⣺⢽⣺⢽⣳⢯⡷⣯⣿⠅\r\n"
				+ "⣟⣗⣗⣗⣟⣞⣞⢾⢽⢽⣝⣗⣗⡯⣗⣗⣗⡯⣾⣺⢵⢯⢯⢯⣗⡯⣗⡯⣟⣞⣟⡾⣽⢽⣗⣿⠅\r\n"
				+ "⣗⣟⣞⣞⣞⣞⡾⡽⣽⣳⣳⣳⣳⢯⣗⣗⡷⡯⣗⡯⡯⣯⢟⣽⣺⢽⡽⣽⣳⣻⣺⡽⣽⣻⢾⣻⠅\r\n"
				+ "⣺⣽⣞⣗⡯⡾⡽⣽⣺⢞⣞⡾⣺⣳⣳⢗⣯⢯⣗⡿⡽⣽⢽⣳⢯⢯⣟⢾⣺⣳⢯⣟⣷⣻⡿⣿⠁\r\n"
				+ "⢸⣷⢷⢯⣟⣽⢯⣗⡯⣯⣗⡿⣽⣺⣞⣟⡾⣽⣺⡽⣽⣳⣟⡾⣽⣻⣺⢯⢷⡯⣿⣺⡷⣿⣿⡿⢀\r\n"
				+ "⠨⣾⣿⣯⣷⢿⡽⣾⢽⣳⣗⣯⡷⣗⡷⣗⣟⡷⣯⣯⢷⡷⣗⣿⣳⣟⣾⣻⣯⢿⣽⣷⣿⣿⣷⠏⠠\r\n"
				+ "⠀⠘⠿⣟⣿⣿⣿⡿⣿⣻⣽⣷⣿⣿⣻⣿⣯⣿⣷⣿⣟⣿⣻⣽⣷⣿⣯⣷⣿⣿⣿⣯⡿⡯⠟⠀⠀\r\n"
				+ "⢀⠀⡀⠀⠁⠁⠁⠉⡉⢉⠉⠈⠁⠉⡉⢈⠉⡈⠡⠉⠉⢉⠉⡉⠁⠉⠈⠉⢈⠁⢁⠁⠁⠀⠂⠀⠄\r\n"
				+ "");
		
		Thread.sleep(1000);
  	System.out.println();

  
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠂⠐⡀⠀⠀⠀⠀⠂⠐⡀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠐⠀⢂⠀⠀⠀⠀⠐⠀⠂⠀⠀⠀\r\n"
				+ "⠀⠀⠀⡀⠡⠐⠀⢀⠀⢀⠀⠡⠐⠀⠀⠀⢀⠈⠄⠂⠀⡀⠀⡀⠈⠄⠂⠀⠀⠀⡀⠁⠈⠐⠀⡀⠀\r\n"
				+ "⢁⠈⠠⠀⡀⣀⢄⣔⣔⢴⣔⡴⡴⡴⡵⡼⡴⡴⡴⣴⢴⣢⢶⢴⡴⡴⣴⢬⣬⣔⡤⣀⡀⠀⡁⠄⠂\r\n"
				+ "⠀⡨⣜⡮⡯⣞⡽⣺⡪⣗⢷⢽⢽⢽⢽⢽⢽⡽⣽⡳⡯⡯⡯⣟⣞⣯⢯⣟⣾⣺⢽⢯⣯⢷⣄⠀⠁\r\n"
				+ "⣔⣽⣳⢽⢝⠎⡎⣞⣞⡽⡽⣽⢽⢽⣫⢿⢽⣺⣗⡯⡿⡽⡯⣟⣞⡷⣯⢷⣳⢯⣟⣟⡾⣯⣟⣆⠀\r\n"
				+ "⣟⣞⡾⡽⡡⡱⣝⣞⡮⣯⢯⣷⣻⡽⣽⢽⣻⣺⣞⡽⡯⡿⣽⢽⣺⣽⣳⢿⣝⣟⣞⣷⣻⣗⣯⣷⠄\r\n"
				+ "⣿⡵⡯⣯⢪⣺⢵⣗⡯⣯⢟⢎⠎⠎⢯⣻⣺⡵⣗⡿⡽⣯⢯⣟⣗⡷⡯⣟⣞⣷⣻⢞⣗⣿⣺⣽⡇\r\n"
				+ "⣯⢯⣟⡮⣗⣽⣳⣳⢯⡯⡇⠕⢅⢑⢐⢵⣗⣟⣗⡿⣽⢽⡽⣞⣗⡿⣽⣻⢞⣗⣯⢿⡽⣞⡷⣯⡇\r\n"
				+ "⣷⣻⢮⣻⣺⣺⣺⣺⢽⣞⢿⡬⣆⡦⣮⣗⣯⢾⣳⢯⢿⢽⣽⢽⢾⣽⣳⢯⡿⡽⣞⣯⢿⡽⣯⢿⡇\r\n"
				+ "⣿⣗⣯⣗⣗⣗⣗⡯⣟⡾⡽⣞⡯⣯⢷⣳⢯⣟⣾⡻⡽⣟⣾⣻⡽⣾⣺⢯⢿⣽⣻⣞⣯⢿⡽⣟⡧\r\n"
				+ "⣷⣟⣞⣞⣞⣞⡾⣽⡳⣯⢟⣗⡿⣽⢽⣞⣟⡞⢆⠣⡑⡑⣗⣷⣻⣳⢯⡿⣽⢾⣺⡾⣽⢯⣟⣿⡇\r\n"
				+ "⣿⣞⣷⣳⣳⣳⢯⣗⡿⣽⢽⣳⢯⡯⣟⣞⣗⣯⠢⡑⡐⣐⢵⣗⣿⣺⢯⢿⡽⣽⣳⢿⡽⣯⢿⢾⡇\r\n"
				+ "⣿⣳⣗⣗⣗⡯⣟⣮⣟⣾⣫⡯⣯⢯⣟⣞⡷⡯⣟⣾⣺⣳⣟⡾⣞⣾⣻⣽⢽⣗⡿⣽⢯⢿⡽⣿⡇\r\n"
				+ "⣿⣗⣯⢾⣺⢽⣳⢗⣷⣳⣗⡿⣽⣻⣺⣳⢿⢽⣻⣺⣳⣗⣯⢿⡽⣞⢳⠹⡻⣞⣯⢿⣽⣻⣽⣯⡇\r\n"
				+ "⣿⡽⣾⢽⣺⡽⣞⣯⢷⣳⣗⣟⣗⣟⡾⡽⣯⢿⢽⣞⣷⣻⣺⢯⡯⡪⠪⠨⠨⣪⢿⡽⣾⡽⣾⢷⡏\r\n"
				+ "⣿⡿⣽⢽⣳⣻⡽⣞⣯⢷⣻⣺⣗⣯⢿⡽⣽⢯⣟⡾⣞⣾⢽⢯⢿⣜⣌⣌⢦⣳⢿⡽⣷⣻⣯⣿⠇\r\n"
				+ "⣿⣯⢿⡽⣞⣷⣻⡽⣞⣯⢷⣻⣞⡾⡯⣟⣽⡽⣾⢽⣻⣺⢯⣟⣿⣺⣗⣯⢿⡽⣯⢿⡽⣷⢿⣾⠅\r\n"
				+ "⣿⣽⣯⢿⣻⣞⣷⣻⡽⣞⣯⢷⡯⡿⣽⢯⣷⣻⡽⣯⢷⣻⡯⣷⣻⢾⣺⣽⢯⣟⣯⣿⣻⣟⣿⠗⠀\r\n"
				+ "⣿⢷⣟⣿⡷⣿⣞⣷⣟⣯⣿⣽⡽⣿⢽⣻⣞⣷⢿⣽⣟⣷⣟⡿⣾⣻⣽⣾⣟⣯⣿⣾⢿⣻⡯⠁⠀\r\n"
				+ "⠟⡿⣻⢿⢿⣿⣻⣽⣿⣽⣾⣷⣿⣿⣿⡿⣿⢿⡿⣿⣾⣿⣽⣿⢿⣿⣻⣷⡿⡿⡿⡽⠟⠋⠠⠈⡀\r\n"
				+ "⠀⠀⠀⠀⠅⠀⠄⠀⠀⠀⠀⠄⠠⠀⠀⠈⠀⢁⠈⡀⠄⠀⠀⠀⠄⠠⠀⡀⠀⠀⠀⠄⠀⠄⠐⠀⠀\r\n"
				+ "");
		
		Thread.sleep(1000);
		System.out.println();
		  
		System.out.println("\r\n"
				+ "⠀⠀⠀⢀⢐⣀⣂⢄⣀⣄⣠⣐⢄⣢⡠⣠⡠⣀⣢⣐⣄⢄⣄⢄⣄⣢⣐⣄⣄⢄⣄⣄⣂⣐⣀⠀⠀\r\n"
				+ "⠂⡰⣜⡮⣗⡷⡽⡽⡵⣳⡳⡽⣝⢮⢯⡳⡫⡟⡞⡞⡞⡽⡺⢝⢞⢞⢞⣞⢾⢽⣺⣺⡽⣽⢾⣻⡤\r\n"
				+ "⢰⢯⣗⡯⣗⡯⡯⡯⣯⣳⢽⢽⢮⣗⡷⡽⣝⡾⣝⣞⣞⡮⣞⣖⣖⢦⡳⣝⡽⣽⣺⢵⣻⣽⢿⣽⣽\r\n"
				+ "⣺⣽⣺⢽⣳⣻⢽⢯⣗⡯⣟⣽⣳⣗⡯⣟⣗⣯⢷⣳⣗⡯⣷⣳⢯⢯⡯⣗⣟⣞⢾⢽⣳⣟⣿⢷⣻\r\n"
				+ "⣗⣗⣯⢯⣗⣯⢿⢽⣺⡽⣽⣞⣾⣺⢽⣳⣻⣺⡽⣞⡾⣽⣳⢯⡯⣯⢯⡷⣳⢯⣟⣽⣞⡷⣿⣟⣯\r\n"
				+ "⣷⣻⣺⡽⣞⣷⣻⢫⢫⢫⢳⢷⣳⢯⣟⣗⣟⡾⣽⢽⣽⡳⡫⡫⡫⡯⣯⢿⢽⡽⣞⣗⡷⣿⣟⣯⡷\r\n"
				+ "⣗⣟⡾⣽⣳⣗⡇⠅⠅⠅⢕⢽⢯⣟⣞⣗⣯⢯⡯⣟⣾⠨⠪⠨⠢⢩⡯⡿⣽⢽⣳⢯⣟⣷⣿⢿⡽\r\n"
				+ "⣯⢷⣻⣳⣗⣟⣮⢪⢨⢨⣲⣻⡽⣞⣷⡻⣞⣯⢿⢽⣺⣕⢅⢅⢅⣗⣯⢿⢽⣽⢽⣻⣞⣷⣿⣟⣯\r\n"
				+ "⢿⡽⣽⣞⣗⣟⡾⣽⢽⡽⣞⣗⡿⣽⣺⣽⣻⣺⡽⣯⢷⢯⢷⢯⣟⣗⣯⢿⡽⣞⣯⢷⣻⡾⣿⣽⣷\r\n"
				+ "⢽⡯⣷⣳⣟⡾⡽⣯⢯⢿⡽⡾⣽⣳⣟⣾⣺⣗⡿⣽⢽⢯⢿⡽⣞⡷⡯⣟⡾⣯⢯⣟⡷⣿⢿⣳⣿\r\n"
				+ "⡽⣯⢷⣻⣺⡽⣯⢯⡿⣽⢽⡯⡷⣗⡷⣗⡷⣗⡿⣽⢽⣻⣽⢽⣽⢽⢯⡯⡿⣽⡽⣞⣿⣽⣿⣯⡿\r\n"
				+ "⣻⡽⡯⣟⡾⣽⢯⡯⡿⡽⣯⣻⡽⣯⢿⡽⣽⢯⡯⡿⣽⣳⢯⣟⣾⣻⡽⣯⣟⣷⣻⣽⢾⡷⣿⣾⣻\r\n"
				+ "⣽⣽⣻⡽⣯⢿⡽⣽⣻⡯⣷⢯⡿⣽⢽⣽⢽⣽⢽⡯⣷⣻⡽⣗⣿⣺⣽⣳⣗⣿⣺⡽⣯⣿⣿⢷⣟\r\n"
				+ "⣗⣿⣺⢯⡿⡽⡏⡇⠧⡹⡚⣯⢿⣽⣻⣞⣿⣺⡯⣟⣷⢫⢺⢸⠸⡱⣟⣾⣳⣻⢾⡽⣷⢿⣾⣿⢽\r\n"
				+ "⣗⡿⣞⣯⣟⣯⡇⡪⡈⡢⡑⣽⣻⣞⣗⣟⣞⣷⣻⣽⢾⡨⡂⠢⡑⢜⣟⣾⢽⣾⣻⣽⣯⣿⣿⡾⣟\r\n"
				+ "⣯⢿⡯⣷⢯⡷⣟⣆⣦⣲⣺⣻⣞⡷⣯⢯⣷⣻⢾⡽⣯⢷⣌⢦⢮⡯⣟⣾⣻⣞⣷⣟⣾⣯⣿⣯⣟\r\n"
				+ "⣿⣯⢿⣯⣟⣯⣟⣷⣳⣯⢷⣻⢾⡽⣯⢿⣺⣽⢯⡿⣽⣻⣞⣿⢽⡯⣟⣷⣯⡷⣿⢾⣻⣽⣿⣞⠇\r\n"
				+ "⢹⣾⢿⣳⣯⣷⢿⣺⣗⣿⣽⣻⣽⢯⣟⣯⡿⣞⣯⣿⣳⣟⣾⡽⣯⢿⣯⡷⣷⡿⣿⡿⣿⡿⡷⠃⠐\r\n"
				+ "⠀⠙⢟⢿⣽⣾⣿⣯⣿⢾⡷⣿⣽⢿⣽⡷⣿⣻⡷⣿⣞⣿⢾⣻⣟⣿⣾⢿⣟⣿⣟⡿⠟⠝⢁⠀⠀\r\n"
				+ "⠁⡀⢀⠀⠁⠉⠊⠓⠛⠛⠛⠛⠝⠛⠫⠛⠛⠛⠛⠛⠝⠛⠛⠛⠋⠛⠊⠋⠉⡈⠀⡀⠁⠈⠀⡀⢀\r\n"
				+ "");
		
		Thread.sleep(1000);
		System.out.println();

		
		
		System.out.println("\r\n"
				+ "⡀⢀⠀⠁⠁⠁⠉⡈⢁⠉⠈⠉⠈⠉⡈⢉⠈⠉⠁⠉⠉⢈⠉⡈⠉⠈⠁⠉⠈⡁⢁⠁⠁⠐⠀⠂⠀\r\n"
				+ "⠠⠠⡀⣄⣄⡤⣔⣤⣢⣔⣤⡤⣤⣔⣤⣢⡬⣤⢤⣤⢤⣢⣔⡴⣤⣢⡤⣤⣔⡤⣔⣄⣄⡀⡀⠀⡁\r\n"
				+ "⣜⢾⢽⣳⡳⡯⣗⠗⢗⢓⢳⢹⢳⢳⢳⢳⡫⡗⣟⢞⣝⢗⣗⢯⢗⣗⡯⣗⡷⣻⣽⣺⣳⣟⡷⣄⠀\r\n"
				+ "⣯⢿⢽⢮⢯⣫⢮⢮⣖⣵⣳⣳⣳⢽⣺⣳⢽⣺⣵⡻⣮⣗⡷⣯⣻⢮⡯⣗⣟⣗⣷⣫⡾⣞⣿⣽⡀\r\n"
				+ "⣿⢽⢽⣝⢷⢽⣝⣗⣷⡳⣗⣷⣫⡯⣗⣯⣟⣾⣺⢽⣳⣗⣯⢷⢯⢷⣻⡽⣞⣷⣳⢯⡯⣟⣾⣽⡆\r\n"
				+ "⣿⢽⣽⣺⣽⣻⣺⣳⣗⡿⣽⣺⣳⢿⢽⣞⡾⣞⡾⡯⣷⣳⢯⢿⡽⣯⢷⣻⡽⣞⡾⡯⡿⣽⣞⣷⡇\r\n"
				+ "⣻⣳⢗⣷⣳⣗⣟⣾⢺⢹⡙⡺⢽⢯⣟⡾⡽⡯⣯⣟⣗⣯⣟⡯⡏⡏⡏⡗⣿⡽⣽⢯⣟⣷⣻⢾⡗\r\n"
				+ "⣯⢯⣟⣾⣺⣞⣗⡧⠣⡑⢌⢊⢪⢿⣺⣽⣻⡽⣗⣟⣞⣗⣿⠸⡨⡊⡢⡑⡵⣿⢽⣻⣞⣗⣯⡿⣏\r\n"
				+ "⣯⣟⣾⣺⣳⣗⣯⢿⢬⡨⣐⢰⢵⢿⡽⣞⣷⣻⡽⡾⣽⢾⢽⢧⡢⣂⡂⡦⡿⣽⢯⣷⣻⣞⣷⢿⣗\r\n"
				+ "⣗⡷⣗⣟⣾⣺⣳⢿⡽⣾⣺⡽⡯⡿⡽⣯⢾⡾⣽⢯⡯⣿⢽⡯⣟⣷⣻⣞⡿⣽⣻⣺⣳⣟⣾⣻⣗\r\n"
				+ "⣯⢿⢽⣳⣻⣺⡽⣽⢽⣳⢯⡯⣿⢽⣻⡽⡫⡭⡹⡹⣫⣯⡯⣿⢽⣞⣷⣳⢿⡽⣾⢽⣳⣟⡾⣯⣗\r\n"
				+ "⣯⢿⡽⣽⣞⣷⣻⡽⣯⢿⡽⣽⢽⢯⣯⡇⡣⠡⡑⠌⢮⣷⣻⣽⣻⣞⣾⢽⡯⣿⢽⡯⣿⣺⢿⣽⣗\r\n"
				+ "⣯⡯⣟⣗⣟⣞⣷⣻⣽⢽⡽⣯⣟⣟⣾⣳⡬⣢⢨⢸⣵⢷⣻⣞⣗⣟⡾⣯⢿⡽⣯⣟⣷⣻⣽⢷⣗\r\n"
				+ "⣷⣻⣽⣳⡯⣷⣻⢾⣺⡿⣽⣗⣿⣺⣳⢯⣯⢷⣻⣽⢾⡯⣷⣻⣞⣯⡿⣽⢯⣟⣗⣿⣺⣗⣿⣻⣗\r\n"
				+ "⣷⣻⣞⣷⣻⣗⣯⡿⡳⡹⡸⡪⣳⡯⣯⢿⣞⡿⣽⣞⣯⢿⣽⡳⡝⡜⡎⡻⣽⣞⣟⣾⣳⣟⣾⣯⣗\r\n"
				+ "⣟⣾⣳⣟⡾⣞⡷⣏⠪⡨⠪⠨⡪⣿⢽⣻⣞⣯⡷⣟⣾⣻⣾⡑⠕⠅⠕⠌⣞⣷⣻⣞⡷⣟⣾⢷⣗\r\n"
				+ "⣿⣳⣟⡾⣯⢿⣽⣻⣼⣨⢨⣸⣺⡽⡿⣽⣞⡷⣟⣯⣷⣻⣞⣷⣕⢥⡡⣳⣻⣞⣷⣻⣽⢿⣽⣿⡇\r\n"
				+ "⣿⣷⣻⣽⢯⣿⣺⣗⣷⢯⣿⣺⣗⣿⣻⣗⣯⡿⣽⣗⣿⣺⣗⣷⣻⡽⣯⢿⣺⣷⣻⣽⣾⢿⣻⣾⡇\r\n"
				+ "⣿⡷⣿⡽⣟⣾⣗⡿⣞⣿⣞⣷⣻⣞⡷⣯⡷⣟⣷⣻⣞⣷⣻⣞⣯⡿⣽⣻⣽⡾⣯⣷⡿⣿⡿⡿⠀\r\n"
				+ "⠙⢿⢯⣿⣟⣷⡿⣽⣟⣷⣟⣾⣻⣾⣻⣽⢿⣽⢷⣟⣷⣯⣷⢿⣳⣿⣯⣿⣳⣿⣟⣷⣿⣿⠻⠉⡀\r\n"
				+ "⢈⠀⡁⠉⠋⠫⠻⠻⠻⠯⠿⡻⠯⠿⡻⠽⠿⢟⠿⡻⠷⢟⠿⠿⡻⠷⠿⠞⠟⠏⠛⠙⠁⠀⠀⠀⠄\r\n"
				+ "⠀⠀⠀⠂⡁⠐⠀⠀⠀⠀⠄⢀⠂⠄⠀⠀⠀⠠⠀⡐⢀⠀⠀⠀⠀⡐⠀⢂⠀⠀⠀⠀⡁⢈⠀⡁⠀\r\n"
				+ "");
		
		Thread.sleep(1000);
		System.out.println();
		
		
		System.out.println("\r\n"
				+ "⠐⠀⠀⠀⢀⠂⡐⢀⠀⢀⠀⡐⢀⢂⠀⢀⠀⢀⠂⡐⠀⠀⠀⠀⡐⢀⠂⠀⠀⠀⠀⠂⠐⡀⠀⠀⠀\r\n"
				+ "⣁⣦⣗⡯⣷⡻⣞⡷⣻⣳⢟⣽⣳⢯⣟⢷⣻⣽⡻⣞⣿⣻⣻⣻⣞⣷⣻⣽⣻⣞⡾⣮⢦⣀⠀⠀⠀\r\n"
				+ "⣾⢾⣺⣽⡳⡯⡗⡏⡓⣝⡽⣞⡾⣽⣺⢯⣗⣷⣻⡽⣞⣞⣷⣳⣟⡾⣵⢷⣗⣯⢿⡽⣯⣷⡥⠈⡀\r\n"
				+ "⣿⢯⡷⣗⡿⡽⡱⣜⡾⣽⢽⣳⢿⡽⣞⣿⣺⣗⣯⢿⣽⣳⣟⡾⣞⣯⢿⣽⢾⡯⣿⢽⡷⣷⢿⡄⠀\r\n"
				+ "⣿⡯⣿⢽⡽⡽⣝⣷⣻⡽⣯⢿⡽⣯⢿⣺⣗⣿⣺⣟⣾⣳⡯⣟⣯⡿⣽⢾⣯⢿⣽⢯⣿⢽⣟⡧⠀\r\n"
				+ "⣿⢯⢿⡽⣽⢽⢯⣾⣳⢿⡽⡏⣏⢏⢟⢷⣻⣞⣷⣻⣞⣷⣻⣯⡷⡟⣝⢝⢽⣻⢾⣻⣽⢯⣿⣻⠀\r\n"
				+ "⣿⣗⢿⡽⡯⡿⣽⢾⡽⣯⣟⢜⢌⠢⡑⢽⣳⣟⣾⣳⣟⣾⣳⡷⣟⢜⢌⠪⡂⣟⣯⡿⣾⣻⡷⣿⠀\r\n"
				+ "⣿⣽⢯⡿⣽⢯⡿⣽⡽⣗⡿⣦⢥⡱⣌⣯⡷⣟⣾⣳⣟⣾⣳⣟⡿⣦⢥⣱⣜⣾⣳⣟⣯⣷⢿⣿⠂\r\n"
				+ "⣿⣽⢿⡽⣯⢯⣟⣷⣻⣽⢯⣟⣯⢿⡯⣷⣟⣿⣺⣗⣿⣺⣗⣯⡿⣽⣟⣷⣻⡾⣽⣽⢷⣻⡿⣽⡂\r\n"
				+ "⣿⣽⢯⡿⡽⣯⢷⣻⢾⣽⣻⢣⢣⢣⠹⢽⣞⣷⣻⣞⣷⣻⢾⣳⣟⢇⢗⢜⢜⢿⣽⢾⣟⣯⡿⣿⡀\r\n"
				+ "⣿⣽⢿⣽⣻⡽⣯⢿⡽⣾⣽⡘⠔⠅⢅⣟⣾⣳⣟⣾⣳⣟⣿⢽⣗⡕⢕⢐⠱⡽⣯⢿⣽⢷⡿⣿⠀\r\n"
				+ "⣿⣯⣿⣳⡯⣿⢽⡯⣟⣷⢯⣿⣳⣟⣶⣻⣞⣷⣻⣾⣳⢿⣺⣟⣷⣟⡾⣮⣯⢿⡯⣿⡽⣯⡿⣿⠀\r\n"
				+ "⣿⡿⣞⣷⢿⡽⣯⣟⣿⣺⣟⡗⡟⡞⡯⣷⢿⣺⣷⣻⣾⣻⣯⢿⣞⡷⡻⡻⡺⣿⡽⣯⡿⣯⡿⣿⠁\r\n"
				+ "⣿⣿⣻⣽⢯⣟⣷⣻⣞⡷⣿⢸⢑⢕⢑⢽⣻⣽⢾⣳⣯⡷⣿⢽⣗⢕⢝⠜⢌⢷⣟⣯⡿⣯⡿⣿⠀\r\n"
				+ "⡿⣾⢯⣿⡽⣷⣻⢾⣳⣿⣻⣦⣑⢔⣰⢽⣟⣾⣟⡿⣞⣯⡿⣯⣷⣕⣔⣑⢬⢿⡽⣷⢿⣯⡿⣟⠀\r\n"
				+ "⠹⣯⢿⡷⣟⣯⣟⣿⣽⢾⣳⣟⣾⣻⣽⢯⣿⣺⡷⣟⣿⣳⡿⣷⣻⣾⣳⣿⣻⣟⣿⣽⣟⣷⣿⡏⢀\r\n"
				+ "⠀⠹⣯⢿⣿⡽⣟⣾⣽⢿⣽⣻⣾⣻⣾⣻⣷⣻⣽⣯⣟⣷⣟⣯⣷⣟⡷⣟⣾⣟⣾⡷⣿⣻⡷⠁⠠\r\n"
				+ "⠐⠀⠈⠻⢷⢿⣿⢿⣾⡿⣷⡿⣾⢷⣟⣷⣿⣽⣾⢷⣟⣷⣿⣽⣾⣯⣿⢿⣽⣾⡿⣿⢟⠟⠀⠀⠀\r\n"
				+ "⠁⢀⠀⢀⠀⠂⠁⠉⠑⠙⠋⠛⠛⠛⠛⠝⠚⠛⠚⠛⠛⠫⠓⠛⠓⠛⠝⠛⠙⢉⠉⠈⠀⠄⢀⠀⡀\r\n"
				+ "");
		Thread.sleep(1000);
		System.out.println();
	}
	
		// menuPrint() - 메뉴 출력 후 리턴
	public void startRulePrint() throws InterruptedException {
		System.out.println("플레이어 이름을 설정한 뒤 게임이 시작됩니다");
		System.out.println("게임이 시작되면 주사위가 자동으로 굴려지며");
		System.out.println("처음 굴려진 주사위를 킵하지 않는다면 해당 주사위로 점수를 기록해야 합니다");
		
		Thread.sleep(3000);
		System.out.println();
	}
	
		// pritRules() - 점수 기록 방법 출력 메서드 
	public void printRules() {
    System.out.println("============================== 게임 룰 ==============================");
    System.out.println("1. 각 플레이어는 주사위를 3번 던질수 있으며 해당 번호를 킵 할수 있다.");
    System.out.println(" - 예 : 처음 3,3,1,2,5 3번 킵 / 킵 된 주사위 - 3,3");
    System.out.println(" - 예 : 2번째 3개를 리 롤 5,3,1 킵 / 킵 된 주사위 - 3,3,3");
    System.out.println(" - 예 : 마지막 2개 리 롤 5,6 - 최종 3,3,3,5,6 ");
    
    
    System.out.println("\n2. 상위 항목의 점수 계산 방법");
    System.out.println(" - Aces (1) : 주사위에서 1이 나온 개수만큼 점수 합산 (예: 1이 3개 나오면 3점)");
    System.out.println(" - Deuces (2) : 주사위에서 2가 나온 개수만큼 점수 합산 (예: 2가 3개 나오면 6점)");
    System.out.println(" - Threes (3) : 주사위에서 3이 나온 개수만큼 점수 합산");
    System.out.println(" - Fours (4) : 주사위에서 4가 나온 개수만큼 점수 합산");
    System.out.println(" - Fives (5) : 주사위에서 5가 나온 개수만큼 점수 합산");
    System.out.println(" - Sixes (6) : 주사위에서 6이 나온 개수만큼 점수 합산");
    
    System.out.println("\n3. 하위 항목의 점수 계산 방법");
    System.out.println(" - subTotal : 1~6까지의 점수 합계가 63점 이상일 경우 보너스 35점 추가");
    
//    System.out.println("\n4. 추가 점수 항목:");
//    System.out.println(" - 초이스 (Choice): 주사위 눈 5개의 합계 (최대 30점)");
    System.out.println(" - 4 or Kind: 동일한 주사위 눈 4개 이상일 경우, 4개가 나온 눈의 총합");
//    System.out.println(" - Full House (풀 하우스): 같은 숫자 3개 + 다른 숫자 2개일 경우 총합 (최대 28점)");
//    System.out.println(" - 스몰 스트레이트 (Small Straight): 1, 2, 3, 4 또는 2, 3, 4, 5 또는 3, 4, 5, 6 일 때 15점");
//    System.out.println(" - 라지 스트레이트 (Large Straight): 1, 2, 3, 4, 5 또는 2, 3, 4, 5, 6 일 때 30점");
    System.out.println(" - 야추 (Yacht): 임의의 동일한 주사위 눈 5개가 나오면 50점");

    System.out.println("\n4. 게임 점수 합계:");
    System.out.println(" - 각 항목의 점수를 더한 최종 점수로 승패를 가리고 총 9라운드 진행");
    System.out.println("==================================================================");
	}
	
	
		// gamePlayMenu() - 게임 실행 선택 시 출력 메뉴
	public int gamePlayMenu() {
		System.out.println("수행하실 작업을 선택하세요");
		System.out.println("킵은 한 번 할 수 있으며 킵한 주사위는 최대 2번 주사위를 다시 굴릴 수 있습니다");
		System.out.println("남은 주사위 횟수 : " + (2-totalNum));
		System.out.println("1) 점수 기록 규칙 보기   2) 킵   3) 킵한 주사위 굴리기   4) 점수 기록");

		System.out.print("입력 : ");
		int n = sc.nextInt();
		
		return n;
	}
	
		// playerNameSet() - 플레이어 생성 및 이름 설정 
	public void playerNameSet(){
		// 플레이어 생성
		System.out.println("플레이어의 이름을 설정해주세요.");		
		System.out.print("입력 : ");
		String s = sc.next();
		
		DiceGamePlayer pl = new DiceGamePlayer(s);
	}
	
		// rollDice1() - 주사위 1개 던지기  
  public int rollDice1() {
  	int dice = (int)(Math.random()*6) + 1;
  	
  	return dice;
  }
  
		// rollDice5() - 주사위 5개 던지기  
	public void rollDice5() {
		for(int i = 0; i < 5; i++) { 
			plDiceList.add(rollDice1());
		}
		// 굴린 결과 확인 
		System.out.print("주어진 주사위 : ");
		for(int i : plDiceList) { System.out.print(+ i + " ");}
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
		// keepDice() - 킵할 주사위 선택
  public void keepDice() {
  	// 멤버 변수 초기화
  	char c;
  	int cnt = 0;
  	ArrayList<Integer> tmp = new ArrayList<Integer>();
  	
  	// keep 횟수 증가
  	keepNum++;
  	
  	// 주사위를 굴린 경우에만 킵 가능
  	if(!plDiceList.isEmpty() && keepNum <= 1) {
  		// UI
    	do {
    		System.out.println();
    		System.out.println("몇 번째 주사위를 킵할지 선택하세요");
    		System.out.println();
      	System.out.println("      <주사위 위치>");
      	System.out.println("    0 | 1 | 2 | 3 | 4 ");
      	System.out.println();
      	System.out.print("선택 번호 입력 : ");
        int n = sc.nextInt();
    		
//        // if (킵을 두 번째 선택한 경우)
//        	// 이거 처리 해야됨 
//        if(plDiceList.get(n) != null) {
//        	
//        }
        
        tmp.add(plDiceList.get(n)); cnt++;
        plDiceList.set(n, 0);
        
        // 확인,
        System.out.print("선택 번호 : ");
        for(int e : tmp) {
        	System.out.print(e + " ");
        } System.out.println();
        
        System.out.println("킵을 계속 진행하시겠습니까? (Y/N)");
        System.out.print("선택 (Y/N) : ");
        c = Character.toUpperCase(sc.next().charAt(0));
    	}while(c != 'N');
    	
    	plDiceList.clear();
      
    	// 킵한 주사위 저장 
    	for(int i = 0; i < cnt; i++) {
    		if(tmp.get(i) != 0) { plDiceList.add(tmp.get(i)); } 
    	}
    	
      // 확인
    	System.out.print("결과 : ");
      for(int e : plDiceList) {
      	System.out.print(e + " ");
      } 
      System.out.println("\n");
  	} // if fin
  		else if(plDiceList.isEmpty()) { 
  			System.out.println("킵할 주사위가 없습니다..!");
  		}
  		
  		else if(keepNum >= 2) { 
  			System.out.println("킵을 두 번 이상할 수 없습니다 "); return;
  		}
  	}
  
  	// modrollDice() - 킵한 다이스 굴리기 
  public void modRollDice() {
  	// 멤버 변수 초기화
  		// 임시 배열 생성 
  	int[] tmpArr = new int[5];
//  	ArrayList<Integer> tmpPlDiceList = new ArrayList<>();
  	int cnt = 0;
  	int tmpIdx = 0;
  	char c;
  	
  	// keep 을 한 번도 하지 않았다면 문구 출력 
  	if(keepNum == 0) {return;}
  	
  	// 
  	else if(keepNum >= 1 && totalNum <= 2) {
  		// user 주사위를 가져와서 임시 배열에 저장 
  		for(int e : plDiceList) { 
    		if(e != 0) { 
    			tmpArr[cnt] = e; 
    			cnt++; 
    			// 확인, System.out.print(e + " ");
    		}
    	} // 확인, System.out.println(cnt);
    	
    	tmpIdx = cnt;
    	
    	// 반복
    	loop : do {   	   	
    		totalNum++;
    		
      	int i = 5-cnt;
    		
    		while(i > 0) {
      		tmpArr[tmpIdx] = rollDice1();
      		tmpIdx++;
      		i--;
      	}
    		
    		tmpIdx = cnt;
    		System.out.println();
    		System.out.print("굴린 주사위의 결과 : ");
    		for(int e : tmpArr) { System.out.print(e + " "); }
    		System.out.println("\n");
    	
    		
    		if(totalNum < 2) {
    			System.out.println("다시 굴리시겠습니까?");
      		System.out.print("Yes (Y) / No (N) : ");
      		
      		c = Character.toUpperCase(sc.next().charAt(0));
      		
      		// 주사위 초기화
      		if(c == 'Y') {
      			for(int j = cnt; j < 5; j++) { tmpArr[j] = 0; }
      		}
      		
      		else if(c == 'N') { break loop; }
    		}
    	}while(totalNum < 2);	
    		
    
//    	// 값 저장
//    	for(int e = tmpArr.length -1; e >= 0; e--) {
//    		plDiceList.add(cnt, tmpArr[e]);
//    	}
    	
    	for(int e : tmpArr) {
    		plDiceList.add(cnt, e);
			}
    	
    	for (int k = plDiceList.size() - 1; k >= 5; k--) {
        plDiceList.remove(k);
    	}
    	
    	// 확인용 출력
    	System.out.println("-------------");
    	for(int e : plDiceList) { System.out.print(e + " "); }
    	System.out.println("\n");
  		
    	this.keepNum = 0;
  	} 
  	return;
  }
  
  	// 점수 기록 메서드 
  	// scoreSave() - 점수 기록 메서드
  public void scoreSave() {
  	this.totalNum = 4;
  	
  	System.out.println("어느 곳에 기록하시겠습니까? ");
  	sb.allScorePrint();
  	
  	System.out.println("기록하실 위치를 선택해주세요");
  	System.out.println("1) Aces   2) Deuces   3) Threes");
  	System.out.println("4) Fours   5) Fives   6) Sixes");
  	System.out.println("7) Subtotal   8) 4 or Kind   9) Yacht   10) 뒤로 가기");
  	
  	int tmp = sc.nextInt();
  	
  	switch(tmp) {
  		case 1 : 
  			sb.acesSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  		
  		case 2 :
  			sb.deucesSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 3 :
  			sb.threesSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 4 : 
  			sb.foursSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  		
  		case 5 :
  			sb.fivesSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 6 :
  			sb.sixesSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 7 :
  			sb.subTotal(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 8 :
  			sb.same4Sum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  		
  		case 9 :
  			sb.yachtSum(plDiceList); 
  			sb.allScorePrint(); sb.fin(); 
  			plDiceList.clear(); break;
  			
  		case 10 : return;
  	}
//  	switch()
  }
  	
  
  // Getter(), Setter()
	int getTotalNum() {
		return totalNum;
	}
	
	void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
}