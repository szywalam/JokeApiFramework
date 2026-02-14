package stepDefinitions;

import controllers.JokeController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import model.MultipleJokes;
import model.NegativeResponse;
import model.SingleJoke;

import java.util.Map;

public class StepDefinitions {
    private final JokeController jokeController = new JokeController();
    private SingleJoke singleJoke;
    private MultipleJokes multipleJokes;
    private NegativeResponse negativeResponse;
    private int responseStatus;
    private int jokeId;

    @Given("I want a single random joke")
    public void iWantASingleRandomJoke() {}

    @Given("I want {int} jokes")
    public void iWantMultipleJokes(int count) {}

    @Given("I want a joke that does not exist")
    public void iWantAJokeThatDoesNotExist() {}

    @Given("I know a joke has id of {int}")
    public void iKnowAJokeHasIdOfJoke(int id) {}

    @When("I obtain a single random joke")
    public void iObtainASingleRandomJoke() {}

    @When("I obtain {int} jokes")
    public void iObtainMultipleJokes(int count) {}

    @When("I try to obtain a non-existent joke")
    public void iTryToObtainANonExistentJoke() {}

    @When("I get that specific joke")
    public void iGetThatSpecificJoke() {}

    @Then("I should see a positive response")
    public void iShouldSeeAPositiveResponse() {
    }

    @Then("I should see a negative response")
    public void iShouldSeeANegativeResponse() {}

    @Then("I should see {string} section")
    public void iShouldSeeASection(String section) {
        switch (section) {
            case "Error":
                break;
            case "Category":
                break;
            case "Type":
                break;
            case "Safe":
                break;
            case "Id":
                break;
            case "Language":
                break;
            default:
                throw new IllegalArgumentException("Passed section does not exist within the list");
        }
    }

    @Then("I should see a list of flags")
    public void iShouldSeeAListOfFlags() {}

    @Then("I should see {int} jokes")
    public void iShouldSeeMultipleJokes(int count) {}

    @Then("I should get a joke with {int} id")
    public void iShouldGetAJokeWithId(int id) {}

    @Then("I validate if following fields match the expected values")
    public void iValidateIfFollowingFieldsMatchTheExpectedValues(Map<String, String> expectedFields) {}
}
