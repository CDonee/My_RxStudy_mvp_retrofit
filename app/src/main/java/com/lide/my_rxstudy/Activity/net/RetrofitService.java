package com.lide.my_rxstudy.Activity.net;


import com.lide.my_rxstudy.Activity.global.Constants;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(new Interceptor() {
//                                      @Override
//                                      public Response intercept(Interceptor.Chain chain) throws IOException {
//                                          Request original = chain.request();
//
//                                          Request request = original.newBuilder()
//                                                  .header("authorization", "APP_KEYS d113cffb-fcfb-4ff6-94ae-3ff1e53d0c49")
//                                                  .method(original.method(), original.body())
//                                                  .build();
//
//                                          return chain.proceed(request);
//                                      }
//                                  });
//
//                OkHttpClient mc = httpClient.build();


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //请求头
            Interceptor headInterceptor = chain -> {
            Request original = chain.request();
                Request request = null;
                try {
                    String key =  Constants.USER_KEY+"";
                    request = original.newBuilder().header("authorization",key)
                            .method(original.method(), original.body())
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return chain.proceed(request);
        };
         logging.setLevel(HttpLoggingInterceptor.Level.BODY);
         okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).addInterceptor(headInterceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
