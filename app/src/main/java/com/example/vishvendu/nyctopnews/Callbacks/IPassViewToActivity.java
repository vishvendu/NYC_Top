package com.example.vishvendu.nyctopnews.Callbacks;

import android.widget.ImageView;

import com.example.vishvendu.nyctopnews.database.TopNewsData;
import com.example.vishvendu.nyctopnews.model.Result;

import java.util.List;

/**
 * Created by vishvendu on 12/12/17.
 */

public interface IPassViewToActivity {

    void passViewtoActivity(int position , List<Result> movieItems, String postUrl);

    void passViewtoActivityoffline(int position , List<TopNewsData> movieItems, String postUrl);
}
