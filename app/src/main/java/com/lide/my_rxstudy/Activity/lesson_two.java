package com.lide.my_rxstudy.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lide.my_rxstudy.R;

import java.util.ArrayList;

/**
 * @author DaiJiCheng
 * @time 2017/4/24  17:47
 * @desc ${RX_LESSON-two}
 */
public class lesson_two extends AppCompatActivity {
    private ArrayList<String> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_lesson_two);

    }


    public void  showToast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

}
