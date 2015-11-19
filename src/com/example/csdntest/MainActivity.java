package com.example.csdntest;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.DrawerAdapter;
import com.example.base.BaseFragmentActivity;
import com.example.bean.DrawerInfo;
import com.example.view.drawerlayout.ActionBarDrawerToggle;
import com.example.view.drawerlayout.DrawerArrowDrawable;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends BaseFragmentActivity {

	private DrawerLayout drawerLayout;
	private RelativeLayout toprl;
	private LinearLayout animll_id;
	private ImageView login_tv;
	private TextView user_name;
	private ImageView iv_main_left_head;
	private RelativeLayout rl;
	private ListView navdrawer;

	private DrawerArrowDrawable mArrowDrawable;
	private DrawerAdapter mAdapter;
	private ActionBarDrawerToggle mDrawerToggle;

	private boolean isOpen = false;

	private String[] mMenuTitles = { "首页", "频道", "热门", "收藏", "关于", "设置" };
	private int[] mResId = { R.drawable.me_06, R.drawable.me_03,
			R.drawable.find_04, R.drawable.me_02, R.drawable.me_04,
			R.drawable.me_05 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initDrawerLayout();

		initDrawerList();
	}

	/**
	 * 初始化ListView
	 */
	private void initDrawerList() {
		List<DrawerInfo> list = new ArrayList<DrawerInfo>();
		for (int i = 0; i < mMenuTitles.length; i++) {
			DrawerInfo info = new DrawerInfo();
			info.setName(mMenuTitles[i]);
			info.setResId(mResId[i]);
			list.add(info);
		}
		mAdapter = new DrawerAdapter(this, list);
		navdrawer.setAdapter(mAdapter);
		mAdapter.setSelectionPosition(0);
		setItemListener();
	}

	/**
	 * 设置ListView条目点击的监听事件
	 */
	private void setItemListener() {
		navdrawer.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
	}

	/**
	 * 初始化DrawerLayout
	 */
	@SuppressLint("NewApi")
	private void initDrawerLayout() {
		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setHomeButtonEnabled(true);
		mArrowDrawable = new DrawerArrowDrawable(this) {
			@Override
			public boolean isLayoutRtl() {
				return false;
			}
		};
		mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				mArrowDrawable, R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
				isOpen = true;
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
				isOpen = false;
			}
		};
		drawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();

	}

	/**
	 * 初始化View对象
	 */
	private void initView() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		toprl = (RelativeLayout) findViewById(R.id.toprl);
		animll_id = (LinearLayout) findViewById(R.id.animll_id);
		login_tv = (ImageView) findViewById(R.id.login_tv);
		user_name = (TextView) findViewById(R.id.user_name);
		iv_main_left_head = (ImageView) findViewById(R.id.iv_main_left_head);
		rl = (RelativeLayout) findViewById(R.id.rl);
		navdrawer = (ListView) findViewById(R.id.navdrawer);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (drawerLayout.isDrawerOpen(rl)) {
				drawerLayout.closeDrawer(rl);
				isOpen = false;
			} else {
				drawerLayout.isDrawerOpen(rl);
				isOpen = true;
			}
		}
		return super.onOptionsItemSelected(item);

	}

}
