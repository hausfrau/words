package my.example.testwords1.org.app.collection.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import my.example.testwords1.org.app.collection.LessonsCollection;
import my.example.testwords1.org.app.collection.Tester;
import my.example.testwords1.org.app.logger.CustomLogger;
import my.example.testwords1.org.app.model.Answer;
import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Source;

/**
 * Implementation if the engine, implementation can be a lot
 * 
 * @author Ogarkov.Sergey
 * 
 */
public class TesterImpl implements Tester {

	private Integer count = 15;
	private Integer countAnswers = 3;
	private final static LessonsCollection lessonsCollection = new LessonsCollection();
	private StringBuffer resultString = new StringBuffer();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'  'HH:mm:ss");

	@Override
	public void parse(Source source) {
		Collections.shuffle(source.getWords());
		//System.out.println("количество слов - " + source.getWords().size()
	//			+ " this.count=" + this.count);
		List<Word> words = new ArrayList<Word>(source.getWords().subList(0,
				this.count));
		Collections.shuffle(words);
		for (Word word : words) {
			lessonsCollection.put(word, getAnswer(word, source.getWords()));

		}
	}

	private List<Answer> getAnswer(Word word, List<Word> words) {
		List<Word> answersWords = new ArrayList<Word>();
		answersWords.addAll(words);
		answersWords.remove(word);
		Collections.shuffle(answersWords);
		List<Answer> answers = new ArrayList<Answer>();
		// right answer
		Answer answer = new Answer(word);
		answer.isRight();
		answers.add(answer);
		// wrong answer
		List<Word> wrongAnswes = new ArrayList<Word>(answersWords.subList(0,
				this.countAnswers - 1));
		for (Word w : wrongAnswes) {
			answers.add(new Answer(w));
		}
		Collections.shuffle(answers);
		int count = 1;
		for (Answer number : answers) {
			number.number = count++;
		}
		return answers;
	}

	@Override
	public LessonsCollection getCollections() {
		return lessonsCollection;
	}

	@Override
	public void setCountWords(Integer count) {
		this.count = count;
	}

	@Override
	public void result() {
		this.resultString.setLength(0);
		int wrongCount = 0;
		int rightCount = 0;
		String tempString;
		this.resultString.append("\r\n"+sdf.format(new Date(System.currentTimeMillis()))+"\r\n");
		for (Entry<Word, List<Answer>> r : lessonsCollection
				.getLessonsCollection().entrySet()) {
			for (Answer a : r.getValue()) {
				if (a.number == r.getKey().yourAnswers) {
					if (a.isRight == true) {
						rightCount++;
						tempString = "\r\n==============\r\nПравильно!  \r\n\r\nВопрос: "
								+ a.word.original + ", \r\nОтвет: "
								+ a.word.translation;
						CustomLogger.log(tempString);
					} else {
						wrongCount++;
						tempString = "\r\n==============\r\nНе правильно!  \r\n\r\nВопрос: "
								+ r.getKey().original + ", \r\n\r\nНе верный ответ: "
								+ a.word.translation + ", \r\n\r\nВерный ответ: "
								+ getWriteAnswer(r.getValue());
						CustomLogger.log(tempString);
					}
					this.resultString.append(tempString);
				}
			}
		}
		this.resultString.append("\r\n==============\r\n\r\nПравильных ответов:" + rightCount);
		this.resultString.append("\r\nНе правильных ответов:" + wrongCount);
		this.resultString.append("\r\nОтветы лежат в файле result.txt");
		//System.out.println("Правильных ответов:" + rightCount);
		//System.out.println("Не правильных ответов:" + wrongCount);
		//System.out.println("Ответы лежат в файле result.txt");
	}

	private String getWriteAnswer(List<Answer> asnwers) {
		for (Answer a : asnwers) {
			if (a.isRight == true) {
				return a.word.getTranslationAsString();
			}
		}
		return null;
	}

	@Override
	public void setCountAnswers(Integer countAnswers) {
		this.countAnswers = countAnswers;
	}

	/*@Override
	public boolean isRightAnswer(Word w, int i) {
		boolean res = false;
		// for( Entry<Word, List<Answer>> r :
		// lessonsCollection.getLessonsCollection().entrySet()) {

		for (Answer a : (List<Answer>) lessonsCollection.getLessonsCollection()
				.get((Word) w)) {
			if (a.number == w.yourAnswers) {
				if (a.isRight == true) {
					return true;
				}
			}
		}
		// }
		return res;
	}
	
	@Override
	public String getRightAnswer(Word w) {
		String res;
		// for( Entry<Word, List<Answer>> r :
		// lessonsCollection.getLessonsCollection().entrySet()) {

		for (Answer a : (List<Answer>) lessonsCollection.getLessonsCollection()
				.get((Word) w)) {
			if (a.number == w.yourAnswers) {
				if (a.isRight == true) {
					a.word..toString()return true;
				}
			}
		}
		// }
		return "";
	}*/
	@Override
	public StringBuffer getResultString() {
		return this.resultString;
	}
}