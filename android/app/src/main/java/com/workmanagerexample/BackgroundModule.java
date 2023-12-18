package com.workmanagerexample;

import android.content.Context;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.concurrent.TimeUnit;

public class BackgroundModule extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "BackgroundWorkManager";
    private final ReactApplicationContext mContext;
    private PeriodicWorkRequest workRequest;

    public BackgroundModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
        workRequest = new PeriodicWorkRequest.Builder(BackgroundWorker.class, 20, TimeUnit.MINUTES).build();
    }

    @ReactMethod
    public void startBackgroundWork() {
        WorkManager.getInstance(mContext).enqueueUniquePeriodicWork("testWork", ExistingPeriodicWorkPolicy.KEEP, workRequest);
    }

    @ReactMethod
    public void stopBackgroundWork() {
        WorkManager.getInstance(mContext).cancelUniqueWork("testWork");
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }
}
