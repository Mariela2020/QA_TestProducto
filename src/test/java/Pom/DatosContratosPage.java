package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatosContratosPage extends BasePage {

    public DatosContratosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@id=\"datosFactura\"]/div[1]/h3[2]")
    private org.openqa.selenium.WebElement pasodosdetres;
    private String titlePage8 = "TOCTOC.com Gestión Corredoras";

    @FindBy(xpath= "//*[@id=\"payFormProduct\"]/div/div[2]/div/div[1]/span")
    private WebElement radiofactura;

    @FindBy(xpath = "//*[@id=\"payFormProduct\"]/div/div[2]/div/div[2]/input")
    private WebElement radioboleta;

    @FindBy(id="razonSocial")
    private By razonSocial;

    @FindBy(id="nombreFantasia")
    private By nombreFantasia;

    @FindBy(id="giro")
    private By giro;

    @FindBy(id="rutFacturacion")
    private By rutFacturacion;

    @FindBy(id="emailFacturacion")
    private By emailFacturacion;

    @FindBy(id="telefono")
    private By telefono;

    @FindBy(id="region")
    private WebElement dropdownList_region;

    @FindBy(id="comuna")
    private WebElement dropdownList_comuna;

    @FindBy(id="direccion")
    private By direccion;

    @FindBy(id="celular")
    private By celular;

    @FindBy(id="representanteLegal")
    private By representanteLegal;

    @FindBy(id="rutRepresentanteLegal")
    private By rutRepresentanteLegal;

    @FindBy(id="direccionFacturacion")
    private By direccionFacturacion;

    @FindBy(css = "#aceptaTerminos")
    private WebElement checkaceptaTerminos;

    @FindBy(xpath="//*[@id=\'actualizaInfo\']")
    private WebElement checkactualizaInfo;

    @FindBy(css = "button.btn:nth-child(2)")
    //@FindBy(xpath = "/html/body/div[1]/div/div[4]/section/div/form/div[2]/div[5]/div/button[2]")
    private WebElement btnContinuar;

    @FindBy(xpath="//*[@id=\"nextStep\"]")
    private WebElement btnSiguiente;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[3]/a[1]")
    private WebElement usuariovalidado;
    private String titlePage28 = "TOCTOC.com Gestión Corredoras";



    public boolean isImagenDisplayed4() throws Exception {
        return this.isDisplayed(usuariovalidado) && this.getTitle().equals(titlePage28);
    }

    public boolean isImagenDisplayed5() throws Exception {
        return this.isDisplayed(pasodosdetres) && this.getTitle().equals(titlePage8);
    }

    public void typeDatosContratospaso1() throws Exception {
        //this.click(radioboleta);
        this.click(radiofactura);
        Thread.sleep(1000);
        clear(" ", By.id("razonSocial"));
        type("Prueba de Flujo QA", By.id("razonSocial"));
        clear(" ", By.id("rutFacturacion"));
        type("267008469", By.id("rutFacturacion"));
        clear(" ", By.id("nombreFantasia"));
        type("Tuinmueble", By.id("nombreFantasia"));
        clear(" ", By.id("giro"));
        type("Giro3", By.id("giro"));
        clear(" ", By.id("telefono"));
        type("+56955167469", By.id("telefono"));
        clear(" ", By.id("direccion"));
        type("Bella Vista", By.id("direccion"));
        this.click(btnSiguiente);

    }

    public void typeDatosContratospaso2() throws Exception {
        clear(" ", By.id("representanteLegal"));
        type("Mariela Hurtado test", By.id("representanteLegal"));
        clear(" ", By.id("rutRepresentanteLegal"));
        type("267008469", By.id("rutRepresentanteLegal"));
        clear(" ", By.id("emailFacturacion"));
        type("mariela.hurtado@toctoc.com", By.id("emailFacturacion"));
        clear(" ", By.id("celular"));
        type("+56993947209", By.id("celular"));
        clear(" ", By.id("direccionFacturacion"));
        type("Manuel Rodriguez Norte", By.id("direccionFacturacion"));
    }

    public String selectDropdownList() throws Exception {
        Select selectList_region = new Select(dropdownList_region);
        selectList_region.selectByVisibleText("Metropolitana");
        return getText(selectList_region.getFirstSelectedOption());
    }

    public String selectDropdownList1() throws Exception {
        Select selectList_comuna = new Select(dropdownList_comuna);
        selectList_comuna.selectByVisibleText("Santiago");
        return getText(selectList_comuna.getFirstSelectedOption());
    }

    public void ClickOncheckaceptaTerminos() throws Exception {
        Thread.sleep(2000);
        for (int i=0; i<3; i++) {
            this.click(checkaceptaTerminos);
        }
    }

    /*public void ClickOncheckactulizainfo() throws Exception {
        Thread.sleep(2000);
        for (int i=0; i<3; i++) {
            this.click(checkactualizaInfo);
            //System.out.println(checkactualizaInfo.isSelected());
        }
    }*/

    public void ClickOnbtnContinuar() throws Exception {
        Thread.sleep(2000);
        this.click(btnContinuar);
    }



}
