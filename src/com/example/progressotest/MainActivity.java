package com.example.progressotest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {

	private ProgressBar mProgress;
	private int mProgressStatus = 0;
	
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
    
    public void increaseTwenty(View v){
    	
    	int progress = mProgress.getProgress();
    	mProgress.setProgress(progress + 20);
    	
    }
    
    public void decreaseTwenty(View v){
    	
    	int progress = mProgress.getProgress();
    	mProgress.setProgress(progress - 20);
    	
    }
    
    public void setZero(View v){
    	
    	mProgress.setProgress(0);
    	
    }
    
    public void setFull(View v){
    	
    	mProgress.setProgress(100);
    	
    }
    
    public void setInd(View v){
    	
    	mProgress.setIndeterminate(!mProgress.isIndeterminate());
    	
    }
    
    
    
}
