package com.example.kimdk.harusikdan_survey;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.kimdk.harusikdan_survey.model.Person;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private static Person person;
    private Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = Person.getInstance();
        mainButton = findViewById(R.id.button);

        vp = findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ddd","person의 weight = " + Person.getInstance().getWeight());
                Log.d("ddd","person의 weight = " + Person.getInstance().getHeight());
                Log.d("ddd","person의 age = " + Person.getInstance().getAge());
                Log.d("ddd","persondml gender = " + Person.getInstance().isGender() );
                Log.d("ddd","persond의 activity = " + Person.getInstance().getActivity() );
                Log.d("ddd","persond의 illList = " + Person.getInstance().getDiseaseList() );
                Log.d("ddd","persond의 preferred list = " + Person.getInstance().getPreferredList() );
                Log.d("ddd","persond의 hate list = " + Person.getInstance().getHateList() );

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();


            }
        });

    }

/*        View.OnClickListener movePageListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int tag = (int) v.getTag();
                vp.setCurrentItem(tag);
            }
        };*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //dudld
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1: {
                    //Log.d("ddd","person의 weight = " + person.getWeight());
                    return new SecondFragment();
                }
                case 2:
                    return new ThirdFragment();
                case 3:
                    return new FourthFragement();
                case 4:
                    return new FifthFragment();
                case 5:
                    return new SixthFragment();
                case 6:
                    return new SeventhFragment();
                case 7:
                    return new EighthFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 8;
        }
    }

}
