package com.bishe.main.controller;

import com.alibaba.fastjson.JSON;
import com.bishe.main.entity.result.Result;
import com.bishe.main.entity.result.TokenResult;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static cn.hutool.crypto.SecureUtil.sha1;

@RestController
@RequestMapping("/rong/api")
public class RongController {
    /**
     * @return
     * @Description 获取融云token
     * @param userId  自定义id串，我们用的是员工id
     * @param userHead  图片的url
     * @param userName  名称
     */
    @GetMapping("/get_token")
    public Result<TokenResult> getToken(@RequestParam String userId,
                                        @RequestParam  String userHead,
                                        @RequestParam  String userName) {
        StringBuffer res = new StringBuffer();
        String url = "http://api-cn.ronghub.com/user/getToken.json";
        String App_Key = "p5tvi9dspqvn4"; //开发者平台分配的 App Key。
        String App_Secret = "rps7Li53Fb";//开发者平台分配的App_Secret 。
        String Timestamp = String.valueOf(System.currentTimeMillis());//时间戳，从 1970 年 1 月 1 日 0 点 0 分 0 秒开始到现在的秒数。
        String Nonce = String.valueOf(Math.floor(Math.random() * 1000000));//随机数，无长度限制。
        String Signature = sha1(App_Secret + Nonce + Timestamp);//数据签名。
        //Logger.i(Signature);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("App-Key", App_Key);
        httpPost.setHeader("Timestamp", Timestamp);
        httpPost.setHeader("Nonce", Nonce);
        httpPost.setHeader("Signature", Signature);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
        nameValuePair.add(new BasicNameValuePair("name", userName));//名称（例如使用这个功能的‘张三’）
        nameValuePair.add(new BasicNameValuePair("userId", userId));// 用户id（根据自己的项目，自己生成一个串就行，UUID就行）
        nameValuePair.add(new BasicNameValuePair("portraitUri", userHead));//头像(存储头像的路径)
        HttpResponse httpResponse = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, "utf-8"));
            httpResponse = httpClient.execute(httpPost);
            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line = null;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("res=" + res.toString());
        TokenResult tokenResult = JSON.parseObject(res.toString(), TokenResult.class);
        return Result.success(tokenResult);
    }

    @GetMapping("/get_user_info")
    @ApiOperation("获取融云客户信息")
    public Result<TokenResult> getUserInfo(@RequestParam String userId) {
        StringBuffer res = new StringBuffer();
        String url = "http://api-cn.ronghub.com//user/info.json";
        String App_Key = "p5tvi9dspqvn4"; //开发者平台分配的 App Key。
        String App_Secret = "rps7Li53Fb";//开发者平台分配的App_Secret 。
        String Timestamp = String.valueOf(System.currentTimeMillis());//时间戳，从 1970 年 1 月 1 日 0 点 0 分 0 秒开始到现在的秒数。
        String Nonce = String.valueOf(Math.floor(Math.random() * 1000000));//随机数，无长度限制。
        String Signature = sha1(App_Secret + Nonce + Timestamp);//数据签名。
        //Logger.i(Signature);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("App-Key", App_Key);
        httpPost.setHeader("Timestamp", Timestamp);
        httpPost.setHeader("Nonce", Nonce);
        httpPost.setHeader("Signature", Signature);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
        nameValuePair.add(new BasicNameValuePair("userId", userId));// 用户id（根据自己的项目，自己生成一个串就行，UUID就行）
        HttpResponse httpResponse = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, "utf-8"));
            httpResponse = httpClient.execute(httpPost);
            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line = null;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("res=" + res.toString());
        TokenResult tokenResult = JSON.parseObject(res.toString(), TokenResult.class);
        return Result.success(tokenResult);
    }
}