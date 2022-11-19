package pageObjects;

public interface Page {

    // In this page I will declare all methods to be used in POM pages

    default void findElementAndClickFunction(String element){};

    default void findElementAndSendKeyFunction(String element, String text){};

    default void selectFromDropDown(String element){};

    default void hoverOverTheElement(String element){};

    public void initMap();

    default public void scrollToElement(String element) {};

    default public void randomClickOnElementInsideListOfWebElement(String ListOfWebElement){};

}