package com.maxx.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.maxx.generic.BaseClass;
import com.maxx.pom.HomePage;
@Listeners(com.maxx.generic.ListenerImplementation.class)
public class ProjectModule extends BaseClass{
	public void createProject() {
		
	}
	public void deleteProject() {
		
	}
	
	@Test
	public void deleteCustomer() throws InterruptedException {
		HomePage h=new HomePage(driver);
		h.setTasks();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Start typing name ...']")).sendKeys("Dinga");
		driver.findElement(By.xpath("//span[@class='highlightToken']/../..//div[@class='editButton available']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='headerBlock']//div[@class='action']")).click();
		driver.findElement(By.xpath("//div[text()='Delete']")).click();
		driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
	}
}
