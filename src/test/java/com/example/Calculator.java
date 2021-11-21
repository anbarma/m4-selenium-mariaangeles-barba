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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Calculator {
    private static final String URL_CALCULADORA = "https://testsheepnz.github.io/BasicCalculator.html";
    WebDriver driver = null;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Angie\\Cursos\\CursoTesting\\9-SemanaNovena15Nov\\selenium\\m4-selenium-mariaangeles-barba\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
    @Test
    void testTitle(){
        driver.get(URL_CALCULADORA);

        String title = driver.getTitle();
        assertEquals("Basic Calculator",title);
    }
    @Test
    void tagNameSelectorDemo(){
        driver.get(URL_CALCULADORA);

        WebElement h1 = driver.findElement(By.tagName("h1"));
        String h1Text = h1.getText();
        assertEquals("Instructions", h1Text);
    }
    @Test
    void TextBoxInputFirstNumberTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("3");
        sleep();

        input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        String inputValue = input1.getAttribute("value");
        assertEquals("3", inputValue);
    }

    @Test
    void TextBoxInputSecondNumberTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("2");
        sleep();

        input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        String inputValue = input2.getAttribute("value");
        assertEquals("2", inputValue);
    }

    @Test
    void calculateButtonTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("3");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("5", inputValue);

    }

    @Test
    void TextBoxInputFirstNumberTestIsNotaNumber(){
        driver.get(URL_CALCULADORA);

        WebElement input = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input.sendKeys("hola");
        sleep();

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();

        input = driver.findElement(By.id("errorMsgField"));
        String inputValue = input.getText();
        assertEquals("Number 1 is not a number", inputValue);
        sleep();

        boolean inputDisplayed = input.isDisplayed();
        assertEquals(true, inputDisplayed);
    }

    @Test
    void TextBoxInputSecondNumberTestIsNotaNumber(){
        driver.get(URL_CALCULADORA);

        WebElement input = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input.sendKeys("adiós");
        sleep();

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();

        input = driver.findElement(By.id("errorMsgField"));
        String inputValue = input.getText();
        assertEquals("Number 2 is not a number", inputValue);
        sleep();

        boolean inputDisplayed = input.isDisplayed();
        assertTrue(inputDisplayed);
    }


    private void sleep() {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
