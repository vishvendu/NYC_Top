package com.example.vishvendu.nyctopnews.presenter;

import com.example.vishvendu.nyctopnews.model.Result;

import java.util.List;

/**
 * Created by vishvendu on 11/12/17.
 */

public interface ITopStoriesPresenter {

    public void fetchTopStories();
    void updateRecyclerView(List<Result> list);

}
