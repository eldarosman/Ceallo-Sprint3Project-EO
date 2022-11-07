package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so I am closing
    access to the object of this class from outside the class
    */

    private Driver(){}

    /*
    I make WebDriver private, because I want to close access from outside the class.
    I make it static because I will use it in a static method.
    */

    private static WebDriver driver; // value is null by default

    /*
    Creating a re-usable utility method which will return same driver instance when I call it
    */

    public static WebDriver getDriver(){

        if (driver == null){

            /*
            I read a browserType from configuration.properties.
            This way, I can control which browser is opened from outside my code, from configuration.properties
            */

            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will be return from configuration.properties file
            switch statement will determine the case, and open the matching browser
             */

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("Unknown Browser Type " + browserType);
                    driver = null;
            }

        }

        return driver;

    }

    /*
    This method will make sure a driver value is always null after using quit() method
     */

    public static void closeDriver(){
        if (driver != null){
            driver.quit(); // this line will terminate the existing session. Value will not even be null
            driver = null;
        }

    }


}
