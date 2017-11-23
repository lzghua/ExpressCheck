package com.express.server;


import com.express.util.HttpRequestUtil;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPost {
    public static void main(String[] args) {
        String url = "https://www.kuaidi100.com/query?type=shunfeng&postid=601305082460&id=1&valicode=&temp=0.04495492544964774&nooralce=1&sessionid=";
        String url2 = "https://www.kuaidi100.com/query";
        String param = "type=shunfeng&postid=601305082460&id=1&valicode=&temp=0.04495492544964774&nooralce=1&sessionid=";
        JSONObject postDate = HttpRequestUtil.Httprequest(url2, "POST", param);
        System.out.println(postDate.toString());
        /*try {
            getRequestJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
    public static String getRequestJson(String urls) throws Exception {
        URL url = new URL(urls);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(5000);
        //connection.setRequestMethod("post");
        connection.setDoOutput(true);//允许对外输出数据

        //connection.getResponseMessage();
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getResponseCode());
        // 一旦发送成功，用以下方法就可以得到服务器的回应：
        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // 传说中的三层包装阿！
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(
                l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString += sCurrentLine + "/r/n";

        }
        System.out.println(sTotalString);
        return null;
    }
}
