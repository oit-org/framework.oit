package oit.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToNewWindow {
    public static WebDriver driver;

    public SwitchToNewWindow(WebDriver driver) {
        SwitchToNewWindow.driver = driver;
    }

    public void switchToChildWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();
        for (String newWindow : childWindows) {
            if (!newWindow.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public void backToParentWindow() {
        String childWindows = driver.getWindowHandle();
        Set<String> parentWindow = driver.getWindowHandles();
        for (String newWindow : parentWindow) {
            if (!newWindow.equalsIgnoreCase(childWindows)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public void closeChildBackToParent() throws InterruptedException {
        try {
            String childWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            for (String newWindow : windows) {
                if (!newWindow.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow).close();
                    driver.switchTo().window(newWindow);
                }
            }
        } catch (Exception e) {
            driver.navigate().refresh();
        }
    }
}
