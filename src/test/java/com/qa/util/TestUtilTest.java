package com.qa.util;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import javax.xml.transform.Source;

import static org.testng.Assert.*;

/**
 * @Time : 2019-08-17 16:32
 * @Author : huanghe
 * @File : TestUtilTest
 * @Software: IntelliJ IDEA
 */
public class TestUtilTest {


    @Test
    public void testGetVaueByJPath() {
        JSONObject obj = new JSONObject();
        obj.put("name","huanghe");
        obj.put("age",12);
        //System.out.println((TestUtil.toJsonString(obj)));

        String s = TestUtil.getVaueByJPath(obj,"name");
        System.out.println(s);

    }
}