package com.example.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_1_ID = "NotificationChannel1";
    public static final String CHANNEL_2_ID = "NotificationChannel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_1_ID, "channel1", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("This is channel 1");

            NotificationChannel notificationChannel2 = new NotificationChannel(
                    CHANNEL_2_ID, "channel1", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel2.setDescription("This is channel 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
    }
}
