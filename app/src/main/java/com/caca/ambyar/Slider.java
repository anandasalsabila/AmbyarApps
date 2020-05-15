package com.caca.ambyar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slider extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;


    public Slider(Context context) {
        this.context = context;
    }

    public int[] imageView = {
            R.drawable.woody,
            R.drawable.madagascar,
            R.drawable.ninja,
    };

    public String[] heading = {
            "WELCOME TO AMBYAR APPS",
            "DON'T LOVE ME",
            "DON'T HATE ME"
    };

    public String[] slide_descs = {
            "Hi, Welcome To My Apps. All in Here is About Me. Enjoy, Thanks",
            "Don't love me, because love is hurt",
            "Don't hate me, because I have nothing wrong with you"
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slider, container,false);

        ImageView slideimageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideheading = (TextView) view.findViewById(R.id.heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideimageView.setImageResource(imageView[position]);
        slideheading.setText(heading[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);


        return view;

    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
