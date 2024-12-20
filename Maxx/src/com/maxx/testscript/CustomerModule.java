package com.maxx.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.maxx.generic.BaseClass;
import com.maxx.pom.HomePage;
import com.maxx.pom.TaskListPage;
@Listeners(com.maxx.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		String custName = f.getExcelData("createCustomer", 1, 1);
		String description = f.getExcelData("createCustomer", 1, 2);
		HomePage h=new HomePage(driver);
		h.setTasks();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewbtn().click();
		t.getNewCustBtn().click();
		t.getCustTbx().sendKeys(custName);
		t.getCustDesc().sendKeys(description);
		t.getCustDropdown().click();
		t.getOurCompOpt().click();
		t.getCreateCustBtn().click();
		Thread.sleep(2000);
		String actualCustName = t.getCreatedCust().getText();
		Assert.assertEquals(custName, actualCustName);
		System.out.println("Created a customer successfully");
	} 
}
