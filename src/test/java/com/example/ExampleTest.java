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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    private static final String URL_DEMO = "https://tutorialshut.com/demo-website-for-selenium-automation-practice/";
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

    @Test
    void testTitle(){
        driver.get(URL_DEMO);

        String title = driver.getTitle();
        assertEquals("Demo website for selenium Automation Practice - Tutorials Hut",title);
    }

    @Test
    void tagNameSelector(){
        driver.get("https://www.digital55.com/desarrollo-tecnologia/herramientas-testing-introduccion-selenium/");

        WebElement h1 = driver.findElement(By.tagName("h1"));
        String h1Text = h1.getText();
        assertEquals("Herramientas de testing: introducción a Selenium", h1Text);
    }

    @Test
    void tagNameSelectorDemo(){
        driver.get(URL_DEMO);

        WebElement h1 = driver.findElement(By.tagName("h1"));
        String h1Text = h1.getText();
        assertEquals("Demo website for Selenium Automation Practice - Tutorials Hut", h1Text);
    }

    @Test
    void TextBoxTest(){
        driver.get(URL_DEMO);

        WebElement input = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        input.sendKeys("Texto desde Selenium");
        sleep();
        String texto_entrada = input.getAttribute("value");
        assertEquals("Texto desde Selenium", texto_entrada);
    }

    @Test
    void classSelector(){
        driver.get("https://github.com/mozilla");

        List<WebElement> repositories = driver.findElements(By.className("Box-row"));
        assertEquals(10, repositories.size());
    }

    @Test
    void cssSelector(){
        driver.get("https://github.com/mozilla");

        List<WebElement> topics = driver.findElements(By.cssSelector(".topic-tag.topic-tag-link"));
        assertEquals(5, topics.size());

        //WebElement repositories = driver.findElement(By.id("fname"));
        //assertTrue(repositories.isDisplayed());

        //String css = repositories.getAttribute("class");
        //assertEquals("mb-3", css);
    }

    @Test
    void testInputForm(){
        driver.get("https://seleniumbase.io/demo_page");

        WebElement input = driver.findElement(By.id("myTextInput"));
        // Enviar información al campo del formulario
        input.sendKeys("Texto desde selenium");

        sleep();

        // comprobar que el input tiene el texto introducido
        input = driver.findElement(By.id("myTextInput"));
        String inputValue = input.getAttribute("value");
        assertEquals("Texto desde selenium", inputValue);

    }

    @Test
    void testSearchDuckDuckGo(){
        driver.get("https://duckduckgo.com/");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium java examples" + Keys.ENTER);
        sleep();
    }

    @Test
    void testSearchDuckDuckGo2(){
        driver.get("https://duckduckgo.com/");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium java examples" + Keys.ENTER);

        // Prueba a limpiar el campo de búsqueda para realizar otra búsqueda:
        input = driver.findElement(By.name("q"));
        input.clear();
        input.sendKeys("JUnit 5" + Keys.ENTER);

    }

    @Test
    void testSearchGoogle(){
        driver.get("https://www.google.es");
        // 1. aceptar terminos y condiciones
        //sleep();
        WebElement acceptButton = driver.findElement(By.xpath("//div[text() = 'Acepto']"));
        assertEquals("jyfHyd", acceptButton.getAttribute("class"));
        acceptButton.click();
        //sleep();
        // 2. realizar busqueda
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium java examples");
        input.submit();
        System.out.println("fin");
    }

    // Selector de formulario
    @Test
    void testDropDown(){
        driver.get("https://seleniumbase.io/demo_page");

        // abrir el selector
        WebElement selector = driver.findElement(By.id("mySelect"));
        selector.click();

        // Opción 1: seleccionar utilizando selector css
//        List<WebElement> options = driver.findElements(By.cssSelector("#mySelect option"));
//        assertEquals(4, options.size());
//        options.get(3).click();

        // Opcion 2: seleccionar utilizando selector xpath (opcional)
        WebElement option = driver.findElement(By.xpath("//select[@id='mySelect']/option[@value='100%']"));
        option.click();

        System.out.println("fin");
    }



    private void sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //https://jqueryui.com/
    // https://omayo.blogspot.com/
    //https://tutorialshut.com/demo-website-for-selenium-automation-practice/

}
