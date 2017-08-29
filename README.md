# moo-test-excercise

The Project aims to automate few functionalities of MOO live website. The scenarios covered are:

1. Valid Search
2. Invalid search
3. An existing user logs in
4. A user checks his/her order history

The test framework used to automate the above flow is a Cucumber-JVM project using Maven.It has following structure:

1. The project uses Selenium Webdriver, Cucumber dependencies, Spring dependencies. These dependencies are mentioned in the pom.xml file in the project which lets the dependencies to be downloaded when the project is imported.
2. It has a hybrid framework, predominantly uses the principles of Page-object model and data-driven model.
3. The /src/main folder contains the Webdriver definitition and page object definitions
4. The /src/test folder contains feature files, step definitions, property file etc.
5. Cucumber.xml under /src/test folder, defines the base package and paths to property file
6. Valid and invalid search scenarios are covered in SearchProduct.feature, rest of the scenarios are covered in AdditionalScenarios.feature.

/src/main/java - contains reusable functions and they are independant of thrir implementations
/src/test/java - contains the step definitions
/src/test/resources - the feature file, property files

Pre-requisite to run the project:

Maven
Java JDK
Firefox
Java IDE(Intellij, eclipse etc)


To run this project , kindly follow the below steps:

1. Download the project from https://github.com/swagatabasu/moo-test-excercise
2. Open it from any java IDE
3. Add a Maven run configuration and use the below command:
clean install -Dbrowser=firefox -DEnv=local -DsocksProxyHost=localhost -DsocksProxyPort=8080 -Dtarget.runner=<runnerName>

Please note: Runners reside under /src/test/java/testRunner directory. There are 3 runners defined for different scenarios. You may replace <runnerName> in the command above with any of the runner name and it should be able to run that particular test.
e.g. - clean install -Dbrowser=firefox -DEnv=local -DsocksProxyHost=localhost -DsocksProxyPort=8080 -Dtarget.runner=loginRunner
