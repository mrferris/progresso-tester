package com.example.progressotest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static final int SECONDS = 5000;

	private ProgressBar mProgress;
	private int mProgressStatus = 0;
	private AsyncTask<Void, Integer, Void> mProgressTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button setZero = (Button) findViewById(R.id.setZeroButton);
		setZero.setText("0");
		Button setFull = (Button) findViewById(R.id.setFullButton);
		setFull.setText("100");
		Button increaseTwenty = (Button) findViewById(R.id.increaseTwentyButton);
		increaseTwenty.setText("+20");
		Button decreaseTwenty = (Button) findViewById(R.id.decreaseTwentyButton);
		decreaseTwenty.setText("-20");
		Button setInd = (Button) findViewById(R.id.setIndButton);
		setInd.setText("Ind");

		mProgress = (ProgressBar) findViewById(R.id.progressBar);
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

	public void increaseTwenty(View v) {

		int progress = mProgress.getProgress();
		mProgress.setProgress(progress + 20);

	}

	public void decreaseTwenty(View v) {

		int progress = mProgress.getProgress();
		mProgress.setProgress(progress - 20);

	}

	public void setZero(View v) {

		mProgress.setProgress(0);

	}

	public void setFull(View v) {

		mProgress.setProgress(100);

	}

	public void setInd(View v) {

		mProgress.setIndeterminate(!mProgress.isIndeterminate());

	}

	public void determinateSecondsFire(View v) {
		if (mProgressTask != null) {
			Toast.makeText(this, "ProgressTask already running.",
					Toast.LENGTH_SHORT).show();
			return;
		} else {
			mProgress.setIndeterminate(false);
			mProgressTask = new ProgressTask();
			mProgressTask.execute(new Void[] {});
		}
	}

	public void indeterminateSecondsFire(View v) {
		if (mProgressTask != null) {
			Toast.makeText(this, "ProgressTask already running.",
					Toast.LENGTH_SHORT).show();
			return;
		} else {
			mProgress.setIndeterminate(true);
			mProgressTask = new ProgressTask();
			mProgressTask.execute(new Void[] {});
		}
	}

	private class ProgressTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			long startTime = System.currentTimeMillis();
			long now = System.currentTimeMillis();
			while (now - startTime < SECONDS) {
				double soFar = ((double) (now - startTime) / SECONDS) * 100;
				publishProgress((int) soFar);
				now = System.currentTimeMillis();
			}
			return null;
		}

		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			int v = values[0];
			mProgress.setProgress(v);
		}

		protected void onPostExecute(Void value) {
			// Reset progress bar
			super.onPostExecute(value);
			mProgress.setProgress(0);
			mProgress.setIndeterminate(false);
			mProgressTask = null;
		}
	}

}
