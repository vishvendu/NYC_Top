package com.example.vishvendu.nyctopnews.retroClient;

import com.example.vishvendu.nyctopnews.constant.Constants;
import com.example.vishvendu.nyctopnews.model.TopNews;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by vishvendu on 11/12/17.
 */

public interface RetrofitCallbacks {


    @GET("svc/topstories/v2/home.json")
    Observable<TopNews> getTopStories(@Query("api-key") String API_KEY);
}
