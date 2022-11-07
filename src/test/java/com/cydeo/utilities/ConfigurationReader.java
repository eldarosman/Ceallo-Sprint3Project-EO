package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    //1- Create the object of Properties

    /*
     * Configuration.properties file:
     * - Avoid hardcoding.
     * - Store important test data.
     * - make our code easy to maintain.
     *       It stores information in key=value format.
     *           browser=chrome
     *           username=test
     *           password=tester
     *           env=qa1.google.com
     * */

    /*
     * Configuration Reader file:
     * - Custom class we created to read from configuration.properties
     * - We created method in it for re-usability purpose.
     * - Synthax:
     *       1- Properties properties = new Properties();
     *       2- FileInputStream file = new FileInputStream("pathOfTheFile");
     *       3- properties.load(file);
     *       4- properties.getProperty("keyWord");
     *
     * */

    private static Properties properties = new Properties();
    // I created an object properties, and made it private because I want it to be visible only to class and
    // I made it static because I want this file open only once to read it and

    // static block needs to be in static
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Error occured while reading configuration file");
            e.printStackTrace();
        }

    }

    // to read value from this configuration properties file
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    // To call this data use code below:
    //
    // public class CRMLogin {
    //
    // @Test
    // public void crmLogin(){
    //  Driver.getDriver().get(ConfigurationReader.getProperty("env")); // "env" is from configuration.properties file
    //
    //  // Enter valid username
    //  WebElement inputUsername = Driver.getDriver().findElement(By.xpath("..."));
    //  inputUsername.sendKeys(ConfigurationReader.getProperty("username")); // "username" is from configuration.properties file
    //
    //  // Enter valid password
    //  WebElement inputPassword = Driver.getDriver().findElement(By.xpath("..."));
    //  inputPassword.sendKeys(ConfigurationReader.getProperty("password")); // "password" is from configuration.properties file
    //
    //  // Click to Log In button
    //  WebElement loginButton = Driver.getDriver().findElement(By.xpath("..."));
    //  loginButton.click();
    //

}
