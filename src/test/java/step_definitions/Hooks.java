package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void setUp(){

    }

    @After
    public void takeScreenshot(Scenario scenario){
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

            String filePath = "screenshots/" + scenario.getName() + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(filePath));

                byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(image, "image/png", scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterAll
    public static void tearDown(){
        Driver.getDriver().quit();
    }
}
