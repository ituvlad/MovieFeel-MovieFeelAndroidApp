package com.moviefeel.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	Context context;
    private int[] galleryImages;
    public ImageAdapter(Context context,int[] images){
    	this.context=context;
    	this.galleryImages = images;
    }
    @Override
    public int getCount() {
      return galleryImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      ImageView imageView = new ImageView(context);
      int padding = 5;
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageResource(galleryImages[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((ImageView) object);
    }
  }
