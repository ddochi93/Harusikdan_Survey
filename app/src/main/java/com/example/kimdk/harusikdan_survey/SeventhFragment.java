package com.example.kimdk.harusikdan_survey;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.kimdk.harusikdan_survey.model.Person;


public class SeventhFragment extends Fragment {
    private ToggleButton toggleButton1;
    private ToggleButton toggleButton2;
    private ToggleButton toggleButton3;
    private ToggleButton toggleButton4;
    private ToggleButton toggleButton5;
    private ToggleButton toggleButton6;


    public SeventhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Person person = Person.getInstance();
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_seventh, container, false);
        ToggleButton.OnCheckedChangeListener onCheckedChangeListener = new ToggleButton.OnCheckedChangeListener() {
            TextView tv = layout.findViewById(R.id.text_send);

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (compoundButton.getId()) {
                    case R.id.korean:
                        if (toggleButton1.isChecked()) {
                            person.addPreferred(toggleButton1.getText().toString());
                        } else {
                            person.removePreferred(toggleButton1.getText().toString());
                        }
                        break;
                    case R.id.chinese:
                        if (toggleButton2.isChecked()) {
                            person.addPreferred(toggleButton2.getText().toString());
                        } else {
                            person.removePreferred(toggleButton2.getText().toString());
                        }
                        break;
                    case R.id.western:
                        if (toggleButton3.isChecked()) {
                            person.addPreferred(toggleButton3.getText().toString());
                        } else {
                            person.removePreferred(toggleButton3.getText().toString());
                        }
                        break;
                    case R.id.japanese:
                        if (toggleButton4.isChecked()) {
                            person.addPreferred(toggleButton4.getText().toString());
                        } else {
                            person.removePreferred(toggleButton4.getText().toString());
                        }
                        break;
                    case R.id.bunsik:
                        if (toggleButton5.isChecked()) {
                            person.addPreferred(toggleButton5.getText().toString());
                        } else {
                            person.removePreferred(toggleButton5.getText().toString());
                        }
                        break;
                    case R.id.fastfood:
                        if (toggleButton6.isChecked()) {
                            person.addPreferred(toggleButton6.getText().toString());
                        } else {
                            person.removePreferred(toggleButton6.getText().toString());
                        }
                        break;
                }
                //Collections.sort(person.getDiseaseList());
                tv.setText(person.getPreferredList().toString());
            }
        };

        toggleButton1 = layout.findViewById(R.id.korean);
        toggleButton2 = layout.findViewById(R.id.chinese);
        toggleButton3 = layout.findViewById(R.id.western);
        toggleButton4 = layout.findViewById(R.id.japanese);
        toggleButton5 = layout.findViewById(R.id.bunsik);
        toggleButton6 = layout.findViewById(R.id.fastfood);

        toggleButton1.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton2.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton3.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton4.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton5.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton6.setOnCheckedChangeListener(onCheckedChangeListener);

        return layout;
    }

}
