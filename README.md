# README
## How to build the project?

## How to run only Cucumber scenarios?

## Where can I find a test report?
All test runs are saved within "allure-results" folder, which can be found in the root directory of the repository.
To watch the HTML report, find the latest generated report file, open it by double clicking on it and from top-right corner of the IDE
pick browser of Your choice:

## Used tech stack 
- Java 17
- Cucumber Core - 7.34.2
- TestNG - 7.12.0
- Lombok 1.18.42
- Rest Assured - 5.5.6
- Jackson Core - 2.20.1
- Jackson Databind - 2.20.0
- Jackson Annotations - 2.20
- JSON (org.json) - 20231013
- Allure TestNG - 2.25.0
- Allure Rest Assured - 2.25.0
- AspectJ Weaver - 1.19.21

## AI usage disclosure
To provide consistency and transparency in tracking AI supported development, all of the commits are beginning with tags 
"_AI=NO_" or "_AI=YES_". Furthermore, all of the generated sections of the code will be marked with the following comment blocks:
```/* START AI */``` and ```/* END AI */```. 
I am also providing a list of examples, where I utilized LLMs to support preparation of this project:
- ChatGPT was used to convert pom.xml file into Markdown list of used dependencies alongside their  versions
- During clients.JokeClient implementation I have inquired about transforming my first approach to a one utilizing Builder design pattern.
Initial response has shown me how to handle the Path depending on Joke category and language, I have extrapolated that information
to the rest of the possible combinations for the request. 