package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
	//학생 => 과목 수강하는 과정을 관리
	
	private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>(); 
    
    public void insertStudent(Scanner scan) {
    	System.out.println("학번: ");
        String num = scan.next();
        System.out.println("이름: ");
        String name = scan.next();
        System.out.println("나이: ");
        String age = scan.next();
        System.out.println("전화번호: ");
        String phone = scan.next();
        scan.nextLine();
        System.out.println("주소: ");
        String address = scan.nextLine();
        
        Student student = new Student(num, name, age, phone, address);
        students.add(student);
        System.out.println("학생 등록 완료");
        
    }
    public void printStudent() {
    	if(students.isEmpty()) {
    		System.out.println("등록 학생이 없습니다.");
    		return;
    	}
    	 for (Student student : students) {
             System.out.println(student);
         }
    }
    
    public void insertSubject(Scanner scan) {
    	
		
	}
    
   
}
