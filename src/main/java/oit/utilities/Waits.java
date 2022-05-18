package oit.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    Actions actions;
    private WebDriver driver;
    public static Wait<WebDriver> wait;
    public static Wait<WebDriver> fWait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        actions = new Actions(driver);
    }

    public void waitForJSandJQueryToLoad() {
        Boolean readyStateComplete = false;
        while (!readyStateComplete) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            System.out.println(((String) executor.executeScript("return document.readyState")));
            readyStateComplete = ((String) executor
                    .executeScript("return document.readyState"))
                    .equals("complete");
        }
    }

    public void waitForTextAppears(By locator, String textToBePresent) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, textToBePresent));
    }

    public void waitForTextNotAppears(By locator, String textToBePresent) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(locator,
                textToBePresent)));
    }

    public void waitForElementAppearsAndPresence(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(locator));
    }

    public void waitForElementAppears(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementNOTAppears(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions
                .elementToBeClickable(locator));
    }

    public void scrollDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
    }

    public void fluentWaitForVisibility(int numberOfAttempts, int timePeriod, String elementToBeVisible) throws Exception {
        fWait = new WebDriverWait(driver, Duration.ofSeconds(timePeriod));
        for (int i = 1; i <= numberOfAttempts; i++) {
            try {
                System.out.println("Attempt number " + i + " With time period " + timePeriod + " seconds to for the element to be visible");
                fWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementToBeVisible)));
                break;
            } catch (Exception e) {
                if (i == numberOfAttempts) {
                    throw new Exception("Couldn't find element");
                } else {
                    driver.navigate().refresh();
                    waitForJSandJQueryToLoad();
                }
            }
        }
    }

    public void fluentWaitForPresence(int numberOfAttempts, int timePeriod, String elementToBeVisible) throws Exception {
        fWait = new WebDriverWait(driver, Duration.ofSeconds(timePeriod));
        driver.navigate().refresh();
        for (int i = 1; i <= numberOfAttempts; i++) {
            try {
                System.out.println("Attempt number " + i + " With time period " + timePeriod + " seconds for the element to be present");
                fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToBeVisible)));
                break;
            } catch (Exception e) {
                if (i == numberOfAttempts) {
                    throw new Exception("Couldn't find element");
                } else {
                    driver.navigate().refresh();
                    waitForJSandJQueryToLoad();
                }
            }
        }
    }

    public void clickElementAndFluentWaitForPresence(String webElement, int numberOfAttempts,
                                                     int timePeriod, String elementToBeVisible) throws Exception {
        fWait = new WebDriverWait(driver, Duration.ofSeconds(timePeriod));
        driver.navigate().refresh();
        for (int i = 1; i <= numberOfAttempts; i++) {
            try {
                System.out.println("Attempt number " + i + " With time period " + timePeriod + " seconds for the element to be present");
                actions.clickAction(By.xpath(webElement));
                fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToBeVisible)));
                break;
            } catch (Exception e) {
                if (i == numberOfAttempts) {
                    throw new Exception("Couldn't find element");
                } else {
                    driver.navigate().refresh();
                    waitForJSandJQueryToLoad();
                }
            }
        }
    }

    public void fluentWaitForInVisibility(int numberOfAttempts, int timePeriod, String elementToBeVisible) throws Exception {
        fWait = new WebDriverWait(driver, Duration.ofSeconds(timePeriod));
        for (int i = 1; i <= numberOfAttempts; i++) {
            try {
                System.out.println("Attempt number " + i + " With time period " + timePeriod + " seconds for the element to be visible");
                fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementToBeVisible)));
                break;
            } catch (Exception e) {
                if (i == numberOfAttempts) {
                    throw new Exception("Couldn't find element");
                } else {
                    driver.navigate().refresh();
                    waitForJSandJQueryToLoad();
                }
            }
        }
    }

}
