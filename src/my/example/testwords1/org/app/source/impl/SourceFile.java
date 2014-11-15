package my.example.testwords1.org.app.source.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Files;
import android.util.Log;

/**
 * File source implementation
 * 
 * @author Ogarkov.Sergey
 *
 */
public class SourceFile implements Files {
	
//	private final static  List<Word> list = new ArrayList<Word>();
	private final static  Set<Word> list = new HashSet<Word>();

	private final static String SEPARATOR = "[ ]";

	final String FILENAME_SD = "words_de";
	final String LOG_TAG = "myLogs";
	final String DIR_SD = "MyFiles";
	
	@Override
	public List<Word> getWords() {
		List<Word> words = new ArrayList(list);
		Collections.shuffle(words);
		return words;
	}
	
	@Override
	public void parse(File sdFile) {
		/*try {
			List<String> lines = java.nio.file.Files.readAllLines(file.toPath(), Charset.defaultCharset());
			for(String line : lines) {
				addWord(takeWord(line));
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				addWord(takeWord(line));
			}
			br.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}*/
		
		

				try {
					// открываем поток для чтения
					BufferedReader br = new BufferedReader(new FileReader(sdFile));
					String str = "";
					// читаем содержимое
					while ((str = br.readLine()) != null) {
						//Log.d(LOG_TAG, str);
						addWord(takeWord(str));
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
		
		
		
		
	}
	
	/**
	 * add word to collection
	 * 
	 * @param word
	 */
	public void addWord(Word word) {
		if(word == null) {			
			throw new RuntimeException("������ ������ ����� �c�� ��� ���");
		}
		list.add(word);
	}
	
	/**
	 * take a part word from file(from line)
	 * @param text
	 * @return
	 */
	private Word takeWord(String text) {		
		String[] words = text.split(SEPARATOR);

		//String[] words = text.split("[#]");
		StringBuffer original = new StringBuffer();
		List<String> translate = new ArrayList<String>();
		//original.append(text.substring(0, text.indexOf("#")));
		//translate.add(text.substring(text.indexOf("#"), text.length()));
		for(String s : words) {
			if(isOriginal(s)) {
				original.append(s.trim());
				original.append(" ");
			} else {
				translate.add(s);
			}
		}
		return new Word(original.toString(),  translate);
	}
	
	/**
	 * check if word id english(for example)
	 * 
	 * @param word
	 * @return
	 */
	//TODO it's not universal
	private boolean isOriginal(String word) {
		return word.matches("[a-zA-Z]+");
	}
	@Override
	public Integer getSize() {		
		return list.size();
	}
}


