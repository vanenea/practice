package getDate3;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Story implements Runnable {

    public static void main(String[] args) {
        new Thread(new Story()).start();
    }

    private String host = "http://book.sbkk8.com";
    private HttpClient client = HttpClientBuilder.create().build();

    @Override
    public void run() {
        HttpGet get = new HttpGet(host + "/gushihui/taijiaogushi/");
        get.setHeader("userAgent", "Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
        get.setHeader("Content-Type", "application/x-www-form-urlencoded");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("C:\\Users\\vanen\\Desktop\\test.txt"));
            PrintWriter pw = new PrintWriter(fileOutputStream);
            HttpResponse response = client.execute(get);
            HttpEntity entiry = response.getEntity();
            String html = EntityUtils.toString(entiry, "gbk");
            Document doc = Jsoup.parse(html);
            Elements elements = doc.getElementsByClass("mulu").get(0).getElementsByTag("li");
            for (Element element : elements) {
                pw.println(element.text());
                Elements as = element.getElementsByTag("a");
                for (Element a :
                        as) {
                    String href = a.attr("href");
                    get = new HttpGet(host + href);
                    response = client.execute(get);
                    entiry = response.getEntity();
                    html = EntityUtils.toString(entiry, "gbk");
                    doc = Jsoup.parse(html);
                    String contet = doc.getElementById("content").text();

                    pw.println(contet);
                    pw.println("");
                    pw.println("");
                }
                pw.flush();
            }
            pw.flush();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
