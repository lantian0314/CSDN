package com.example.adapter;

import java.util.List;

import com.example.bean.DrawerInfo;
import com.example.csdntest.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	private Context mContext;
	private List<DrawerInfo> mList;
	private int selection = -1;

	public DrawerAdapter(Context context, List<DrawerInfo> list) {
		super();
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

	@SuppressLint("ResourceAsColor")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.listitem_drawer, null);
			holder = new ViewHolder();
			holder.llDrawer = (LinearLayout) convertView
					.findViewById(R.id.llDrawer);
			holder.imvDrawer = (ImageView) convertView
					.findViewById(R.id.imvDrawer);
			holder.tvDrawer = (TextView) convertView
					.findViewById(R.id.tvDrawer);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvDrawer.setText(((DrawerInfo) getItem(position)).getName());
		holder.imvDrawer.setImageResource(((DrawerInfo) getItem(position))
				.getResId());

		if (position ==selection) {
			holder.llDrawer.setBackgroundColor(R.color.gray_bg);
			holder.tvDrawer.setTextColor(mContext.getResources().getColor(
					R.color.main_color));
		} else {
			holder.llDrawer
					.setBackgroundResource(R.drawable.selector_drawer_bg_white);
			holder.tvDrawer.setTextColor(mContext.getResources().getColor(
					R.color.black_text));
		}
		return convertView;
	}

	public void setSelectionPosition(int position) {
		this.selection = position;
		notifyDataSetChanged();
	}

	public int getSelectionPosition() {
		return this.selection;
	}

	static class ViewHolder {
		LinearLayout llDrawer;
		ImageView imvDrawer;
		TextView tvDrawer;
	}

}
