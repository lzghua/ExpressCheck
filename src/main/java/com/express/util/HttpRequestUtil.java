package com.express.util;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *通过HTTP请求 获取json结果
 */
public class HttpRequestUtil {
    /**
     * @param requestUrl 发送请求的url
     * @param requestMethod 请求的方式 GET/POST
     * @param outputStr 请求的参数 name1=value1&name2=value2 的形式
     * @return 远程返回的json数据 转为Json对象
     */
    public static JSONObject Httprequest(String requestUrl, String requestMethod, String outputStr){
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream=null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            //将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            //给定编码防止乱码-要和请求返回输入流的编码一致
            jsonObject = new JSONObject(new JSONTokener(new InputStreamReader(inputStream,"UTF-8")));

        } catch (ConnectException ce) {
            ce.printStackTrace();
            System.out.println("Weixin server connection timed out");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("http request error:{}");
        }finally{
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}
