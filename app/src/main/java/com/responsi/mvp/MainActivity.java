package com.responsi.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.responsi.mvp.Interfaces.MainVIiew;
import com.responsi.mvp.adapter.MainAdapter;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.network.API;
import com.responsi.mvp.network.BaseURl;
import com.responsi.mvp.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainVIiew {
    MainPresenter mainPresenter;
    RecyclerView recyclerView;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getPeople();

    }


    @Override
    public void onPeopleUpdate(List<ResultsItem> resultsItems) {
        for (ResultsItem resultsItem : resultsItems){
            Log.d("HASIL", "onPeopleUpdate: "+resultsItem.getName());
            recyclerView= findViewById(R.id.rvPeople);
            recyclerView.setHasFixedSize(true);
            adapter = new MainAdapter(resultsItems);
            adapter.setContext(this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        }
    }
}
