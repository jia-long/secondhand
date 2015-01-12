package com.example.secondhand.adapter;

import java.util.List;
import com.example.secondhand.domain.Goods;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GoodsListAdapter extends BaseAdapter {
	private List<Goods> goods;
	private Context context;
	
	public GoodsListAdapter(Context context, List<Goods> goods){
		this.goods = goods;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		if(goods.size() == 0){
			return 0;
		}
		return goods.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		return null;
	}

}
