package com.example.vishvendu.nyctopnews.presenter;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishvendu.nyctopnews.constant.Constants;
import com.example.vishvendu.nyctopnews.model.ITopStoryModel;
import com.example.vishvendu.nyctopnews.model.Result;
import com.example.vishvendu.nyctopnews.model.TopNews;
import com.example.vishvendu.nyctopnews.model.TopStoryModelImpl;
import com.example.vishvendu.nyctopnews.retroClient.ApiUtils;
import com.example.vishvendu.nyctopnews.retroClient.RetrofitCallbacks;
import com.example.vishvendu.nyctopnews.retroClient.RetrofitClient;
import com.example.vishvendu.nyctopnews.view.ITopNewsView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import rx.schedulers.Schedulers;

/**
 * Created by vishvendu on 11/12/17.
 */

public class TopStoriesImpl implements ITopStoriesPresenter {


    ITopNewsView iTopNewsView;
    ITopStoryModel iTopStoryModel;
    RetrofitCallbacks retrofitCallbacks;
    private Disposable disposable = null;

    public TopStoriesImpl(ITopNewsView iTopNewsView) {
        System.out.println("iTopNewsView");
        this.iTopNewsView = iTopNewsView;
        iTopStoryModel = new TopStoryModelImpl(this);
        retrofitCallbacks = ApiUtils.getCallbacks();
    }

    @Override
    public void fetchTopStories() {

        System.out.println("fetchstory");


        retrofitCallbacks.getTopStories(Constants.NYC_API_KEY)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError );









     /*   retrofitCallbacks.getTopStories(Constants.NYC_API_KEY).enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {

                System.out.println("onResponse Top story "+ response.body().getSection());
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {

                System.out.println("onResponse failure ");

            }
        });*/

    }

    private void handleResults(TopNews topNews) {

        System.out.println("topnews "+topNews);

    }




    private void handleError(Throwable t){
        Log.e("Observer", ""+ t.toString());

    }

    @Override
    public void updateRecyclerView(List<Result> list) {

    }
}
