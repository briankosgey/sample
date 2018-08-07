package com.example.emobilis.chs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context =context;
    }
    public int []slider ={
            R.drawable.car,
            R.drawable.hire,
            R.drawable.spare,
            R.drawable.rent,
    };
     public String []slidehead={
             "CAR SALES",
             "SECOND CAR",
             "SPARE PARTS",
             "CAR HIRE",
     };
     public String []slidecont={
             "A variety of cars offered for a discount and one of the best car offers",
             "Second car cars also available at minimum prices.They are also quality cars",
             "One of the most rare spare parts are also available from the market",
             "Car Hire also available at minimum prices",
     };

    @Override
    public int getCount() {
        return slidehead.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
    layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view=layoutInflater.inflate(R.layout.slide, container,false);
        ImageView slide=view.findViewById(R.id.imageView2);
        TextView text=view.findViewById(R.id.textView2);
        TextView texts=view.findViewById(R.id.textView3);

        slide.setImageResource(slider[position]);
        text.setText(slidehead[position]);
        texts.setText(slidecont[position]);

        container.addView(view);

    return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
