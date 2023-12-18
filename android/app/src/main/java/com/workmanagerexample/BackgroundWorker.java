package com.workmanagerexample;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.util.concurrent.TimeUnit;
import android.content.*;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class BackgroundWorker extends Worker {
    private final Context context;

    public BackgroundWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override

    public Result doWork() {

        // background work will take place here
        Log.w("bg", "Worker do work");
        return Result.success();

    }
    
}
