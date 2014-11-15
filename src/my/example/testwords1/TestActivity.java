package my.example.testwords1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import my.example.testwords1.org.app.collection.LessonsCollection;
import my.example.testwords1.org.app.collection.Tester;
import my.example.testwords1.org.app.collection.impl.TesterImpl;
import my.example.testwords1.org.app.model.Answer;
import my.example.testwords1.org.app.model.Word;
import my.example.testwords1.org.app.source.Files;
import my.example.testwords1.org.app.source.impl.SourceFile;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.util.SparseBooleanArray;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;

public class TestActivity extends Activity implements OnItemClickListener {

	//TestActivity This = this;
	TextView tvWordList;
	TextView tvWord;
	// ListView lvTestAnswer;
	ListView lvMain;
	final String FILENAME_SD = "words_de";
	final String LOG_TAG = "myLogs";
	final String DIR_SD = "MyFiles";
	// String path = "words_de";
	File sdPath;
	File file;
	Files source;
	ArrayList<String> global = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	LinearLayout linLayout;
	Integer countWords = 0;
	Integer countAnswers = 0;
	int reverse = 0;

	Tester words = null;
	LessonsCollection lessons = null;
	Map<Word, List<Answer>> lessonsMap;
	Object[] arr;
	int pos = 0;
	int lastChecked = 0;
	int indRightAnswer = 0;
	String rightAnswer = null;
	String originalWord;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		//Log.d(LOG_TAG, "TestActivity: onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Intent intent = getIntent();
		reverse = Integer.parseInt(intent.getStringExtra("reverse"));
		countWords = Integer.parseInt(intent.getStringExtra("wordscount"));
		countAnswers = Integer.parseInt(intent.getStringExtra("answerscount"));

		tvWord = (TextView) findViewById(R.id.tvWord);

		getWordsCollection();
		//colors[0] = Color.parseColor("#559966CC");
		//colors[1] = Color.parseColor("#55336699");
		lvMain = (ListView) findViewById(R.id.lvMain);
		// устанавливаем режим выбора пунктов списка
		lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// Создаем адаптер, используя массив из файла ресурсов

		/*adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, global);*/
		adapter = new ArrayAdapter<String>(this,
				R.layout.my_list_item, global);
		adapter.setNotifyOnChange(true);
		lvMain.setAdapter(adapter);
		// adapter.notifyDataSetChanged();

