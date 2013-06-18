package cuke;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static selenium.SeleniumCukeHooks.script;

public class StepDefs {

    @Given("^I am on Google UK front page$")
    public void I_am_on_Google_UK_front_page() {
        script.gotoGoogleUkFrontPage();
    }

    @When("^I search for thirstybear$")
    public void I_search_for_thirstybear() {
        script.searchForThirstyBear();
    }

    @Then("^my website is the top hit$")
    public void my_website_is_the_top_hit() {
        script.clickOnFirstLink();
        script.checkWeAreOnThirstyBearHomePage();
    }

}
