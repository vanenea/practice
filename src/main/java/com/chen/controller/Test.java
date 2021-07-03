package com.chen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chen.activemq.Producer;
import com.chen.configuration.PropertiesConfig;
import com.chen.utils.ResponseResult;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
public class Test {

    private String aa = random();

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Autowired
    private Producer producer;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/test1")
    public String test() {
        return "test";
    }

    @RequestMapping("/vueDemo")
    public String vueDemo() {
        return "vueDemo";
    }

    @RequestMapping("/component")
    public String vueComp() {
        return "vueComponent";
    }

    @RequestMapping("/basicProps")
    public String basicProps() {
        return "basic-props";
    }

    @RequestMapping("/vueSearch")
    public String vueSearch() {
        return "vueSearch";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/cartList")
    @ResponseBody
    public ResponseResult<JSONObject> cartList() {
        String json = "{\r\n" +
                "      \"totalHoney\":59,\r\n" +
                "      \"list\":[\r\n" +
                "      {\r\n" +
                "      \"name\": \"面具1\",\r\n" +
                "      \"price\": 19,\r\n" +
                "      \"count\": 1,\r\n" +
                "      \"amount\": 19,\r\n" +
                "      \"imgPic\": \"../images/test.jpg\",\r\n" +
                "      \"gifts\": [\r\n" +
                "        {\r\n" +
                "          \"partId\":\"10001\",\r\n" +
                "          \"partName\":\"打火机\"\r\n" +
                "        },\r\n" +
                "        {\r\n" +
                "          \"partId\":\"10002\",\r\n" +
                "          \"partName\":\"火柴\"\r\n" +
                "        }\r\n" +
                "      ]\r\n" +
                "      },\r\n" +
                "      {\r\n" +
                "      \"name\": \"面具2\",\r\n" +
                "      \"price\": 20,\r\n" +
                "      \"count\": 1,\r\n" +
                "      \"amount\": 20,\r\n" +
                "      \"imgPic\": \"../images/test1.jpg\",\r\n" +
                "        \"gifts\": [\r\n" +
                "          {\r\n" +
                "            \"partId\":\"10001\",\r\n" +
                "            \"partName\":\"打火机\"\r\n" +
                "          },\r\n" +
                "          {\r\n" +
                "            \"partId\":\"10002\",\r\n" +
                "            \"partName\":\"火柴盒\"\r\n" +
                "          }\r\n" +
                "        ]\r\n" +
                "      },\r\n" +
                "        {\r\n" +
                "          \"name\": \"面具3\",\r\n" +
                "\r\n" +
                "          \"price\": 20,\r\n" +
                "          \"count\": 1,\r\n" +
                "          \"amount\": 20,\r\n" +
                "          \"imgPic\": \"../images/test1.jpg\",\r\n" +
                "          \"gifts\": [\r\n" +
                "            {\r\n" +
                "              \"partId\":\"10001\",\r\n" +
                "              \"partName\":\"打火机\"\r\n" +
                "            },\r\n" +
                "            {\r\n" +
                "              \"partId\":\"10002\",\r\n" +
                "              \"partName\":\"火柴盒\"\r\n" +
                "            }\r\n" +
                "          ]\r\n" +
                "        }\r\n" +
                "      ]\r\n" +
                "  }";
        System.out.printf(aa);
        JSONObject jo = JSON.parseObject(json);
//		Map<String, Object> map = new HashMap<>();
//		map.put("data", jo);
//		jo.putAll(map);
//		System.out.println(jo.toJSONString());
        ResponseResult<JSONObject> result = new ResponseResult<>(1, "返回数据成功", jo);
        return result;
    }

    @RequestMapping("/test")
    @ResponseBody
    public void tes() {
        System.out.printf(aa);
        System.out.println("propertiesConfig:" + propertiesConfig.getSalt());
        System.out.println("redisTemplate:" + redisTemplate);
        ValueOperations<String, Object> va = redisTemplate.opsForValue();
        String str = (String) va.get("name");
        if (str == null) {
            str = "字符串";
            va.set("name", str, 10, TimeUnit.SECONDS);

        }
        System.out.println("reids:" + va.get("name"));
        System.out.println(str);
    }

    @RequestMapping("/mq")
    @ResponseBody
    public void activeMqTest() {
        Destination destination = new ActiveMQQueue("test.queque");
        for (int i = 0; i < 10; i++) {
            producer.send(destination, "HelloWorld");

        }
    }

    public static String random() {
        return Integer.toString(new Random().nextInt(1000));
    }

    public static void main(String[] args) {
        System.out.println(random());
        System.out.println(random());
    }

}
