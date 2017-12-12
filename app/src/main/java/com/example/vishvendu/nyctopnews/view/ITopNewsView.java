package com.example.vishvendu.nyctopnews.view;

import com.example.vishvendu.nyctopnews.model.Result;

import java.util.List;

/**
 * Created by vishvendu on 11/12/17.
 */

public interface ITopNewsView {

    public void showProgress();
    public void hideProgress();
    void updateRecyclerView(List<Result> list);

}
