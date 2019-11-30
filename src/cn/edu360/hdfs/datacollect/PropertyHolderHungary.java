package cn.edu360.hdfs.datacollect;

import java.io.IOException;
import java.util.Properties;

/***
 * 单例设计模式, 方式一：饿汉式单例
 * 每次加载返回同一个prop
 */
public class PropertyHolderHungary {
    private static Properties prop = new Properties();

    static{
        try{
            prop.load(PropertyHolderHungary.class.getClassLoader().getResourceAsStream("collect.property"));

        }catch ( Exception e){}
    }
    public static Properties getProps() throws IOException {

        return prop;

    }
}
