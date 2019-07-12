package com.responsi.mvp.network;

import com.responsi.mvp.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("people")
    Call<Response> getPeople();
}
