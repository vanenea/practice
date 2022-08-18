package com.chen.practice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) throws Exception {
        jsonTest();
        

    }

    public static void jsonTest(){
        String aa = "123123213,8785957894";
        String[] bb = aa.split(",");
        JSONObject params = new JSONObject();
        JSONArray ja = new JSONArray();
        for (int i= 0; i<bb.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("pid", bb[i]);
            ja.add(jo);
        }
        params.put("id", "123123213");
        params.put("list", ja);
        System.out.println(params.toJSONString());
    }


    public static void timeTest() {
       /* Timer timer = new Timer();
        System.out.println(new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());

                timer.cancel();
            }
        }, 1000);


        Runnable runnable = new Runnable() {
            public void run() {
                // 把run方法里的内容换成你要执行的内容
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("当前的系统时间为：" + sdf.format(new Date()));
            }
        };*/
        ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();

        //public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
        //command--执行的任务,initialDelay--延迟开始,period--间隔时间,unit--时间单位
        /* service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS); */
        System.out.println("当前线程00000: " + Thread.activeCount());
        for (int i = 0; i < 10; i++) {
            ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
            service2.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程: " + Thread.activeCount());

                    try {
                        Thread.sleep(5000);
                        service2.shutdown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 5, TimeUnit.SECONDS);

        }

        for (int i = 0; i < 10; i++) {

            service1.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程1: " + Thread.activeCount());
                    /*try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }, 1, TimeUnit.SECONDS);
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束: " + Thread.activeCount());
    }

    public static int i = 0;

    public static void recursion() {
        while (i < 5) {
            if (i > 3) {
                recursion();
            }
            i--;
        }
        System.out.println("recursion");
    }


    /**
     * Json to xml string.
     *
     * @param json the json
     * @return the string
     */
    public static String jsonToXml(String json) {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            JSONObject jObj = JSON.parseObject(json);
            jsonToXmlstr(jObj, buffer);
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * Json to xmlstr string.
     *
     * @param jObj   the j obj
     * @param buffer the buffer
     * @return the string
     */
    public static String jsonToXmlstr(JSONObject jObj, StringBuffer buffer) {
        Set<Map.Entry<String, Object>> se = jObj.entrySet();
        for (Iterator<Map.Entry<String, Object>> it = se.iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> en = it.next();
            if (en.getValue().getClass().getName().equals("com.alibaba.fastjson.JSONObject")) {
                buffer.append("<" + en.getKey() + ">");
                JSONObject jo = jObj.getJSONObject(en.getKey());
                jsonToXmlstr(jo, buffer);
                buffer.append("</" + en.getKey() + ">");
            } else if (en.getValue().getClass().getName().equals("com.alibaba.fastjson.JSONArray")) {
                JSONArray jarray = jObj.getJSONArray(en.getKey());
                for (int i = 0; i < jarray.size(); i++) {
                    buffer.append("<" + en.getKey() + ">");
                    JSONObject jsonobject = jarray.getJSONObject(i);
                    jsonToXmlstr(jsonobject, buffer);
                    buffer.append("</" + en.getKey() + ">");
                }
            } else if (en.getValue().getClass().getName().equals("java.lang.String")) {
                buffer.append("<" + en.getKey() + ">" + en.getValue());
                buffer.append("</" + en.getKey() + ">");
            }
        }
        return buffer.toString();
    }
}
