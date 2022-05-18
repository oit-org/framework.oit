package oit.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AlertHandling {
    public WebDriver driver;

    public AlertHandling(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        String acceptPopup = "window.confirm = function(){return true;}";
        ((JavascriptExecutor) driver).executeScript(acceptPopup);
    }

    public void cancelAlert() {
        String cancelPopup = "window.confirm = function(){return false;}";
        ((JavascriptExecutor) driver).executeScript(cancelPopup);
    }
}
