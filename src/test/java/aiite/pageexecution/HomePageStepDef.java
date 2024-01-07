package com.aiite.pageexecution;

import com.aiite.basepack.BaseClass;
import com.aiite.pagefactory.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {	
	
	@Given("Launch the browser and load the Url")
	public void launch_the_browser_and_load_the_url() {
		BaseClass.browserLaunch();
		BaseClass.loadURL("https://www.amazon.in/");			
	}

	@When("Input keyword Mobile and hit Search")
	public void input_keyword_mobile_and_hit_search() {
		HomePage hp = new HomePage();		
		BaseClass.searchElementById(hp.searchBox).sendKeys("Mobile");
		BaseClass.searchElementByXpath(hp.searchBtn).click();	
		
	}

	@Then("Validate the results are displayed for Mobiles")
	public void validate_the_results_are_displayed_for_mobiles() throws Exception {
		Thread.sleep(3000);
		//validation
		BaseClass.closeBrowser();
	}

}
