package com.example.config;

import android.content.Context;

import com.example.bean.Blogger;
import com.example.config.CategoryManager.CategoryName;
import com.example.db.BloggerDao;
import com.example.utils.Shared;

public class BloggerManager {
	/**
	 * 执行插入数据库的操作
	 * 
	 * @param bloggerDb
	 * @param blogger
	 * @param array
	 */
	private void insertBlogger(BloggerDao bloggerDb, Blogger blogger,
			String[] array) {
		if (bloggerDb == null || blogger == null || array == null
				|| array.length < 6) {
			return;
		}

		blogger.setUserId(array[0]);
		blogger.setTitle(array[1]);
		blogger.setDescription(array[2]);
		blogger.setImgUrl(array[3]);
		blogger.setLink(array[4]);
		blogger.setType(array[5]);
		blogger.setIsTop(0);
		blogger.setIsNew(0);
		blogger.setCategory(CategoryName.MOBILE);
		blogger.setUpdateTime(System.currentTimeMillis());

		bloggerDb.insert(blogger);
	}

	/**
	 * 删除所有博客信息
	 * 
	 * @param bloggerDb
	 * @param type
	 */
	private void deleteAllBlogger(BloggerDao bloggerDb, String type) {
		bloggerDb.deleteAll();
	}

	/**
	 * 初始化数据
	 * 
	 * @param context
	 *            上下文
	 * @param bloggerDb
	 * @param type
	 */
	public void init(Context context, BloggerDao bloggerDb, String type) {
		if (!(Boolean) Shared.get(context, ExtraString.IS_FIRST, true)) {
			return;
		}
		deleteAllBlogger(bloggerDb, type);
		bloggerDb.init(type);

		Blogger blogger = new Blogger();
		String[] array = new String[6];

		array[0] = "lmj623565791";
		array[1] = "张鸿洋";
		array[2] = "生命不息，奋斗不止，万事起于忽微，量变引起质变";
		array[3] = "http://avatar.csdn.net/F/F/5/1_lmj623565791.jpg";
		array[4] = "http://blog.csdn.net/lmj623565791";
		array[5] = type;
		insertBlogger(bloggerDb, blogger, array);

		Shared.put(context, ExtraString.IS_FIRST, false);
		Shared.put(context, ExtraString.BLOG_TYPE, type);
	}
}
