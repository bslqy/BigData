package JavseSeDay14;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {

        String type = "JavseSeDay14.LoginServiceImpl";
        String func = "say";
        String paramType = "java.lang.String";

        Class<?> forname = Class.forName(type);
        Object instance = forname.newInstance();

        Method method = forname.getMethod(func,Class.forName(paramType));

        method.invoke(instance,"AB");


        /***
         * 反射文件加载结合案例
         */
//        Properties props = new Properties();
//        props.put("type",type);
//        props.put("func",func);
//        props.put("paramType",paramType);

        Properties props = new Properties();
        props.load(Reflection.class.getClassLoader().getResourceAsStream("xx.properties"));
        String type1 = props.getProperty("type");
        String func1 = props.getProperty("func");
        String paramType1 = props.getProperty("paramType");


        Class<?> forname1 = Class.forName(type1);
        Object instance1 = forname.newInstance();

        Method method1 = forname.getMethod(func1,Class.forName(paramType1));

        method.invoke(instance,"ABC");



    }
}
