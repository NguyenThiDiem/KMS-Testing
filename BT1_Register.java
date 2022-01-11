package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BT1_Register {
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\diem\\Testing-KMS\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Register_Empty() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	     boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
	    	 System.out.println("Da den trang đăng ký!!!");
	    	driver.findElement(By.id("txtFirstname")).sendKeys("");
	 		driver.findElement(By.id("txtEmail")).sendKeys("");
	 		driver.findElement(By.id("txtCEmail")).sendKeys("");
	 		driver.findElement(By.id("txtPassword")).sendKeys("");
	 		driver.findElement(By.id("txtCPassword")).sendKeys("");
	 		driver.findElement(By.id("txtPhone")).sendKeys("");
	 		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
	    	 
	     }
	     else {
	    	 System.out.println("Điều hướng đến trang đăng ký!!!");
	     }
		



		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

	}

	@Test
	public void TC02_Register_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Thị Diem");
		driver.findElement(By.id("txtEmail")).sendKeys("diemmmm.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("diemmmm.com");
		driver.findElement(By.id("txtPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtCPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtPhone")).sendKeys("0962012746");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
	     }else {
	    	 System.out.println("Bạn cần điều hướng đến trang đăng ký.");
	     }

		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

	}

	@Test
	public void TC_03_Register_IncorrectConfirm_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Thị Diem");
		driver.findElement(By.id("txtEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("diemmm@gmail");
		driver.findElement(By.id("txtPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtCPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtPhone")).sendKeys("0962012746");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
	     }else {
	    	 System.out.println("Bạn cần điều hướng đến trang đăng ký");
	     }

		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC04_Register_Password_Less_Than_6_Chars() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Diem");
		driver.findElement(By.id("txtEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("d2001");
		driver.findElement(By.id("txtCPassword")).sendKeys("d2001");
		driver.findElement(By.id("txtPhone")).sendKeys("0962012746");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
	     }else {
	    	 System.out.println("Bạn cần điều hướng đến trang đăng ký");
	     }
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),
				"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),
				"Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_Register_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Diem");
		driver.findElement(By.id("txtEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtCPassword")).sendKeys("d21012002");
		driver.findElement(By.id("txtPhone")).sendKeys("0962012746");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();

		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}else {
		System.out.println("Bạn cần điều juowsng đến trang đăng ký.");
	}}

	@Test
	public void TC_06_Register_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		boolean headerTitle = driver.findElement(By.className("title_login")).isDisplayed();
	     if (headerTitle ==true) {
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Diem");
		driver.findElement(By.id("txtEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("diemmm@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtCPassword")).sendKeys("d21012001");
		driver.findElement(By.id("txtPhone")).sendKeys("789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();

		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}else {
		System.out.println("Bạn cần điều hướng đến trang đăng ký");
	}}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
