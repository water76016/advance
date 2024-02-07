/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-18 15:05
 **/
public class JDKProxyCat implements JDKProxyAnimal{
    private String name;

    public JDKProxyCat(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("小猫：" + name + "正在吃饭");
    }
}
