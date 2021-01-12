
# takeaway-api

**This is the Gradle subproject containing api automation framework and tests for http://coop.apps.symfonycasts.com/.**

This assignment is done using Java as programming language, Serenity as Junit wrapper, io.rest-assured Java library. POJO is used to serialize and deserialize into JSON object. BDD approach & Single-responsibility principle (SRP) is followed while creating the framework.

**Testing scope** - Farm Actions used for api automation. All the POST operations are automated. 

Requirements :
1.  Java 1.8+ should be installed on the machine.
2.  Gradle should be installed on the machine.

Steps :
1.  Clone the repo using - git clone  [https://github.com/hbanafal/takeaway-assignment.git](https://github.com/hbanafal/takeaway-assignment.git)
2.  Go to the subproject directory - cd takeaway-assignment/takeaway-api
3.  Run tests using command - ./gradlew clean test 
4.  Generate Serenity Reports using - ./gradlew aggregate
5.  Open report from the path - takeaway-api/target/site/serenity/index.html
6.  Click on Test Results in the report and check the stories and steps involved in the test.

Configuration - /src/main/resources/config.properties contains BaseURI, Client id, Client Secret and User id. Please update the config file if required.
