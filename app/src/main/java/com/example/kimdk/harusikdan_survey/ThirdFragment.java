package com.example.kimdk.harusikdan_survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kimdk.harusikdan_survey.model.Person;


public class ThirdFragment extends Fragment {
    private NumberPicker nPicker;

    public ThirdFragment() {
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
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_third, container, false);
        nPicker = layout.findViewById(R.id.nPicker);
        nPicker.setMinValue(1);
        nPicker.setMaxValue(100);
        nPicker.setValue(25);
        nPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                TextView tv = layout.findViewById(R.id.text_send);
                tv.setText(nPicker.getValue()+"");
                String age = tv.getText().toString().trim();
                person.setAge(Integer.parseInt(age));
            }
        });


        return layout;
    }
}
