package oit.pagesource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetPageSource {
    public static WebDriver driver;
    public WebElement element;
    public String textWanted;
    public String valueOfAttribute;

    public GetPageSource(WebDriver driver) {
        GetPageSource.driver = driver;
    }

    public String innerHTMLForElement(String xpath) {
        element = driver.findElement(By.xpath(xpath));
        textWanted = element.getAttribute("innerHTML");
        return textWanted;
    }

    public String innerTextForElement(String xpath) {
        element = driver.findElement(By.xpath(xpath));
        textWanted = element.getAttribute("innerText");
        return textWanted;
    }


    public String valueForAttribute(String xpath, String attributeName) {
        element = driver.findElement(By.xpath(xpath));
        valueOfAttribute = element.getAttribute(attributeName);
        return valueOfAttribute;
    }

    public int listsInsideULTag(By locator, By tagName) {
        WebElement ul = driver.findElement(locator);
        List<WebElement> li = ul.findElements(tagName);
        for (int i = 0; i < li.size(); i++) {
        }
        return li.size();
    }

    //get innerHTML text in div s
    public String textInsideTag(String locator) {
        WebElement listOfResults = driver.findElement(By.xpath(locator));
        return listOfResults.getText();
    }

    public String textInsideULLists(String xpathOfULTag) {
        String allResults;
        WebElement listOfResults = driver.findElement(By.xpath(xpathOfULTag));
        allResults = listOfResults.getText();
        return allResults;
    }

    //to get size of the element in the page if it is exist or not
    public int elementSize(String x) {
        int listOfResults;
        listOfResults = driver.findElements(By.xpath(x)).size();
        return listOfResults;
    }

    //to know the selected item from drop down
    public String selectedItemFromList(By locator) {
        String defaultItem;
        Select select = new Select(driver.findElement(locator));
        WebElement option = select.getFirstSelectedOption();
        defaultItem = option.getText();
        return defaultItem;
    }

    public String replaceStringValue(String string, String target, String replacement) {
        String newString;
        newString = string.replace(target, replacement);
        return newString;
    }
}
