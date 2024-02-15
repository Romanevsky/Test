package org.example.UI_Base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Options {

    @BeforeClass
    public void setUp() {
        //Configuration.remote = "http://localhost:4444";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1344x1200";
        Configuration.timeout = 60_000;//Может долго прогружаться страница Google
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
