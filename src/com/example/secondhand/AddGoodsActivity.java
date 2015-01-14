package com.example.secondhand;

import com.example.secondhand.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddGoodsActivity extends Activity implements OnClickListener {

	// 四张要上传的商品图片
	private ImageView iv_upImage1, iv_upImage2, iv_upImage3, iv_upImage4;
	// 商品信息
	private EditText ev_goodsName, ev_goodsPrices, ev_details;

	// 发布按钮
	private Button b_secondhand_publish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondhand_addgoods);
		init();
	}

	/**
	 * 初始化界面
	 */
	public void init() {

		iv_upImage1 = (ImageView) findViewById(R.id.iv_secondhand_addgoods_images1);
		iv_upImage2 = (ImageView) findViewById(R.id.iv_secondhand_addgoods_images2);
		iv_upImage3 = (ImageView) findViewById(R.id.iv_secondhand_addgoods_images3);
		iv_upImage4 = (ImageView) findViewById(R.id.iv_secondhand_addgoods_images4);

		b_secondhand_publish = (Button) findViewById(R.id.b_secondhand_publish);
		iv_upImage1.setOnClickListener(this);
		iv_upImage2.setOnClickListener(this);
		iv_upImage3.setOnClickListener(this);
		iv_upImage4.setOnClickListener(this);
		b_secondhand_publish.setOnClickListener(this);
	}

	/**
	 * 实现OnclickListener的抽象方法
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_secondhand_addgoods_images1:
			addPicture();
			break;
		case R.id.iv_secondhand_addgoods_images2:

			break;
		case R.id.iv_secondhand_addgoods_images3:

			break;
		case R.id.iv_secondhand_addgoods_images4:

			break;
		case R.id.b_secondhand_publish:
			addPicture();
			break;
		}

	}

	public void addPicture() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 调用android自带的照相机
		startActivityForResult(intent, 1);
	}
	
	
}
