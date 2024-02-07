import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-08-09 00:10
 **/
public class GlobalSymbol {
    /**
     * 定义全局标志位
     */
    public static AtomicBoolean globalFlag = new AtomicBoolean(false);
}
