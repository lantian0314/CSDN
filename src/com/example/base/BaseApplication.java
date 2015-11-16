package com.example.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.config.CacheManager;

import android.app.Activity;
import android.app.Application;

public class BaseApplication extends Application {

	private static BaseApplication instanceApplication;
	private List<Activity> mActivities=new ArrayList<Activity>();
	/**
	 * 单例
	 * @return
	 */
	public static BaseApplication getInstance() {
		if (instanceApplication == null) {
			instanceApplication = new BaseApplication();
		}
		return instanceApplication;
	}
	
	@Override
	public File getCacheDir() {
		return new File(CacheManager.getAppCachePath(this));
	}
	
	/**
	 * 将Activity加入历史栈
	 * @param activity
	 */
	public void addActivity(Activity activity){
		mActivities.add(activity);
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		for (Activity activity : mActivities) {
			activity.finish();
		}
		System.exit(0);
	}
}
