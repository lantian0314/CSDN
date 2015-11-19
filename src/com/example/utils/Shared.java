package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared {

	/*
	 * �������ֻ�������ļ���
	 */
	public static final String FILE_NAME = "share_data";

	/**
	 * ����shared���ݵķ���
	 * 
	 * @param context
	 *            ������
	 * @param key
	 *            ��
	 * @param object
	 *            ����
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
	 * �õ�Shared���ݵķ���
	 * 
	 * @param context
	 *            ������
	 * @param key
	 *            ��ֵ
	 * @param object
	 *            ��������
	 * @return ���
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
