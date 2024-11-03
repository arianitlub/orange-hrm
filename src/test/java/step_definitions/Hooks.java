package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;


public class Hooks {

    @Before
    public void setUp(){

    }

    @After
    public void takeScreenshot(Scenario scenario){

        if(scenario.isFailed()){
            byte[] image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
    }

    @AfterAll
    public static void tearDown(){
        Driver.getDriver().quit();
    }
}
