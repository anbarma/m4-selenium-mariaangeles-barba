package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    WebDriver driver = null;

    @BeforeEach
    void setUp(){
        //String dir = System.getProperty("user.dir");
        //String driverUrl = "/driver/chromedriver.exe";
        //String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", "C:\\Angie\\Cursos\\CursoTesting\\9-SemanaNovena15Nov\\selenium\\m4-selenium-mariaangeles-barba\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        // driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void test(){
        driver.get("https://www.digital55.com/desarrollo-tecnologia/herramientas-testing-introduccion-selenium/");

        String title = driver.getTitle();
        assertEquals("Introducción a Selenium: Cómo funciona, Características y Opciones",title);
    }

    @Test
    void test2(){
        driver.get("https://github.com/anbarma/m4-selenium-mariaangeles-barba");

        String title = driver.getTitle();
        assertEquals("GitHub - anbarma/m4-selenium-mariaangeles-barba",title);
    }

}
