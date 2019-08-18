package com.qa.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.xml.ws.Response;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Time : 2019-08-17 13:53
 * @Author : huanghe
 * @File : TestUtil
 * @Software: IntelliJ IDEA
 */
public class TestUtil {
    public static <T> T parseObject(String json, Class<T> name) {
        if (json == null || json.trim().length() == 0) {
            return null;
        }
        return JSON.parseObject(json, name);
    }

    public static String toJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj);
    }

    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

    public static String getVaueByJPath(JSONObject object, String JPath) {
        Object obj = object;
        
        for (String s : JPath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                     obj =  ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    int s1 = Integer.parseInt(s.split("\\[")[1].replaceAll("]", ""));
                     obj = ((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(s1);


                }
            }
        }

        return obj.toString() ;
    }


}
