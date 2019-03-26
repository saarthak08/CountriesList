package com.sg.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sg.R;
import com.sg.adapter.CountryAdapter;
import com.sg.model.Info;
import com.sg.model.Result;
import com.sg.services.RetrofitInstance;
import com.sg.services.getCountryDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Result> results;
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCountries();
        getView();
    }

    private void getView() {
        recyclerView=findViewById(R.id.rv);
        countryAdapter=new CountryAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(countryAdapter);
    }

    public Object getCountries() {
        getCountryDataService getCountryDataService= RetrofitInstance.getService();
        Call<Info> call=getCountryDataService.getAllCountries();
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info=response.body();
                if(info!=null&&info.getRestResponse()!=null)
                {
                    results=(ArrayList<Result>)info.getRestResponse().getResult();
                    for (Result r:results)
                    {
                        Log.i("Test code","*****************"+r.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.i("test fail","Error");

            }
        });

        return results;
    }


}
