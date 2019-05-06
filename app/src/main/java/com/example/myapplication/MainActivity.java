package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    NotificationHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);

        final EditText editText2  = findViewById(R.id.editText2);

        final TextView text = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);

        if(Build.VERSION.SDK_INT >  26) {
            helper = new NotificationHelper(this);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer a = Integer.valueOf(String.valueOf(editText1.getText()));
                Integer b = Integer.valueOf(String.valueOf(editText2.getText()));

                //text.setText(String.valueOf(a+b));

                if(Build.VERSION.SDK_INT >  26) {
                    Notification.Builder notificationbuilder = helper.getChannelNotification("Sum", String.valueOf(a+b));
                    helper.getManager().notify(new Random().nextInt(), notificationbuilder.build());
                }

            }
        });

    }
}
