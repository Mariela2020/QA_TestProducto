package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;



public class ProductosPage extends BasePage {

    public WebDriver driver;
    WebDriverWait waitElement;

    @FindBy(xpath="//*[@id=\"app\"]/div/div[3]/section[2]/a/div/h2")
    private WebElement imagenlocator;
    private String titlePage = "TOCTOC.com - Productos y servicios para Corredores de propiedades";


    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[1]/div[2]/h4")
    private WebElement imagentarjeta;

    // general //*[@id="vitrina_productos"]/div/button[1]/div[2]/h4

    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[1]/div[2]/h4")
    private WebElement tarjetapropdestacada;

    @FindBy (xpath = "//*[@id=\"vitrina_productos\"]/div/button[2]/div[2]/div/div[2]/a")
    private  WebElement tarjetaultventas;

    @FindBy (xpath = "//*[@id=\"vitrina_productos\"]/div/button[3]/div[2]/div/div[2]/a")
    private WebElement tarjetamailing;

    @FindBy (xpath = "//*[@id=\"vitrina_productos\"]/div/button[4]/div[2]/div/div[2]/a")
    private WebElement tarjetabanner;

    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[5]/div[2]/div/div[2]/a")
    private WebElement tarjetabanner5prop;

    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[6]/div[2]/div/div[2]/a")
    private WebElement tarjetaespaciolanding;

    @FindBy (xpath = "//*[@id=\"vitrina_productos\"]/div/button[7]/div[2]/div/div[2]/a")
    private WebElement tarjetamail500;

    @FindBy (xpath = "//*[@id=\"vitrina_productos\"]/div/button[8]/div[2]/div/div[2]/a")
    private WebElement tarjetaapicontacto;

    @FindBy (xpath= "//*[@id=\"vitrina_productos\"]/div/button[9]/div[2]/div/div[2]/a")
    private WebElement tarjetapropdestx5;

    @FindBy (xpath= "//*[@id=\"vitrina_productos\"]/div/button[10]/div[2]/div/div[2]/a")
    private WebElement tarjetapropdestx15;

    @FindBy (xpath= "//*[@id=\"vitrina_productos\"]/div/button[11]/div[2]/div/div[2]/a")
    private WebElement tarjetapropdestx30;

    @FindBy (xpath= "//*[@id=\"vitrina_productos\"]/div/button[12]/div[2]/div/div[2]/a")
    private WebElement tarjetapropdestx60;


    @FindBy(id = "msjCorredor")
    private WebElement productolocator;

    // @FindBy(linkText = "COMPRAR")
    @FindBy (css = "body > div.fade.modal.show > div > div > div.modal-footer > div:nth-child(2) > a")
    private WebElement btncomprar;

    public ProductosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isImagenDisplayed() throws Exception {
        Thread.sleep(1000);
        return this.isDisplayed(imagenlocator) && this.getTitle().equals(titlePage);
    }

    public void clickOnTarjetaProducto() throws Exception {
        imagentarjeta=tarjetapropdestx60;
        //String tarjeta = imagentarjeta.getAttribute("value");
        //System.out.println("string de la tarjeta" + tarjeta + "es igual a" + imagentarjeta);
        // WebDriverWait wait =new WebDriverWait(driver,10);
        // waitElement.until(ExpectedConditions.presenceOfElementLocated((By) imagentarjeta));
        this.click(imagentarjeta);
    }

    public boolean isImagenDisplayed2() throws Exception {
        Thread.sleep(2000);
        return this.isDisplayed(productolocator) && this.getTitle().equals(titlePage);
    }

    public void ClickOnComprar() throws Exception {
        Thread.sleep(1000);
        this.click(btncomprar);
    }

   /* @DataProvider(name= "SeleccionProducto")
    public Object[] getData()  {

        Object[] data = new Object[2];
        data[0] = imagentarjeta=Tarjetapropdestx5;
        data[1] = imagentarjeta=tarjetabanner5prop;
        return data;
    }
     */

}
