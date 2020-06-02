package java04;

import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {

		ExamList list = new ExamList();
		list.exams = new Exam[3];
		list.current = 0;

		// exam. -> 연산자
		int menu = 0;
		boolean flag = true;

		while (flag) {

			menu = selectMenu();

			switch (menu) {
			case 1:
				inputScore(list);
				break;

			case 2:
				displayScore(list);
				//displayScore(list,1);
				break;

			case 3:
				flag = false;
				break;
			}
		}
		System.out.println("종료합니다.");
	}

	private static void displayScore(ExamList list) {
		// 출력
		displayScore(list, list.current);
	}
	
	private static void displayScore(ExamList list, int size) {
		// 출력
		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < size; i++) {
			Exam exam = list.exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			total = kor + eng + math;
			avg = total / 3;
			System.out.println("┌──────────┐");
			System.out.println("│  성적 출력   │");
			System.out.println("└──────────┘");

			System.out.printf("국어: %d\n", kor);
			System.out.printf("영어: %d\n", eng);
			System.out.printf("수학: %d\n", math);

			System.out.printf("총점: %d\n", total);
			System.out.printf("평균: %6.2f\n", avg);// 전체 6자리 중 소수점 2번째까지

			System.out.println("------------------");
		}
	}
	
	private static void inputScore(ExamList list) {

		Scanner scan = new Scanner(System.in);
		// 입력
		System.out.println("┌──────────┐");
		System.out.println("│  성적 입력   │");
		System.out.println("└──────────┘");

		int kor, eng, math;

		do {
			System.out.print("국어: ");
			kor = scan.nextInt();
			if (kor < 0 || 100 < kor)
				System.out.println("성적범위를 (0~100) 벗어났습니다.");
		} while (kor < 0 || kor > 100);

		do {
			System.out.print("영어: ");
			eng = scan.nextInt();
			if (eng < 0 || 100 < eng)
				System.out.println("성적범위를 (0~100) 벗어났습니다.");
		} while (eng < 0 || eng > 100);

		do {
			System.out.print("수학: ");
			math = scan.nextInt();
			if (math < 0 || 100 < math)
				System.out.println("성적범위를 (0~100) 벗어났습니다.");
		} while (math < 0 || math > 100);

		Exam exam = new Exam();
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;

		Exam[] exams = list.exams;
		int size = list.current;
		if (exams.length == size)
		{
			Exam[] temp = new Exam[size + 3];
			for(int i = 0; i<size; i++)
			{
				temp[i]=exams[i];
			}
			list.exams=temp;
		}
		list.exams[list.current] = exam;
		list.current++;

		System.out.println("------------------");

	}

	private static int selectMenu() {

		// 메뉴
		Scanner scan = new Scanner(System.in);

		int menu;
		System.out.println("┌──────────┐");
		System.out.println("│  메뉴 선택   │");
		System.out.println("└──────────┘");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		System.out.print("선택 >> ");
		menu = scan.nextInt();
		return menu;
	}
}
