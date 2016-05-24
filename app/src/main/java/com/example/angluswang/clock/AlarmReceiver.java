package com.example.angluswang.clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Jeson on 2016/5/24.
 * 闹钟的广播接受者
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("闹钟执行了~");

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(PendingIntent.getBroadcast(
                context, getResultCode(), new Intent(context, AlarmReceiver.class), 0));

        Intent i = new Intent(context, PlayAlarmAty.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}