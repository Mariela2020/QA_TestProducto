package TestCases;

import Pom.*;
import Runners.DriverManagerFactory;
import Runners.DriverType;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class ProductosTest {

    static WebDriver driver;
    String baseUrl = "https://ww2.toctoc.com/gestioncorredor/";
    String expected = null;
    String actual = null;
    WebDriverWait waitElement;
    DesiredCapabilities capability= null;
    HomePageCorredor homePageCorredor;
    ProductosPage productosPage;
    LoginPageCorredor loginPageCorredor;
    DatosContratosPage datosContratosPage;
    DetalleContratoPage detalleContratoPage;

    @BeforeTest
    //@Parameters({"browser"})
    public void setUpTest() throws MalformedURLException {
        DriverManagerFactory.getInstance().setDriver(DriverType.FIREFOX);
        driver = DriverManagerFactory.getInstance().getDriver();
        driver.get(baseUrl);
        waitElement = new WebDriverWait(driver, 15);
    }

  /*  @BeforeTest
    @Parameters({"browser"})
    public void launchBrowser(String browser) throws Exception {
        switch (browser.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver= new ChromeDriver();
                // capability = DesiredCapabilities.chrome();
                // capability.setBrowserName("chrome");
                // capability.setPlatform(Platform.ANY);

                break;
            case "FIREFOX":
                //System.out.println("firefox");
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver =new FirefoxDriver();
                //capability = DesiredCapabilities.firefox();
                //capability.setBrowserName("firefox");
                //capability.setPlatform(Platform.ANY);

                break;
            case "EDGE":
               // System.out.println("edge");
               // capability = DesiredCapabilities.edge();
               // capability.setBrowserName("MicrosoftEdge");
               // capability.setPlatform(Platform.WINDOWS);
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "OPERA":
                System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
                driver = new OperaDriver();

                break;
            case "SAFARI":
                System.out.println("safari");
                capability = DesiredCapabilities.safari();
                capability.setBrowserName("safari");
                capability.setPlatform(Platform.IOS);
                break;
            default:
                Assert.fail("Verifique el browser seleccionado");

        }
        //driver = new RemoteWebDriver(new URL(nodeUrl),capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);

    } */

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    //@Test(dataProvider = "SeleccionProducto", dataProviderClass = ProductosPage.class)
    @Test(priority = 1, description = "Selecciona el Producto a Contratar")
    public void Producto() throws Exception {
        homePageCorredor = new HomePageCorredor(driver);
        productosPage = new ProductosPage(driver);
        Assert.assertTrue(homePageCorredor.homePageIsDisplayed());
        homePageCorredor.clickOnProductos();
        Assert.assertTrue("No se redirrecciono correctamente a la pagina de Productos", productosPage.isImagenDisplayed());
        productosPage.clickOnTarjetaProducto();
        Assert.assertTrue(productosPage.isImagenDisplayed2());
        productosPage.ClickOnComprar();
    }

    @Test(priority = 2, description = "Ingresa las credenciales del usuario Corredor")
    public void Login() throws Exception {
        loginPageCorredor = new LoginPageCorredor(driver);
        loginPageCorredor.isImagenDisplayed3();
        Thread.sleep(1000);
        loginPageCorredor.typeEmailLocator();
        loginPageCorredor.typePasswordLocator();
        loginPageCorredor.ClickOnIngresar();
    }

    @Test(priority = 3, description = "LLena los campos solicitados")
    public void Formulario() throws Exception {
        datosContratosPage = new DatosContratosPage(driver);
        Assert.assertTrue(datosContratosPage.isImagenDisplayed4());
        datosContratosPage.typeDatosContratospaso1();
        Assert.assertTrue(datosContratosPage.isImagenDisplayed5());
        datosContratosPage.typeDatosContratospaso2();
        Assert.assertEquals(datosContratosPage.selectDropdownList(), "Metropolitana");
        Assert.assertEquals(datosContratosPage.selectDropdownList1(), "Santiago");
        datosContratosPage.ClickOncheckaceptaTerminos();
        //datosContratosPage.ClickOncheckactulizainfo();
        datosContratosPage.ClickOnbtnContinuar();
    }

    @Test(priority = 4, description = "Visualiza el detalle del Contrato")
    public void Contrato() throws Exception {
        detalleContratoPage = new DetalleContratoPage(driver);
        Assert.assertTrue(detalleContratoPage.istitledetalleDisplayed());
        detalleContratoPage.ClickOnbtnPagar();
        Assert.assertTrue(detalleContratoPage.istitledetalleDisplayed2());
        detalleContratoPage.WriteExcelFile();
    }


}

