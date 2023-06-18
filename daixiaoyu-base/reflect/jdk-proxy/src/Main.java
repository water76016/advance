import java.lang.reflect.Proxy;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-18 15:02
 **/
public class Main {
    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy(new JDKProxyCat("咪咪"));
        JDKProxyAnimal cat = (JDKProxyAnimal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                new Class[]{JDKProxyAnimal.class}, proxy);
        cat.eat();
    }
}
