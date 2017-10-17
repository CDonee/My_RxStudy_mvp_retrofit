package app;

import android.app.Application;
import android.content.Context;

import com.lide.my_rxstudy.Activity.MainActivity;

/**
 * @author DaiJiCheng
 * @time 2017/10/17  10:47
 * @desc ${TODD}
 */
public class MyApp extends Application {
    public Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = new MainActivity();
    }
}
