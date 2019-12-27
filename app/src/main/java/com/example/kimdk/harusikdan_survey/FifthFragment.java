package com.example.kimdk.harusikdan_survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kimdk.harusikdan_survey.model.Person;


public class FifthFragment extends Fragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;


    public FifthFragment() {
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
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_fifth, container, false);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = layout.findViewById(R.id.text_send);
                switch (view.getId()) {
                    case R.id.button1:
                        person.setActivity(1);
                        tv.setText("1active");
                        break;
                    case R.id.button2:
                        person.setActivity(2);
                        tv.setText("2active");
                        break;
                    case R.id.button3:
                        person.setActivity(3);
                        tv.setText("3active");
                        break;
                    case R.id.button4:
                        person.setActivity(4);
                        tv.setText("4active");
                        break;
                    default:
                        tv.setText("noactive");
                }
            }
        };

        button1 = layout.findViewById(R.id.button1);
        button2 = layout.findViewById(R.id.button2);
        button3 = layout.findViewById(R.id.button3);
        button4 = layout.findViewById(R.id.button4);

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        return layout;
    }


}
