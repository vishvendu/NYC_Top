package com.example.vishvendu.nyctopnews.Utils;

import android.app.Application;

import com.example.vishvendu.nyctopnews.database.DaoMaster;
import com.example.vishvendu.nyctopnews.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by vishvendu on 12/12/17.
 */

public class TopNewsApplication extends Application{


    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "local_topnews");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
