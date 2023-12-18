package com.workmanagerexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Build;
import android.os.*;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class BackgroundHeadlessTaskService extends HeadlessJsTaskService {
    @Override
    protected @Nullable HeadlessJsTaskConfig getTaskConfig(Intent intent) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
            Notification notification = new NotificationCompat.Builder(getApplicationContext(), "demo")
                    .setContentTitle("Headless Work")
                    .setTicker("runn")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(true)
                    .build();
            startForeground(1, notification);
        }

        Bundle extras = intent.getExtras();
        if (extras != null) {
            return new HeadlessJsTaskConfig(
                    "BackgroundHeadlessTask",
                    Arguments.fromBundle(extras),
                    5000,
                    true);
        }
        return null;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void createChannel() {
        String description = "test channel";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("demo", "test", importance);
        channel.setDescription(description);
        NotificationManager notificationManager = (NotificationManager) getApplicationContext()
                .getSystemService(NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(channel);

    }
}
