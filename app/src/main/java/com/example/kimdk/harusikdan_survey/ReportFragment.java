package com.example.kimdk.harusikdan_survey;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kimdk.harusikdan_survey.model.Diary;
import com.example.kimdk.harusikdan_survey.model.DiaryList;
import com.example.kimdk.harusikdan_survey.model.Value;
import com.example.kimdk.harusikdan_survey.util.PersonAPI;
import com.example.kimdk.harusikdan_survey.util.RecyclerImageTextAdapter;
import com.example.kimdk.harusikdan_survey.util.RecyclerItem;
import com.google.gson.JsonObject;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import noman.weekcalendar.WeekCalendar;
import noman.weekcalendar.listener.OnDateClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReportFragment extends Fragment {
    RecyclerView mRecyclerView = null;
    RecyclerImageTextAdapter mAdapter = null;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();


    private WeekCalendar weekCalendar;
    private TextView totalCalorie;
    private TextView carbo;
    private TextView protein;
    private TextView fat;
    private TextView custom;

    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /// 코드 계속 ...
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_report, container, false);
        /////////////////////////////////////////////////////
        totalCalorie = layout.findViewById(R.id.totalCalorie);
   /*     totalCalorie.setText("ㅎㅎ");
        totalCalorie.setText("fff");*/
        carbo = layout.findViewById(R.id.carbo);
        protein = layout.findViewById(R.id.protein);
        fat = layout.findViewById(R.id.fat);
        custom = layout.findViewById(R.id.custom);

        ////////////////////////////////////////////////////
        mRecyclerView = layout.findViewById(R.id.recycler1);

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new RecyclerImageTextAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);


        /// ... 코드 계속.
        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//


/*        // 아이템 추가.
        addItem(getResources().getDrawable(R.drawable.body),
                "Box", "Account Box Black 36dp");
        // 두 번째 아이템 추가.
        addItem(getResources().getDrawable(R.drawable.body_severance),
                "Circle", "Account Circle Black 36dp");
        // 세 번째 아이템 추가.
        addItem(getResources().getDrawable(R.drawable.holo_circle),
                "Ind", "Assignment Ind Black 36dp");
        addItem(getResources().getDrawable(R.drawable.holo_circle),
                "Ind", "Assignment Ind Black 36dp");
        addItem(getResources().getDrawable(R.drawable.holo_circle),
                "Ind", "Assignment Ind Black 36dp");
        mList.get(3).setIcon(getResources().getDrawable(R.drawable.female_clicked));
        mAdapter.notifyDataSetChanged();
*/

        ////////////////////////////////////////////////////
        weekCalendar = layout.findViewById(R.id.weekCalendar);
        weekCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(DateTime dateTime) {
                Toast.makeText(getContext(),
                        "You Selected " + dateTime.toString(), Toast.LENGTH_SHORT).show();
                JsonObject jsonObject = dateTimeToJsonObj(dateTime);
                getDiaryList(jsonObject);
            }

        });

        return layout;
    }

    public void getDiaryList(JsonObject date) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PersonAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PersonAPI api = retrofit.create(PersonAPI.class);
        Call<DiaryList> call = api.receiveDiary(date);


        call.enqueue(new Callback<DiaryList>() {
            @Override
            public void onResponse(Call<DiaryList> call, Response<DiaryList> response) {
                if (response.isSuccessful()) {
                    mList.clear();  //리스트 내 아이템 전부 삭제.
                    mAdapter.notifyDataSetChanged();

                    List<Diary> diary = response.body().getDiary();

                    Log.e("ddd", diary.size() + "");
                    for (int i = 0; i < diary.size(); i++) {
                        String foodName = diary.get(i).getEatFood();
                        String eatDate = diary.get(i).getEatDate();
                        String eatTime = diary.get(i).getEatTime();
                        String salt = diary.get(i).getFoodSalt();
                        addItemByFoodName(foodName, eatDate, eatTime, salt);
                        Log.e("ddd", i + "번쨰 돌아갑니다~");
                    }
                    mAdapter.notifyDataSetChanged();


                    Value value = response.body().getValue();
                    totalCalorie.setText("총 섭취량 : " + value.getFoodKcal());
                    carbo.setText("탄수화물 : " + value.getFoodCarbo());
                    protein.setText("단백질 : " + value.getFoodProtein());
                    fat.setText("지방 : " + value.getFoodFat());
                    custom.setText("커스텀 : " + value.getFoodSalt());


                } else {
                    Log.e("ddd", "응답 오긴 왔는데 이상한거 옴");
                }

            }

            @Override
            public void onFailure(Call<DiaryList> call, Throwable t) {
                Toast.makeText(getContext(), "receive Diary failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public JsonObject dateTimeToJsonObj(DateTime dateTime) {
        String date = dateTime.toString().substring(0, 10);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("day", date);

        return jsonObject;
    }


    public void addItem(Drawable icon, String title, String desc) {
        RecyclerItem item = new RecyclerItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        mList.add(item);
    }

    public void addItemByFoodName(String foodName, String eatDate, String eatTime, String salt) {
  /*      addItem(getResources().getDrawable(R.drawable.body),
                foodName, "식사 일시 : " + eatDate + " " + eatTime + "\n나트륨 함량 : " + salt);*/
        int id = 0;
        switch (foodName.trim()) {
            case "순두부찌개":
                id = R.drawable.softofu;
                break;
            case "라면":
                id = R.drawable.ramen;
                break;
            case "짬뽕":
                id = R.drawable.jjambong;
                break;
            case "자장면":
                id = R.drawable.jajang;
                break;
            case "된장찌개":
                id = R.drawable.doinjang;
                break;
            case "김치찌개":
                id = R.drawable.kimchi;
                break;
            default:
                id = R.drawable.ic_image;

        }
        addItem(getResources().getDrawable(id), foodName, "식사 일시 : " + eatDate + " " + eatTime + "\n나트륨 함량 : " + salt);
    }

}
