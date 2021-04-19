import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert.*;
import org.junit.Test;



public class ReadFileDat {
    public static void main(String[] args) throws InterruptedException {

        File file = new File("src/data.properties");

        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = new FirefoxDriver();

        driver.get(prop.getProperty("URL"));

        System.out.println("URL ::" + prop.getProperty("URL"));
        driver.findElement(By.className("_yb_1dfrx")).click();
        driver.findElement(By.id("login-username")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("login-signin")).click();

        Thread.sleep(5000);
        driver.findElement(By.className("password")).click();
        driver.findElement(By.className("password")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.id("login-signin")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("ybarMailLink")).click();

        System.out.println("Success!");

        driver.close();
    }

}
