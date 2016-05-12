package com.han.servicebestpractice.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.han.servicebestpractice.R;
import com.han.servicebestpractice.service.LongRunningService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent service = new Intent(this,LongRunningService.class);
		startService(service );
	}
}
