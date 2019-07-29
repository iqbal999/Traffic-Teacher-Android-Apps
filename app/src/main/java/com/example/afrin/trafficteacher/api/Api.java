package com.example.afrin.trafficteacher.api;

import com.example.afrin.trafficteacher.model.showGarageResponse;
import com.example.afrin.trafficteacher.model.showRouteResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("api/showBusRoute.php")
    Call<List<showRouteResponse>> getAllRouteInfo();

    @GET("api/showGarage.php")
    Call<List<showGarageResponse>> getAllGarageInfo();

    @FormUrlEncoded
    @POST("api/searchBusRoute.php")
    Call<List<showRouteResponse>> searchRoute(
            @Field("source") String src,
            @Field("destination") String dest
    );
}
