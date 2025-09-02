package test.java.main.gotasdeteconologia.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.main.gotasdeteconologia.reports.VideoRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        VideoRecorder.startRecording(scenario.getName());
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        VideoRecorder.stopRecording();
    }

}
