package ch.coop.app.test.testbench;

import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTestBenchIT extends TestBenchTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestBenchIT.class);

    protected final String testURL = "http://localhost:8080";

    @Rule
    public ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this, true);

    @BeforeClass
    public static void beforeAbstractITClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeAbstractIT() {
        Parameters.setScreenshotErrorDirectory("screenshots/errors");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        Map<String, Integer> timeouts = new HashMap<>();
        timeouts.put("implicit", 1000 * 60 * 10);
        timeouts.put("pageLoad", 1000 * 60 * 10);
        timeouts.put("script", 1000 * 60 * 10);
        chromeOptions.setCapability("timeouts", timeouts);

        setDriver(TestBench.createDriver(new ChromeDriver(chromeOptions)));
        getDriver().get(testURL);
    }
}
