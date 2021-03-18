package Pom;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    private WebDriver driver;
    private List WebElement;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento:" + element);
        }
    }

    public void click(WebElement element) throws Exception {
        try {
            element.click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento:" + element);
        }
    }

    public boolean isDisplayed(By element) throws Exception {
        try {
            return driver.findElement(element).isDisplayed();
        }catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento:" + element);
        }
    }

    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        }catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento:" + element);
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento:" + element);
        }
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento:" + element);
        }
    }

    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el titulo del driver");
        }
    }

    public void type(String inputText, By element) throws Exception {
        try {
            driver.findElement(element).sendKeys(inputText);
        }catch (Exception e){
            throw new Exception("No se pudo escribir el texto sobre el elemento:" + element);
        }
    }

    void clear(String s, By element) throws Exception {
        try {
            driver.findElement(element).clear();
        } catch (Exception e) {
            throw new Exception("No se pudo limpliar el elemento:" + element);
        }
    }

    public List<org.openqa.selenium.WebElement> getWebElement(WebElement element) throws Exception {
        try {
            return driver.findElements((By) getWebElement(element));
        }catch (Exception e){
            throw new Exception("No se pudo seleccionar el elemento de la lista:" + element);
        }
    }

    public boolean setSelect(WebElement element) throws Exception {
        try{
            return element.isSelected();
        }catch (Exception e){
            throw new Exception("No esta marcado el checkbox: " + element);
        }
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public void readExcel ( String filepath, String sheetName) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        for (int i=0; i<= rowCount; i++){
            XSSFRow row = newSheet.getRow(i);
            for (int f=0; f< row.getLastCellNum(); f++){
                //System.out.println(row.getCell(f).getStringCellValue() + "||");
            }
        }

    }

    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);
        return cell.getStringCellValue();

    }

    public static void main(String args[]){
        LocalDate date = LocalDate.now();
        // System.out.println(date);
    }

    public void writeExcel(String filepath, String sheetName, String dataToWrite) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        XSSFRow row = newSheet.getRow(0);
        XSSFRow newRow = newSheet.createRow(rowCount+1);
        for (int i=0; i < row.getLastCellNum(); i++){
            XSSFCell newCell = newRow.createCell(i);
            newCell.setCellValue(dataToWrite);
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();

    }

    public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell firstCell = row.getCell(cellNumber-1);
        //System.out.println("El valor de la primera celda es." + firstCell.getStringCellValue());
        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);
        //System.out.println("El valor de la Siguiente celda es:" + nextCell.getStringCellValue());
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();

    }
}


