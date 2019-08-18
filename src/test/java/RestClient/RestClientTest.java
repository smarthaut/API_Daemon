package RestClient;

import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * @Time : 2019/8/18 7:30
 * @Author : huanghe
 * @File : RestClientTest
 * @Software: IntelliJ IDEA
 */
public class RestClientTest {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    final static Logger log = Logger.getLogger(RestClient.class);

    @Test
    public void testGet() throws IOException {
        testBase = new TestBase();
        host = testBase.prop.getProperty("HOST");
        url = host + "/getJoke?page=1&count=2&type=video";
        System.out.println(url);
        log.info("begin.....");
        restClient = new RestClient();
        CloseableHttpResponse httpResponse = restClient.get(url);
        //获取状态码
        int statusCode = restClient.getStatusCode(httpResponse);
        Assert.assertEquals(statusCode,200);
        JSONObject response = restClient.getResponseJson(httpResponse);

        System.out.println(response.toJSONString());
        String s = TestUtil.getVaueByJPath(response,"result[1]/text");

        System.out.println(s);
    }

    @Test
    public void testTestGet() {
    }
}