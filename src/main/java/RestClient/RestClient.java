package RestClient;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Time : 2019/8/18 6:45
 * @Author : huanghe
 * @File : RestClient
 * @Software: IntelliJ IDEA
 */
public class RestClient {

    final  static Logger log = Logger.getLogger(RestClient.class);
    /*
    *不带请求头的get方法
    * */
    public CloseableHttpResponse get(String url) throws IOException {
        CloseableHttpClient httpclient =  HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        log.info("开始发送get请求");
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        log.info("发送请求成功。得到响应对象");
        return httpResponse;

    }
    /**
     * 带请求头的get方法
     */

    public CloseableHttpResponse get(String url, HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        for(Map.Entry<String,String> entry:headermap.entrySet()){
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        log.info("开始发送get请求");
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        log.info("发送请求成功。得到响应对象");
        return closeableHttpResponse;
    }
    public CloseableHttpResponse post(String url,String entrystring,HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(entrystring));
        for(Map.Entry<String,String> entry:headermap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpPost);
        return closeableHttpResponse;
    }
    public int getStatusCode(CloseableHttpResponse response){
        int status = response.getStatusLine().getStatusCode();
        log.info("解析 获取到的状态码为："+status);
        return status;
    }
    public JSONObject getResponseJson(CloseableHttpResponse response) throws IOException {
        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        JSONObject responseJson = JSON.parseObject(responseString);
        return responseJson;
    }
}
