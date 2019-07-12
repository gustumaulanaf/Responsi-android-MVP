package com.responsi.mvp.network;

import com.responsi.mvp.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BaseURl {
  public  static  final String  BASE_URL ="https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";
  public  static Retrofit retrofit = null;
  public static  Retrofit getApi(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
  }
}
