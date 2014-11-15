package my.example.testwords1;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Map.Entry;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
//import android.os.Environment;

import android.util.Log;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/*import my.example.testwords1.org.app.collection.LessonsCollection;
import my.example.testwords1.org.app.collection.Tester;
import my.example.testwords1.org.app.collection.impl.TesterImpl;
import my.example.testwords1.org.app.model.Answer;
import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Files;
import my.example.testwords1.org.app.source.impl.SourceFile;;*/

public class MainActivity extends Activity implements OnClickListener {

	EditText editTextWordsCount;
	EditText editTextAnswersCount;
	RadioGroup rgLang1Lang2Rev;
	Button btnOK;
	Button btnQuit;
	int reverse = 0;
	//final String FILENAME_SD = "words_de";
	final String LOG_TAG = "myLogs";
	//final String DIR_SD = "MyFiles";
	//String path = "words_de";
	//Integer countWords = 10;		
	//Integer countAnswers = 5;
	
	//Tester words = null;
	//LessonsCollection lessons = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    //Log.d(LOG_TAG, "MainActivity: onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editTextWordsCount = (EditText) findViewById(R.id.editTextWordsCount);
		editTextAnswersCount = (EditText) findViewById(R.id.editTextAnswersCount);
		rgLang1Lang2Rev = (RadioGroup) findViewById(R.id.rgLang1Lang2Rev);
		btnOK = (Button) findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
		btnQuit = (Button) findViewById(R.id.btnQuit);
		btnQuit.setOnClickListener(this);
		editTextWordsCount.setText("10");
		editTextAnswersCount.setText("5");
		//writeFileSD();
		//readFileSD();
		
