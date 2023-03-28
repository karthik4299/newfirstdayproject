package org.pomproject;

import org.base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class ProjectClass extends BaseClass {
public ProjectClass() {
	PageFactory.initElements(driver, this);
	
	System.out.println("1234567");
	System.err.println("qwertyui");
	
	
	
}
public static void main(String[] args) {
	browserlaunch("chrome");
}
}
