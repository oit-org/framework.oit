package oit.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions {
    private static WebDriver driver;
    public static WebElement element;
    public static Wait<WebDriver> wait;
    public static JavascriptExecutor executor;

    public Actions(WebDriver driver) {
        Actions.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        executor = (JavascriptExecutor) driver;
    }

    public  WebElement checkAvailabilityOf(By locator) throws Exception {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not present on the current DOM");
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not visible on the current DOM");
        }
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (element.isEnabled()) {
            return element;
        } else {
            throw new Exception("Element " + locator.getClass().getName() +
                    " is not interactive & visible ");
        }
    }

    public  void typeInTextField(By locator, String string) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            element.clear();
            element.sendKeys(string);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void typeInField(By locator, String string) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            executor.executeScript("arguments[0].value='" + string + "';", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void typeInteger(By locator, Integer number) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            executor.executeScript("arguments[0].value='" + number + "';", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void appendText(By locator, String string) {
        try {
            //append text before current text
            driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME) + string);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void imageSendKeys(By locator, String string) {
        try {
            driver.findElement(locator).sendKeys(string);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  String imageSendKeys_AlertHandling(By locator, String string) {
        String alertText = "";
        try {
            driver.findElement(locator).sendKeys(string);
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alertText;
    }

    public  void typeInTextFieldAndEnter(By locator, String string) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            element.clear();
            element.sendKeys(string);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void clickAction(By locator) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            executor.executeScript("arguments[0].click();",
                    element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void doubleClickAction(By locator) {
        try {
            WebElement ele = driver.findElement(locator);
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver).doubleClick(ele);
            actions.build().perform();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void clickActionManyTimes(By locator) {
        int counter = 0;
        try {

            WebElement element = checkAvailabilityOf(locator);
            do {
                executor.executeScript("arguments[0].click();", element);
                counter++;
            } while (!(counter == 5));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void clickJS(By locator) {
        try {
            executor.executeScript("arguments[0].click();",
                    driver.findElement(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void clickJS2(String id) {
        try {

            executor.executeScript("var clickEvent = document.createEvent " +
                    "('MouseEvents');clickEvent.initEvent ('mousedown', true, true);" +
                    "document.getElementById('" + id + "').dispatchEvent(clickEvent);");

            executor.executeScript("const ke = new KeyboardEvent('keydown', " +
                    "{bubbles: true, cancelable: true, keyCode: 13})" +
                    ";document.getElementById('" + id + "').dispatchEvent(ke);");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void click(By locator) {
        try {
            driver.findElement(locator).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void dropDownByText(By locator, String value) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            Select select = new Select(element);
            select.selectByVisibleText(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void dropDownByIndex(By locator, int value) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            Select select = new Select(element);
            select.selectByIndex(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void dropDownByValue(By locator, String value) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void switchToFrame(By locator) {

        try {
            WebElement element = checkAvailabilityOf(locator);
            driver.switchTo().frame(element);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void scrollToElement(By locator) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
