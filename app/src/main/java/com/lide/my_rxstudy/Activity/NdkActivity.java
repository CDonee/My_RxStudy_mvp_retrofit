package com.lide.my_rxstudy.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lide.my_rxstudy.R;

/**
 * @author DaiJiCheng
 * @time 2017/8/31  9:37
 * @desc ${TODD}
 */
public class NdkActivity extends AppCompatActivity {
    //F:\code\My_RxStudy\app\src\main\java>javah com.lide.my_rxstudy.Activity.NdkActivity.java

    static {
        System.loadLibrary("ndk-test");//导入生成的链接库文件
    }

    public native String getStringFromNative();//本地方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);
    }

    public void onClick(View view) {
        Toast.makeText(this, getStringFromNative(), Toast.LENGTH_LONG).show();
    }
}
