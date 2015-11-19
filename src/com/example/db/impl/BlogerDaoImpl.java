package com.example.db.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.example.bean.Blogger;
import com.example.db.BloggerDao;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

public class BlogerDaoImpl implements BloggerDao {

	private DbUtils db;
	private Context mContext;

	public BlogerDaoImpl(Context context, String type) {
		this.mContext = context;
		init(type);
	}

	@Override
	public void insert(Blogger blogger) {
		try {
			Blogger findIteam = db.findFirst(Selector.from(Blogger.class)
					.where("userId", "=", blogger.getUserId()));
			if (findIteam != null) {
				db.update(blogger,
						WhereBuilder.b("userId", "=", blogger.getUserId()));
			} else {
				db.save(blogger);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(List<Blogger> list) {
		try {
			db.saveOrUpdateAll(list);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Blogger query(String userId) {
		try {
			return db.findFirst(Selector.from(Blogger.class).where("userId",
					"=", userId));
		} catch (DbException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Blogger> queryAll() {
		try {
			List<Blogger> list = new ArrayList<Blogger>();
			List<Blogger> toplist = db.findAll(Selector.from(Blogger.class)
					.where("isTop", "=", 1).orderBy("updateTime", true));
			List<Blogger> newlist = db.findAll(Selector.from(Blogger.class)
					.where("isTop", "=", 0).and("isNew", "=", 1)
					.orderBy("updateTime", true));
			List<Blogger> oldlist = db.findAll(Selector.from(Blogger.class)
					.where("isTop", "=", 0).and("isNew", "=", 0));

			if (toplist != null) {
				list.addAll(toplist);
			}
			if (newlist != null) {
				list.addAll(newlist);
			}
			if (oldlist != null) {
				list.addAll(oldlist);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Blogger blogger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(List<Blogger> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(String type) {
		this.db = DbUtils.create(mContext, "blogger_" + type);
	}

}
