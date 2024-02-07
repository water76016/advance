import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-18 15:08
 **/
public class JDKProxy implements InvocationHandler {
    private Object bean;

    public JDKProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("eat")){
            System.out.println("准备执行eat方法");
        }
        method.invoke(bean, args);
        System.out.println("eat方法执行结束");
        return null;
    }
}
