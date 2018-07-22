package com.chen.io;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Image2Base64 {

    public static String exc(String imageUrl) {
        ByteArrayOutputStream data = null;
        InputStream is = null;
        try {
            data = new ByteArrayOutputStream();
            URL url = new URL(imageUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(3000);
             is = con.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len=is.read(b))!=-1) {
                data.write(b,0,len);
            }
            BASE64Encoder be = new BASE64Encoder();
            return "data:image/jpg;base64," + be.encode(data.toByteArray());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(data!=null){
                try {
                    data.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return imageUrl;
    }

    public static void main(String[] args) {
        //https://res.vmallres.com/pimages/detailImg/2018/07/04/201807041516058788086.jpg
        //https://baike.baidu.com/pic/%E6%B1%A0%E6%B3%BD%E5%BD%A9%E9%87%8E%E8%8A%B1/1509534/0/241f95cad1c8a7868a2713146c09c93d70cf509e?fr=lemma&ct=single#aid=0&pic=241f95cad1c8a7868a2713146c09c93d70cf509e
        System.out.println(exc("https://baike.baidu.com/pic/%E6%B1%A0%E6%B3%BD%E5%BD%A9%E9%87%8E%E8%8A%B1/1509534/0/241f95cad1c8a7868a2713146c09c93d70cf509e?fr=lemma&ct=single#aid=0&pic=241f95cad1c8a7868a2713146c09c93d70cf509e"));
    }

}
