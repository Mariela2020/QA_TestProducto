package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageCorredor extends BasePage{

    //WebDriver driver;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[2]/div[3]/div[1]/div/ul/li[3]/a")
    private WebElement botonproductos;
    private String titlePage = "TOCTOC.com - Gestión corredor - Planes de publicación";

    //@FindBy (xpath="//*[@id=\"app\"]/div/div[3]/div/div/div/div/button")
    //@FindBy (xpath = "//*[@id=\"app\"]/div/div[2]/div[3]/div[1]/div/ul/li[3]/a")
    @FindBy(linkText = "Planes")
    private WebElement botonplanes;


    public HomePageCorredor(WebDriver driver){
        super(driver);
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homePageIsDisplayed() throws Exception {
        return this.getTitle().equals(titlePage);

    }

    public void clickOnProductos() throws Exception {
        this.click(botonproductos);
    }

    public boolean homePageIsDisplayed1() throws Exception {
        return this.getTitle().equals(titlePage);
    }

    public void clickOnPlanes() throws Exception {
        this.click(botonplanes);
    }

}
