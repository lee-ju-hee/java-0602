package java04;

import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {

		ExamList list = new ExamList();
		list.exams = new Exam[3];
		list.current = 0;

		// exam. -> ������
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
		System.out.println("�����մϴ�.");
	}

	private static void displayScore(ExamList list) {
		// ���
		displayScore(list, list.current);
	}
	
	private static void displayScore(ExamList list, int size) {
		// ���
		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < size; i++) {
			Exam exam = list.exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			total = kor + eng + math;
			avg = total / 3;
			System.out.println("������������������������");
			System.out.println("��  ���� ���   ��");
			System.out.println("������������������������");

			System.out.printf("����: %d\n", kor);
			System.out.printf("����: %d\n", eng);
			System.out.printf("����: %d\n", math);

			System.out.printf("����: %d\n", total);
			System.out.printf("���: %6.2f\n", avg);// ��ü 6�ڸ� �� �Ҽ��� 2��°����

			System.out.println("------------------");
		}
	}
	
	private static void inputScore(ExamList list) {

		Scanner scan = new Scanner(System.in);
		// �Է�
		System.out.println("������������������������");
		System.out.println("��  ���� �Է�   ��");
		System.out.println("������������������������");

		int kor, eng, math;

		do {
			System.out.print("����: ");
			kor = scan.nextInt();
			if (kor < 0 || 100 < kor)
				System.out.println("���������� (0~100) ������ϴ�.");
		} while (kor < 0 || kor > 100);

		do {
			System.out.print("����: ");
			eng = scan.nextInt();
			if (eng < 0 || 100 < eng)
				System.out.println("���������� (0~100) ������ϴ�.");
		} while (eng < 0 || eng > 100);

		do {
			System.out.print("����: ");
			math = scan.nextInt();
			if (math < 0 || 100 < math)
				System.out.println("���������� (0~100) ������ϴ�.");
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

		// �޴�
		Scanner scan = new Scanner(System.in);

		int menu;
		System.out.println("������������������������");
		System.out.println("��  �޴� ����   ��");
		System.out.println("������������������������");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ����");
		System.out.print("���� >> ");
		menu = scan.nextInt();
		return menu;
	}
}
