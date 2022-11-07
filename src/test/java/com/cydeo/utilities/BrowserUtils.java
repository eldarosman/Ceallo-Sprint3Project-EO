package com.cydeo.utilities;

import org.junit.Assert;

import java.util.Set;

public class BrowserUtils {


        /*
    Explained at:
    E9-Test Automation
    Gurhan Kocyigit
    RECORDING: DAY 7 - WEBTABLES - UTILITIES - JAVAFAKER
    from 3:09:00 till 3:46:00
     */

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */

    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        //Example of usage:
        //BrowserUtils.switchWindowAndVerify(WebDriver driver, String expectedTitle);

        //Assert: Title contains "expectedInTitle"
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }


}
