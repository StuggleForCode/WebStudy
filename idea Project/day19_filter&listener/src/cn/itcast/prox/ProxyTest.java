package cn.itcast.prox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenvo lenvo = new Lenvo();

        //2.动态代理增强lenovo对象
        /**
         * 三个参数：
         *  1.类加载器，真实对象lenvo.getClass().getClassLoader()
         *  2.接口数组，真实对象lenvo.getClass().getInterfaces()
         *  3.处理器new InvocationHandler()
         */
        SaleComputer proxy_lenvo = (SaleComputer) Proxy.newProxyInstance(lenvo.getClass().getClassLoader(), lenvo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
             * @param proxy 代理对象
             * @param method 代理对象调用的方法，被封转为的对象
             * @param args 代理对象调用的方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了...");
//                System.out.println(method.getName());
//                System.out.println(args[0]);

                //1.增强参数
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                        //1.增强参数
                        double money = (double)args[0];
                        money *= 0.85;
                        System.out.println("专车接你..."); //增强方法体
                        //使用真实对象调用该方法
                        String obj = (String) method.invoke(lenvo, money);
                        System.out.println("免费送货...");
                        return obj + "_鼠标垫";
                    }else{
                        //使用真实对象调用该方法
                        Object obj = method.invoke(lenvo, args);
                    return obj;
                }
            }
        });

        //2.调用方法
        String computer = proxy_lenvo.sale(8000);
        System.out.println(computer);
        proxy_lenvo.show();
    }
}
