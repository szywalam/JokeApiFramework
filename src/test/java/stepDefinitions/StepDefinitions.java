package stepDefinitions;

import controllers.JokeController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import model.*;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class StepDefinitions {
    private final JokeController jokeController = new JokeController();
    private SingleJoke singleJoke;
    private MultipleJokes multipleJokes;
    private NegativeResponse negativeResponse;

    @Given("I want a single random joke")
    public void iWantASingleRandomJoke() {
        this.singleJoke = jokeController.getJoke();
    }

    @Given("I want {int} jokes")
    public void iWantMultipleJokes(int count) {
        this.multipleJokes = jokeController.getMultipleJokes(count);
    }

    @Given("I want a joke that does not exist")
    public void iWantAJokeThatDoesNotExist() {
        this.negativeResponse = jokeController.getNegativeJoke();
    }

    @Given("I know a joke has id of {int}")
    public void iKnowAJokeHasIdOfJoke(int id) {
        this.singleJoke = jokeController.getJokeById(id);
    }

    @When("I obtain a single random joke")
    public void iObtainASingleRandomJoke() {
        Allure.step("Validate that singleJoke object is not empty", () -> {
            Assert.assertNotNull(this.singleJoke);
        });
    }

    @When("I obtain {int} jokes")
    public void iObtainMultipleJokes(int count) {
        Allure.step("Validate that multipleJokes object is not empty", () -> {
            Assert.assertNotNull(this.multipleJokes);
        });
        Allure.step("Validate that the joke count is equal to " + count, () -> {
            Assert.assertEquals(count,
                    this.multipleJokes
                            .getJokes()
                            .size()
            );
        });
    }

    @When("I try to obtain a non-existent joke")
    public void iTryToObtainANonExistentJoke() {
        Allure.step("Validate that negativeResponse object is not empty", () -> {
            Assert.assertNotNull(this.negativeResponse);
        });
    }

    @When("I get that specific joke with {int} id")
    public void iGetThatSpecificJoke(int id) {
        Allure.step("Validate that singleJoke object is not empty", () -> {
            Assert.assertNotNull(this.singleJoke);
        });
        Allure.step("Validate that obtained joke has id of " + id, () -> {
            Assert.assertEquals(id, this.singleJoke
                    .getJoke()
                    .getId()
            );
        });
    }

    @Then("I should see {string} section")
    public void iShouldSeeASection(String section) {
        Joke joke = this.singleJoke.getJoke();
        Allure.step("Validate that obtainedJoke has " + section + " section", () -> {
            switch (section) {
                case "Error":
                    Assert.assertFalse(this.singleJoke.getError());
                    break;
                case "Category":
                    Assert.assertNotNull(joke.getCategory());
                    break;
                case "Type":
                    Assert.assertNotNull(joke.getType());
                    break;
                case "Safe":
                    Assert.assertNotNull(joke.getSafe());
                    break;
                case "Id":
                    Assert.assertNotNull(joke.getId());
                    break;
                case "Language":
                    Assert.assertNotNull(joke.getLang());
                    break;
                default:
                    throw new IllegalArgumentException("Passed section does not exist within the list");
            }
        });
    }

    @Then("I should see a list of flags")
    public void iShouldSeeAListOfFlags() {
        Flags flags = this.singleJoke.getJoke().getFlags();
        Allure.step("Validate that the joke contains nsfw flag field", () ->
                Assert.assertNotNull(flags.getNsfw())
        );
        Allure.step("Validate that the joke contains religious flag field", () ->
                Assert.assertNotNull(flags.getReligious())
        );
        Allure.step("Validate that the joke contains political flag field", () ->
                Assert.assertNotNull(flags.getPolitical())
        );
        Allure.step("Validate that the joke contains racist flag field", () ->
                Assert.assertNotNull(flags.getRacist())
        );
        Allure.step("Validate that the joke contains sexist flag field", () ->
                Assert.assertNotNull(flags.getSexist())
        );
        Allure.step("Validate that the joke contains explicit flag field", () ->
                Assert.assertNotNull(flags.getExplicit())
        );
    }

    @Then("I should see {int} jokes")
    public void iShouldSeeMultipleJokes(int count) {
        int jokeCounter = 1;
        Allure.step("Validate that there was no error", () -> {
            Assert.assertFalse(this.multipleJokes.getError());
        });
        Allure.step("Validate that amount matches the number of jokes", () -> {
            Assert.assertEquals(this.multipleJokes.getAmount(), count);
        });
        for (Joke joke : this.multipleJokes.getJokes()) {
            Allure.step("Validate that joke number " + jokeCounter + " has a category", () -> {
                Assert.assertNotNull(joke.getCategory());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has a type", () -> {
                Assert.assertNotNull(joke.getType());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has nsfw content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getNsfw());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has religious content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getReligious());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has political content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getPolitical());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has racist content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getRacist());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has sexist content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getSexist());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has explicit content flag", () -> {
                Assert.assertNotNull(joke.getFlags().getExplicit());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has an id", () -> {
                Assert.assertNotNull(joke.getId());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has a safe flag", () -> {
                Assert.assertNotNull(joke.getSafe());
            });
            Allure.step("Validate that joke number " + jokeCounter + " has a language", () -> {
                Assert.assertNotNull(joke.getLang());
            });
            jokeCounter++;
        }
    }

    @Then("I should get a joke with {int} id")
    public void iShouldGetAJokeWithId(int id) {
        Joke joke = this.singleJoke.getJoke();
        Allure.step("Validate that there was no error", () -> {
            Assert.assertFalse(this.singleJoke.getError());
        });
        Allure.step("Validate that joke has a category", () -> {
            Assert.assertNotNull(joke.getCategory());
        });
        Allure.step("Validate that joke has a type", () -> {
            Assert.assertNotNull(joke.getType());
        });
        Allure.step("Validate that joke number has nsfw content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getNsfw());
        });
        Allure.step("Validate that joke number has religious content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getReligious());
        });
        Allure.step("Validate that joke number has political content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getPolitical());
        });
        Allure.step("Validate that joke number has racist content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getRacist());
        });
        Allure.step("Validate that joke number has sexist content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getSexist());
        });
        Allure.step("Validate that joke number has explicit content flag", () -> {
            Assert.assertNotNull(joke.getFlags().getExplicit());
        });
        Allure.step("Validate that joke ID matches with specified value of " + id, () -> {
            Assert.assertEquals(joke.getId(), id);
        });
        Allure.step("Validate that joke number has a safe flag", () -> {
            Assert.assertNotNull(joke.getSafe());
        });
        Allure.step("Validate that joke number has a language", () -> {
            Assert.assertNotNull(joke.getLang());
        });
    }

    /* AI START */
    @Then("I validate if following fields match the expected values")
    public void iValidateIfFollowingFieldsMatchTheExpectedValues(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Joke joke = this.singleJoke.getJoke();
        Flags flags = joke.getFlags();

        for (Map<String, String> row : rows) {
            String field = row.get("field");
            String expectedValue = row.get("expected_value");

            switch (field) {
                case "error":
                    boolean expectedError = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate error is " + expectedError, () ->
                            Assert.assertEquals(this.singleJoke.getError(),
                                    expectedError,
                                    "Error field mismatch")
                    );
                    break;
                case "category":
                    Allure.step("Validate category is " + expectedValue, () ->
                            Assert.assertEquals(joke.getCategory(),
                                    expectedValue,
                                    "Category field mismatch")
                    );
                    break;
                case "type":
                    Allure.step("Validate type is " + expectedValue, () ->
                            Assert.assertEquals(joke.getType(),
                                    expectedValue,
                                    "Type field mismatch")
                    );
                    break;
                case "setup":
                    Allure.step("Validate setup is correct", () ->
                            Assert.assertEquals(joke.getSetup(),
                                    expectedValue,
                                    "Setup field mismatch")
                    );
                    break;
                case "delivery":
                    Allure.step("Validate delivery is correct", () ->
                            Assert.assertEquals(joke.getDelivery(),
                                    expectedValue,
                                    "Delivery field mismatch")
                    );
                    break;
                case "id":
                    int expectedId = Integer.parseInt(expectedValue);
                    Allure.step("Validate id is " + expectedId, () ->
                            Assert.assertEquals(joke.getId(),
                                    expectedId,
                                    "ID field mismatch")
                    );
                    break;
                case "safe":
                    boolean expectedSafe = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate safe is " + expectedSafe, () ->
                            Assert.assertEquals(joke.getSafe(),
                                    expectedSafe,
                                    "Safe field mismatch")
                    );
                    break;
                case "lang":
                    Allure.step("Validate language is " + expectedValue, () ->
                            Assert.assertEquals(joke.getLang(),
                                    expectedValue,
                                    "Lang field mismatch")
                    );
                    break;
                case "nsfw":
                    boolean expectedNsfw = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate nsfw is " + expectedNsfw, () ->
                            Assert.assertEquals(flags.getNsfw(),
                                    expectedNsfw,
                                    "Nsfw field mismatch")
                    );
                    break;
                case "religious":
                    boolean expectedReligious = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate religious is " + expectedReligious, () ->
                            Assert.assertEquals(flags.getReligious(),
                                    expectedReligious,
                                    "Religious field mismatch")
                    );
                    break;
                case "political":
                    boolean expectedPolitical = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate religious is " + expectedPolitical, () ->
                            Assert.assertEquals(flags.getPolitical(),
                                    expectedPolitical,
                                    "Religious field mismatch")
                    );
                    break;
                case "racist":
                    boolean expectedRacist = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate racist is " + expectedRacist, () ->
                            Assert.assertEquals(flags.getRacist(),
                                    expectedRacist,
                                    "Racist field mismatch")
                    );
                    break;
                case "sexist":
                    boolean expectedSexist = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate sexist is " + expectedSexist, () ->
                            Assert.assertEquals(flags.getSexist(),
                                    expectedSexist,
                                    "Racist field mismatch")
                    );
                    break;
                case "explicit":
                    boolean expectedExplicit = Boolean.parseBoolean(expectedValue);
                    Allure.step("Validate sexist is " + expectedExplicit, () ->
                            Assert.assertEquals(flags.getExplicit(),
                                    expectedExplicit,
                                    "Racist field mismatch")
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Unknown field: " + field);
            }
        }
    }
    /* AI END */

    @Then("I validate the obtained error response")
    public void iValidateTheObtainedErrorResponse() {
        NegativeResponse response = this.negativeResponse;
        Allure.step("Validate that obtained response is for error", () -> {
            Assert.assertTrue(response.getError());
        });
        Allure.step("Validate that internal error is false", () -> {
            Assert.assertFalse(response.getInternalError());
        });
        Allure.step("Validate that message is 'No matching joke found'", () -> {
            Assert.assertEquals(response.getMessage(), "No matching joke found");
        });
        Allure.step("Validate that causedBy array has a single element", () -> {
            Assert.assertEquals(response.getCausedBy().size(), 1);
        });
        Allure.step("Validate message within causedBy array", () -> {
            Assert.assertEquals(response.getCausedBy().get(0),
                    "No jokes were found that match your provided filter(s)."
            );
        });
        Allure.step("Validate additional info matches the reason for failure", () -> {
            Assert.assertEquals(response.getAdditionalInfo(),
                    "The specified language code \"aaaaa\" is invalid. Please see " +
                            "https://jokeapi.dev/#langcodes-endpoint for more info."
            );
        });
        Allure.step("Validate that timestamp is not empty", () -> {
            Assert.assertNotNull(response.getTimestamp());
        });
    }
}
