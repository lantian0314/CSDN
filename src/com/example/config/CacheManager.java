package com.example.config;

import java.io.File;

import android.content.Context;

import com.example.utils.FileUtils;

/**
 * ª∫¥Êπ‹¿Ì
 * 
 * @author xingyatong
 * 
 */
public class CacheManager {

	private static String getExternalCachePath(Context context) {
		return FileUtils.getExternalCacheDir(context);
	}
	
	public static String getAppCachePath(Context context){
		return getExternalCachePath(context)+File.separator+"App"+File.separator+"Cache";
	}
}
