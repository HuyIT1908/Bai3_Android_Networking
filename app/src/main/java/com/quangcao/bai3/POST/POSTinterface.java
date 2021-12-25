package com.quangcao.bai3.POST;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface POSTinterface {

    @FormUrlEncoded
    @POST("create_product.php")
    Call<SVResponseProductsPOST> postDATA(@Field("name") String name,
                                   @Field("price") String price,
                                   @Field("description") String description);
}
