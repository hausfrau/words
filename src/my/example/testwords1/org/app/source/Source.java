package my.example.testwords1.org.app.source;


import java.util.List;

import my.example.testwords1.org.app.model.Word;
/**
 * General interface for all implementation,  source can be (txt,xml, ftp and etc)
 * 
 * @author Ogarkov.Sergey
 *
 */
public interface Source {
	/**
	 * Method return Word collections
	 * @return list of the words
	 */
	public List<Word> getWords();	
	public Integer getSize();
}

