package resources;

import org.openqa.selenium.WebDriver;
import pageObjects.Page;
import pageObjects.TestPage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import static resources.base.driver;

public class BaseClass {

    // create different browser for the parallel testing
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();
    private static List<Page> list = new ArrayList<>(); // List of all Pages using interface Page

    public static Page getPage(String pageName){
        // get Page from List<Pages>
        Predicate<Page> predicate = obj -> obj.getClass().toString().toUpperCase(Locale.ROOT).contains(pageName.toUpperCase(Locale.ROOT));
        Page page = list.stream().filter(predicate).findFirst().orElse(null);

        if (page == null) {
            throw new RuntimeException("Page not found " + pageName);
        }
        return page;
    }

    public static void initPageList(){
        list.add(new TestPage(driver));
    }

    public void hoverOverTheElement(String element) {
        moveToElementAndClick(getWebElement(map, element));
    }
}
