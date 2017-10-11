package com.lide.my_rxstudy.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lide.my_rxstudy.R;


/**
 * Created by Administrator on 2017/4/12.
 */

public class CustomDialogGif extends AlertDialog{
    public CustomDialogGif(Context context) {
        super(context);
    }

    public CustomDialogGif(Context context, int theme) {
        //super(context, theme);
        super(context, R.style.LoadDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域可以，实际中可以抽出去封装供外包设置
		setCancelable(true);
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.customdialoglayout);
        ImageView imageView=(ImageView) findViewById(R.id.iv_dialog_load);
        Glide.with(context).load(R.mipmap.loading5).into(imageView);
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.width=WindowManager.LayoutParams.WRAP_CONTENT;
        params.height=WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void show() {
        super.show();
    }
}
