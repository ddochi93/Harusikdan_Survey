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

import java.util.Collections;


public class SixthFragment extends Fragment {
    private ToggleButton toggleButton1;
    private ToggleButton toggleButton2;
    private ToggleButton toggleButton3;
    private ToggleButton toggleButton4;
    private ToggleButton toggleButton5;
    private ToggleButton toggleButton6;


    public SixthFragment() {
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
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_sixth, container, false);
        ToggleButton.OnCheckedChangeListener onCheckedChangeListener = new ToggleButton.OnCheckedChangeListener() {
            TextView tv = layout.findViewById(R.id.text_send);
/*            ToggleButton toggleButton1 = layout.findViewById(R.id.toggleButton1);
            ToggleButton toggleButton2 = layout.findViewById(R.id.toggleButton2);*/

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (compoundButton.getId()) {
                    case R.id.toggleButton1:
                        if (toggleButton1.isChecked()) {
                            person.addDisease(1);
                        } else {
                            person.removeDisease(1);
                        }
                        break;
                    case R.id.toggleButton2:
                        if (toggleButton2.isChecked()) {
                            person.addDisease(2);
                        } else {
                            person.removeDisease(2);
                        }
                        break;
                    case R.id.toggleButton3:
                        if (toggleButton3.isChecked()) {
                            person.addDisease(3);
                        } else {
                            person.removeDisease(3);
                        }
                        break;
                    case R.id.toggleButton4:
                        if (toggleButton4.isChecked()) {
                            person.addDisease(4);
                        } else {
                            person.removeDisease(4);
                        }
                        break;
                    case R.id.toggleButton5:
                        if (toggleButton5.isChecked()) {
                            person.addDisease(5);
                        } else {
                            person.removeDisease(5);
                        }
                        break;
                    case R.id.toggleButton6:
                        if (toggleButton6.isChecked()) {
                            person.addDisease(6);
                        } else {
                            person.removeDisease(6);
                        }
                        break;


                }
                Collections.sort(person.getDiseaseList());
                tv.setText(person.getDiseaseList().toString());
            }
        };


        toggleButton1 = layout.findViewById(R.id.toggleButton1);
        toggleButton2 = layout.findViewById(R.id.toggleButton2);
        toggleButton3 = layout.findViewById(R.id.toggleButton3);
        toggleButton4 = layout.findViewById(R.id.toggleButton4);
        toggleButton5 = layout.findViewById(R.id.toggleButton5);
        toggleButton6 = layout.findViewById(R.id.toggleButton6);

        toggleButton1.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton2.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton3.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton4.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton5.setOnCheckedChangeListener(onCheckedChangeListener);
        toggleButton6.setOnCheckedChangeListener(onCheckedChangeListener);

        return layout;
    }

}
