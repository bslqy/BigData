package JavseSeDay14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo  {
    public static void main(String[] args) {
        // 构造一个LoginService接口的动态代理对象.这个对象可以重写接口的方法，不需要改变原来接口实现类的方法。
        // 谁用，接口是什么，句柄
        LoginService o = (LoginService)  Proxy.newProxyInstance(LoginService.class.getClassLoader()
        ,new Class<?>[] {LoginService.class}, new InvocationHandler(){

            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("eat")){
                    System.out.println("我一点也不喜欢吃"+ args[0]);

                }

                if (method.getName().equals("speak")){

                }

                if (method.getName().equals("say")){
                    if(method.getParameterTypes().length > 0){

                    }

                }
                return null;

            }
        });
        o.eat("三明治");
    }
}
