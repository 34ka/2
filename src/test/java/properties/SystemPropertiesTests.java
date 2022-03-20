package properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void someTest1() {
        String browser = System.getProperty("browser");
        System.out.println(browser); // null
    }

    @Test
    void someTest2() {
        System.setProperty("some_browser", "safari");
        String browser = System.getProperty("some_browser");
        System.out.println(browser); // safari
    }

    @Test
    void someTest3() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
        // gradle clean test                          // opera
        // gradle clean test -Dbrowser=mozilla        // mozilla
    }

    @Test
    void someTest4() {
        System.out.println(System.getProperty("any_value")); // null

        System.setProperty("any_value", "some");
        System.out.println(System.getProperty("any_value")); // some
    }

    @Test
    void someTest5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        /* gradle clean test
            chrome
            91
            300x300 */
        /* gradle clean test -Dbrowser=mozilla -Dversion=80 -DbrowserSize=600x600
            mozilla
            80
            600x600 */
    }

    @Test
    void someTest6() {
        System.out.println("I want to say: " + System.getProperty("someText"));
    }
}
