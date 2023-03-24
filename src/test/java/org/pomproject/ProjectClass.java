package org.pomproject;

import org.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class ProjectClass extends BaseClass {
public ProjectClass() {
	PageFactory.initElements(driver, this);
	
	System.out.println("1234567");
	System.err.println("qwertyui");
	
}
}
