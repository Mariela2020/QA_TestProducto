package Pom;

import Utils.LogHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleContratoPage extends BasePage{

    private static final Logger LOGGER = LogHelper.getLogger(DetalleContratoPage.class);

    public DetalleContratoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[4]/section/div/div[1]/h3[1]")
    private org.openqa.selenium.WebElement titledetalleContrato;
    private String titlePage26 = "TOCTOC.com Gestión Corredoras";

    @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/div[2]/div[3]/div[2]/p")
    private WebElement resultotaltext;

    @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/h2")
    private WebElement preciotext;

    @FindBy (xpath="/html/body/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/h2")
    private WebElement ivatext;

    @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[1]/p[2]")
    private WebElement productotext;

    @FindBy (xpath ="/html/body/div/div/div[4]/section/div/div[4]/div/a")
    //@FindBy (className = "btnPagar")
    private WebElement btnPagar;

    @FindBy (xpath ="/html/body/div/div/div/div/div/div[2]/div[2]/h1")
    private WebElement titledetallepago;

    public boolean istitledetalleDisplayed() throws Exception {
        Thread.sleep(2000);
        return this.isDisplayed(titledetalleContrato) && this.getTitle().equals(titlePage26);
    }

    public void WriteExcelFile() throws Exception {
        String filepath = "src/test/resources/filepath/Test.xlsx";
        String date = getDate();
        String resultText= getText(resultotaltext);
        String precio= getText(preciotext);
        String iva= getText(ivatext);
        String producto= getText(productotext);
        LOGGER.log(Level.INFO, "El valor total del Producto es:" + resultText);
        readExcel(filepath, "Hoja1");
        writeExcel(filepath,"Hoja1", producto +";  " + precio + ";  " + iva + ";  " + resultText + ";  " + date);
        readExcel(filepath,"Hoja1");
    }

    public void ClickOnbtnPagar() throws Exception {
        //Thread.sleep(2000);
        this.click(btnPagar);
    }

    public boolean istitledetalleDisplayed2() throws Exception {
        Thread.sleep(2000);
        return this.isDisplayed(titledetallepago);
    }
}
