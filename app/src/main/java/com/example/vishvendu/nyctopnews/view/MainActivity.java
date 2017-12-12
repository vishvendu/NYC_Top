package com.example.vishvendu.nyctopnews.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vishvendu.nyctopnews.Callbacks.IDataDao;
import com.example.vishvendu.nyctopnews.Callbacks.IPassViewToActivity;
import com.example.vishvendu.nyctopnews.R;
import com.example.vishvendu.nyctopnews.Utils.NetworkConnectivity;
import com.example.vishvendu.nyctopnews.Utils.TopNewsApplication;
import com.example.vishvendu.nyctopnews.database.DaoSession;
import com.example.vishvendu.nyctopnews.database.TopNewsData;
import com.example.vishvendu.nyctopnews.model.Result;
import com.example.vishvendu.nyctopnews.presenter.ITopStoriesPresenter;
import com.example.vishvendu.nyctopnews.presenter.TopStoriesImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ITopNewsView,IPassViewToActivity,IDataDao {

    ITopStoriesPresenter iTopStoriesPresenter;
    RecyclerView recyclerView;
    CardViewAdapter cardViewAdapter;
    IDataDao iDataDao;
    TopNewsData topNews;
   // NewsCard  newsCard;
    long Top_News_data;
    List<TopNewsData> newsResult;
    private String TableName;
    private ArrayList<Result> DaoDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        if(!new NetworkConnectivity(this).isNetworkAvailable())
        {
            iDataDao.showDataDao();

        }




    }

    private void intiView() {
        DaoDataList = new ArrayList<Result>();
        iDataDao = (IDataDao)this;
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        cardViewAdapter = new CardViewAdapter(this,R.layout.cards,this);
        recyclerView.setAdapter(cardViewAdapter);
        iTopStoriesPresenter = new TopStoriesImpl(this);
        iTopStoriesPresenter.fetchTopStories();


    }

    @Override
    public void showProgress() {



    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void updateRecyclerView(List<Result> list) {

        System.out.println("updated recyclerview "+ list);
        cardViewAdapter.setDiscoverNewsResult(list,newsResult,true);
        cardViewAdapter.notifyDataSetChanged();
        iDataDao.insertDataDao(list);



    }



    @Override
    public void passViewtoActivity(int position, List<Result> movieItems, String postUrl) {


        Intent intent = new Intent(this , WebViewDetails.class);
        intent.putExtra("SelectedUrl",postUrl);
        startActivity(intent);

    }

    @Override
    public void passViewtoActivityoffline(int position, List<TopNewsData> movieItems, String postUrl) {

        Intent intent = new Intent(this , WebViewDetails.class);
        intent.putExtra("SelectedUrl",postUrl);
        startActivity(intent);

    }

    @Override
    public void insertDataDao(List<Result> list) {

        for(int i= 0 ; i <= list.size() ; i++){

            topNews = new TopNewsData(null,list.get(i).getTitle(),list.get(i).getByline(),list.get(i).getSection(),list.get(i).getShortUrl(),null);
            Top_News_data = getAppDaoSession().getTopNewsDataDao().insert(topNews);
        }




    }

    public DaoSession getAppDaoSession() {
        return ((TopNewsApplication) getApplication()).getDaoSession();
    }

    @Override
    public void showDataDao() {

      TableName = getAppDaoSession().getTopNewsDataDao().getTablename();

        if(TableName.equals("TOP_NEWS_DATA")){

            newsResult =((TopNewsApplication)getApplication()).getDaoSession().getTopNewsDataDao().loadAll();







                cardViewAdapter.setDiscoverNewsResult(DaoDataList,newsResult,false);
                cardViewAdapter.notifyDataSetChanged();


        }


    }
}
