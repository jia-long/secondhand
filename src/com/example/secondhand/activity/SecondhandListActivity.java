package com.example.secondhand.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.secondhand.R;
import com.example.secondhand.adapter.GoodsListAdapter;
import com.example.secondhand.domain.Goods;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;

public class SecondhandListActivity extends Activity {
	private ListView lv_secondhand_list;
	private List<Map<String, Object>> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondhand_list);
		items = new ArrayList<Map<String, Object>>();
		
		Bitmap pic = BitmapFactory.decodeResource(getResources(),
				R.drawable.xiaomi);
		for (int i = 0; i < 50; i++) {
			Bitmap[] pics = { pic };
			Goods g = new Goods(i, "手机_中，一般来说，" + i, "详细sources)形式来表现的。但是有时候我们需要用这个适配器来显示网上的远程图片时，该如何直接显示呢？方法是实现ViewBinder()这个接口，在里面定义数据和视图的匹配关系。代码片段如下：情况一个小项目中需要用到将SD卡中的图片读出后，缩略计算后再simpleAdapter进行显示", i + 100, pics);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", g.getName());

			map.put("discription", g.getDiscription());

			map.put("money", "￥ "+g.getMoney());

			map.put("pictures", g.getPictures()[0]);

			items.add(map);
		}

		lv_secondhand_list = (ListView) findViewById(R.id.lv_secondhand_list);

		String[] from = new String[] { "name", "discription", "money",
				"pictures" };

		int[] to = new int[] { R.id.tv_goods_name, R.id.tv_goods_discription,
				R.id.tv_goods_money, R.id.iv_goods_image };

		SimpleAdapter adapter = new SimpleAdapter(this, items,
				R.layout.activity_secondhand_item, from, to);

		adapter.setViewBinder(new ViewBinder() {
			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				// TODO Auto-generated method stub
				if (view instanceof ImageView && data instanceof Bitmap) {
					ImageView i = (ImageView) view;
					i.setImageBitmap((Bitmap) data);
					return true;
				}
				return false;
			}
		});

		lv_secondhand_list.setAdapter(adapter);

		lv_secondhand_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(SecondhandListActivity.this, position + "",
						Toast.LENGTH_SHORT).show();

			}

		});
	}

}
