package com.example.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class VersionUtils {

	/**
	 * 得到当前系统的版本
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context) {
		String versionName = "";
		try {
			PackageManager manager=context.getPackageManager();
			PackageInfo info;
			info=manager.getPackageInfo(context.getPackageName(), 0);
			versionName=info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return versionName;
	}
}
