import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("SomeService");

        Object obj = clazz.newInstance();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object obj2 = constructor.newInstance();

        // 获取方法
        Method doSome = clazz.getMethod("doSome", String.class, int.class);
        Method doSome2 = clazz.getMethod("doSome", String.class);

        // 调用方法
        Object retValue = doSome.invoke(obj, "zhangsan", 250);
        System.out.println(retValue);

        Object retValue2 = doSome2.invoke(obj2, "lisi");
        System.out.println(retValue2);


    }
}
