package com.example.vishvendu.nyctopnews.retroClient;

import com.example.vishvendu.nyctopnews.constant.Constants;

/**
 * Created by vishvendu on 11/12/17.
 */

public class ApiUtils {

    public static RetrofitCallbacks getCallbacks() {
        return RetrofitClient.getClient(Constants.BASE_URL).create(RetrofitCallbacks.class);
    }

}
