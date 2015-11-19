package com.example.db;

import com.example.db.impl.BlogerDaoImpl;

import android.content.Context;

public class DaoFactory {

	private static DaoFactory mInstance = null;
	
	private Context mContext;
	public DaoFactory(Context context) {
		this.mContext=context;
	}

	public static DaoFactory getInstance(Context context) {
		if (mInstance == null) {
			synchronized (DaoFactory.class) {
				mInstance = new DaoFactory(context);
			}
		}
		return mInstance;
	}
	/**
	 * ��ò��������ݿ�
	 * @param type ����
	 * @return
	 */
	public BloggerDao getBloggerDao(String type){
		return new BlogerDaoImpl(mContext,type);
	}
	
}
