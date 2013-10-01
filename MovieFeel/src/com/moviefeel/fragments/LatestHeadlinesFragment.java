package com.moviefeel.fragments;

import com.moviefeel.activities.R;
import com.moviefeel.adapters.ImageAdapter;
import com.moviefeel.helper.Constants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LatestHeadlinesFragment extends Fragment {
	public static final String TAG = Constants.TAG_FRAGMENT_LATESTHEADLINES;
	
	public int[] GalImages;

	private int currentPage;
	private ViewPager viewPager;
	

	public LatestHeadlinesFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.latest_headlines_layout,
				container, false);
		if (GalImages != null && GalImages.length > 0) {
			initUI(rootView);
			setListeners();
		}
		return rootView;
	}

	private void initUI(View v) {
		viewPager = (ViewPager) v.findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this.getActivity(), GalImages);
		viewPager.setAdapter(adapter);
	}

	private void setListeners() {
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				currentPage = position;
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// not needed
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				if (state == ViewPager.SCROLL_STATE_IDLE) {
					int pageCount = 3;

					if (currentPage == 0) {
						viewPager.setCurrentItem(pageCount - 1, false);
					} else if (currentPage == pageCount - 1) {
						viewPager.setCurrentItem(0, false);
					}
				}
			}
		});
	}
}
