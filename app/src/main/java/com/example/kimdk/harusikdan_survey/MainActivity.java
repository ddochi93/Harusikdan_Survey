package com.example.kimdk.harusikdan_survey;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.kimdk.harusikdan_survey.model.Person;
import com.example.kimdk.harusikdan_survey.model.PersonResponse;
import com.example.kimdk.harusikdan_survey.util.PersonAPI;
import com.example.kimdk.harusikdan_survey.util.PersonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private static Person person;
    private Button mainButton;
    private PersonUtil personUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personUtil = new PersonUtil();
        person = Person.getInstance();
        mainButton = findViewById(R.id.button);

        vp = findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Log.d("ddd", "person의 weight = " + Person.getInstance().getWeight());
                Log.d("ddd", "person의 weight = " + Person.getInstance().getHeight());
                Log.d("ddd", "person의 age = " + Person.getInstance().getAge());
                Log.d("ddd", "persondml gender = " + Person.getInstance().getGender());
                Log.d("ddd", "persond의 activity = " + Person.getInstance().getActivity());
                Log.d("ddd", "persond의 illList = " + Person.getInstance().getDiseaseList());
                Log.d("ddd", "persond의 preferred list = " + Person.getInstance().getPreferredList());*/
                Log.d("ddd", "persond의 hate list = " + Person.getInstance().getNonPreferredList().toArray().toString());

                submitPerson();




                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(intent);
                finish();


            }
        });

    }

    public void submitPerson() {
        Person person = Person.getInstance();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(PersonAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonObject jsonObject = personToJsonObj();
        Log.d("ddd",jsonObject.toString());

        PersonAPI api = retrofit.create(PersonAPI.class);
        Call<PersonResponse> call = api.postPerson(jsonObject);



        call.enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                //Log.e("TEST ::", response.toString());
                Log.e("TEST ::", response.raw().toString());
                if(response.isSuccessful()) {
                    Log.e("TEST ::", response.body().getHello());
                    Toast.makeText(getApplicationContext(),"respone succeed", Toast.LENGTH_LONG).show();

                }
                else {
                    Log.e("TEST ::", "response else");
                    Toast.makeText(getApplicationContext(),"respone else", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"response Fail", Toast.LENGTH_LONG).show();
            }
        });

    }

    public JsonObject personToJsonObj() {
        Person person = Person.getInstance();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id","asd123");
        jsonObject.addProperty("weight", person.getWeight());
        jsonObject.addProperty("height", person.getHeight());
        jsonObject.addProperty("age", person.getAge());
        jsonObject.addProperty("gender", person.getGender());
        jsonObject.addProperty("activity", person.getActivity());

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < person.getDiseaseList().size(); i++) {
            jsonArray.add(person.getDiseaseList().get(i));
        }
        jsonObject.add("diseaseList", jsonArray);


        jsonArray = new JsonArray();
        for (int i = 0; i < person.getPreferredList().size(); i++) {
            jsonArray.add(person.getPreferredList().get(i));
        }
        jsonObject.add("preferredList", jsonArray);


        jsonArray = new JsonArray();
        for (int i = 0; i < person.getNonPreferredList().size(); i++) {
            jsonArray.add(person.getNonPreferredList().get(i));
        }
        jsonObject.add("nonpreferredList", jsonArray);

        return jsonObject;
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
