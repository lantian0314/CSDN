package com.example.csdntest;

import com.example.base.BaseActivity;
import com.example.utils.VersionUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends BaseActivity {

	private TextView tv_version;
	private RelativeLayout rl_splash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// 初始化试图
		initView();

		startAnimation();
	}

	private void startAnimation() {
		Animation animation = new Animation() {
		};
		animation.setDuration(3000);
		rl_splash.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initView() {
		tv_version = (TextView) findViewById(R.id.tv_version);
		rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);

		String version = VersionUtils.getVersionName(this);
		tv_version.setText("当前版本:" + version);
	}
}
