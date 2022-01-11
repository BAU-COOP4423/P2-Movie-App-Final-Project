package com.yilmazgokhan.movieapp.v2.service;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;

public class DemoHmsMessageService extends HmsMessageService {
    private final String TAG = "DemoHmsMessageService";

    @Override
    public void onNewToken(String token) {
        Log.i(TAG, "received refresh token:" + token);

    }

}
