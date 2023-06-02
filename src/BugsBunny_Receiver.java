package ik.dev.bugsbunny;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by İsmail Kaya on 9.10.2017.
 */

public class BugsBunny_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service = new Intent(context, BugsBunny_Service.class);
        context.startService(service);

    }
}