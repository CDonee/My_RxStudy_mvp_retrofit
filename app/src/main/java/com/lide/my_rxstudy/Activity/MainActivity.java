package com.lide.my_rxstudy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lide.my_rxstudy.Activity.bean.loginbeans.LoginReqest;
import com.lide.my_rxstudy.Activity.presenter.LogingPresenter;
import com.lide.my_rxstudy.Activity.view.IloginView.IVieWloginFinish;
import com.lide.my_rxstudy.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements IVieWloginFinish {

    @Bind(R.id.button)
    Button mButton;
    @Bind(R.id.button2)
    Button mButton2;
    @Bind(R.id.activity_main)
    RelativeLayout mActivityMain;
    @Bind(R.id.ed_user)
    EditText mEdUser;
    @Bind(R.id.et_pass)
    EditText mEtPass;
    @Bind(R.id.text)
    TextView mText;
    private LogingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new LogingPresenter(this, this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                // startActivity(new Intent(this,Lesson_one.class));
                CustomDialogGif dialogGif = new CustomDialogGif(this);
                dialogGif.show();
                break;
            case R.id.button2:
                startActivity(new Intent(this, lesson_two.class));
                break;
            case R.id.button3:
                Toast.makeText(this, "登陸中。。", Toast.LENGTH_SHORT).show();
                String userName = mEdUser.getText().toString().trim();
                String passWord = mEtPass.getText().toString().trim();
                LoginReqest reqest = new LoginReqest();
                reqest.accountType = "EMPLOYEE";
                reqest.businessModuleCode = "HDW";
                reqest.warehouseCode = "001";
                reqest.username = userName;
                reqest.password = passWord;
                String toUploads = new Gson().toJson(reqest);
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toUploads);
                mPresenter.login(body);
                break;

        }
    }




    @Override
    public void LoginFinishSuceess(String key) {
        Log.d("test","key--->"+key);
        mText.setText(key);
    }

    @Override
    public void LoginFinishFailer(String key) {
        Log.d("test","key--->"+key);
        runOnUiThread(() -> mText.setText(key));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
           mPresenter.destroy();
        }
    }
}
