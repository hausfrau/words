package my.example.testwords1.org.app.console;


import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import my.example.testwords1.org.app.collection.LessonsCollection;
import my.example.testwords1.org.app.collection.Tester;
import my.example.testwords1.org.app.collection.impl.TesterImpl;
import my.example.testwords1.org.app.model.Answer;
import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Files;
import my.example.testwords1.org.app.source.impl.SourceFile;

public class Main {
	/*public static void main(String[] args) {
		
		if(args.length == 0 ) {
			System.out.println("java.exe -jar word.jar <���� �� ����� �� �������> <���������� ���� � �����> <���������� ������� � �������>");
			System.exit(1);
		}
		
		String path = args[0];
		Integer countWords = Integer.valueOf(args[1]);		
		Integer countAnswers = Integer.valueOf(args[2]);
		
		
		//for debuging
		/*String path = "C:"+File.separator+"temp"+File.separator+"words.txt";
		Integer countWords = 10;		
		Integer countAnswers = 5;
		
		
		File file = new File(path);
		Files source = new SourceFile();
		source.parse(file);		
		Tester words = new TesterImpl();		
		if(countWords != null) {
			words.setCountWords(countWords);
		}		
		if(countAnswers != null) {
			words.setCountAnswers(countAnswers);
		}
		words.parse(source);
		LessonsCollection lessons = words.getCollections();
		
		System.out.println("���������� ���� � ������: "+source.getWords().size());
		System.out.println("���������� ���� � �����: "+(countWords != null ? countWords : 15));
		System.out.println("���������� ��������: "+(countAnswers != null ? countAnswers : 3));
		
		System.out.println("����� �������� ������");
		System.out.println("��� ������ ����� ������� Enter");		 
		
		//TODO ������� ru-en en-ru
		//TODO ������� ����� �� ����������� ����� � ����� �������
		//TODO ������� �������� ������������ ���� � ������
		//TODO ������ ���������� ������ �� ����������
		//TODO ������� ������ ���� �� http://www.alleng.ru/mybook/7phv170/TOP170_alph.htm
		//TODO ������� ������ �� xml <words><word><original>word</original><translate>�����</translate><transcript></transcript></word></words>
		//TODO ������� ������ �� ��
		//TODO ������� � properti ����� ��������� ��������
		//TODO ������� �� maven
		//TODO ����������� ����� Loggin
		//TODO ����� ��������� ���� (����� ���� ���������� �����)
		//TODO �������� ��� ����� ����������
		//TODO �������� ��� ������������ xml ������� ������ ��� ������������(��� �� �������)
		//TODO ��� ������ �� ������ �� ��������
		//TODO ������� ���������� (��� �� �������), �������  ��� ���������� � ��������� 
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		int sum = 0;
		for(Entry<Word, List<Answer>> r :  lessons.getLessonsCollection().entrySet()) {
			++sum;
			System.out.println("--------------------������ �������-"+sum+"/"+countWords+"------------------------------------");
			System.out.println("�����: "+r.getKey().original);
			System.out.println();
			System.out.println("�����:");
			for(Answer a : r.getValue()) {
				 System.out.println(a.number+") "+ a.word.getTranslationAsString());
			}
			System.out.println("-------------------����� �������------------------------------------");
			System.out.print("������� �����:");
			try{
				r.getKey().yourAnswers = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("����� ������ ���� ������:");
				System.out.println("���� ��������� ���� ����� :(");
				System.exit(1);
			}
			scanner.nextLine();
		}
		words.result();
		System.out.println("���� ��������");
	}*/
}
