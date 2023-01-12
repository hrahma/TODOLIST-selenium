package com.exerciceQA.e2eTests.todoList.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TodoListPage {

	final static String LINK_TACHES = "//*[contains(text(),'Tâches')]";
	final static String LINK_DECONNEXION = "//*[contains(text(),'Déconnexion')]";
	final static String EMAIL = "//input[@type='email']";
	final static String PASSWORD = "//input[@type='password']";
	final static String SUBMIT_BUTTON = "//input[@type='submit']";
	final static String ERROR_MESSAGE = "//div[@class='alert alert-danger']";
	final static String BUTTON_AJOUTER_LA_TACHE = "//button[@class='btn btn-primary']";
	final static String FIELD_NOM_DE_LA_TACHE = "//input[@class='form-control']";
	final static String FIELD_DESCRIPTION_DE_LA_TACHE = "//*[@id=\"root\"]/div/div/div/div[2]/input";
	final static String LIST_DES_TACHES = "//*[@id=\"root\"]/div/div/ul/li/span[1]";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = LINK_TACHES)
	public static WebElement linkTaches;
	@FindBy(how = How.XPATH, using = LINK_DECONNEXION)
	public static WebElement linkDeconnexion;
	@FindBy(how = How.XPATH, using = EMAIL)
	public static WebElement email_field;
	@FindBy(how = How.XPATH, using = PASSWORD)
	public static WebElement password_field;
	@FindBy(how = How.XPATH, using = SUBMIT_BUTTON)
	public static WebElement btnSubmit;
	@FindBy(how = How.XPATH, using = ERROR_MESSAGE)
	public static WebElement alert;
	@FindBy(how = How.XPATH, using = BUTTON_AJOUTER_LA_TACHE)
	public static WebElement btnAjouterLaTache;
	@FindBy(how = How.XPATH, using = FIELD_NOM_DE_LA_TACHE)
	public static WebElement task;
	@FindBy(how = How.XPATH, using = FIELD_DESCRIPTION_DE_LA_TACHE)
	public static WebElement descriptionOfTask;
	@FindBy(how = How.XPATH, using = LIST_DES_TACHES)
	public static WebElement listDesTaches;

	/* Methods */
	public void iFillEmail(String email) {
		email_field.clear();
		email_field.sendKeys(email);
	}
	
	public void iFillPassword(String password) {
		password_field.clear();
		password_field.sendKeys(password);
	}
	
	public void clickButtonSubmit() {
		btnSubmit.click();
	}
	
	public void iFillTask(String password) {
		task.sendKeys(password);
	}
	
	public void iFillDescription(String password) {
		descriptionOfTask.sendKeys(password);
	}
	
	public void clickOnAddTask() {
		btnAjouterLaTache.click();
	}

	public Boolean isElementEnabled(WebElement element) {

		Boolean isElementEnabled = element.isEnabled();
		return isElementEnabled;
	}

	public Boolean isElementDisplayed(WebElement element) {

		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}

	public String checkElementContains(WebElement element) {

		String elementTodo = element.getText();
		return elementTodo;
	}
	
	public void verifyColor(WebElement element) {
		
		String color = element.getCssValue("color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();

		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();

		int hexValue3 = Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

		Assert.assertEquals("#721c24", actualColor);
		System.out.print("The color of text is :" + actualColor);
	}

}
