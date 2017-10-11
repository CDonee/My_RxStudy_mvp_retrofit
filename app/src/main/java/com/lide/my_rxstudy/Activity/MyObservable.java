package com.lide.my_rxstudy.Activity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 * @author DaiJiCheng
 * @time 2017/4/24  18:21
 * @desc ${TODD}
 */
public class MyObservable <T> extends Observable<T> {


    /**
     * Creates an Observable with a Function to execute when it is subscribed to.
     * <p>
     * <em>Note:</em> Use {@link #create(OnSubscribe)} to create an Observable, instead of this constructor,
     * unless you specifically have a need for inheritance.
     *
     * @param f {@link OnSubscribe} to be executed when {@link #subscribe(Subscriber)} is called
     */
    protected MyObservable(OnSubscribe<T> f) {
        super(f);
    }

    public static List<String> query(String msg) {
        ArrayList<String> list = new ArrayList();
        list.add("he");
        list.add("she");
        list.add("you");
        return  list;
    }

}
