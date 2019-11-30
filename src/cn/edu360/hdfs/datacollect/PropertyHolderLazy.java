package cn.edu360.hdfs.datacollect;

import java.util.Properties;

public class PropertyHolderLazy {
    private static Properties prop = null;

    public static Properties getProps() throws  Exception{
        // 第一个线程进来，第二个紧随，同时判断为空（假设第二个进来时第一个并未创建完成）
        //创建时候只允许一个进程执行，二次判断是否为空，避免第二个进程重复创建。
        if(prop == null) {
            synchronized (PropertyHolderLazy.class) {
                if(prop == null){
                    prop = new Properties();
                    prop.load(Properties.class.getClassLoader().getResourceAsStream("collection.property"));

                }
            }
        }
        return prop;
    }
}
