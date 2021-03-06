import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NewInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        return method.getAnnotation(Selector.class).xpath();
    }
}
