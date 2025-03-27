package day10;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 성적표
		 * 몇명의 성적을 출력할지 결정 > 3
		 * 이름  국어  영어  수학  총점  평균  석차 => syso 출력
		 * hong  89  90  85	   00 	00    0 
		 * choi  89  90  85	   00 	00    0 
		 * park  89  90  85	   00 	00    0 
		 * "\t" : 탭
		 * */
		
		/* Report 클래스 생성
		 * 이름	국어	영어	수학	총점 평균 석차 => 멤버변수
		 * 메서드 체크
		 * */
		/* main Report 객체의 배열 생성
		 * 석차 구하기
		 * */
		
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생수"+ " ");
        int numStudents = scanner.nextInt();
        
        Report[] rp = new Report[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print((i + 1) + "번 학생의 이름: ");
            String name = scanner.next();

            int kor;
            while (true) {
                System.out.print("국어점수: ");
                kor = scanner.nextInt();
                if (kor >= 0 && kor <= 100) {
                    break;
                } else {
                    System.out.println("오류 0~100까지 숫자 입력.");
                }
            }

            int eng;
            while (true) {
                System.out.print("영어점수: ");
                eng = scanner.nextInt();
                if (eng >= 0 && eng <= 100) {
                    break;
                } else {
                    System.out.println("오류 0~100까지 숫자 입력.");
                }
            }

            int math;
            while (true) {
                System.out.print("수학점수: ");
                math = scanner.nextInt();
                if (math >= 0 && math <= 100) {
                    break;
                } else {
                    System.out.println("오류 0~100까지 숫자 입력.");
                }
            }

            rp[i] = new Report(i + 1, name, kor, eng, math); // 번호를 함께 전달하여 객체 생성
        }

        for (int i = 0; i < rp.length; i++) {
            rp[i].avg();
        }

        for (int i = 0; i < rp.length; i++) {
            int rank = 1;
            for (int j = 0; j < rp.length; j++) {
                if (i != j && rp[i].getTotals() < rp[j].getTotals()) {
                    rank++;
                }
            }
            rp[i].setSeq(rank);
        }

        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
        for (Report report : rp) {
            System.out.print(report.getNumber() + "\t");
            System.out.print(report.getName() + "\t");
            System.out.print(report.getKor() + "\t");
            System.out.print(report.getEng() + "\t");
            System.out.print(report.getMath() + "\t");
            System.out.print(report.getTotals() + "\t");
            System.out.print(String.format("%.2f", report.getAvgs()) + "\t");
            System.out.println(report.getSeq() + "등");
        }
        scanner.close(); 
    }
}

class Report {
    private int number;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int totals;
    private double avgs;
    private int seq;

    public Report() {}

    public Report(int number, String name, int kor, int eng, int math) {
        this.number = number;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.totals = kor + eng + math;
        avg();
    }

    public void avg() {
        this.totals = kor + eng + math;
        this.avgs = totals / 3.0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public double getAvgs() {
        return avgs;
    }

    public void setAvgs(double avgs) {
        this.avgs = avgs;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}