package com.example.kimdk.harusikdan_survey;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kimdk.harusikdan_survey.model.Person;


public class ProfileFragment extends Fragment {
    private TextView id;
    private TextView height;
    private TextView weight;
    private TextView gender;
    private TextView age;
    private TextView activity;
    private TextView targetCalorie;
    private TextView diseaseList;
    private TextView preferredList;
    private TextView nonPreferredList;




    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Person person = Person.getInstance();
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_profile,container,false);
        id = layout.findViewById(R.id.id);
        height = layout.findViewById(R.id.height);
        weight = layout.findViewById(R.id.weight);
        gender = layout.findViewById(R.id.gender);
        age = layout.findViewById(R.id.age);
        activity = layout.findViewById(R.id.activity);
        targetCalorie = layout.findViewById(R.id.targetCalorie);
        diseaseList = layout.findViewById(R.id.diseaseList);
        preferredList = layout.findViewById(R.id.preferredList);
        nonPreferredList = layout.findViewById(R.id.nonPreferredList);

        id.setText("아이디 : " + "rangskim@naver.com");
        height.setText("키 : " + person.getHeight() );
        weight.setText("몸무게 : " + person.getWeight());

        if(person.getGender() == 0) {
            gender.setText("성별 : 남");
        } else {
            gender.setText("성별 : 여");
        }
        age.setText("나이 : " + person.getAge());
        switch(person.getActivity()) {
            case 1:
                activity.setText("활동성 : 매우 활동적");
                break;
            case 2:
                activity.setText("활동성 : 활동적");
                break;
            case 3:
                activity.setText("활동성 : 저 활동적");
                break;
            case 4:
                activity.setText("활동성 : 비 활동적");
                break;

        }
        targetCalorie.setText("목표 칼로리 : " + person.getTargetCalorie());
        diseaseList.setText("보유 질병 목록 : "  + person.getDiseaseList().toString());
        preferredList.setText("선호 음식 목록 : " + person.getPreferredList().toString());
        nonPreferredList.setText("비선호 음식 목록 : " + person.getNonPreferredList().toString());
        return layout;

    }

}
