package com.responsi.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.responsi.mvp.Interfaces.MainVIiew;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.network.API;
import com.responsi.mvp.network.BaseURl;
import com.responsi.mvp.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainVIiew {
    MainPresenter mainPresenter;
    BaseURl baseURl;
    API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = BaseURl.getApi().create(API.class);
        mainPresenter = new MainPresenter(this,api);
        mainPresenter.getPeople();
    }

    @Override
    public void onPeopleUpdate(List<ResultsItem> resultsItems) {
        for (ResultsItem resultsItem : resultsItems){
            Log.d("HASIL", "onPeopleUpdate: "+resultsItem.getName());
        }
    }
}
