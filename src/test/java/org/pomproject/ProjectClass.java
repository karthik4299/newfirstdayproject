package org.pomproject;

import org.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class ProjectClass extends BaseClass {
public ProjectClass() {
	PageFactory.initElements(driver, this);
	
}
}
