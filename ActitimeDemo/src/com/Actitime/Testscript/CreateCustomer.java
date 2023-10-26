package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

import comActitime.GenericLibrary.BaseClass;
import comActitime.GenericLibrary.FileLibrary;

public class CreateCustomer extends BaseClass {
     
      @Test
      public void create(String Sheet1) throws EncryptedDocumentException, IOException {
    	  HomePage hp = new HomePage(driver);
    	  hp.getTasklnk().click();
    	  TaskPage tp = new TaskPage(driver);
    	  tp.getAddnewbtn().click();
    	  tp.getNewcustomer().click();
    	  FileLibrary f = new FileLibrary();
    	  String custname = f.readDataFromExcel(Sheet1, 1, 1);
    	  String custdesp = f.readDataFromExcel(Sheet1, 1, 2);
    	  tp.getCustomername().sendKeys(custname);
    	  tp.getCustdesp().sendKeys(custdesp);
    	  tp.getCreatecustbtn().click();
    	  String expecteddata = custname;
    	  String actualdata = driver.findElement(By.xpath("(//div[.='"+custname+"'])[2]")).getText();
    	  SoftAssert s = new SoftAssert();
    	  s.assertEquals(expecteddata, actualdata);
    	  s.assertAll();
    	  
    	  
	
    	 
     }
}
