import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MethodInterception {
    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {

        var interfaces = new Class[] {clazz};

        var mainPage = (MainPage) Proxy.newProxyInstance(NewInvocationHandler.class.getClassLoader(), interfaces ,
                new NewInvocationHandler());

        return mainPage;
    }
}
