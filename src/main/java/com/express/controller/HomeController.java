package com.express.controller;

import com.express.util.HttpRequestUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
    @RequestMapping(method =RequestMethod.GET)
    public String home(){
        return "home";
    }
    //"601305082460"

    @RequestMapping(value = "query/{type}/{postid}",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String expressDate(@PathVariable String type, @PathVariable String postid){
        String url2 = "https://www.kuaidi100.com/query";
        String param = "type="+type+"&postid="+postid+"&id=1&valicode=&temp=0.04495492544964774&nooralce=1&sessionid=";
        JSONObject postDate = HttpRequestUtil.Httprequest(url2, "POST", param);
        System.out.println(postDate.toString());
        return postDate.toString();
    }
}
