package com.responsi.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.responsi.mvp.Interfaces.DetailVIiew;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.presenter.DetailPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements DetailVIiew {
    CircleImageView circleImageView;
    TextView nama,email,gender,phone,alamat;
    DetailPresenter detailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama =findViewById(R.id.tvUsername);
        email = findViewById(R.id.tvemail);
        gender =findViewById(R.id.tvgender);
        phone = findViewById(R.id.tvPhone);
        alamat = findViewById(R.id.tvAlamat);
        circleImageView = findViewById(R.id.cDetail);
        detailPresenter = new DetailPresenter(this);
        detailPresenter.getPeople();
    }

    @Override
    public void onPeopleUpdate(List<ResultsItem> resultsItems) {
        Intent intent = getIntent();
        int posisi = intent.getIntExtra("posisi",0);
       for (ResultsItem resultsItem:resultsItems){
           nama.setText(resultsItems.get(posisi).getName().getFirst()+" "+resultsItems.get(posisi).getName().getLast());
           Picasso.with(this).load(resultsItems.get(posisi).getPicture().getLarge()).into(circleImageView);
           email.setText(resultsItems.get(posisi).getEmail());
           gender.setText(resultsItems.get(posisi).getGender());
           alamat.setText(resultsItems.get(posisi).getLocation().getStreet());
           phone.setText(resultsItems.get(posisi).getPhone());
       }
    }
}
