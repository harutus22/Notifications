package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.notifications.App.CHANNEL_1_ID;
import static com.example.notifications.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private EditText mTitle;
    private EditText mMessage;
    private NotificationManagerCompat notificationManager;
    private MediaSessionCompat mediaSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        mediaSession = new MediaSessionCompat(this, "tag");

        mTitle = findViewById(R.id.edit_text_title);
        mMessage = findViewById(R.id.edit_text_message);
    }

    public void sendOnChannelOne(View view) {
        String title = mTitle.getText().toString();
        String message = mMessage.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

//        Intent broadcastIntent = new Intent(this, ExampleBroadcastReceiver.class);
//        broadcastIntent.putExtra(ExampleBroadcastReceiver.EXTRA_MESSAGE, message);
//        PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0,
//                broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.photo);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_android_1)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText(getString(R.string.dummy_text)).
//                                setBigContentTitle("Big content title")
//                        .setSummaryText("Summary text")
//                )
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture)
                .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
//                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannelTwo(View view) {
        String title = mTitle.getText().toString();
        String message = mMessage.getText().toString();

        Bitmap artWork = BitmapFactory.decodeResource(getResources(), R.drawable.photo);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_android_2)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(artWork)
                .addAction(R.drawable.ic_dislike, "Dislike", null)
                .addAction(R.drawable.ic_skip_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_skip_next, "Next", null)
                .addAction(R.drawable.ic_like, "Like", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1,2,3).setMediaSession(mediaSession.getSessionToken()))
                .setSubText("Sub Text")


//                .setStyle(new NotificationCompat.InboxStyle().addLine(
//                        "this is line 1"
//                ).addLine(
//                        "this is line 2"
//                ).addLine(
//                        "this is line 3"
//                ).addLine(
//                        "this is line 4"
//                ).addLine(
//                        "this is line 5"
//                ).addLine(
//                        "this is line 6"
//                ).addLine(
//                        "this is line 7"
//                ).addLine(
//                        "this is line 8"
//                ))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }
}
