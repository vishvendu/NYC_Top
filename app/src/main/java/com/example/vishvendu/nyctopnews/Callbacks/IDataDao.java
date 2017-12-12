package com.example.vishvendu.nyctopnews.Callbacks;

import com.example.vishvendu.nyctopnews.model.Result;

import java.util.List;

/**
 * Created by vishvendu on 12/12/17.
 */

public interface IDataDao {

    void insertDataDao(List<Result> list);
    void showDataDao();
}
