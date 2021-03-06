package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import step_definitions.Hooks;

public class Screenshot {
    public static void takeScreenshot() {
        SeleniumUtils.waitForPageToLoad();
        try{
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Hooks.currentScenario.attach(screenshot, "image/png", "Screenshot | " + DataUtils.CURRENT_DATETIME);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
}
