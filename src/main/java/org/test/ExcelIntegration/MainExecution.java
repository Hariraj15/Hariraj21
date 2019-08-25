package org.test.ExcelIntegration;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainExecution extends TestExcel {
	public static void main(String[] args) throws Throwable{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\eclipse-Hari\\ExcelIntegration\\driver\\chromedriver.exe");
		WebDriver d =new ChromeDriver();
		d.get("https://www.snapdeal.com");
		WebElement q = d.findElement(By.id("inputValEnter"));
		q.sendKeys(getData(1,1));
		Thread.sleep(2000);
		WebElement p = d.findElement(By.xpath("//span[@class='searchTextSpan']"));
		p.click();
		Thread.sleep(2000);
		WebElement t = d.findElement(By.xpath("(//img[@class='product-image '])[2]"));
		t.click();
		String par = d.getWindowHandle();
		Set<String> All = d.getWindowHandles();
		for (String x : All) {
			if(!x.equals(par)) {
				d.switchTo().window(x);
				WebElement a = d.findElement(By.xpath("//span[text()='add to cart']"));
				a.click();
				Thread.sleep(2000);
				WebElement h = d.findElement(By.xpath("//i[@class='sd-icon sd-icon-cart-icon-white-2']"));
				h.click();
				
			}
			
		}
		
	}
	

}