		//File file = new File("");
		/*
		// проверяем доступность SD
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Log.d(LOG_TAG,
					"SD-карта не доступна: "
							+ Environment.getExternalStorageState());
			return;
		}
		// получаем путь к SD
		File sdPath = Environment.getExternalStorageDirectory();
		// добавляем свой каталог к пути
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		// формируем объект File, который содержит путь к файлу
		File file = new File(sdPath, FILENAME_SD);
		Files source = new SourceFile();
		source.parse(file);		
		words = new TesterImpl();		
		if(countWords != null) {
			words.setCountWords(countWords);
		}		
		if(countAnswers != null) {
			words.setCountAnswers(countAnswers);
		}
		words.parse(source);
		lessons = words.getCollections();
		
		System.out.println("Количество слов в списке: "+source.getWords().size());
		System.out.println("Количество слов в тесте: "+(countWords != null ? countWords : 15));
		System.out.println("Количество вопросов: "+(countAnswers != null ? countAnswers : 3));
		
		System.out.println("Ответ выбираем цифрой");
		System.out.println("Для начала теста нажмите Enter");		 
		
		//Scanner scanner = new Scanner(System.in);
		//scanner.nextLine();
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
			//try{
				r.getKey().yourAnswers = 1;//scanner.nextInt();
			//} catch(Exception e) {
			//	System.out.println("Ответ должен быть цифрой:");
			//	System.out.println("Надо запустеть тест снова :(");
			//	System.exit(1);
		//	}
			//scanner.nextLine();
		}
		words.result();
		System.out.println("Тест завершен");*/
	}
		
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnOK:
			switch (rgLang1Lang2Rev.getCheckedRadioButtonId()) {
			case R.id.rbLang1Lang2:
				reverse = 0;
				break;
			case R.id.rbLang2Lang1:
				reverse = 1;
				break;
			}
			Intent intent = new Intent(this, TestActivity.class);
			intent.putExtra("wordscount", editTextWordsCount.getText().toString().trim());
			intent.putExtra("answerscount", editTextAnswersCount.getText().toString().trim());
			intent.putExtra("reverse", String.valueOf(reverse));
			startActivity(intent);
			finish();
		case R.id.btnQuit:
			finish();
		}

	}
	
	/*void writeFileSD() {
		// проверяем доступность SD
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Log.d(LOG_TAG,
					"SD-карта не доступна: "
							+ Environment.getExternalStorageState());
			return;
		}
		// получаем путь к SD
		File sdPath = Environment.getExternalStorageDirectory();
		// добавляем свой каталог к пути
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		// создаем каталог
		sdPath.mkdirs();
		// формируем объект File, который содержит путь к файлу
		File sdFile = new File(sdPath, FILENAME_SD);
		try {
			// открываем поток для записи
			BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
			// пишем данные
			bw.write("quiescent находящийся в покое, неподвижный, спокойный \r\n"+
"pending в ожидании \r\n"+
"slightly мало, незначительно, \r\n"+
"By itself мало, незначительно, несущественно, немного, слегка; еле-еле; едва; слабо \r\n"+ 
"to take effect вступили в силу \r\n"+
"become становиться, делаться; превращаться; стать \r\n"+ 
"predict предсказывать, пророчить; прогнозировать \r\n"+ 
"omit пропускать, не включать \r\n"+ 
"somewhat отчасти, до некоторой степени, слегка; весьма; немного; несколько \r\n"+ 
"Specifically особенно, специально, в особенности \r\n"+ 
"Surprisingly удивительно, поразительно; неожиданно \r\n"+ 
"otherwise иначе, иным способом; иным образом; по-другому \r\n"+ 
"invocation заклинание, мольба, просьба \r\n"+ 
"notion идея, представление, понятие, знание; принцип \r\n"+ 
"whenever всякий раз, когда \r\n"+ 
"satisfies удовлетворять, давать удовлетворение \r\n"+  
"sufficiently достаточно, в достаточной мере \r\n"+ 
"precisely точно, строго, определенно \r\n"+ 
"Sequential являющийся продолжением; следующий \r\n"+
"justify оправдывать; находить оправдание; извинять; объяснять \r\n"+ 
"extensively  в значительной степени, сильно \r\n"+ 
"comprehensive всесторонний, полный, всеобъемлющий; исчерпывающий; обширный \r\n"+ 
"you've ever worked with вам доводилось работать \r\n"+ 
"hire нанимать \r\n"+
"actually  фактически, на самом деле, в действительности; по-настоящему; действительно \r\n"+ 
"aftermath последствия (событий) \r\n"+ 
"overrated переоцененный \r\n"+
"rate оценка \r\n"+
"unaware не знающий, не ведающий; не подозревающий \r\n"+
"clearly  ясно; очевидно; несомненно; конечно; понятно; безусловно \r\n"+ 
"lore знания в какой-л. области \r\n"+
"ability  способность, возможность (делать что-л.) \r\n"+ 
"heyday  зенит, расцвет, лучшая пора \r\n"+  
"manhole лаз, люк \r\n"+ 
"Who cares? — Не все ли равно? \r\n"+
"twisting in your chair to look all around \r\n"+
"apparent видимый, видный; (легко) различимый \r\n"+ 
"viable жизнеспособный \r\n"+
"on the one hand с одной стороны \r\n"+ 
"aware  знающий, осведомленный, сведущий, сознающий \r\n"+ 
"equally равно, в равной степени; равным образом, одинаково \r\n"+  
"whatever  все что; что бы ни \r\n"+ 
"their их; принадлежащий им; свой \r\n"+ 
"strength сила, мощь \r\n"+ 
"surrender сдаваться; капитулировать \r\n"+ 
"predefined предопределенный \r\n"+ 
"consistent последовательный, стойкий \r\n"+
"worth ценность \r\n"+
"incomparable не сравнимы \r\n"+
"vice зло, порок \r\n"+ 
"vice versa наоборот \r\n"+
"preserve сохранять, сберегать \r\n"+
"vast majority подавляющее большинство \r\n"+
"fences забор, изгородь, ограждение; ограда \r\n"+  
"violate нарушать, попирать, преступать  \r\n"+
"notion идея, представление, понятие, знание; принцип \r\n"+ 
"Nevertheless тем не менее \r\n"+
"bounces  подпрыгивать; отскакивать (фин не принятым () \r\n"+
"assume принимать, брать на себя \r\n"+
"Moreover боле того \r\n"+
"offence преступление \r\n"+
"beverage напиток \r\n"+
"condiments приправа специи \r\n"+
"contradictory противоричивый \r\n"+
"tie down привязывать \r\n"+
"outmost самый дальний от середины, от центра; крайний; наиболее удаленный от середины \r\n"+
"insight способность проникновения в суть \r\n"+
"redundancy чрезмерность, избыточность, резервирование \r\n"+
"encourage ободрять; поощрять, поддерживать \r\n"+ 
"decent подходящий, пристойный \r\n"+ 
"conduct сопровождать \r\n"+
"hire нанимать \r\n"+
"obscure  непонятный; невразумительный, неясный; неразборчивый "
);
			// закрываем поток
			bw.close();
			Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/*void readFileSD() {
		// проверяем доступность SD
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Log.d(LOG_TAG,
					"SD-карта не доступна: "
							+ Environment.getExternalStorageState());
			return;
		}
		// получаем путь к SD
		File sdPath = Environment.getExternalStorageDirectory();
		// добавляем свой каталог к пути
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		// формируем объект File, который содержит путь к файлу
		File sdFile = new File(sdPath, FILENAME_SD);
		try {
			// открываем поток для чтения
			BufferedReader br = new BufferedReader(new FileReader(sdFile));
			String str = "";
			// читаем содержимое
			while ((str = br.readLine()) != null) {
				Log.d(LOG_TAG, str);
				//addWord(takeWord(str));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	/*
	moveTaskToBack(true);
	super.onBackPressed();
	FLAG_ACTIVITY_CLEAR_TOP
	 не возвращаться к предыдущим Активити при нажатии кнопки Back - SingleTop or singleInstance , изьятие приложения из истории (recents app)
*/


    
  @Override
  protected void onStart() {
    super.onStart();
    //Log.d(LOG_TAG, "MainActivity: onStart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    //Log.d(LOG_TAG, "MainActivity: onResume()");
  }

  @Override
  protected void onPause() {
    super.onPause();
    //Log.d(LOG_TAG, "MainActivity: onPause()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    //Log.d(LOG_TAG, "MainActivity: onStop()");
  }
    
  @Override
  protected void onDestroy() {
    super.onDestroy();
    //Log.d(LOG_TAG, "MainActivity: onDestroy()");
  }
	
	}
