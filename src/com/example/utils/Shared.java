package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared {

	/*
	 * 保存在手机里面的文件名
	 */
	public static final String FILE_NAME = "share_data";

	/**
	 * 保存shared数据的方法
	 * 
	 * @param context
	 *            上下文
	 * @param key
	 *            键
	 * @param object
	 *            数据
	 */
	public static void put(Context context, String key, Object object) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		if (object instanceof String) {
			editor.putString(key, (String) object);

		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);

		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);

		} else if (object instanceof Long) {
			editor.putLong(key, (Long) object);

		} else if (object instanceof Float) {
			editor.putFloat(key, (Float) object);

		} else {
			editor.putString(key, (String) object);
		}

		editor.commit();
	}

	/**
	 * 得到Shared数据的方法
	 * 
	 * @param context
	 *            上下文
	 * @param key
	 *            键值
	 * @param object
	 *            数据类型
	 * @return 结果
	 */
	public static Object get(Context context, String key, Object defValue) {
		Object object = null;
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		if (defValue instanceof String) {
			object=sp.getString(key, (String)defValue);
		}else if (defValue instanceof Integer) {
			object=sp.getInt(key, (Integer)defValue);
		}else if (defValue instanceof  Boolean) {
			object=sp.getBoolean(key, (Boolean)defValue);
		}else if (defValue instanceof Long) {
			object=sp.getLong(key, (Long)defValue);
		}else if (defValue instanceof Float) {
			object=sp.getFloat(key, (Float)defValue);
		}
		return object;
	}
}
