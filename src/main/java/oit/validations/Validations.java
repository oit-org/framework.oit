package oit.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Validations {
    public WebDriver driver;
    public String currentValue;

    public Validations(WebDriver driver) {
        this.driver = driver;
    }

    public void assertEqualsValue(String actualValue, String currentURL) {
        if (driver.getCurrentUrl().equals(currentURL)) {
            currentValue = driver.getPageSource();
            Assert.assertTrue(currentValue.contains(actualValue));
        }

    }

    public void validateNotFound(String actualValue, String currentURL) {
        if (driver.getCurrentUrl().equals(currentURL)) {
            currentValue = driver.getPageSource();
            Assert.assertFalse(currentValue.contains(actualValue));
        }
    }

    public void assertNotEqualsValue(String expectedValue, String currentValue) {
        Assert.assertNotSame(expectedValue, currentValue);
    }

    public void validateOnTittle(String actualValue) {
        currentValue = driver.getTitle();
        Assert.assertEquals(actualValue, currentValue);
    }

    public void validateTitleContains(String expectedValue) {
        currentValue = driver.getTitle();
        Assert.assertTrue(currentValue.contains(expectedValue));
    }

    public void assertTwoValuesTrue(String expectedvalue, String currentvalue) {
        Assert.assertEquals(expectedvalue, currentvalue);
        System.out.println("Two Values are equal");
    }

    public void assertEqualsByInt(int expectedvalue, int currentvalue) {
        Assert.assertEquals(expectedvalue, currentvalue);
    }

    public void validateTextContains(String currentValue, String expectedValue) {
        Assert.assertTrue(currentValue.contains(expectedValue));
    }

    public void validateTextNOTContains(String currentValue, String expectedValue) {
        Assert.assertFalse(currentValue.contains(expectedValue));
    }


    public void assertInnerHTMLContainTrue(String xpath, String actualValue) {
        WebElement element = driver.findElement(By.xpath(xpath));
        currentValue = element.getAttribute("innerHTML");
        Assert.assertTrue(currentValue.contains(actualValue));
    }

    public void assertInnerHTMLContainFalse(String xpath, String actualValue) {
        WebElement element = driver.findElement(By.xpath(xpath));
        currentValue = element.getAttribute("innerHTML");
        Assert.assertFalse(currentValue.contains(actualValue));
    }

    public boolean isElementPresent(String webElement) {
        try {
            driver.findElement(By.xpath(webElement));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public void validateElementFound(String webElement) {
        boolean element;
        try {
            driver.findElement(By.xpath(webElement));
            element = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            element = false;
        }
        assertTrue(element, "Element is not found");
    }


    public void validateElementNotFound(String webElement) {
        boolean element;
        try {
            driver.findElement(By.xpath(webElement));
            element = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            element = false;
        }
        assertFalse(element, "Element is found and displayed");
    }
}
