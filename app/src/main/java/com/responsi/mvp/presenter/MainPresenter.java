package com.responsi.mvp.presenter;

import android.util.Log;

import com.responsi.mvp.Interfaces.MainVIiew;
import com.responsi.mvp.model.Response;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.network.API;
import com.responsi.mvp.network.BaseURl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainPresenter {
    BaseURl baseURl;
    MainVIiew mainVIiew;
    API api;

    public MainPresenter(MainVIiew mainVIiew) {
        this.mainVIiew = mainVIiew;
        if (baseURl==null){
            this.baseURl = new BaseURl();

        }
    }
    public void getPeople(){
      API  api=BaseURl.getApi().create(API.class);
        api.getPeople().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    List<ResultsItem> data = response.body().getResults();
                    mainVIiew.onPeopleUpdate(data);
                    Log.d("HASIL", "onPeopleUpdate: "+data.get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("GAGAL", "onFailure: ");
            }
        });
    }
}
