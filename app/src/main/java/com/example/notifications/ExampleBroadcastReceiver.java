package com.example.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    public static final String EXTRA_MESSAGE = "broadcastToastMessage";
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
