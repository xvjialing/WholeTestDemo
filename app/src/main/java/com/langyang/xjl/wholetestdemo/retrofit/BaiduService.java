package com.langyang.xjl.wholetestdemo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Author : xjl
 * @Created : 2016-12-16
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public interface BaiduService {
    @GET("/")
    Call<String> getBaidu();
}
