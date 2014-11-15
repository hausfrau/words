package my.example.testwords1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements OnClickListener {
	TextView tvResult;
	Button btnQuit;
	Button newTest;
	final String LOG_TAG = "myLogs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Log.d(LOG_TAG, "ResultActivity: onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		btnQuit = (Button) findViewById(R.id.btnQuit);
		btnQuit.setOnClickListener(this);

		newTest = (Button) findViewById(R.id.btnNewTest);
		newTest.setOnClickListener(this);

		tvResult = (TextView) findViewById(R.id.tvResult);
		Intent intent = getIntent();
		String result = intent.getStringExtra("result");
		tvResult.setText(result);
	}

	public void onClick(View v) {
		// finish();
		// Intent intent = getIntent();
		// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		/*
		 * moveTaskToBack(true); super.onBackPressed();
		 */
		if (v.getId() == R.id.btnNewTest) {
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		}
		finish();
	}

	/*
	 * 
	 * Intent intent = new Intent("sj.action.vacancyDetail");
	 * intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); startActivity(intent);
	 * finish();
	 * 
	 * 
	 * FLAG_ACTIVITY_REORDER_TO_FRONT
	 * 
	 * FLAG_ACTIVITY_NEW_TASK
	 * 
	 * savedInstanceState
	 */

	@Override
	protected void onStart() {
		super.onStart();
		//Log.d(LOG_TAG, "ResultActivity: onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		//Log.d(LOG_TAG, "ResultActivity: onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		//Log.d(LOG_TAG, "ResultActivity: onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		//Log.d(LOG_TAG, "ResultActivity: onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//Log.d(LOG_TAG, "ResultActivity: onDestroy()");
	}
}