package com.caca.ambyar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderActivty extends AppCompatActivity {

    //Nama : Ananda Salsabila
    //Nim : 10117133
    //Kelas : AKB

    //Tanggal pengerjaan 6 mei 2020

    private ViewPager viewPager;
    private LinearLayout NavMenu;
    private TextView[] btmMenu;
    private Slider slider;
    private Button NextBtn;
    private Button BackBtn;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_activty);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        NavMenu = (LinearLayout) findViewById(R.id.bottomMenu);

        BackBtn = (Button) findViewById(R.id.button);
        NextBtn = (Button) findViewById(R.id.button2);

        slider = new Slider(this);

        viewPager.setAdapter(slider);

        addMenuIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);

        //OnClickListener

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem() + 1 < slider.getCount()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(mCurrentPage - 1);

            }
        });
    }

    public void addMenuIndicator(int position){

        btmMenu = new TextView[3];
        NavMenu.removeAllViews();

        for (int i = 0; i < btmMenu.length; i++){

            btmMenu[i] = new TextView(this);
            btmMenu[i].setText(Html.fromHtml("&#8226;"));
            btmMenu[i].setTextSize(35);
            btmMenu[i].setTextColor(getResources().getColor(R.color.button));

            NavMenu.addView(btmMenu[i]);
        }

        if(btmMenu.length > 0){

            btmMenu[position].setTextColor(getResources().getColor(R.color.white));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addMenuIndicator(position);
            mCurrentPage = position;

            if (position == 0){

                NextBtn.setEnabled(true);
                BackBtn.setEnabled(false);
                BackBtn.setVisibility(View.INVISIBLE);

                NextBtn.setText("Next");
                BackBtn.setText("");
            } else if (position == btmMenu.length - 1 ) {

                NextBtn.setEnabled(true);
                BackBtn.setEnabled(true);
                BackBtn.setVisibility(View.VISIBLE);

                NextBtn.setText("Finish");
                BackBtn.setText("Back");
            } else {
                NextBtn.setEnabled(true);
                BackBtn.setEnabled(true);
                BackBtn.setVisibility(View.VISIBLE);

                NextBtn.setText("Next");
                BackBtn.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
