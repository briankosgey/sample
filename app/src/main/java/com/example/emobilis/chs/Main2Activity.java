package com.example.emobilis.chs;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ViewPager page;
    private LinearLayout lay;
    private TextView[] dots;

    private SliderAdapter sliderAdapter;
    private Button mnxtBtn;
    private Button mprevBtn;
    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        page=findViewById(R.id.view);
        lay=findViewById(R.id.linear);
        mnxtBtn= (Button) findViewById(R.id.nxtBtn);
        mprevBtn= (Button) findViewById(R.id.prevBtn);

        sliderAdapter=new SliderAdapter(this);
        page.setAdapter(sliderAdapter);
        adddots(0);
        page.addOnPageChangeListener(viewListener);
        mnxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page.setCurrentItem(mCurrentPage +1);
                if(mnxtBtn.getText().toString().toLowerCase().contains("finish")){
                    Intent intent =new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(intent);
                }

            }
        });
        mprevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page.setCurrentItem(mCurrentPage -1);
            }
        });
    }
    public void adddots(int position){
        dots=new TextView[3];
        for (int i=0; i< dots.length; i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transwhite));
            lay.addView(dots[i]);
        }
        if (dots.length >0){
            dots[position].setTextColor(getResources().getColor(R.color.transwhite));
        }

    }
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            adddots(position);
            mCurrentPage= position;
            if (position == 0){
                mnxtBtn.setEnabled(true);
                mprevBtn.setEnabled(false);
                mprevBtn.setVisibility(View.INVISIBLE);
                mnxtBtn.setText("next");
                mprevBtn.setText("");
            } else if (position==dots.length -1) {
                mnxtBtn.setEnabled(true);
                mprevBtn.setEnabled(true);
                mprevBtn.setVisibility(View.VISIBLE);
                mnxtBtn.setText("finish");
                mprevBtn.setText("back");
            }else if (position ==dots.length -1){
                mnxtBtn.setEnabled(true);
                mprevBtn.setEnabled(true);
                mprevBtn.setVisibility(View.VISIBLE);
                mnxtBtn.setText("next");
                mprevBtn.setText("back");
                } else {
                mnxtBtn.setEnabled(true);
                mprevBtn.setEnabled(true);
                mprevBtn.setVisibility(View.VISIBLE);
                mnxtBtn.setText("next");
                mprevBtn.setText("back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
