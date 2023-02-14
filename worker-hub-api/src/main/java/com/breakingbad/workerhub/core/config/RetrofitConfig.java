package com.breakingbad.workerhub.core.config;

import com.breakingbad.workerhub.constant.RetrofitAPI;
import com.breakingbad.workerhub.core.api.kasi.KasiAPIs;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfig {

    private static final int DEFAULT_TIME_OUT = 60;

    private static final int CONNECTION_TIME_OUT = 20;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    @Bean("kasiRetrofit")
    public Retrofit kasiRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(RetrofitAPI.KASI_API_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Bean
    public KasiAPIs kasiAPIs(@Qualifier("kasiRetrofit") Retrofit retrofit) {
        return retrofit.create(KasiAPIs.class);
    }

}
