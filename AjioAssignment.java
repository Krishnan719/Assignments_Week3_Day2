package javalearning.week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class AjioAssignment {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags"+Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(4000);
		String count=driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(count);
		List<WebElement> usingList = new ArrayList<WebElement>();
		usingList=driver.findElements(By.xpath("//div[@class='nameCls' and contains(text(),'Bag')]"));
		int total=usingList.size();
		System.out.println(total);
		System.out.println("Total bag names:");
		for (WebElement bagName : usingList) {
			System.out.println(bagName.getText());
		}
		List<WebElement> usingBrand = new ArrayList<WebElement>();
		System.out.println("Total brand names:");
		usingBrand=driver.findElements(By.xpath("//div[@class='brand']"));
		int total1=usingBrand.size();
		System.out.println(total1);
		for(WebElement displayBrand:usingBrand) {
			System.out.println(displayBrand.getText());
		}
	}
}