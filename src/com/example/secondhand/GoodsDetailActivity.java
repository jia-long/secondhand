package com.example.secondhand;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GoodsDetailActivity extends Activity implements OnClickListener{
	
	//图片返回按钮
	private ImageView iv_seconhand_goodsdetail_back_btn;
	
	private int[] imgResIDs = new int[] { R.drawable.a, R.drawable.b,
			R.drawable.c, R.drawable.d, R.drawable.e };
	private int[] radioButtonID = new int[] { R.id.radio0, R.id.radio1,
			R.id.radio2, R.id.radio3, R.id.radio4 };
	private ViewPager pager;
	private RadioGroup mGroup;
	private ArrayList<View> items = new ArrayList<View>();
	private Runnable runnable;
	private int mCurrentItem = 0;
	private int mItem;
	private Runnable mPagerAction;
	private boolean isFrist = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_secondhand_goodsdetail);
		pager = (ViewPager) findViewById(R.id.tuijian_pager);
		mGroup = (RadioGroup) findViewById(R.id.rg_secondhand_goodsdetail);
		initAllItems();
		pager.setAdapter(new PagerAdapter() {
			// 创建
			@Override
			public Object instantiateItem(View container, int position) {
				View layout = items.get(position % items.size());
				pager.addView(layout);
				return layout;
			}

			// 销毁
			@Override
			public void destroyItem(View container, int position, Object object) {
				View layout = items.get(position % items.size());
				pager.removeView(layout);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;

			}

			@Override
			public int getCount() {
				return imgResIDs.length;
			}

		});
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(final int arg0) {
				mCurrentItem = arg0 % items.size();
				pager.setCurrentItem(mCurrentItem);
				mGroup.check(radioButtonID[mCurrentItem]);
				items.get(arg0).findViewById(R.id.tuijian_header_img)
						.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								Toast.makeText(GoodsDetailActivity.this,
										arg0 + "", 1000).show();
							}
						});
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		mPagerAction = new Runnable() {
			@Override
			public void run() {

				if (mItem != 0) {
					if (isFrist == true) {
						mCurrentItem = 0;
						isFrist = false;
					} else {
						if (mCurrentItem == items.size() - 1) {
							mCurrentItem = 0;
						} else {
							mCurrentItem++;
						}
					}

					pager.setCurrentItem(mCurrentItem);
					mGroup.check(radioButtonID[mCurrentItem]);

				}
				// pager.postDelayed(mPagerAction, 2500);
			}
		};
		// pager.postDelayed(mPagerAction, 100);
	}

	private void initAllItems() {
		iv_seconhand_goodsdetail_back_btn = (ImageView) findViewById(R.id.iv_seconhand_goodsdetail_back_btn);
		iv_seconhand_goodsdetail_back_btn.setOnClickListener(this);
		
		// 初始化Viewpager的所有item
		for (int i = 0; i < imgResIDs.length; i++) {
			items.add(initPagerItem(imgResIDs[i]));
		}
		mItem = items.size();
	}

	private View initPagerItem(int resID) {
		View layout1 = getLayoutInflater().inflate(
				R.layout.secondhand_slidin_image_item, null);
		ImageView imageView1 = (ImageView) layout1
				.findViewById(R.id.tuijian_header_img);
		imageView1.setImageResource(resID);
		return layout1;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		//返回按钮
		case R.id.iv_seconhand_goodsdetail_back_btn: 
			finish();
			break;
		}
		
	}
}