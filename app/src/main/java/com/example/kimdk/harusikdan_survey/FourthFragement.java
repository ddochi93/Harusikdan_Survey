package com.example.kimdk.harusikdan_survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kimdk.harusikdan_survey.model.Person;


public class FourthFragement extends Fragment {
    private ImageView male;
    private ImageView female;
    public FourthFragement() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Person person = Person.getInstance();
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_fourth, container, false);
        /*nPicker = layout.findViewById(R.id.nPicker);
        nPicker.setMinValue(1);
        nPicker.setMaxValue(100);
        nPicker.setValue(20);
        nPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                TextView tv = layout.findViewById(R.id.text_send);
                tv.setText(nPicker.getValue()+"");
                String age = tv.getText().toString().trim();
                person.setAge(Integer.parseInt(age));
            }
        });*/
        male = layout.findViewById(R.id.male);
        female = layout.findViewById(R.id.female);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = layout.findViewById(R.id.text_send);
                tv.setText("male");
                person.setGender(true);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = layout.findViewById(R.id.text_send);
                tv.setText("female");
                person.setGender(false);
            }
        });
     /*   male.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView image = (ImageView) view;
                view.setBackground();
*//*                switch (view.getId()) {

                    case R.id.image_player:

                        if (event.getAction() == MotionEvent.ACTION_DOWN) {

                            image.setColorFilter(0xaa111111, Mode.SRC_OVER);

                        } else if (event.getAction() == MotionEvent.ACTION_UP) {

                            image.setColorFilter(0x00000000, Mode.SRC_OVER);

                        }

                        break;

                }*//*
                return false;
            }
        });
*/

        return layout;
    }



}
