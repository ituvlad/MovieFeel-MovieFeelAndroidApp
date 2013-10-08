package com.moviefeel.activities;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.moviefeel.helper.Api_Factory;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.GetHandler;

public class MainActivity extends BaseActivity {

	private String currentFragmentTag;
	private AutoCompleteTextView etMovieSearch;
	private Button btnMovieSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		api = Api_Factory.getApi(Constants.API, this);
		initUI();
		setListeners();

	}

	private void initUI() {
		etMovieSearch = (AutoCompleteTextView) findViewById(R.id.etMovieSearch);
		
		ArrayList<String> myDBData=new GetHandler().executeGet();
        ArrayAdapter<String> adapter =
        		new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,myDBData);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        etMovieSearch.setAdapter(adapter);
        
		btnMovieSearch = (Button) findViewById(R.id.btnMovieSearch);

	}

	private int[] GalImages = new int[] { R.drawable.one, R.drawable.two,
			R.drawable.three };

	private void setListeners(){
    	btnMovieSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				LatestHeadlinesFragment contentFrag = new LatestHeadlinesFragment();
//				contentFrag.GalImages = GalImages;
//		        currentFragmentTag = LatestHeadlinesFragment.TAG;
//		        FragmentManager fragmentManager = getSupportFragmentManager();
//		        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//		        fragmentTransaction.replace(R.id.fragmentLatestHeadlines, contentFrag);
//		        fragmentTransaction.commit();
//				if (!etMovieSearch.getText().toString().equals("")){
//					Movie movie = new Movie();
//					movie.setTitle(etMovieSearch.getText().toString());
//					String rating = api.getMovieRating(movie);
//					
//					
//					MovieDetailsFragment contentFrag = new MovieDetailsFragment();
//					contentFrag.setMovieRatingText(rating);
//			        currentFragmentTag = MovieDetailsFragment.TAG;
//			        FragmentManager fragmentManager = getSupportFragmentManager();
//			        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//			        fragmentTransaction.add(R.id.fragment_container, contentFrag);
//			        fragmentTransaction.commit();
//				}
				
				
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
