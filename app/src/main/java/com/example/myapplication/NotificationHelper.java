package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Build;

public class NotificationHelper extends ContextWrapper {

    private static final String channel_id = "innomet.example.com.innometretail";
    private static final String channel_name = "channel_name";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    private void createChannels(){

        if(Build.VERSION.SDK_INT >  26) {
            NotificationChannel notificationChannel = new NotificationChannel(channel_id, channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(Color.GREEN);

            getManager().createNotificationChannel(notificationChannel);
        }

    }

    public NotificationManager getManager(){
        if(manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    public Notification.Builder getChannelNotification(String title,String body) {

        if(Build.VERSION.SDK_INT >  26) {

            return new Notification.Builder(getApplicationContext(), channel_id)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setAutoCancel(true);

        }
        else
        {
            return null;
        }

    }
}


