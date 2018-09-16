package base;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://35.231.186.189";
        Configuration.headless = true;
    }

    protected <T> T at(Class<T> tClass){
        try {
            return tClass.newInstance();
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }
}
