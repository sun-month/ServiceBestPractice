package com.han.servicebestpractice.receiver;

import com.han.servicebestpractice.service.LongRunningService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent service = new Intent(context, LongRunningService.class);
		context.startService(service);
	}

}
