package com.example.vishvendu.nyctopnews.model;

import com.example.vishvendu.nyctopnews.presenter.ITopStoriesPresenter;
import com.example.vishvendu.nyctopnews.presenter.TopStoriesImpl;

import java.util.ArrayList;

/**
 * Created by vishvendu on 11/12/17.
 */

public class TopStoryModelImpl implements ITopStoryModel{

ITopStoriesPresenter iTopStoriesPresenter;

    public TopStoryModelImpl(ITopStoriesPresenter iTopStoriesPresenter) {

        this.iTopStoriesPresenter = iTopStoriesPresenter;
    }

    @Override
    public void TopStoryModel() {

        iTopStoriesPresenter.updateRecyclerView(new ArrayList<Result>());
    }
}
