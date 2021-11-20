package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    private static final String URL_DEMO = "https://tutorialshut.com/demo-website-for-selenium-automation-practice/";
    WebDriver driver = null;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Angie\\Cursos\\CursoTesting\\9-SemanaNovena15Nov\\selenium\\m4-selenium-mariaangeles-barba\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
    @Test
    void testTitle(){
        driver.get(URL_DEMO);

        String title = driver.getTitle();
        assertEquals("Demo website for selenium Automation Practice - Tutorials Hut",title);
    }
    @Test
    void tagNameSelectorDemo(){
        driver.get(URL_DEMO);

        WebElement h1 = driver.findElement(By.tagName("h1"));
        String h1Text = h1.getText();
        assertEquals("Demo website for Selenium Automation Practice - Tutorials Hut", h1Text);
    }
    //@Disabled
    @Test
    void TextBoxInputTest(){
        driver.get(URL_DEMO);

        WebElement input = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        input.sendKeys("Texto desde Selenium");
        sleep();

        //input = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        String inputValue = input.getAttribute("value");
        assertEquals("Texto desde Selenium", inputValue);
    }

    private void sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
