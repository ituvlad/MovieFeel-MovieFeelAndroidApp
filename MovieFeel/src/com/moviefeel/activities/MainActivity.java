package com.moviefeel.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moviefeel.fragments.LatestHeadlinesFragment;

public class MainActivity extends FragmentActivity {
	
	private String currentFragmentTag;
	private EditText etMovieSearch;
	private Button btnMovieSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setListeners();
        
    }
    
    private void initUI(){
    	etMovieSearch = (EditText) findViewById(R.id.etMovieSearch);
        btnMovieSearch = (Button) findViewById(R.id.btnMovieSearch);
        
        
    }
    private int[] GalImages = new int[] { R.drawable.one, R.drawable.two,
			R.drawable.three };
    private void setListeners(){
    	btnMovieSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LatestHeadlinesFragment contentFrag = new LatestHeadlinesFragment();
				contentFrag.GalImages = GalImages;
		        currentFragmentTag = LatestHeadlinesFragment.TAG;
		        FragmentManager fragmentManager = getSupportFragmentManager();
		        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		        fragmentTransaction.replace(R.id.fragmentLatestHeadlines, contentFrag);
		        fragmentTransaction.commit();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
