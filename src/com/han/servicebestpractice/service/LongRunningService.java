package com.han.servicebestpractice.service;

import java.util.Date;

import com.han.servicebestpractice.receiver.AlarmReceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class LongRunningService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				Log.e("LongRunningService", "execute at " + new Date());
			}
		}).start();

		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		int anHour = 60 * 60 * 1000;
		long triggerAtMillis = SystemClock.elapsedRealtime() + anHour;
		Intent intent2 = new Intent(this, AlarmReceiver.class);
		PendingIntent operation = PendingIntent.getBroadcast(this, 0, intent2,
				0);
		manager.set(AlarmManager.ELAPSED_REALTIME, triggerAtMillis, operation);

		return super.onStartCommand(intent, flags, startId);
	}

}
