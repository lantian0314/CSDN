package com.example.utils;

import java.io.File;

import android.content.Context;
import android.os.Environment;

public class FileUtils {

	public static String getExternalCacheDir(Context context) {
		String path = "";
		try {
			if (getSdAvailable()) {
				File file = context.getExternalCacheDir();
				if (file != null) {
					path = file.getAbsolutePath();
				} else {
					path = context.getCacheDir().getAbsolutePath();
				}
			} else {
				path = context.getCacheDir().getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * sdcard
	 * 
	 * @return
	 */
	private static boolean getSdAvailable() {
		boolean flag = false;
		try {
			String externalState = Environment.getExternalStorageState();
			flag = Environment.MEDIA_MOUNTED.equals(externalState);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
