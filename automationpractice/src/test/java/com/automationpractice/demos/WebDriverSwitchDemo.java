package com.automationpractice.demos;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.Common;

public class WebDriverSwitchDemo extends Driver{
	
	
	@Test
	public void swicthToWindow() {

		
		String handle1;
//		String handle2;
		
		driver.get("http://testleaf.herokuapp.com/pages/Window.html");
		
		handle1=driver.getWindowHandle();
//		System.out.println(handle1);
		
		driver.findElement(By.id("home")).click();
		
//		handle2=driver.getWindowHandle();
//		System.out.println(handle2);
		
		
		Set<String> handles=driver.getWindowHandles();
		
		handles.forEach(handle->{
//			System.out.println(handle);
			if(handle.equals(handle1)) {
				System.out.println("this is first window, so not switching...");
			}else {
				driver.switchTo().window(handle);
			}
		});
		
		
		
		driver.findElement(By.xpath("//a[child::h5[text()='Image']]")).click();
		
		
	}
	
	
	@Test
	public void switchToFrame() {
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("Click")).click();
		
	}
	
	
	@Test
	public void swicthtoAlert() {
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		Common.sleep(2);
		
		driver.findElement(By.xpath("//button[preceding-sibling::label[text()='Click the button to display a alert box.']]")).click();
		
		driver.switchTo().alert().accept();
		
		
	}
	
	
	

}
