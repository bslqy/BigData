package JavseDay11;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 反射
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classname = "JavseDay11.Person";
        String methodName = "say";
        Class<?> forname = Class.forName(classname);

        // run the class constructor
        Person p = (Person) forname.newInstance();

        // 从forName这个class模板中获得指定的“方法”
        Method method = forname.getMethod(methodName);
        Method method2 = forname.getMethod("eat",String.class);
        // 带参数的方法

        // 使用方法
        method.invoke(p);

        System.out.println(p);

        method2.invoke(p,"Pizza");


    }
}
