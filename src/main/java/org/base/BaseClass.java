package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// browser launch

	public static WebDriver browserlaunch(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(op);
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			// driver = new FirefoxDriver();

		}
		return driver;

	}

	// url launch

	public static void urlLaunch(String url) {
		driver.get(url);

	}

	// maximize
	public static void maximize() {

		driver.manage().window().maximize();
	}
	// implicity wait

	public static void implicityWait(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);

	}

	// sentkeye
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);

	}

	// click
	public static void click(WebElement e) {
		e.click();
	}

	// quit
	public static void quit() {
		driver.quit();
	}

	// gettext

	public static String getText(WebElement e) {

		String text = e.getText();
		return text;
	}

	// getattribute
	public static String getAttribute(WebElement e, String value) {
		String attribute = e.getAttribute(value);
		System.out.println(attribute);
		return attribute;
	}

	// Action
	// moveToElement

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	// dragAndDrop
	public static void dragAndDrop(WebElement drag, WebElement drop) {
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();

	}

	// context click
	public static void conTextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	// doubleclic
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	// Alert
	// accept
	public static Alert accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
		return a;

	}

	// dismiss
	public static Alert dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		return a;
	}

	// sendkey
	public static Alert alertSentkey(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		return a;
	}

	// getText
	public static Alert alertGetText() {
		Alert a = driver.switchTo().alert();
		a.getText();
		return a;
	}
	// Robot
	// down

	public static void robotDown(int size) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < size; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		}
	}

	// enter
	public static void robotEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	// ROBOT

	public static void robotselect() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);

	}

	public static void robotCut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);

	}

	public static void robotTab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void robotCopy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

	}

	public static void robotpaste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	// select
	// index
	public static void selectByIndex(WebElement e, int a) {
		Select s = new Select(e);
		s.selectByIndex(a);
	}

	public static void selectByValue(WebElement e, String b) {
		Select s = new Select(e);
		s.selectByValue(b);
	}

	public static void selectByVisibleText(WebElement e, String c) {
		Select s = new Select(e);
		s.selectByVisibleText(c);

	}

	// isMultible
	public static boolean isMultible(WebElement e) {
		Select s = new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	// getoptions
	public static List<WebElement> getOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> option = s.getOptions();
		return option;

	}

	// getAllSelectedOption
	public static List<WebElement> getAllSelectedOption(WebElement e) {
		Select s = new Select(e);
		List<WebElement> all = s.getAllSelectedOptions();
		return all;
	}

	// getFirstSelectedOption
	public static WebElement getFirstSelectedOption(WebElement e) {
		Select s = new Select(e);
		WebElement first = s.getFirstSelectedOption();
		String text = first.getText();
		return first;
	}

	// selectByIndex
	public static void selectAllByIndex(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			s.selectByIndex(i);
		}
	}

	// deselect
	public static void deselectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	public static void deselectByIndex(WebElement e, int a) {
		Select s = new Select(e);
		s.deselectByIndex(a);
	}

	public static void deselectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);

	}

	public static void deselectByVisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByVisibleText(value);
	}
	// tackesscreenshot

	public static File takesScreenshot(String value) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File f = new File(
				"C:\\Users\\KARTHIK KUMAR K\\eclipse-workspace\\MavenProject\\Screenshot\\" + value + time + ".png");
		FileUtils.copyFile(screenshotAs, f);
		return f;

	}

	// takesscreenshotelement
	public static File takesScreenshotElement(WebElement e, String value) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File screenshotAs = e.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File f = new File(
				"C:\\Users\\KARTHIK KUMAR K\\eclipse-workspace\\MavenProject\\Screenshot\\" + value + time + ".png");
		FileUtils.copyFile(screenshotAs, f);
		return f;
	}

	// frames
	// frame index
	public static void frameIndex(int a) {
		driver.switchTo().frame(a);
	}

	public static void frameIdName(String value) {
		driver.switchTo().frame(value);
	}

	public static void frameWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}

	public static void frameDefaultContext() {
		driver.switchTo().defaultContent();
	}

	public static void frameParentFrame() {
		driver.switchTo().parentFrame();
	}

	// navigation
	public static void navigationTo(String value) {
		driver.navigate().to(value);
	}

	public static void navigationBack() {
		driver.navigate().back();
	}

	public static void navigationRefresh() {
		driver.navigate().refresh();
	}

	public static void navigationForward() {
		driver.navigate().forward();
	}

	// javaScriptExecutor
	public static void javascriptExecutorSentkey(WebElement e, String value) {
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].setAttribute('value','" + value + "')", e);
	}

	public static void javascriptExecutorClick(WebElement e) {
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].click()", e);
	}

	public static void javascriptExecutorGetAttribute(WebElement e) {
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("retrun arguments[0].getAttribute('value')", e);

	}

	public static void javascriptExecutorScrollDown(WebElement e) {
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void javascripExecutorScrollUp(WebElement e) {
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(false)", e);
	}

	// windowHandeling

	public static String getWindowHandle() {
		String parendId = driver.getWindowHandle();
		return parendId;
	}

	public static Set<String> getWindowHandles() {
		Set<String> allId = driver.getWindowHandles();
		return allId;

	}

	public static String getExcel(String filename, String sheet, int row, int c) throws IOException {

		File f = new File("C:\\Users\\KARTHIK KUMAR K\\eclipse-workspace\\MavenProject\\src\\test\\resources\\"
				+ filename + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		// Workbook w = new XSSFWorkbook(fi);
		// Sheet s = w.getSheet(sheet);
		// Row r = s.getRow(row);
		// Cell cell = r.getCell(c);
		// int cellType = cell.getCellType();
		// String value;
		// if (cellType == 1) {
		// value = cell.getStringCellValue();
		// } else {
		// if (DateUtil.isCellDateFormatted(cell)) {
		// Date dc = cell.getDateCellValue();
		// SimpleDateFormat sd = new SimpleDateFormat("d-MM-yy");
		// value = sd.format(dc);
		// } else {
		// double nv = cell.getNumericCellValue();
		// long l = (long) nv;
		// value = String.valueOf(l);
		//
		// }
		// }
		return sheet;

	}

	// tables
	public void tables(String b) {
		List<WebElement> tables = driver.findElements(By.tagName("tables"));
		WebElement t = tables.get(0);

		// All values
		String t1 = t.getText();

		// All headings
		List<WebElement> heads = t.findElements(By.tagName("th"));
		for (int i = 0; i < heads.size(); i++) {
			WebElement h = heads.get(i);
			String t2 = h.getText();
		}

		// All rows

		List<WebElement> rows = t.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement r = rows.get(i);
			String t3 = r.getText();
		}
		// All values

		List<WebElement> values = t.findElements(By.tagName("td"));
		for (int i = 0; i < values.size(); i++) {
			WebElement v = values.get(i);
			String t4 = v.getText();
		}

		// Heads only in row wise
		List<WebElement> rows1 = t.findElements(By.tagName("tr"));
		for (int i = 0; i < rows1.size(); i++) {
			WebElement r = rows1.get(i);
			List<WebElement> headsR = r.findElements(By.tagName("th"));
			for (int j = 0; j < headsR.size(); j++) {
				WebElement hr = headsR.get(j);
				String t5 = hr.getText();
			}
		}

		// Datas only in row wise
		List<WebElement> rows2 = t.findElements(By.tagName("tr"));
		for (int i = 0; i < rows1.size(); i++) {
			WebElement r1 = rows2.get(i);
			List<WebElement> datasR = r1.findElements(By.tagName("td"));
			for (int j = 0; j < datasR.size(); j++) {
				WebElement hr = datasR.get(j);
				String t6 = hr.getText();
			}
		}

		// Get particular value
		List<WebElement> rows3 = t.findElements(By.tagName("tr"));
		for (int i = 0; i < rows3.size(); i++) {
			WebElement r3 = rows3.get(i);
			List<WebElement> datas1 = r3.findElements(By.tagName("td"));
			for (int j = 0; j < datas1.size(); j++) {
				WebElement hr1 = datas1.get(j);
				String t7 = hr1.getText();
				if (t7.equals("qwe")) {

					String text = r3.getText();

					// ways

					// System.out.println(text);
					// System.out.println("row num...."+i);
					// System.out.println("row num...."+j);

				}

			}
		}
	}
}
