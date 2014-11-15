package my.example.testwords1.org.app.source;


import java.io.File;
/**
 * Inerface for file implementation
 * 
 * @author Ogarkov.Sergey
 *
 */
public interface Files extends Source {
	
	/**
	 * Method parses txt file 
	 * 
	 * file format is 
	 * 	 hello ������ 
	 * 	 something  ��� ��
	 * 	 it's apple ��� ������ 	
	 * 
	 * @param file
	 */
	public void parse(File file);
}