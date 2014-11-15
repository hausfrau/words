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
			System.out.println("java.exe -jar word.jar <путь до файла со словами> <количество слов в тесте> <количество ответов в вопросе>");
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
		
		System.out.println("Количество слов в списке: "+source.getWords().size());
		System.out.println("Количество слов в тесте: "+(countWords != null ? countWords : 15));
		System.out.println("Количество вопросов: "+(countAnswers != null ? countAnswers : 3));
		
		System.out.println("Ответ выбираем цифрой");
		System.out.println("Для начала теста нажмите Enter");		 
		
		//TODO Сделать ru-en en-ru
		//TODO Сделать вывод не правильного слова в конце вопроса
		//TODO Сделать проверку уникальности слов в списке
		//TODO Чтение нескольких файлов из директории
		//TODO Сделать чтение слов из http://www.alleng.ru/mybook/7phv170/TOP170_alph.htm
		//TODO Сделать чтение их xml <words><word><original>word</original><translate>Слово</translate><transcript></transcript></word></words>
		//TODO Сделать чтение из БД
		//TODO Вынести в properti поиск латинских символов
		//TODO Занести по maven
		//TODO Логирование через Loggin
		//TODO Выбор источкина слов (выбор всех источников сразу)
		//TODO Подумать над много язычностью
		//TODO подумать над формирование xml готовых тестов для проигрования(что то смутное)
		//TODO Веб версия по такому же принципу
		//TODO плагины расширения (что то смутное), сделать  как библиотеку с плагинами 
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		int sum = 0;
		for(Entry<Word, List<Answer>> r :  lessons.getLessonsCollection().entrySet()) {
			++sum;
			System.out.println("--------------------Начало запроса-"+sum+"/"+countWords+"------------------------------------");
			System.out.println("Слово: "+r.getKey().original);
			System.out.println();
			System.out.println("Ответ:");
			for(Answer a : r.getValue()) {
				 System.out.println(a.number+") "+ a.word.getTranslationAsString());
			}
			System.out.println("-------------------Конец запроса------------------------------------");
			System.out.print("Введите ответ:");
			try{
				r.getKey().yourAnswers = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Ответ должен быть цифрой:");
				System.out.println("Надо запустеть тест снова :(");
				System.exit(1);
			}
			scanner.nextLine();
		}
		words.result();
		System.out.println("Тест завершен");
	}*/
}
