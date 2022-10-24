import manager.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.FIREFOX.browserName()));

    @BeforeSuite
    public void setUp() {
        app.init();
    }


    @AfterSuite
    public void tearDown() {
        //app.stop();

    }

}
