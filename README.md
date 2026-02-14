# README
## Prerequisites
- Java Version 17 installed locally on the machine
- Maven build tool installed locally on the machine
## How to build the project?

## How to run only Cucumber scenarios?

## Where can I find a test report?
Executing a Test Suite with Maven automatically generates a report within CLI that executed it. The project includes 
additional reporting tool, which is Allure Report. To generate a report from previous test execution, please run the
following command within the CLI:

```mvn allure:serve```

It will launch a local web server, which can be accessed by clicking on the address, while holding a Control button
![Allure_CLI_Example.png](docs_images/Allure_CLI_Example.png)
Clicking on it, should lead to a similar looking page: 
![Allure_Report.png](docs_images/Allure_Report.png)

## Used tech stack 
- Java 17

**Dependencies**
- Cucumber Core - 7.31.0
- Cucumber Java - 7.31.0
- Cucumber TestNG - 7.31.0
- TestNG - 7.12.0
- Lombok - 1.18.42
- Rest Assured - 5.5.6
- Jackson Core - 2.20.1
- Jackson Databind - 2.20.0
- Jackson Annotations - 2.20
- Json - 20231013
- Allure TestNG - 2.25.0
- Allure Rest Assured - 2.32.0
- Allure Cucumber7 JVM - 2.32.0

**Plugins**
- Allure Maven - 2.10.0

## AI usage disclosure
To provide consistency and transparency in tracking AI supported development, all of the commits are beginning with tags 
"_AI=NO_" or "_AI=YES_". Furthermore, all of the generated sections of the code will be marked with the following comment blocks:
```/* START AI */``` and ```/* END AI */```. 
I am also providing a list of examples, where I utilized LLMs to support preparation of this project:
- ChatGPT was used to convert pom.xml file into Markdown list of used dependencies alongside their  versions
- During clients.JokeClient implementation I have inquired about transforming my first approach to a one utilizing Builder design pattern.
Initial response has shown me how to handle the Path depending on Joke category and language, I have extrapolated that information
to the rest of the possible combinations for the request. 
- Creating a Step Definition implementation for Data Table scenario - LLM has created the method outline, I have only corrected the data access from singleJoke object