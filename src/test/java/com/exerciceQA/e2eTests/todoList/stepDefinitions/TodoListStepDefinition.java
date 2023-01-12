package com.exerciceQA.e2eTests.todoList.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.exerciceQA.e2eTests.todoList.pages.TodoListPage;
import com.exerciceQA.e2eTests.utils.CommonMethods;
import com.exerciceQA.e2eTests.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TodoListStepDefinition {
	
	public WebDriver driver;
	private TodoListPage todoListPage = new TodoListPage();
	private CommonMethods commonMethods = new CommonMethods();

	public TodoListStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, TodoListPage.class);
	}
	
	@Given("^Je me connecte sur l'application TODOLIST$")
	public void jeMeConnecteSurLApplicationTODOLIST() throws Throwable {
		commonMethods.openApplication();
		Thread.sleep(3000);
	}

	@Then("^Les liens Tâches et Déconnexion apparaissent seulement quand l'utilisateur est identifié$")
	public void lesLiensTâchesEtDéconnexionApparaissentSeulementQuandLUtilisateurEstIdentifié() throws Throwable {
		todoListPage.isElementDisplayed(TodoListPage.linkTaches);
		todoListPage.isElementDisplayed(TodoListPage.linkDeconnexion);
	}

	@Then("^Lorsque les identifiants de connexion \"([^\"]*)\" et \"([^\"]*)\" sont incorrects, un message rouge apparait pour les alerter \"([^\"]*)\"$")
	public void lorsqueLesIdentifiantsDeConnexionEtSontIncorrectsUnMessageRougeApparaitPourLesAlerter(String email, String password, String alert) throws Throwable {
		todoListPage.iFillEmail(email);
		todoListPage.iFillPassword(password);
		todoListPage.clickButtonSubmit();
		String errorMessage = TodoListPage.alert.getText();
		Assert.assertEquals(errorMessage, alert);
		todoListPage.verifyColor(TodoListPage.alert);
	}

	@Then("^Les boutons connexion et ajout de tâches ne sont pas activés si tous les champs ne sont pas remplis \"([^\"]*)\" et \"([^\"]*)\"$")
	public void lesBoutonsConnexionEtAjoutDeTâchesNeSontPasActivésSiTousLesChampsNeSontPasRemplis(String email, String password) throws Throwable {
		todoListPage.isElementEnabled(TodoListPage.btnSubmit);
		todoListPage.iFillEmail(email);
		todoListPage.iFillPassword(password);
		todoListPage.clickButtonSubmit();
		Thread.sleep(3000);
		todoListPage.isElementEnabled(TodoListPage.btnAjouterLaTache);
	}

	@When("^J'ajoute une tache \"([^\"]*)\" \"([^\"]*)\"$")
	public void jAjouteUneTache(String task, String description) throws Throwable {
		todoListPage.iFillTask(task);
		todoListPage.iFillDescription(description);
		todoListPage.clickOnAddTask();
	}

	@Then("^Les données dans le localStorage sont mises à jour \"([^\"]*)\"$")
	public void lesDonnéesDansLeLocalStorageSontMisesÀJour(String todo) throws Throwable {
		String listeDesTaches = TodoListPage.listDesTaches.getText();
		Assert.assertTrue(listeDesTaches.contains(todo));
	}

}
