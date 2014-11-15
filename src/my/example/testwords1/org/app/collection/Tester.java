package my.example.testwords1.org.app.collection;

import my.example.testwords1.org.app.collection.LessonsCollection;
import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Source;
/**
 * Engine of the tests
 * 
 * @author Ogarkov.Sergey
 *
 */
public interface Tester {
	
	public void setCountWords(Integer countWords);
	
	public void setCountAnswers(Integer countAnswers);
	
	public void parse(Source source);
	
	public LessonsCollection getCollections();
	
	public void result();
	
	/*public boolean isRightAnswer(Word w, int i) ;
	
	public String getRightAnswer(Word w);*/
	
	public StringBuffer getResultString();
}