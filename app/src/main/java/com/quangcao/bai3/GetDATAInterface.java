package com.quangcao.bai3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDATAInterface {
    @GET("getall.json")
    Call<SvResponseProducts> GetJson();
}