		lvMain.setOnItemClickListener(this);
		getListTranslation(0);
		/*
		 * linLayout = (LinearLayout) findViewById(R.id.linLayout);
		 * LayoutInflater ltInflater = getLayoutInflater();
		 * 
		 * for (int i = 0; i < name.length; i++) { Log.d("myLogs", "i = " + i);
		 * View item = ltInflater.inflate(R.layout.item, linLayout, false);
		 * item.setOnClickListener(this); TextView tvName = (TextView)
		 * item.findViewById(R.id.tvName); tvName.setText(name[i]); TextView
		 * tvPosition = (TextView) item.findViewById(R.id.tvPosition);
		 * tvPosition.setText("Должность: " + position[i]); TextView tvSalary =
		 * (TextView) item.findViewById(R.id.tvSalary);
		 * tvSalary.setText("Оклад: " + String.valueOf(salary[i]));
		 * item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
		 * item.setBackgroundColor(colors[i % 2]); linLayout.addView(item); }
		 */
	}

	void getWordsCollection() {
		// проверяем доступность SD
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Log.d(LOG_TAG,
					"SD-карта не доступна: "
							+ Environment.getExternalStorageState());
			return;
		}
		// получаем путь к SD
		sdPath = Environment.getExternalStorageDirectory();
		// добавляем свой каталог к пути
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		// формируем объект File, который содержит путь к файлу
		file = new File(sdPath, FILENAME_SD);
		source = new SourceFile();
		source.parse(file);
		words = new TesterImpl();
		if (countWords != null) {
			words.setCountWords(countWords);
		}
		if (countAnswers != null) {
			words.setCountAnswers(countAnswers);
		}
		words.parse(source);
		lessons = words.getCollections();
		/*
		 * Map<Integer, Integer> i = new HashMap<Integer,Integer>() {{ put(1,2);
		 * put(2,4); put(7,5);
		 * 
		 * }};
		 */

		lessonsMap = lessons.getLessonsCollection();
		arr = lessonsMap.keySet().toArray();

		//System.out.println(Arrays.toString(arr));

		/*for (int k = 0; k < arr.length; k++) {
			Log.d(LOG_TAG, ((Word) arr[k]).getOriginal());
			Log.d(LOG_TAG, k + "=" + lessonsMap.get(arr[k]).size());
		}*/
	}

	List<String> getListTranslation(int pos) {
		this.pos = pos;
	//	Log.d(LOG_TAG, "getListTranslation pos=" + pos + " countWords="
	//			+ this.countWords + " countAnswers=" + this.countAnswers);
		if (reverse == 0) {
			originalWord = "Слово: " + ((Word) arr[pos]).getOriginal() + "\r\n"
					+ (pos+1) + "/" + countWords;
			tvWord.setText(originalWord);
		} else {
			originalWord = "Слово: "
					+ ((Word) arr[pos]).getTranslationAsString() + "\r\n" + (pos+1)
					+ "/" + countWords; 
			tvWord.setText(originalWord);
		}
		List<String> l = new ArrayList<String>(this.lessonsMap.size());
		// ((Answer)this.lessonsMap.get((Word)arr[pos])).word.getTranslationAsString();
		adapter.clear();
		String translate;

		for (Answer a : this.lessonsMap.get((Word) arr[pos])) {

			if (reverse == 0) {
				
				translate = a.word.getTranslationAsString();
				//Log.d(LOG_TAG, a.number + ") " + translate);
				l.add(a.number + ") " + translate);
				adapter.add(a.number + ") " + translate);
			} else {
				translate = a.word.getOriginal();
				//Log.d(LOG_TAG, a.number + ") " + translate);
				l.add(a.number + ") " + translate);
				adapter.add(a.number + ") " + translate);
			}
			if(a.isRight==true) {
				indRightAnswer = a.number;
				rightAnswer = translate;
			}
		}
	
		
		/*
		 * int sum = 0; for(Entry<Word, List<Answer>> r :
		 * lessons.getLessonsCollection().entrySet()) { ++sum;
		 * System.out.println
		 * ("--------------------Начало запроса-"+sum+"/"+countWords
		 * +"------------------------------------");
		 * System.out.println("Слово: "+r.getKey().original);
		 * System.out.println(); System.out.println("Ответ:"); for(Answer a :
		 * r.getValue()) { System.out.println(a.number+") "+
		 * a.word.getTranslationAsString()); } System.out.println(
		 * "-------------------Конец запроса------------------------------------"
		 * ); System.out.print("Введите ответ:"); //try{ r.getKey().yourAnswers
		 * = 1;//scanner.nextInt(); //} catch(Exception e) { //
		 * System.out.println("Ответ должен быть цифрой:"); //
		 * System.out.println("Надо запустеть тест снова :("); //
		 * System.exit(1); // } //scanner.nextLine(); } words.result();
		 * System.out.println("Тест завершен");
		 */

		global = (ArrayList<String>) l;
		// adapter.notifyDataSetChanged();
		return l;// ((Word)arr[pos]).getTranslation();
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, int arg2, long arg3) {
		//Log.d(LOG_TAG, "onItemSelected");
		SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
		int key = -1;
		Word w;
		String res;
		for (int i = 0; i < sbArray.size(); i++) {
			key = sbArray.keyAt(i);
			lastChecked = key;
			w = (Word) arr[pos];
			w.yourAnswers = key + 1;
			if((key+1)==indRightAnswer) {
				res = "Верно!";
			} else {
				res = "Неверно! \r\n"+originalWord+"\r\nПравильный ответ: "+indRightAnswer+") "+rightAnswer;
			}
			//res = words.isRightAnswer(w, key + 1);
			Toast.makeText(this, res, Toast.LENGTH_SHORT)
					.show();
			// ((Word)arr[pos]);
			//Log.d(LOG_TAG, "key = " + key);
		}
		try {
			changeListPosition();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void changeListPosition() throws InterruptedException {
		if (pos == (countWords - 1)) {
			words.result();
			//Log.d(LOG_TAG, "Тест завершен");
			Intent intent = new Intent(this, ResultActivity.class);
			intent.putExtra("result", words.getResultString().toString());
			startActivity(intent);
			finish();
		} else {
			pos++;
			tvWord.setText("");
			 //TimeUnit.SECONDS.sleep(2);
			 lvMain.clearChoices();
			// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			// android.R.layout.simple_list_item_checked,
			// getListTranslation(0));
			// lvMain.removeAllViews();
			getListTranslation(pos);
			// lvMain.setItemChecked(lastChecked, false);

			// lvMain.setSelected(false);
			// lvMain.clearChoices();
			/*
			 * adapter = new ArrayAdapter<String>(this,
			 * android.R.layout.simple_list_item_checked,
			 * this.getListTranslation(this.pos));
			 */
			// adapter.notifyDataSetChanged();
			// adapter.setNotifyOnChange(true);
		}

	}

	/*
	 * @Override public void onClick(View v) { Log.d("myLogs", "v = " +
	 * String.valueOf(v.getContentDescription()));
	 * 
	 * }
	 */

	@Override
	protected void onStart() {
		super.onStart();
		//Log.d(LOG_TAG, "TestActivity: onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		//Log.d(LOG_TAG, "TestActivity: onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		//Log.d(LOG_TAG, "TestActivity: onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		//Log.d(LOG_TAG, "TestActivity: onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//Log.d(LOG_TAG, "TestActivity: onDestroy()");
	}

}