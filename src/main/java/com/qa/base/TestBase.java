package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Time : 2019-08-17 13:43
 * @Author : huanghe
 * @File : TestBase
 * @Software: IntelliJ IDEA
 */
public class TestBase {
    public Properties prop;
    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
