package com.example.vishvendu.nyctopnews.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vishvendu.nyctopnews.R;
import com.example.vishvendu.nyctopnews.presenter.ITopStoriesPresenter;
import com.example.vishvendu.nyctopnews.presenter.TopStoriesImpl;

public class MainActivity extends AppCompatActivity implements ITopNewsView {

    ITopStoriesPresenter iTopStoriesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();

    }

    private void intiView() {

        iTopStoriesPresenter = new TopStoriesImpl(this);
        iTopStoriesPresenter.fetchTopStories();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
