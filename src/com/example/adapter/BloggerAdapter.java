package com.example.adapter;

import java.util.List;

import com.example.bean.Blogger;
import com.example.csdntest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BloggerAdapter extends BaseAdapter {

	private Context mContext;
	private List<Blogger> mList;

	public BloggerAdapter(Context context, List<Blogger> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.listitem_blogger, null);
			mHolder = new ViewHolder();
			mHolder.mImageView = (ImageView) convertView
					.findViewById(R.id.imv_blogger);
			mHolder.tv_BloggerTitle = (TextView) convertView
					.findViewById(R.id.tv_blog_title);
			mHolder.tv_Blogger_Des = (TextView) convertView
					.findViewById(R.id.tv_blog_desc);
			convertView.setTag(mHolder);

		} else {
			mHolder = (ViewHolder) convertView.getTag();
		}

		return null;
	}

	static class ViewHolder {
		ImageView mImageView;
		TextView tv_BloggerTitle, tv_Blogger_Des;
	}
}
