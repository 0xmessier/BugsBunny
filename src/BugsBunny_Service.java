package ik.dev.bugsbunny;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by İsmail Kaya on 9.10.2017.
 */

public class BugsBunny_Service extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Bugs Bunny")
                        .setContentText("Come And Play With Me!");
        int NOTIFICATION_ID = 9654254;

        Intent targetIntent = new Intent(this, NewActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, builder.build());

    }
}