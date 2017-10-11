package com.lide.my_rxstudy.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lide.my_rxstudy.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * @author DaiJiCheng
 * @time 2017/4/24  16:21
 * @desc ${rx_基础一}
 */
public class Lesson_one extends AppCompatActivity {

//        Observable<String> myFirstOb = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("hello world!");
//                subscriber.onCompleted();
//            }
//        });
    Observable<String> myFirstOb = Observable.just("hello", "I", "am", "studying", "RX_ANDROID", "!");
    // 连接字符串
    private Func2<String, String, String> mMergeStringFunc = new Func2<String, String, String>() {
        @Override
        public String call(String s, String s2) {
            return String.format("%s %s", s, s2); // 空格连接字符串
        }
    };
    Subscriber<String> myFistSub = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Toast.makeText(Lesson_one.this, s, Toast.LENGTH_SHORT).show();
            mTextView.setText(s);
        }
    };
    Action1<String> myFistAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Toast.makeText(Lesson_one.this, s, Toast.LENGTH_SHORT).show();
            mTextView.setText(s);
        }
    };

    @Bind(R.id.textView)
    TextView mTextView;
    @Bind(R.id.bt_ls1_sub)
    Button mBtLs1Sub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_lesson_one);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_ls1_sub)
    public void onClick() {
        //myFirstOb.reduce(mMergeStringFunc).subscribe(myFstAction);
        Observable.just("hello,lamada!").subscribe(s -> showToast(s));
       // Observable.just("666").map(s->Integer.parseInt(s)).map(s->String.valueOf(s)).subscribe(p->showToast(String.valueOf(p+111)));
      //  Observable.from(new String[]{"how" ,"are" ,"you"}).subscribe(s -> Log.d("test","array-->"+s));
       // Observable.from(new String[]{"how" ,"are" ,"you"}).subscribe(myFistSub);
    }

    public void  showToast(String msg){
        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Lesson_one.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }
}