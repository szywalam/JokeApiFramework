# Simple REST API Framework for Joke API Testing
## Objective
Creating a lightweight Rest API test automation framework with three different Cucumber feature scenarios, showcasing different
engineering techniques
## Commit strategy
Due to the scope of the project, with majority of the files being small in size, chosen commit strategy focuses on
having a commit per finished Class or Feature, with minor adjustments to other files if necessary.
In case of larger changes to a specific file, which was implemented before, they should be contained within a separate commit
to allow for easier tracking of changes and potential reversal.
## Design challenges
### POJO Modelling
Required POJO models have been obtained by using the following, publicly available tool on the internet:\
https://json2csharp.com/code-converters/json-to-pojo
#### Obtaining a single or multiple jokes
First issue that I had to solve, was finding a reasonable approach for POJO
deserialization without introducing multiple Model classes with repeating fields.
To achieve that, I have extracted the common fields between scenarios where we GET
a single joke or multiple jokes to a "model.Joke" class, which would be later used
in 2 other modelling classes:
- SingleJoke - referenced as ```private Joke joke``` with ```@JsonUnwrapped``` annotation
- MultipleJokes - referenced as ```private List<Joke> jokes``` to cover for multiple jokes being returned in a list format

#### Single and Two-part jokes
This modelling issue would cause issues at preparation stage of the framework
as it would cause Jackson exceptions to be returned, since default request to obtain a joke can return:
- A single joke - containing **joke** field with the entire joke
- A two-part joke - containing **setup** and **delivery** fields, but no **joke** field

A working, stable solution has been achieved by utilizing
```@JsonIgnoreProperties(ignoreUnknown = true)``` annotation, which would simply ignore model elements, which couldn't be found
within the deserialized payload.

### JokeClient DTO - To enum or not to enum
After consideration regarding enum definitions for the Query Parameters for the GET Request (since majority of them 
accepts only certain values), I have decided not to follow up with this decision for a simple reason. While they would enforce
proper definition of parameters we're passing and ensure the validity of requests being sent to the API - that's not what we always want.
Negative test scenarios are as important as positive ones (if not more important sometimes) and being able to check how SUT
behaves when passed an invalid request is crucial to ensure the quality of the product.

### Object initialization within Step Definition, branching statements
For purpose of maintaining a simple data propagation between different Step Definitions, several objects have been declared with default
values within the StepDefinitions class.
``` 
private SingleJoke singleJoke;
private MultipleJokes multipleJokes;
private NegativeResponse negativeResponse;
private int responseStatus;
```
During default initialization, _singleJoke_, _multipleJokes_ and _negativeResponse_ will have _null_ value, while _int_
fields should have 0 as their value, which allows execution of decision-making statements, depending on whether they 
contain a non-null value, which on larger codebases would be unfeasible to maintain, however in this case it 
allows for reducing the amount of implemented different steps and their definitions, while keeping their state between
different steps on a Scenario level further enabling having a separate step for validating the response (which could also
be done during validation of the received response, however for purpose of this task I wanted to maintain most important
data accessible for all the steps, as they do not send more than a single request).

## Testing approach
To execute test scenarios, a combination of TestNG with Cucumber has been used.
Three example feature files have been provided:
- One utilizing Scenarios, with 3 examples: simple positive scenario with validations in multiple steps, 1 for obtaining multiple jokes, 1 negative case
- One with Scenario Outline, passing several Joke ID through Example section
- One using Background section to get a specific joke, with validations performed within Scenario