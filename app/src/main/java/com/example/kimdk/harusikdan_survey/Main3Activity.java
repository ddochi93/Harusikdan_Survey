package com.example.kimdk.harusikdan_survey;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main3Activity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private ReportFragment reportFragment = new ReportFragment();
    private CaptureFragment captureFragment = new CaptureFragment();
    private ProfileFragment profileFragment = new ProfileFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_main, reportFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        public ItemSelectedListener() {
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.report:
                    transaction.replace(R.id.content_main, reportFragment).commitAllowingStateLoss();

                    break;
                case R.id.capture:
                    transaction.replace(R.id.content_main, captureFragment).commitAllowingStateLoss();
                    break;
                case R.id.profile:
                    transaction.replace(R.id.content_main, profileFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
