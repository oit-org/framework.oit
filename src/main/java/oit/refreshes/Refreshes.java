package oit.refreshes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Refreshes {
    public WebDriver driver;

    public Refreshes(WebDriver driver) {
        this.driver = driver;
    }

    //refresh until specific element displayed
    //you can use "fluentWaitForPresence" in Waits class so if the element is not present it through an exception
    public void Refresh(By locator) {
        boolean displayed = false;
        do {
            try {
                displayed = driver.findElement(locator)
                        .isDisplayed();
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        } while (!displayed);
    }

    public void refreshNotDisplayed(By locator)
            throws InterruptedException {
        boolean displayed = false;
        displayed = driver.findElement(locator)
                .isDisplayed();
        while (displayed) {
            driver.navigate().refresh();
            displayed = driver.findElement(locator)
                    .isDisplayed();
            System.out.println(displayed);
        }
    }

    public void RefreshForTextDisplayed(String Text) {
        boolean displayed = false;
        do {
            try {
                String source = driver.getPageSource();
                displayed = source.contains(Text);
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        } while (!displayed);
    }
}
