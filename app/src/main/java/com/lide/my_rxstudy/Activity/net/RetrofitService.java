package com.lide.my_rxstudy.Activity.net;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/17.
 */

public class RetrofitService {

    private static RetrofitService Instance = null;

    public static RetrofitService getInstance(){
        if(Instance == null)
            Instance = new RetrofitService();

        return Instance;
    }

    private String Tag = RetrofitService.class.getSimpleName();
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private RetrofitService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
         okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
                retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.253:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
