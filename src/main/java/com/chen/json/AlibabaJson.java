package com.chen.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chen.domain.User;

import java.util.*;

public class AlibabaJson {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("chen");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setId(1);
        user2.setUsername("chen");
        user2.setPassword("123456");
        userList.add(user1);
        userList.add(user2);
        Map<String, Object> map = new HashMap<>();
        map.put("code","111111");
        map.put("data",userList);
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        jo.putAll(map);
        System.out.println("jo:"+jo.toJSONString());
        for ( Map.Entry<String, Object> mapEntry: jo.entrySet()) {
            System.out.println("key:"+mapEntry.getKey());
            JSONObject j1 = JSON.parseObject(jo.get(mapEntry.getKey()).toString());
        }
        json2JsonObjectM1();

        json2BeanM2();
    }

    /**
     * 将Json文本数据信息转换为JsonObject对象，然后利用键值对的方式获取信息
     */
    private static void json2JsonObjectM1() {
        //一个JsonObject文本数据
        String s = "{\"name\":\"liuzhao\"}";
        //将JsonObject数据转换为Json
        JSONObject object = JSON.parseObject(s);
        //利用键值对的方式获取到值
        System.out.println(object.get("name"));
        /**
         * 打印：
         * liuzhao
         */
    }

    /**
     * 将Json文本数据转换为JavaBean数据！
     * 需要注意的是：这时候的Json文本信息中的键的名称必须和JavaBean中的字段名称一样！键中没有的在这个JavaBean中就显示为null！
     */
    private static void json2BeanM2() {
        String s = "{\"id\":\"00375\",\"username\":\"平顶山\"}";
        //一个简单方便 的方法将Json文本信息转换为JsonObject对象的同时转换为JavaBean对象！
        User weibo = JSON.parseObject(s, User.class);//Weibo类在下边定义
        System.out.println(weibo.getId());
        System.out.println(weibo.getUsername());
        //打印的结果		0375
        //				平顶山
    }



}
