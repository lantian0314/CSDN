package com.example.fragment;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.base.BaseFragment;
import com.example.bean.Blogger;
import com.example.config.BloggerManager;
import com.example.config.CategoryManager.CategoryName;
import com.example.config.ExtraString;
import com.example.csdntest.R;
import com.example.db.BloggerDao;
import com.example.db.DaoFactory;
import com.example.utils.Shared;

public class BloggerFragment extends BaseFragment {

	private String mType = CategoryName.ANDROID;
	private BloggerDao mBloggerDao = null;
	private List<Blogger> mBloggerList;
	private View mRootView;
	private ListView mListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initData();
		if (mRootView==null) {
			mRootView=inflater.inflate(R.layout.fragment_blogger_list, container, false);
			initView(mRootView);
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	/**
	 * 初始化试图
	 * @param mRootView2
	 */
	private void initView(View view) {
		mListView=(ListView) view.findViewById(R.id.listView);
		
	}

	/**
	 * 数据的初始化
	 */
	private void initData() {
		mType = (String) Shared.get(getActivity(), ExtraString.BLOG_TYPE,
				CategoryName.ANDROID);
		mBloggerDao = DaoFactory.getInstance(getActivity())
				.getBloggerDao(mType);
		new BloggerManager().init(getActivity(), mBloggerDao, mType);
		mBloggerList = mBloggerDao.queryAll();
	}

}
